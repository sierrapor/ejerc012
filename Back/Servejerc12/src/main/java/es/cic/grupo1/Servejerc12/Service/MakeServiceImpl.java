package es.cic.grupo1.Servejerc12.Service;

import es.cic.grupo1.Servejerc12.Model.Make;
import es.cic.grupo1.Servejerc12.Repository.MakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MakeServiceImpl implements MakeService {

    @Autowired
    private MakeRepository makeRepository;

    @Override
    public List<Make> getAllMake() {
        return makeRepository.findAll();
    }

    @Override
    public Make getMakeById(Long id) {
        return makeRepository.findById(id).orElse(null);
    }

    @Override
    public Make createMake(Make make) {
        return makeRepository.save(make);
    }

    @Override
    public Make updateMake(Long id, Make make) {
        if (makeRepository.existsById(id)) {
            make.setId(id);
            return makeRepository.save(make);
        }
        return null;
    }

    @Override
    public void deleteMake(Long id) {
        makeRepository.deleteById(id);
    }
}