# 🧩 Gestión de Usuarios — JDBC + DAO + Arquitectura en 3 Capas

Este proyecto implementa un sistema básico de **gestión de usuarios** utilizando:

✔ JDBC Driver  
✔ Patrón de diseño **DAO**  
✔ Arquitectura por capas (**Dominio – Datos – Presentación**)  
✔ Programación Orientada a Objetos (POO)  
✔ Operaciones CRUD probadas por consola  

---

# 🏗 Arquitectura del Proyecto

```
/src
 ├── dominio/
 │     └── Usuario.java
 │
 ├── datos/
 │     ├── IUsuarioDAO.java
 │     └── UsuarioDAO.java
 │
 ├── conexion/
 │     └── Conexion.java
 │
 └── presentacion/
       └── UsuarioApp.java
```

---

# 🗃 1. Capa de Conexión — JDBC

En esta capa se implementa la clase **Conexion**, encargada de:

- Registrar el **driver JDBC**
- Establecer la conexión con MySQL
- Probar el establecimiento efectivo de la conexión
- Retornar el objeto `Connection` para usarlo en el DAO

Incluye manejo de excepciones y cierre adecuado de recursos.

---

# 👤 2. Capa de Dominio — Entidad Usuario

La clase `Usuario` representa la estructura del usuario:

- Atributos del usuario  
- Constructores para:
  - Buscar / eliminar (solo ID)
  - Crear (nombre, email…)
  - Modificar (ID + datos)
- Métodos `get` y `set`
- Métodos sobrescritos:
  - `toString()`  
  - `equals()`  
  - `hashCode()`  

Esto permite un mejor manejo de los objetos y favorece la comparación entre instancias.

---

# 💾 3. Capa de Datos — DAO

Incluye:

### ✔ Interfaz `IUsuarioDAO`
Define los métodos CRUD:

- `listarUsuarios()`
- `buscarUsuarioPorId(Usuario usuario)`
- `agregarUsuario(Usuario usuario)`
- `modificarUsuario(Usuario usuario)`
- `eliminarUsuario(Usuario usuario)`

### ✔ Implementación `UsuarioDAO`
Usando:

- `Connection`
- `PreparedStatement`
- `ResultSet`

Se desarrollan los métodos CRUD accediendo directamente a la base de datos.

Todos los métodos fueron probados por consola.

---

# 🎮 4. Capa de Presentación — Consola

La aplicación presenta un menú interactivo:

```
1. Listar usuarios
2. Buscar usuario por ID
3. Agregar usuario
4. Modificar usuario
5. Eliminar usuario
6. Salir
```

El menú utiliza un objeto del servicio/DAO para ejecutar cada operación.

---

# 🧪 5. Ejemplo de Ejecución por Consola

```md
![Resultado en consola](ruta/<img width="401" height="266" alt="image" src="https://github.com/user-attachments/assets/210a04c1-caa0-4920-9b58-d6373bc8f582" />
)

```

---

# 🚀 Tecnologías Utilizadas

- Java 17+
- MySQL 8
- JDBC Driver
- Patrón DAO
- Arquitectura por capas
- Programación Orientada a Objetos

---

# 📌 Objetivo del Proyecto

Este repositorio forma parte de mi ruta de aprendizaje backend con Java, donde desarrollo un CRUD por cada módulo del sistema **Gestión de Biblioteca**, iniciando con JDBC antes de avanzar hacia:

➡ Spring Boot  
➡ Spring MVC + Thymeleaf

---

# 🙌 Autor

**morocho**  
📧 Correo: *portafoliomoro@gmail.com*  
🔗 GitHub: *portafoliomoro-moro*  

---

