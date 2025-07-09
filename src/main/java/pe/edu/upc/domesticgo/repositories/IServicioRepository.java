package pe.edu.upc.domesticgo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.domesticgo.entities.Servicio;

import java.util.List;

@Repository
public interface IServicioRepository extends JpaRepository<Servicio, Integer> {

    // US02 - Mostrar el número total de servicios pendientes
    @Query("SELECT COUNT(s) FROM Servicio s WHERE s.estadoServicio = 'PENDIENTE'")
    Long contarServiciosPendientes();

    // US03 - Calcular el total de ingresos generados por cada servicio
    @Query("SELECT s.tipoServicio, SUM(p.montoPago) " +
            "FROM Servicio s " +
            "JOIN Pago p ON p.contrato = s.contrato " +
            "GROUP BY s.tipoServicio")
    List<Object[]> calcularIngresosPorTipoServicio();
}
