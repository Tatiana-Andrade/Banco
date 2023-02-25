package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Cliente;
import model.Empleado;
import model.EstadoTransaccion;
import model.Registro;
import model.Cuenta;
import model.TipoCuenta;
import model.TipoTransaccion;
import model.TipoUsuario;

public class LoginController implements Initializable{

    @FXML
    private TextField tfContrasena;
    
    @FXML
    private Button Ingresar;


    @FXML
    private TextField tfNumeroId;

    private ArrayList<Cuenta> clientes = new ArrayList<Cuenta>();
    private ArrayList<Empleado> empleados = new ArrayList<Empleado>();
    static Cuenta cuentaIngresada = null;
    static Empleado cuentaEmpleado = null;
    static TipoUsuario tipoUsuario =null;
    
    public void actualizar (ArrayList<Cuenta> clientes) {
    	this.clientes=clientes;
    	//this.empleados=empleados;
    }
    
    public TipoUsuario asignacionTipoCuenta () {
    	
    	if(cuentaIngresada != null) {
    		return TipoUsuario.CLIENTE;
    	}
    	if(cuentaEmpleado != null) {
    		return TipoUsuario.EMPLEADO;
    	}
    	return null;
    }
    
    public void buscarCuenta(String tfContrasena,String tfNumeroId) {
    	
    	if(tfContrasena.equalsIgnoreCase(tfNumeroId)) {
    		for(Cuenta a: clientes) {
        		if(a.getIdUsuario().equalsIgnoreCase(tfNumeroId)) {
        			cuentaIngresada = a;
        		}
        	}
    		for(Empleado a: empleados) {
        		if(a.getNumeroId().equalsIgnoreCase(tfNumeroId)) {
        			cuentaEmpleado = a;
        		}
    		}    
    	}
    }
    
    @FXML
    void onIngresarBanco(ActionEvent event)  {
    	if(event.getSource()== Ingresar){
            String username = tfNumeroId.getText();
            String contrasena = tfContrasena.getText();
            buscarCuenta(contrasena, username);
            tipoUsuario = asignacionTipoCuenta();
            	if(tipoUsuario == TipoUsuario.CLIENTE && cuentaIngresada != null) {
            		System.out.println("Ingreso Exitoso");
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Cliente.fxml"));
            		Parent root;
            		try {
            			root = loader.load();
            			ClienteController controller = loader.getController();
            			Scene scene =new Scene(root);
            			Stage stage = new Stage();
            			stage.setScene(scene);
            			controller.init(cuentaIngresada,stage,this);
            			stage.show();
            			this.stage.close();
            			} catch (IOException e) {
            			// TODO Auto-generated catch block
            			e.printStackTrace();
            		}
            	}
            	if(tipoUsuario == TipoUsuario.EMPLEADO && cuentaEmpleado != null ) {
            		System.out.println("Ingreso Exitoso");
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Empleado.fxml"));
            		Parent root;
            		try {
            			root = loader.load();
            			EmpleadoController controller1 = loader.getController();
            			Scene scene =new Scene(root);
            			Stage stage = new Stage();
            			stage.setScene(scene);
            			controller1.init(cuentaEmpleado, stage, this);
            			stage.show();
            			this.stage.close();
            			} catch (IOException e) {
            			// TODO Auto-generated catch block
            			e.printStackTrace();
            			
            		}
            	}
    	}
    }
    public void cerrarCuenta (TipoUsuario tipo) {
    	if(tipo==TipoUsuario.CLIENTE) {
    		cuentaIngresada=null;
    	}
    	if(tipo==TipoUsuario.EMPLEADO) {
    		cuentaEmpleado=null;
    	}
    }

    private Stage stage ;
	public void setStage(Stage primaryStage) {
		// TODO Auto-generated method stub
		this.stage = primaryStage;
		
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Cuenta clienteUno = new Cuenta (TipoCuenta.CORRIENTE,"12345",500000,"Carmen");
		Cuenta clienteDos = new Cuenta (TipoCuenta.AHORRO,"3457821324",0,"Andres");
		Cuenta clienteTres = new Cuenta (TipoCuenta.CORRIENTE,"2589863",1000,"Diego");
		Cuenta clienteCuatro = new Cuenta (TipoCuenta.AHORRO,"97254324",0,"Sandra");
		Empleado empleadoUno = new Empleado ("Jhoan","098765");
		
		
		//Registro registro = new Registro ("13/02/2023","567","25000",TipoTransaccion.RETIRO,EstadoTransaccion.EXITOSA);
		
		clientes.add(clienteUno);
		clientes.add(clienteDos);
		clientes.add(clienteTres);
		clientes.add(clienteCuatro);
		empleados.add(empleadoUno);
		empleadoUno.setCuenta(clienteUno);
		empleadoUno.setCuenta(clienteDos);
		empleadoUno.setCuenta(clienteCuatro);
		empleadoUno.setCuenta(clienteTres);
	}
	public void Show() {
		stage.show();
	}
	
	

}
