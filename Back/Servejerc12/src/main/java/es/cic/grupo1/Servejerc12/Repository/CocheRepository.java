package es.cic.grupo1.Servejerc12.Repository;

import es.cic.grupo1.Servejerc12.Model.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CocheRepository extends JpaRepository<Coche, Long> {
}