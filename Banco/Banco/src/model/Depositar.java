package model;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.List;

public class Depositar extends Transaccion {


	    private String numeroCuenta;
	    private TipoCuenta tipoCuenta;
	    private List<Cuenta> cuentas;

	    public Depositar( String numeroCuenta, float registroValor, EstadoTransaccion estadoTansaccion, LocalDateTime hora,
	                     LocalDateTime fecha, TipoCuenta tipoCuenta) {
	        super(registroValor, estadoTansaccion, hora, fecha);
	        this.tipoCuenta= tipoCuenta;
	        this.numeroCuenta=numeroCuenta;
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
	    public  void depositarSaldo( float registrarValor,Cuenta cuenta,  TipoCuenta tipoCuenta){
	        Objects.requireNonNull(cuenta, " el numero de cuenta no puede estar vacio");
	        Objects.requireNonNull(tipoCuenta, " el tipo de cuenta  no puede estar vacio");
	        Objects.requireNonNull(registrarValor, " el saldo no puede ser cero");


	        cuenta.setSaldo(registrarValor + cuenta.getSaldo());



	    }
	    public List<Cuenta> getCuentas() {

	        return cuentas;
	    }

	    public TipoCuenta getTipoCuenta() {

	        return tipoCuenta;
	    }

	    public String getNumeroCuenta() {
	        return numeroCuenta;
	    }



}
