package com.EcoMarketSPA.pago.repository;

import com.EcoMarketSPA.pago.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {

    // Puedes buscar un pago por el idPedido para validar o consultar pagos existentes
    Optional<Pago> findByIdPedido(Long idPedido);

}
