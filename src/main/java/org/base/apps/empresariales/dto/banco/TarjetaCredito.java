package org.base.apps.empresariales.dto.banco;

public class TarjetaCredito implements Pagable{
    @Override
    public String procesarPago() {
        return "Se esta procesando el pago con la tarjeta de credito";
    }
}
