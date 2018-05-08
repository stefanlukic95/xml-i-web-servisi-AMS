package xmlProjectSpringbootstarter.kategorija;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KategorijaRepository extends MongoRepository<Kategorija, String>{
}
