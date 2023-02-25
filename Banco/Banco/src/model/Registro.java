package model;
import java.time.LocalDateTime;

public class Registro {
	
	private String fechaHora;
	private String cuenta;
	private String monto;
	private TipoTransaccion transaccion;
	private EstadoTransaccion estado;
	
	public Registro(String cuenta, float monto) {
		super();
		this.fechaHora = asignarFechaActual();
		this.cuenta = cuenta;
		this.monto = String.valueOf(monto);
	}

	public String getFechaHora() {
		return fechaHora;
	}
	public String asignarFechaActual() {
		LocalDateTime fecha = LocalDateTime.now();
		String dia = String.valueOf(fecha.getDayOfMonth());
		String mes = String.valueOf(fecha.getMonthValue());
		String ano= String.valueOf(fecha.getYear());
		
		return dia+"/"+mes+"/"+ano;
	}

	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	} 

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public String getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = String.valueOf(monto);
	}

	public TipoTransaccion getTransaccion() {
		return transaccion;
	}

	public void setTransaccion(TipoTransaccion transaccion) {
		this.transaccion = transaccion;
	}

	public EstadoTransaccion getEstado() {
		return estado;
	}

	public void setEstado(EstadoTransaccion estado) {
		this.estado = estado;
	}
	
	
	

}
