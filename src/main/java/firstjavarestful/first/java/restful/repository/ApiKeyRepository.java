package firstjavarestful.first.java.restful.repository;

import firstjavarestful.first.java.restful.entity.APIKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiKeyRepository extends JpaRepository<APIKey, String> {
}
