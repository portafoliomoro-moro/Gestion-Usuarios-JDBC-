package gestion_usuarios.dominio;

import java.util.Objects;

public class Usuario {
    private int id;
    private String tipo_documento;
    private String numero_documento;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String telefono;
    private String correo;
    private String llave_saber;

    public Usuario(){}

    //Constructor para buscar y eliminar
    public Usuario(int id){
        this.id = id;
    }

    //Constructor para agregar
    public Usuario(String tipo_documento, String numero_documento, String nombres, String apellidos,
                    String direccion, String telefono, String correo, String llave_saber)
    {
        this.tipo_documento = tipo_documento;
        this.numero_documento = numero_documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.llave_saber = llave_saber;
    }

    //Constructor para modificar
    public Usuario(int id, String tipo_documento, String numero_documento, String nombres, String apellidos,
                   String direccion, String telefono, String correo, String llave_saber)
    {
        this(tipo_documento, numero_documento, nombres, apellidos, direccion, telefono, correo, llave_saber);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(String numero_documento) {
        this.numero_documento = numero_documento;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getLlave_saber() {
        return llave_saber;
    }

    public void setLlave_saber(String llave_saber) {
        this.llave_saber = llave_saber;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", tipo_documento='" + tipo_documento + '\'' +
                ", numero_documento='" + numero_documento + '\'' +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", llave_saber='" + llave_saber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id == usuario.id && Objects.equals(tipo_documento, usuario.tipo_documento) && Objects.equals(numero_documento, usuario.numero_documento) && Objects.equals(nombres, usuario.nombres) && Objects.equals(apellidos, usuario.apellidos) && Objects.equals(direccion, usuario.direccion) && Objects.equals(telefono, usuario.telefono) && Objects.equals(correo, usuario.correo) && Objects.equals(llave_saber, usuario.llave_saber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipo_documento, numero_documento, nombres, apellidos, direccion, telefono, correo, llave_saber);
    }
}
