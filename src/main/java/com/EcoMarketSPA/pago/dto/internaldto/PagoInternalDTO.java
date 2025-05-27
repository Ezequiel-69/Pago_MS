package com.EcoMarketSPA.pago.dto.internaldto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PagoInternalDTO {
    private Long idPedido;
    private Double monto;
    private String metodoPago;
    private String estado;
}