MicroServicio Cliente
=========================
Reto Técnico - Intercorp Retail
* * * * *

### Documentación Api Rest Swagger
[swagger-ui](http://ec2-18-205-116-52.compute-1.amazonaws.com:8095/swagger-ui.html)
[Api-Docs](http://ec2-18-205-116-52.compute-1.amazonaws.com:8095/v2/api-docs)
* * * * *
Microservicio implementado con una Base de datos embebida H2
* * * * *
### crearCliente
http://ec2-18-205-116-52.compute-1.amazonaws.com:8095/creacliente
Request: 
>{
 "apellido": "Yarleque",
  "fechaNacimiento": "1988-09-27",
  "nombre": "Giancarlo"
}

### kpiDeClientes
http://ec2-18-205-116-52.compute-1.amazonaws.com:8095/kpideclientes

Response:
>{
  "promedioEdad": 26,
  "desviacionEstandar": 5
}

### Lista de clientes
http://ec2-18-205-116-52.compute-1.amazonaws.com:8095/listclientes

Response:
>[
  {
    "id": 1,
    "nombre": "Giancarlo Elvis",
    "apellido": "Yarleque Juarez",
    "edad": 31,
    "fechaNacimiento": "1988-09-27",
    "fechaProbableFallecimiento": "2062-12-18"
  },
  {
    "id": 2,
    "nombre": "Eduardo",
    "apellido": "De la Cruz Rojas",
    "edad": 21,
    "fechaNacimiento": "1997-12-29",
    "fechaProbableFallecimiento": "2072-12-18"
  }
]

### Cálculo de la fecha de deceso
Se calculó mediante la esperanza de vida en el Perú (74.6 años)
