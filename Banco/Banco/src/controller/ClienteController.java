package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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


public class ClienteController implements Initializable{
	
	
    @FXML
    private Button btnRetirar;

    @FXML
    private Button btnSalir;

    @FXML
    private TableColumn<Registro, EstadoTransaccion> colEstado;

    @FXML
    private TableColumn<Registro, String> colFecha;

    @FXML
    private TableColumn<Registro, String> colMonto;

    @FXML
    private TableColumn<Registro, TipoTransaccion> colTransaacion;

    @FXML
    private Label lblNumeroCuenta;

    @FXML
    private Label lblNumeroIdentificacion;

    @FXML
    private Label lblSaldo;

    @FXML
    private TableView<Registro> tableRegistroClientes;

    @FXML
    private TextField tfMontoRetiro;
    private Cuenta cuentaUsuario;
    private LoginController controllerLogin;
    private Stage stage;
    ObservableList<Registro> registros = FXCollections.observableArrayList();
    
    
 

    @FXML
    void onRetirar(ActionEvent event) {
    	String cuenta = cuentaUsuario.getIdUsuario();
    	String monto = tfMontoRetiro.getText();
    	TipoTransaccion transaccion = TipoTransaccion.RETIRO;
    	EstadoTransaccion estado = EstadoTransaccion.EXITOSA;
    	Registro registroNuevo = new Registro(cuenta, Float.valueOf(monto));
    	registroNuevo.setEstado(estado);
    	registroNuevo.setTransaccion(transaccion);
    	if( Float.valueOf(monto)!= null || Float.valueOf(monto)>0) {
    	if(cuentaUsuario.getSaldo() >= Float.valueOf(monto)) {
    		float saldoActual = cuentaUsuario.getSaldo()-Float.valueOf(monto);
    		cuentaUsuario.setSaldo(saldoActual);
    		lblSaldo.setText(String.valueOf(saldoActual));
    		registros.add(registroNuevo);
    		tableRegistroClientes.setItems(registros);
    		}else {
    			Alert saldoInsuficiente = new Alert(Alert.AlertType.ERROR);
    			saldoInsuficiente.setTitle("Saldo Insuficiente");
    			saldoInsuficiente.setContentText("Susaldo es Insuficientes para realizar un retiro, por favor deposita :D");
    			saldoInsuficiente.showAndWait();

    		}
    	}
    	}

    
    @FXML
    void onSalir(ActionEvent event) {
    
    	controllerLogin.Show();
    	stage.close();
    	controllerLogin.cerrarCuenta(TipoUsuario.CLIENTE);

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		registros = FXCollections.observableArrayList();
		this.colFecha.setCellValueFactory(new PropertyValueFactory<>("fechaHora"));
		this.colTransaacion.setCellValueFactory(new PropertyValueFactory<>("transaccion"));
		this.colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
		this.colMonto.setCellValueFactory(new PropertyValueFactory<>("monto"));
		
	}
	
	public void init(Cuenta cuentaIngresada,Stage stage,LoginController controllerLogin) {
		this.controllerLogin=controllerLogin;
		this.stage=stage;
		cuentaUsuario=cuentaIngresada;
	/*	Registro r1 = new Registro ("abc",100);
		r1.setEstado(EstadoTransaccion.EXITOSA);
		cuentaIngresada.setRegistro(r1);*/
		for(Registro r : cuentaIngresada.getRegistros()) {
			if(!this.registros.contains(r)) {
				this.registros.add(r);
				tableRegistroClientes.setItems(registros);
			}
		}
		lblNumeroIdentificacion.setText(cuentaIngresada.getIdUsuario());
		lblNumeroCuenta.setText(cuentaIngresada.getNumeroCuenta());
		lblSaldo.setText(String.valueOf(cuentaIngresada.getSaldo()));

		
		
		
		

		/*this.colFecha.setCellValueFactory(new PropertyValueFactory("03/12/2020"));
		this.colTransaacion.setCellValueFactory(new PropertyValueFactory("Transaccion"));
		this.colMonto.setCellValueFactory(new PropertyValueFactory("Monto"));*/
		
		
	}

}
