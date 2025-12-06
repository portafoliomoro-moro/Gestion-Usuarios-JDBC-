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
        return usuarios;
    }

    @Override
    public boolean buscarUsuarioPorId(Usuario usuario) {
        return false;
    }

    @Override
    public boolean agregarUdsuario(Usuario usuario) {
        return false;
    }

    @Override
    public boolean modificarUsuario(Usuario usuario) {
        return false;
    }

    @Override
    public boolean eliminarUsuario(Usuario usuario) {
        return false;
    }
}
