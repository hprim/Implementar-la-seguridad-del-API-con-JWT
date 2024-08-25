package Api.ElOtroSeArruino.DB.Repository;

import Api.ElOtroSeArruino.DB.Modelo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ModeloRepository extends MongoRepository<Modelo, String> {

}
