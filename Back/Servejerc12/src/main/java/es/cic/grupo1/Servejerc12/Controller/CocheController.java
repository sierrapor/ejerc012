package es.cic.grupo1.Servejerc12.Controller;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.http.HttpStatus;
import es.cic.grupo1.Servejerc12.Model.Coche;

@RestController
@RequestMapping("/api/coches")
public class CocheController {

    private List<Coche> coches = new ArrayList<>();
    private AtomicLong idCounter = new AtomicLong();

    @GetMapping
    public List<Coche> getAllCoches() {
        return coches;
    }

    @GetMapping("/{id}")
    public Coche getCocheById(@PathVariable Long id) {
        return coches.stream().filter(coche -> coche.getId().equals(id)).findFirst().orElse(null);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCoche(@RequestBody Coche coche) {
        coche.setId(idCounter.incrementAndGet());
        coches.add(coche);
    }

    @PutMapping("/{id}")
    public Coche updateCoche(@PathVariable Long id, @RequestBody Coche updatedCoche) {
        Coche coche = coches.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
        if (coche != null) {
            coche.setModelo(updatedCoche.getModelo());
            coche.setanio(updatedCoche.getanio());
            coche.setFabricante(updatedCoche.getFabricante());
        }
        return coche;
    }

    @DeleteMapping("/{id}")
    public void deleteCoche(@PathVariable Long id) {
        coches.removeIf(coche -> coche.getId().equals(id));
    }
}