package model;

import java.util.ArrayList;

public class Cuenta extends Banco{
	private TipoCuenta tipoCuenta;
    private String numeroCuenta;
    private float saldo;
    private String IdUsuario;
    private ArrayList<Registro> registros = new ArrayList<Registro>();

    public Cuenta(TipoCuenta tipoCuenta, String numeroCuenta, float saldo, String IdUsuario) {
        this.tipoCuenta = tipoCuenta;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.IdUsuario = IdUsuario;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

	public String getIdUsuario() {
		return IdUsuario;
	}

	public ArrayList<Registro> getRegistros() {
		return registros;
	}

	public void setRegistro(Registro registro) {
		this.registros.add(registro);
	}
    
}
