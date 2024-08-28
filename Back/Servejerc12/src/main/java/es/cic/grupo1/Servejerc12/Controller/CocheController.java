package es.cic.grupo1.Servejerc12.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import es.cic.grupo1.Servejerc12.Model.Coche;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/coches")
public class CocheController {

    private List<Coche> coches = new ArrayList<>();
    private AtomicLong idCounter = new AtomicLong();
    
    // public CocheController() {
    //     coches.add(new Coche(idCounter.incrementAndGet(), "Ford", "Focus", 2010));
    //     coches.add(new Coche(idCounter.incrementAndGet(), "Renault", "Clio", 2015));
    //     coches.add(new Coche(idCounter.incrementAndGet(), "Seat", "Ibiza", 2018));
    // }


    @GetMapping
    public ResponseEntity<List<Coche>> getAllCars() {
        return new ResponseEntity<>(coches, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coche> getCarById(@PathVariable Long id) {
        Coche coche = coches.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
        if (coche == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(coche, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public Coche updateCar(@PathVariable Long id, @RequestBody Coche updatedCar) {
        Coche Coche = coches.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
        if (Coche != null) {
            Coche.setMake(updatedCar.getMake());
            Coche.setModel(updatedCar.getModel());
            Coche.setYear(updatedCar.getYear());
        }
        return Coche;
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        coches.removeIf(Coche -> Coche.getId().equals(id));
    }
}