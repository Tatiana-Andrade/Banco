package model;

public class Cliente extends Banco {
    private String id;
    private String nombre;
    private String apellido;
    private String direccion;
    private String correo;

    public Cliente(String id, String nombre, String apellido, String direccion, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.correo = correo;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCorreo() {
        return correo;
    }

}
