package com.andresyfr.connect.drive.controllers;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/detallePedidos")
public class DetallePedidoController {


    @GetMapping
    public List<?> getAllDetallePedidos() {
        return List.of();
    }

    @GetMapping("/{id}")
    public Long getDetallePedidoById(@PathVariable Long id) {
        return Long.MAX_VALUE;
    }

    @PostMapping
    public String createDetallePedido(@RequestBody String detallePedido) {
        return detallePedido;
    }

    @PutMapping("/{id}")
    public String updateDetallePedido(@PathVariable Long id, @RequestBody String detallePedido) {
        return detallePedido;
    }

    @PatchMapping("/{id}")
    public String partialUpdateDetallePedido(@PathVariable Long id, @RequestBody String detallePedido) {
        return detallePedido;
    }

    @DeleteMapping("/{id}")
    public void deleteDetallePedido(@PathVariable Long id) {
    }
}