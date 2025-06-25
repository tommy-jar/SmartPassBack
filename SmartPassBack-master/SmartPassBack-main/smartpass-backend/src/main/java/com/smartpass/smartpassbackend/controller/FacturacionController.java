package com.smartpass.smartpassbackend.controller;

import com.smartpass.smartpassbackend.model.Cliente;
import com.smartpass.smartpassbackend.model.Factura;
import com.smartpass.smartpassbackend.service.FacturacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/facturacion")
@CrossOrigin(origins = "*")
public class FacturacionController {

    @Autowired
    private FacturacionService facturacionService;

    @PostMapping("/prepago/{idTransito}")
    public String facturarPrepago(@PathVariable Long idTransito) {
        return facturacionService.generarFacturaPrepago(idTransito);
    }

    @PostMapping("/pospago")
    public String facturarPospago(@RequestParam("inicio") String inicioStr,
                                  @RequestParam("fin") String finStr,
                                  @RequestParam("cliente") Long idCliente) {
        LocalDateTime inicio = LocalDateTime.parse(inicioStr);
        LocalDateTime fin = LocalDateTime.parse(finStr);
        return facturacionService.generarFacturaPospago(inicio, fin, idCliente);
    }

    @GetMapping("/cliente/{idCliente}")
    public List<Factura> obtenerFacturasPorCliente(@PathVariable Long idCliente) {
        return facturacionService.obtenerPorCliente(idCliente);
    }


}