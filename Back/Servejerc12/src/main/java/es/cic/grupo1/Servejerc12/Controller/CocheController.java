package es.cic.grupo1.Servejerc12.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.cic.grupo1.Servejerc12.Model.Coche;

@RestController
@RequestMapping("/api/coches")
public class CocheController {



    @GetMapping
    public List<Coche> getAllCars() {
        List<Coche> Coches = new ArrayList<>();
        Coches.add(new Coche(1l, "Toyota", "Corolla", 2020));
        Coches.add(new Coche(2l, "Honda", "Civic", 2019));
        Coches.add(new Coche(3l, "Ford", "Focus", 2018));
        return Coches;
    }

    // @GetMapping("/{id}")
    // public Coche getCarById(@PathVariable Long id) {
    //     return Coches.stream().filter(Coche -> Coche.getId().equals(id)).findFirst().orElse(null);
    // }

    // @PostMapping
    // @ResponseStatus(HttpStatus.CREATED)
    // public void createCar(@RequestBody Coche Coche) {
    //     Coche.setId(idCounter.incrementAndGet());
    //     Coches.add(Coche);
    // }

    // @PutMapping("/{id}")
    // public Coche updateCar(@PathVariable Long id, @RequestBody Coche updatedCar) {
    //     Coche Coche = Coches.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    //     if (Coche != null) {
    //         Coche.setMake(updatedCar.getMake());
    //         Coche.setModel(updatedCar.getModel());
    //         Coche.setYear(updatedCar.getYear());
    //     }
    //     return Coche;
    // }

    // @DeleteMapping("/{id}")
    // public void deleteCar(@PathVariable Long id) {
    //     Coches.removeIf(Coche -> Coche.getId().equals(id));
    // }
}