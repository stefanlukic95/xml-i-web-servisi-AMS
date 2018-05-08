package xmlProjectSpringbootstarter.tipsmestaja;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipsmestajaRepository extends MongoRepository<Tipsmestaja,String>{
}
