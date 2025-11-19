Price API

API REST en Java 17 + Spring Boot que permite obtener el precio aplicable para un producto, marca y fecha según reglas de prioridad.

Ejecutar
mvn clean install
mvn spring-boot:run


Endpoint
GET /prices

Parámetros:
brandId
productId
date (ISO: 2020-06-14T16:00:00)

Ejemplo:
/prices?brandId=1&productId=35455&date=2020-06-14T16:00:00
