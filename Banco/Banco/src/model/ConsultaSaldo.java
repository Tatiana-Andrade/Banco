package model;

import java.util.Objects;
import java.time.LocalDateTime;
import java.util.List;


public class ConsultaSaldo extends Transaccion {

    private String numeroCuenta;
    private List<Cuenta> cuentas;

    public ConsultaSaldo(String numeroCuenta, float registroValor, EstadoTransaccion estadoTansaccion, LocalDateTime hora, LocalDateTime fecha) {
        super(registroValor, estadoTansaccion, hora, fecha);
       this.numeroCuenta = numeroCuenta;
    }

    public Cuenta buscarCuenta( String numeroCuenta) {


        Objects.requireNonNull(numeroCuenta, " el numero de cuenta no puede estar vacio");

        return cuentas.stream()

                .filter((cuentas) -> cuentas.getNumeroCuenta().equals(numeroCuenta)
                )
                // encontrar el primero
                .findFirst()
                // si no lo encuentra me va arrojar vacio
                .orElse(null);

    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }
}
