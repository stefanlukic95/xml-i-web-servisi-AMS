package xmlProjectSpringbootstarter.smestaj;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmestajRepository extends MongoRepository<Smestaj, String>{
    
}
