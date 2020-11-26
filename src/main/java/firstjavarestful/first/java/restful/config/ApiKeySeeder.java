package firstjavarestful.first.java.restful.config;

import firstjavarestful.first.java.restful.entity.APIKey;
import firstjavarestful.first.java.restful.repository.ApiKeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ApiKeySeeder implements ApplicationRunner {

    String apiKey = "SECRET";

    @Autowired
    ApiKeyRepository apiKeyRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if(!apiKeyRepository.existsById(apiKey)){
            apiKeyRepository.save(new APIKey(apiKey));
        }
    }
}
