package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Cuenta;
import model.Empleado;
import model.EstadoTransaccion;
import model.Registro;
import model.TipoTransaccion;
import model.TipoUsuario;

public class EmpleadoController implements Initializable{

    @FXML
    private Button btnDeposito;

    @FXML
    private Button btnSalir;

    @FXML
    private TableColumn<Registro,  String> colCuenta;

    @FXML
    private TableColumn<Registro, EstadoTransaccion> colEstado;

    @FXML
    private TableColumn<Registro, String> colFecha;

    @FXML
    private TableColumn<Registro, String> colMonto;

    @FXML
    private Label lblNombreEmpleado;

    @FXML
    private TableView<Registro> tableRegistroClientes;

    @FXML
    private TextField tfCuentaCliente;

    @FXML
    private TextField tfMontoDeposito;
    
    private LoginController controllerLogin;
    private Stage stage;
    private Empleado cuentaUsuario;
    ObservableList<Registro> registros = FXCollections.observableArrayList();

    @FXML
    void onDepositar(ActionEvent event) {
    	String cuenta = tfCuentaCliente.getText();
    	String monto = tfMontoDeposito.getText() ;
    	
    	for(Cuenta cuentaUno : cuentaUsuario.getCuentas()){
    		
    		if(cuentaUno.getNumeroCuenta().equalsIgnoreCase(cuenta)) {
    			TipoTransaccion transaccion = TipoTransaccion.DEPOSITO;
            	EstadoTransaccion estado = EstadoTransaccion.EXITOSA;
            	Registro registroNuevo = new Registro(cuenta, Float.valueOf(monto));
            	registroNuevo.setEstado(estado);
            	registroNuevo.setTransaccion(transaccion);
            	registros.add(registroNuevo);
            	tableRegistroClientes.setItems(registros);
            	
                Alert saldoInsuficiente = new Alert(Alert.AlertType.INFORMATION);
        		saldoInsuficiente.setTitle("Transaccion Exitosa");
        		saldoInsuficiente.setContentText("La transaccion fue valida");
        		saldoInsuficiente.showAndWait();
        		
        		cuentaUno.setRegistro(registroNuevo);
            	cuentaUno.setSaldo(Float.valueOf(monto)+cuentaUno.getSaldo());
        		controllerLogin.actualizar(cuentaUsuario.getCuentas());
    		}if(!cuentaUno.getNumeroCuenta().equalsIgnoreCase(cuenta)){
    			Alert saldoInsuficiente = new Alert(Alert.AlertType.INFORMATION);
    			saldoInsuficiente.setTitle("Cuenta");
    			saldoInsuficiente.setContentText("Esta cuenta no fue encontrada");
    			saldoInsuficiente.showAndWait();
    		}
    		
    	}
    }
    

    @FXML
    void onSalir(ActionEvent event) {
    	controllerLogin.Show();
    	stage.close();
    	controllerLogin.cerrarCuenta(TipoUsuario.EMPLEADO);
    	

    }

	public void init(Empleado cuentaEmpleado,Stage stage,LoginController controllerLogin) {
		lblNombreEmpleado.setText(cuentaEmpleado.getNombre());
		this.controllerLogin=controllerLogin;
		this.stage=stage;
		cuentaUsuario=cuentaEmpleado;
		for(Registro r : cuentaEmpleado.getRegistros()) {
			if(!this.registros.contains(r)) {
				this.registros.add(r);
				tableRegistroClientes.setItems(registros);
			}
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		registros = FXCollections.observableArrayList();
		this.colFecha.setCellValueFactory(new PropertyValueFactory<>("fechaHora"));
		this.colCuenta.setCellValueFactory(new PropertyValueFactory<>("cuenta"));
		this.colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
		this.colMonto.setCellValueFactory(new PropertyValueFactory<>("monto"));
		
		
	}

}
