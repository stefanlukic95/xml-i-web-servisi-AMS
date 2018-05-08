package xmlProjectSpringbootstarter.dodatneuslg;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DodatneuslugeRepository extends MongoRepository<Dodatneusluge, String>{
}
