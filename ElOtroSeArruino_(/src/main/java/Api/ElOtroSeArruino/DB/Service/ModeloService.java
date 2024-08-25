package Api.ElOtroSeArruino.DB.Service;

import Api.ElOtroSeArruino.DB.Modelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModeloService {

    @Autowired
    private ModeloRepository modeloRepository;

    public Modelo save(Modelo modelo) {
        return modeloRepository.save(modelo);
    }

    public Modelo findById(String id) {
        return modeloRepository.findById(id).orElse(null);
    }
}

