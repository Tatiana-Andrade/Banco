package model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Retiro extends Transaccion{
    private List<Cuenta> cuentas;

    public Retiro(float registroValor, EstadoTransaccion estadoTransaccion, LocalDateTime hora, LocalDateTime fecha) {
        super(registroValor, estadoTransaccion, hora, fecha);


    }

    public Cuenta buscarCuenta(String numeroCuenta) {


        Objects.requireNonNull(numeroCuenta, " el numero de cuenta no puede estar vacio");

        return cuentas.stream()

                .filter((cuentas) -> cuentas.getNumeroCuenta().equals(numeroCuenta)
                )
                // encontrar el primero
                .findFirst()
                // si no lo encuentra me va arrojar vacio
                .orElse(null);


    }
    /*public void retirarDinero(TipoCuenta tipoCuenta, String numeroCuenta,float saldo){

        Objects.requireNonNull(saldo, " el valor a retirar no puede estar vacio");

        cuentas.remove(new Cuenta( tipoCuenta, numeroCuenta,saldo,IdUsuario,));
    }*/

}
