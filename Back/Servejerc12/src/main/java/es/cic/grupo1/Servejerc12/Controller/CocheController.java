package es.cic.grupo1.Servejerc12.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.http.HttpStatus;
import es.cic.grupo1.Servejerc12.Model.Coche;

@RestController
@RequestMapping("/coches")
public class CocheController {

    private static List<Coche> Coches = new ArrayList<>();
    private static AtomicLong idCounter = new AtomicLong();

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

