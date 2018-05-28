package xmlProjectSpringbootstarter.smestaj;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmestajRepository extends MongoRepository<Smestaj, String>{
}
