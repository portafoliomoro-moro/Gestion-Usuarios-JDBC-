package gestion_usuarios.presentacion;


import gestion_usuarios.datos.IUsuarioDAO;
import gestion_usuarios.datos.UsaurioDAO;
import gestion_usuarios.dominio.Usuario;

import java.util.Scanner;

public class UsuarioApp {
    public static void main(String[] args) {
        usuarioApp();
    }

    private static void usuarioApp(){
        var salir = false;
        var consola = new Scanner(System.in);

        IUsuarioDAO usuarioDAO =  new UsaurioDAO();
        while(!salir){
            try{
                var opcion = mostrarMenu(consola);
                salir = ejecutarOpcion(opcion, consola, usuarioDAO);
            }catch(Exception e){
                System.out.println("Error al ingresar opción: " + e.getMessage());
            }
            System.out.println();
        }
    }

    private static int mostrarMenu(Scanner consola){
        System.out.print("""
                *** Gestión Usuarios ***
                1. Listar Usuarios
                2. Buscar Usuario
                3. Agregar Usuario
                4. Modificar Usuario
                5. Eliminar Usuario
                6. Salir
                Elige una opción:\s""");
        return Integer.parseInt(consola.nextLine());
    }

    private static boolean ejecutarOpcion(int opcion, Scanner consola, IUsuarioDAO usuarioDAO){
        var salir = false;
        switch(opcion){
            case 1 -> {
                System.out.println("--- Listado de Usuarios ---");
                var listarUsuarios = usuarioDAO.listarUsuarios();
                listarUsuarios.forEach(System.out::println);
            }
            case 2 -> {
                System.out.println("--- Buscar Usuario ---");
                System.out.print("Id del usuario a buscar: ");
                var idUsuario = Integer.parseInt(consola.nextLine());
                var buscarUsuario = new Usuario(idUsuario);
                var encontrado = usuarioDAO.buscarUsuarioPorId(buscarUsuario);
                if(encontrado){
                    System.out.println("Usuario encontrado: " + buscarUsuario);
                }
                else{
                    System.out.println("Usuario No encontrado: " + buscarUsuario);
                }
            }
            case 3 -> {
                System.out.println("--- Agregar Usuario ---");
                System.out.print("Tipo Documento: ");
                var tipoDocumento = consola.nextLine();
                System.out.print("Número documento: ");
                var numeroDocumento = consola.nextLine();
                System.out.print("Nombres: ");
                var nombres = consola.nextLine();
                System.out.print("Apellidos: ");
                var apellidos = consola.nextLine();
                System.out.print("Dirección: ");
                var direccion = consola.nextLine();
                System.out.print("Teléfono: ");
                var telefono = consola.nextLine();
                System.out.print("Correo: ");
                var correo = consola.nextLine();
                System.out.print("Llave del Saber: ");
                var llaveSaber = consola.nextLine();
                var agregarUsuario = new Usuario(tipoDocumento, numeroDocumento, nombres, apellidos,
                        direccion, telefono, correo, llaveSaber);
                var agregado = usuarioDAO.agregarUdsuario(agregarUsuario);
                if(agregado){
                    System.out.println("Usuario agregado: " + agregarUsuario);
                }
                else{
                    System.out.println("Usuario No agregado: " + agregarUsuario);
                }
            }
            case 4 -> {
                System.out.println("--- Modificar Usuario ---");
                System.out.print("Id del usuario a modificar: ");
                var idUsuario = Integer.parseInt(consola.nextLine());
                var buscarUsuario = new Usuario(idUsuario);
                var encontrado = usuarioDAO.buscarUsuarioPorId(buscarUsuario);
                if(encontrado){
                    System.out.print("Tipo Documento: ");
                    var tipoDocumento = consola.nextLine();
                    System.out.print("Número documento: ");
                    var numeroDocumento = consola.nextLine();
                    System.out.print("Nombres: ");
                    var nombres = consola.nextLine();
                    System.out.print("Apellidos: ");
                    var apellidos = consola.nextLine();
                    System.out.print("Dirección: ");
                    var direccion = consola.nextLine();
                    System.out.print("Teléfono: ");
                    var telefono = consola.nextLine();
                    System.out.print("Correo: ");
                    var correo = consola.nextLine();
                    System.out.print("Llave del Saber: ");
                    var llaveSaber = consola.nextLine();
                    var modificar = new Usuario(idUsuario, tipoDocumento, numeroDocumento, nombres,
                            apellidos, direccion, telefono, correo, llaveSaber);
                    var modificado = usuarioDAO.modificarUsuario(modificar);
                    System.out.println("Usuario Modificado: " + modificar);
                }
                else{
                    System.out.println("Usuario No encontrado: " + buscarUsuario);
                }
            }
            case 5 -> {
                System.out.println("--- Eliminar Usuario ---");
                System.out.print("Id del usuario a eliminar: ");
                var idUsuario = Integer.parseInt(consola.nextLine());
                var buscarUsuario = new Usuario(idUsuario);
                var encontrado = usuarioDAO.buscarUsuarioPorId(buscarUsuario);
                if(encontrado){
                    usuarioDAO.eliminarUsuario(buscarUsuario);
                    System.out.println("Usuario Eliminado: " + buscarUsuario);
                }
                else{
                    System.out.println("Usuario No encontrado: " + buscarUsuario);
                }
            }
            case 6 -> {
                System.out.println("Hasta pronto!");
                salir = true;
            }
            default -> System.out.println("Opción No reconocida: " + opcion);
        }
        return salir;
    }
}
