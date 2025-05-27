package com.EcoMarketSPA.pago.dto.sercheddto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PagoResponseDTO {
    private Long idPedido;
    private String estado;       // "CONFIRMADO", "PENDIENTE", "FALLIDO"
    private String metodoPago;
    private boolean pagoExitoso;
}