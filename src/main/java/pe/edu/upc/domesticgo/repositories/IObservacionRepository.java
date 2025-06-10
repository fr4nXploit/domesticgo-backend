package pe.edu.upc.domesticgo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.domesticgo.entities.Observacion;

@Repository
public interface IObservacionRepository extends JpaRepository<Observacion, Integer> {
}
