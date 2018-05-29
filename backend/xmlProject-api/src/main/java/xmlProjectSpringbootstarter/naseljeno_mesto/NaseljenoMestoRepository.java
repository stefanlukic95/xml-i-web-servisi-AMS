package xmlProjectSpringbootstarter.naseljeno_mesto;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NaseljenoMestoRepository extends MongoRepository<NaseljenoMesto,String> {
}
