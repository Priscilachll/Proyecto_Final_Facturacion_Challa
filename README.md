# Proyecto_Final_Facturacion

Este proyecto es una API REST desarrollada con Spring Boot para la gestión de ventas de productos. Permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre clientes, productos y ventas. Además, incluye funcionalidades específicas para la gestión del stock y la generación de comprobantes de venta.

## Funcionalidades Principales

* **Gestión de Clientes:**
    * Creación, lectura, actualización y eliminación de clientes.
    * Validación de datos de clientes.
* **Gestión de Productos:**
    * Creación, lectura, actualización y eliminación de productos.
    * Actualización automática del stock al realizar ventas.
* **Gestión de Ventas:**
    * Creación de ventas con múltiples líneas de venta.
    * Generación de comprobantes de venta.
    * Cálculo automático del precio total de la venta.
    * Eliminación de ventas (con validaciones).
* **Endpoints REST:**
    * Endpoints para todas las operaciones mencionadas anteriormente.
    * Respuestas en formato JSON.
* **Base de Datos H2:**
    * Utilización de H2 como base de datos en memoria para desarrollo y pruebas.
    * Script `schema.sql` para la creación de tablas.
* **Postman Collection:**
    * Colección de Postman (`PETICIONES.postman_collection.json`) con ejemplos de solicitudes para todos los endpoints.

## Tecnologías Utilizadas

* **Spring Boot:** Framework para la creación de aplicaciones Java.
* **Spring Data JPA:** Módulo para la persistencia de datos con JPA.
* **H2 Database:** Base de datos en memoria para desarrollo.
* **Maven:** Herramienta de gestión de dependencias y construcción de proyectos.
* **Postman:** Herramienta para probar APIs REST.

