package com.EcoMarketSPA.pago.controller;

import com.EcoMarketSPA.pago.dto.externaldto.PagoRequestDTO;
import com.EcoMarketSPA.pago.dto.sercheddto.PagoResponseDTO;
import com.EcoMarketSPA.pago.service.PagoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    // 1️⃣ Procesar un nuevo pago
    @PostMapping
    public ResponseEntity<PagoResponseDTO> procesarPago(@RequestBody PagoRequestDTO pagoRequest) {
        PagoResponseDTO response = pagoService.procesarPago(pagoRequest);
        return ResponseEntity.ok(response);
    }

    // 2️⃣ Confirmar un pago en efectivo
    @PutMapping("/confirmar/{idPedido}")
    public ResponseEntity<PagoResponseDTO> confirmarPagoEfectivo(@PathVariable Long idPedido) {
        PagoResponseDTO response = pagoService.confirmarPagoEfectivo(idPedido);
        return ResponseEntity.ok(response);
    }
}

