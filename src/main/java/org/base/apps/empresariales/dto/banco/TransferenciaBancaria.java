package org.base.apps.empresariales.dto.banco;

public class TransferenciaBancaria implements Pagable {
    @Override
    public String procesarPago() {
        return "Se esta procesando el pago en la transferencia bancaria";
    }
}
