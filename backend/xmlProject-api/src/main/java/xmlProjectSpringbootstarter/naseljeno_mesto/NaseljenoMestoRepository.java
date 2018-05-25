package xmlProjectSpringbootstarter.naseljeno_mesto;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NaseljenoMestoRepository extends MongoRepository<NaseljenoMesto,String> {
}
