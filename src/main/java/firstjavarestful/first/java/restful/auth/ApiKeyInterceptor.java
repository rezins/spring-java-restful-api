package firstjavarestful.first.java.restful.auth;

import firstjavarestful.first.java.restful.error.UnAutorhizedException;
import firstjavarestful.first.java.restful.repository.ApiKeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

@Component
public class ApiKeyInterceptor implements WebRequestInterceptor {

    @Autowired
    ApiKeyRepository apiKeyRepository;

    @Override
    public void preHandle(WebRequest request) throws Exception {
        String apiKey = request.getHeader("X-Api-Key");
        if(apiKey == null){
            throw new UnAutorhizedException();
        }

        if(!apiKeyRepository.existsById(apiKey)){
            throw new UnAutorhizedException();
        }
    }

    @Override
    public void postHandle(WebRequest request, ModelMap model) throws Exception {

    }

    @Override
    public void afterCompletion(WebRequest request, Exception ex) throws Exception {

    }
}
