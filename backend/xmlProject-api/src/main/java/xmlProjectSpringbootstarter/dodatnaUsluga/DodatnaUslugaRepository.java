package xmlProjectSpringbootstarter.dodatnaUsluga;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DodatnaUslugaRepository extends MongoRepository<DodatnaUsluga,String> {
}
