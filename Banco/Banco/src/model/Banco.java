package model;
import java.util.ArrayList;
import java.util.List;

public class Banco {
	private List<Cliente> clientes;
    private List<Cuenta> cuentas;
    private List<Empleado> empelados;
    private List<Transaccion> transacciones;


    public Banco() {
        this.clientes = new ArrayList<>();
        this.cuentas = new ArrayList<>();
        this.empelados = new ArrayList<>();
        this.transacciones = new ArrayList<>();

    }


    public List<Cliente> getClientes() {
        return clientes;

    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public List<Empleado> getEmpelados() {
        return empelados;
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

}
