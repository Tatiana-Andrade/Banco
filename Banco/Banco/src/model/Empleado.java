package model;

import java.util.ArrayList;

public class Empleado extends Banco {
	
	private String nombre;
	private String numeroId;
	private ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
	private ArrayList<Registro> registros =new ArrayList<Registro>();
	
	public Empleado(String nombre, String numeroId) {
		super();
		this.nombre = nombre;
		this.numeroId = numeroId;
	}

	public String getNombre() {
		return nombre;
	}

	
	public String getNumeroId() {
		return numeroId;
	}

	public ArrayList<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuentas.add(cuenta);
	}

	public ArrayList<Registro> getRegistros() {
		return registros;
	}

	public void setRegistro(Registro registro) {
		this.registros.add(registro);
	}

	
	
	
}
