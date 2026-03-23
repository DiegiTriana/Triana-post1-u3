# tienda-patrones-estructurales

Proyecto Unidad 3.
Se implementaron los patrones Adapter y Composite en un proyecto Spring Boot
que simula el backend de una tienda virtual con integracion de pasarelas de pago
y un catalogo de productos jerarquico.

## Que hace el proyecto

El sistema permite procesar pagos a traves de dos pasarelas externas (PayPal y Stripe)
usando el patron Adapter para normalizar sus APIs incompatibles. Ademas, maneja
un catalogo de productos con categorias anidadas usando el patron Composite.

## Patrones implementados

### Adapter
El problema era que PayPal y Stripe tienen APIs completamente diferentes entre si
y ninguna es compatible con la interfaz interna del sistema. Sin el patron Adapter,
el codigo de negocio tendria que conocer cada API por separado y cambiar cada vez
que se agregue una nueva pasarela.

La solucion fue crear la interfaz PasarelaPago como contrato interno, y luego
implementar PayPalAdapter y StripeAdapter que traducen cada API externa
a ese contrato. El servicio solo conoce PasarelaPago, nunca las clases concretas.

### Composite
El problema era que el catalogo de productos tiene categorias que contienen
otras categorias y productos, formando una jerarquia recursiva. Sin Composite,
habria que tratar diferente a los productos individuales y a las categorias.

La solucion fue crear la interfaz ItemCatalogo que tanto Producto (hoja) como
Categoria (nodo) implementan. Esto permite recorrer toda la jerarquia de forma
uniforme y calcular precios totales recursivamente sin saber si es un producto
o una categoria.

## Como ejecutar

Requisitos: Java 17 y Maven 3.8 o superior.

Compilar y empaquetar:
mvn clean package

Ejecutar la aplicacion:
mvn spring-boot:run

Ejecutar los tests:
mvn test

## Capturas de salida y test
![image alt](https://github.com/DiegiTriana/Triana-post1-u3/blob/ef44261027e83bd033b26ed94a5d94666269e56a/captura%20de%20pantalla.png)
![image alt](https://github.com/DiegiTriana/Triana-post1-u3/blob/ef44261027e83bd033b26ed94a5d94666269e56a/captura%20de%20pantalla%202.png)


