package com.EcoMarketSPA.pago.dto.externaldto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PagoRequestDTO {
    private Long idPedido;
    private Double monto;
    private String metodoPago; // Ejemplo: "TARJETA", "EFECTIVO", "TRANSFERENCIA"
}