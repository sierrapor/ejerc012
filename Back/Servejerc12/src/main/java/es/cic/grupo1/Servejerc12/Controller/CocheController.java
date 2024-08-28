package es.cic.grupo1.Servejerc12.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.cic.grupo1.Servejerc12.Model.Coche;
import es.cic.grupo1.Servejerc12.Service.CocheService;

@RestController
@RequestMapping("/api/coches")
public class CocheController {

    @Autowired
    private CocheService cocheService;

    @GetMapping
    public List<Coche> getAllCars() {
        return cocheService.getAllCars();
    }

    @GetMapping("/{id}")
    public Coche getCarById(@PathVariable Long id) {
        return cocheService.getCarById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Coche createCar(@RequestBody Coche coche) {
        return cocheService.createCar(coche);
    }

    @PutMapping("/{id}")
    public Coche updateCar(@PathVariable Long id, @RequestBody Coche updatedCar) {
        return cocheService.updateCar(id, updatedCar);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        cocheService.deleteCar(id);
    }

}