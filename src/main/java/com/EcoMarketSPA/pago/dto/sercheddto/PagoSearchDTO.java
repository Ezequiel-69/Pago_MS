package com.EcoMarketSPA.pago.dto.sercheddto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PagoSearchDTO {
    private Long idPago;
    private Long idPedido;
    private String metodoPago;
    private String estado;
    private Double monto;
    private LocalDateTime fechaPago;
}