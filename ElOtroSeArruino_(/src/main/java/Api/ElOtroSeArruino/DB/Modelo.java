package Api.ElOtroSeArruino.DB;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "miColeccion")
public class Modelo {
    @Id
    private String id;
    private String nombre;
    private String descripcion;

}

