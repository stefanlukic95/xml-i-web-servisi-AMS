package xmlProjectSpringbootstarter.drzava;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrzavaRepository extends MongoRepository<Drzava,String> {

}
