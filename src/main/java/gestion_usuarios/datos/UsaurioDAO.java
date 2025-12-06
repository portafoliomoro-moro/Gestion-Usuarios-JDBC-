package gestion_usuarios.datos;

import gestion_usuarios.dominio.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static gestion_usuarios.conexion.Conexion.getConexion;

public class UsaurioDAO implements IUsuarioDAO{

    @Override
    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        var sql = "SELECT * FROM usuarios ORDER BY id_usuario";
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                var usuario = new Usuario();
                usuario.setId_usuario(rs.getInt("id_usuario"));
                usuario.setTipo_documento(rs.getString("tipo_documento"));
                usuario.setNumero_documento(rs.getString("numero_documento"));
                usuario.setNombres(rs.getString("nombres"));
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setDireccion(rs.getString("direccion"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setLlave_saber(rs.getString("llave_saber"));
                usuarios.add(usuario);
            }
        }catch(Exception e){
            System.out.println("Error al listar los usuarios: " + e.getMessage());
        }
        finally {
            try{
                con.close();
            }catch(Exception e){
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return usuarios;
    }

    @Override
    public boolean buscarUsuarioPorId(Usuario usuario) {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        var sql = "SELECT * FROM usuarios WHERE id_usuario = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, usuario.getId_usuario());
            rs = ps.executeQuery();
            if(rs.next()){
                usuario.setId_usuario(rs.getInt("id_usuario"));
                usuario.setTipo_documento(rs.getString("tipo_documento"));
                usuario.setNumero_documento(rs.getString("numero_documento"));
                usuario.setNombres(rs.getString("nombres"));
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setDireccion(rs.getString("direccion"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setLlave_saber(rs.getString("llave_saber"));
                return true;
            }
        }catch(Exception e){
            System.out.println("Error al buscar registro por Id: " + e.getMessage());
        }
        finally {
            try{
                con.close();
            }catch(Exception e){
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean agregarUdsuario(Usuario usuario) {
        PreparedStatement ps;
        Connection con = getConexion();
        var sql = "INSERT INTO usuarios (tipo_documento, numero_documento, nombres, apellidos," +
                "direccion, telefono, correo, llave_saber) VALUES (?,?,?,?,?,?,?,?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getTipo_documento());
            ps.setString(2, usuario.getNumero_documento());
            ps.setString(3, usuario.getNombres());
            ps.setString(4, usuario.getApellidos());
            ps.setString(5, usuario.getDireccion());
            ps.setString(6, usuario.getTelefono());
            ps.setString(7, usuario.getCorreo());
            ps.setString(8, usuario.getLlave_saber());
            ps.execute();
            return true;
        }catch(Exception e){
            System.out.println("Error al agregar usuario: " + e.getMessage());
        }
        finally {
            try{
                con.close();
            }catch(Exception e){
                System.out.println("Errro al cerrar la conexión:  " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean modificarUsuario(Usuario usuario) {
        PreparedStatement ps;
        Connection con = getConexion();
        var sql = "UPDATE usuarios " +
                "SET tipo_documento=?, numero_documento=?, nombres=?, apellidos=?, direccion=?, telefono=?, correo=?, llave_saber=? " +
                "WHERE id_usuario=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getTipo_documento());
            ps.setString(2, usuario.getNumero_documento());
            ps.setString(3, usuario.getNombres());
            ps.setString(4, usuario.getApellidos());
            ps.setString(5, usuario.getDireccion());
            ps.setString(6, usuario.getTelefono());
            ps.setString(7, usuario.getCorreo());
            ps.setString(8, usuario.getLlave_saber());
            ps.setInt(9, usuario.getId_usuario());
            ps.execute();
            return true;
        }catch(Exception e){
            System.out.println("Error al modificar usuario: " + e.getMessage());
        }
        finally {
            try{
                con.close();
            }catch(Exception e){
                System.out.println("Errro al cerrar la conexión:  " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean eliminarUsuario(Usuario usuario) {
        PreparedStatement ps;
        Connection con = getConexion();
        var sql = "DELETE FROM usuarios WHERE id_usuario=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, usuario.getId_usuario());
            ps.execute();
            return true;
        }catch(Exception e){
            System.out.println("Error al eliminar un usuario: " + e.getMessage());
        }
        finally {
            try{
                con.close();
            }catch(Exception e){
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return false;
    }

//    public static void main(String[] args) {
//        IUsuarioDAO usuarioDAO = new UsaurioDAO();
////        System.out.println("*** Listar Usuarios ***");
//        var listar = usuarioDAO.listarUsuarios();
//        listar.forEach(System.out::println);

//        System.out.println("*** Buscar ***");
//        var buscar = new Usuario(1);
//        var encontrado = usuarioDAO.buscarUsuarioPorId(buscar);
//        if(encontrado){
//            System.out.println("Usuario encontrado: " + buscar);
//        }
//        else{
//            System.out.println("Usuario No encontrado: " + buscar);
//        }

//        System.out.println("*** Agregar ***");
//        var agregar = new Usuario("TI", "46444664", "Mihail", "Tal", "calle 10", "6549466",
//                "tal@mail.com", "LO02");
//        var agregado = usuarioDAO.agregarUdsuario(agregar);
//        if(agregado){
//            System.out.println("Usuario agregado: " + agregar);
//        }
//        else{
//            System.out.println("Usuario No agregado: " + agregar);
//        }
//
//        System.out.println("*** Modificar ***");
//        var modificar = new Usuario(2, "Cc", "464446641", "Mihail2", "Tal3", "calle 104", "65494665",
//                "tal@mail.com6", "LO027");
//        var modifciado = usuarioDAO.modificarUsuario(modificar);
//        if(modifciado){
//            System.out.println("Usuario modificado: " + modificar);
//        }
//        else{
//            System.out.println("Usuario No modificado: " + modificar);
//        }


//            System.out.println("*** Eliminar ***");
//        var eliminar = new Usuario(2);
//        var eliminado = usuarioDAO.eliminarUsuario(eliminar);
//        if(eliminado){
//            System.out.println("Usuario eliminado: " + eliminar);
//        }
//        else{
//            System.out.println("Usuario No eliminado: " + eliminar);
//        }
//
//        System.out.println("*** Listar Usuarios ***");
//        var listar = usuarioDAO.listarUsuarios();
//        listar.forEach(System.out::println);
//   }
}
