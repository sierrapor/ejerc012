package es.cic.grupo1.Servejerc12.Service;

import es.cic.grupo1.Servejerc12.Model.Coche;
import java.util.List;

public interface CocheService {
    List<Coche> getAllCars();
    Coche getCarById(Long id);
    Coche createCar(Coche coche);
    Coche updateCar(Long id, Coche coche);
    void deleteCar(Long id);
}