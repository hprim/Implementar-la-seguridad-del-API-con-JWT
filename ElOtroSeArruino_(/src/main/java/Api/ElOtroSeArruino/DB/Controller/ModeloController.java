package Api.ElOtroSeArruino.DB.Controller;

import Api.ElOtroSeArruino.DB.Modelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/modelos")
public class ModeloController {

    @Autowired
    private ModeloService modeloService;

    @PostMapping
    public Modelo createModelo(@RequestBody Modelo modelo) {
        return modeloService.save(modelo);
    }

    @GetMapping("/{id}")
    public Modelo getModelo(@PathVariable String id) {
        return modeloService.findById(id);
    }


