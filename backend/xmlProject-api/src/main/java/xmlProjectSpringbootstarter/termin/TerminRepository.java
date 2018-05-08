package xmlProjectSpringbootstarter.termin;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerminRepository extends MongoRepository<Termin,String> {
}
