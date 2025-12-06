package gestion_usuarios.datos;

import gestion_usuarios.dominio.Usuario;

import java.util.List;

public interface IUsuarioDAO {
    List<Usuario> listarUsuarios();
    boolean buscarUsuarioPorId(Usuario usuario);
    boolean agregarUdsuario(Usuario usuario);
    boolean modificarUsuario(Usuario usuario);
    boolean eliminarUsuario(Usuario usuario);
}
