package es.cic.grupo1.Servejerc12.Controller;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.http.HttpStatus;
import es.cic.grupo1.Servejerc12.Model.Fabricante;

@RestController
@RequestMapping("/api/fabricantes")
public class FabricanteController {

    private List<Fabricante> fabricantes = new ArrayList<>();
    private AtomicLong idCounter = new AtomicLong();

    @GetMapping
    public List<Fabricante> getAllFabricantes() {
        return fabricantes;
    }

    @GetMapping("/{id}")
    public Fabricante getFabricanteById(@PathVariable Long id) {
        return fabricantes.stream().filter(fabricante -> fabricante.getId().equals(id)).findFirst().orElse(null);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createFabricante(@RequestBody Fabricante fabricante) {
        fabricante.setId(idCounter.incrementAndGet());
        fabricantes.add(fabricante);
    }

    @PutMapping("/{id}")
    public Fabricante updateFabricante(@PathVariable Long id, @RequestBody Fabricante updatedFabricante) {
        Fabricante fabricante = fabricantes.stream().filter(f -> f.getId().equals(id)).findFirst().orElse(null);
        if (fabricante != null) {
            fabricante.setNombre(updatedFabricante.getNombre());
            fabricante.setCoches(updatedFabricante.getCoches());
        }
        return fabricante;
    }

    @DeleteMapping("/{id}")
    public void deleteFabricante(@PathVariable Long id) {
        fabricantes.removeIf(fabricante -> fabricante.getId().equals(id));
    }
}