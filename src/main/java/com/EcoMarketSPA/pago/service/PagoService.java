package com.EcoMarketSPA.pago.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EcoMarketSPA.pago.dto.externaldto.PagoRequestDTO;
import com.EcoMarketSPA.pago.dto.sercheddto.PagoResponseDTO;
import com.EcoMarketSPA.pago.enums.EstadoPago;
import com.EcoMarketSPA.pago.enums.MetodoPago;
import com.EcoMarketSPA.pago.model.Pago;
import com.EcoMarketSPA.pago.repository.PagoRepository;

@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    // Procesa y crea un pago basado en una solicitud desde Pedido
    public PagoResponseDTO procesarPago(PagoRequestDTO pagoRequest) {

        MetodoPago metodo = MetodoPago.valueOf(pagoRequest.getMetodoPago());
        EstadoPago estado;

        switch (metodo) {
            case TARJETA:
                estado = EstadoPago.CONFIRMADO;
                break;

            case EFECTIVO:
                estado = EstadoPago.PENDIENTE;
                break;

            case TRANSFERENCIA:
                estado = Math.random() < 0.5 ? EstadoPago.CONFIRMADO : EstadoPago.FALLIDO;
                break;

            default:
                throw new IllegalArgumentException("Método de pago no soportado: " + metodo);
        }

        Pago pago = Pago.builder()
                .idPedido(pagoRequest.getIdPedido())
                .monto(pagoRequest.getMonto())
                .metodoPago(metodo)
                .estado(estado)
                .build();

        pagoRepository.save(pago);

        return PagoResponseDTO.builder()
                .idPedido(pago.getIdPedido())
                .estado(estado.name()) // Convertido a String para el DTO externo
                .metodoPago(metodo.name())
                .pagoExitoso(estado == EstadoPago.CONFIRMADO || estado == EstadoPago.PENDIENTE)
                .build();
    }



    


}

