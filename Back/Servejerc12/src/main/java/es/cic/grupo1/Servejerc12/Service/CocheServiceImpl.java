package es.cic.grupo1.Servejerc12.Service;

import es.cic.grupo1.Servejerc12.Model.Coche;
import es.cic.grupo1.Servejerc12.Repository.CocheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CocheServiceImpl implements CocheService {

    @Autowired
    private CocheRepository cocheRepository;

    @Override
    public List<Coche> getAllCars() {
        return cocheRepository.findAll();
    }

    @Override
    public Coche getCarById(Long id) {
        return cocheRepository.findById(id).orElse(null);
    }

    @Override
    public Coche createCar(Coche coche) {
        return cocheRepository.save(coche);
    }

    @Override
    public Coche updateCar(Long id, Coche coche) {
        if (cocheRepository.existsById(id)) {
            coche.setId(id);
            return cocheRepository.save(coche);
        }
        return null;
    }

    @Override
    public void deleteCar(Long id) {
        cocheRepository.deleteById(id);
    }
}