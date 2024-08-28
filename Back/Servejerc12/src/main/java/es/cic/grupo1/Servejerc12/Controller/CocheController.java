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

    private List<Coche> Coches = new ArrayList<>();
    private AtomicLong idCounter = new AtomicLong();
    
    public CocheController() {
        Coches.add(new Coche(idCounter.incrementAndGet(), "Ford", "Focus", 2010));
        Coches.add(new Coche(idCounter.incrementAndGet(), "Renault", "Clio", 2015));
        Coches.add(new Coche(idCounter.incrementAndGet(), "Seat", "Ibiza", 2018));
    }

    @GetMapping
    public List<Coche> getAllCars() {
        return Coches;
    }

    @GetMapping("/{id}")
    public Coche getCarById(@PathVariable Long id) {
        return Coches.stream().filter(Coche -> Coche.getId().equals(id)).findFirst().orElse(null);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCar(@RequestBody Coche Coche) {
        Coche.setId(idCounter.incrementAndGet());
        Coches.add(Coche);
    }

    @PutMapping("/{id}")
    public Coche updateCar(@PathVariable Long id, @RequestBody Coche updatedCar) {
        Coche Coche = Coches.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
        if (Coche != null) {
            Coche.setMake(updatedCar.getMake());
            Coche.setModel(updatedCar.getModel());
            Coche.setYear(updatedCar.getYear());
        }
        return Coche;
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        Coches.removeIf(Coche -> Coche.getId().equals(id));
    }
}