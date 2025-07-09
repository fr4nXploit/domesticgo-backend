package pe.edu.upc.domesticgo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.domesticgo.entities.Resenia;

import java.util.List;

@Repository
public interface IReseniaRepository extends JpaRepository<Resenia, Integer> {

    // US05 - Calcular el total de reseñas por trabajador
    @Query("SELECT s.contrato.contratado.idUsuario, " +
            "CONCAT(s.contrato.contratado.nombres, ' ', s.contrato.contratado.apellidoPaterno), " +
            "COUNT(r) " +
            "FROM Resenia r " +
            "JOIN r.servicio s " +
            "GROUP BY s.contrato.contratado.idUsuario, s.contrato.contratado.nombres, s.contrato.contratado.apellidoPaterno")
    List<Object[]> contarReseniasPorTrabajador();
}
