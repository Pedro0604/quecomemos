
# TTPS - 2024

## Trabajo Integrador - ¿Qué Comemos?

### Integrantes
- **Dellarupe Franco**
- **Ponce Gregorio**
- **Spadari Pedro**

### Descripción
"¿Qué Comemos?" es una aplicación web destinada a los clientes y al personal del buffet de la Facultad de Informática. Proporciona funcionalidades tanto para los usuarios del buffet (clientes) como para sus administradores y responsables de turno. Las principales funcionalidades del sistema son:

- **Usuarios (Clientes):**
    - Visualizar los menús del día.
    - Comprar menús ofrecidos por el buffet.
    - Comentar y realizar sugerencias sobre los servicios y productos.

- **Administradores:**
    - Gestionar los menús del día (agregar, modificar y eliminar).
    - Visualizar estadísticas de menús más pedidos y sugerencias recibidas.
    - Revisar las ventas realizadas y acceder al buzón de sugerencias.

- **Responsables de Turno:**
    - Gestionar los pedidos del turno, accediendo a información relevante sobre los clientes habilitados para la compra de tickets.
    - Administrar el registro de pagos realizados en el comedor.
    - Acceder y gestionar el buzón virtual de sugerencias.

### Tabla de Contenidos
1. [Instalación](#instalacion)
2. [Uso](#uso)
3. [Configuración](#configuracion)
4. [Dependencias](#dependencias)
5. [Contribuciones](#contribuciones)
6. [Licencia](#licencia)

### Instalación
1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/Pedro0604/quecomemos
   ```
2. **Configurar el SDK de Amazon Corretto:**
    - Asegúrate de tener instalado el **Amazon Corretto JDK** en la versión 17.

3. **Crear la base de datos:**
    - Crear una base de datos en MySQL con el nombre `ttps-quecomemos`.

4. **Configurar el archivo de persistencia:**
    - Edita el archivo `persistence.xml` y ajusta las credenciales para conectarse a la base de datos.

5. **Instalar dependencias:**
    - Ejecutar los comandos de instalación correspondientes para los frameworks utilizados, `mvn install` para dependencias de Maven en el backend.

### Uso
1. Ejecutar el servidor:
   ```bash
   # Corre la aplicacion sobre el servidor que utilices
   ```
2. Acceder a la aplicación en `http://localhost:puerto` (sustituyendo `puerto` por el puerto configurado en la aplicación).

### Dependencias
- **Java**: Amazon Corretto 17.
- **MySQL**: Base de datos.
- **Maven**: Gestor de dependencias.