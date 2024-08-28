package es.cic.grupo1.Servejerc12.Service;

import es.cic.grupo1.Servejerc12.Model.Make;
import java.util.List;

public interface MakeService {
    List<Make> getAllMake();
    Make getMakeById(Long id);
    Make createMake(Make make);
    Make updateMake(Long id, Make make);
    void deleteMake(Long id);
}
