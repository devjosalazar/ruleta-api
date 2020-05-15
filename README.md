# Ruleta-api
Implementar un API que represente una ruleta de apuestas online utilizando las reglas de Clean Code

# Consideraciones
Framework de desarrollo: Spring Boot

Base de datos: Redis (el servidor no esta embebido en la aplicacion, se ejecuta el servidor de Redis por consola)

<p aling="center">
  <img src="https://github.com/oscarsalazar8913/ruleta-api/blob/master/imagenes/8.%20ejecucionRedisServer.jpg">
</p>


# Documentacion de la Api con Swagger
http://localhost:8080/swagger-ui.html

<p aling="center" border="solid 1px">
  <img src="https://github.com/oscarsalazar8913/ruleta-api/blob/master/imagenes/7.%20ruletaApiDocumentacion.jpg">
</p>

A continuacion se muestran los endpoints desarrollados de acuerdo a las especificaciones de la prueba. Se utilizo Postman
para visualizar y probar los endpoints.

# Crear ruleta

<p aling="center" border="solid 1px">
  <img src="https://github.com/oscarsalazar8913/ruleta-api/blob/master/imagenes/1.%20crearRuleta.jpg">
</p>

# Abrir ruleta

<p aling="center">
  <img src="https://github.com/oscarsalazar8913/ruleta-api/blob/master/imagenes/2.%20abrirRuleta.jpg">
</p>

# Realizar apuesta

<p aling="center">
  <img src="https://github.com/oscarsalazar8913/ruleta-api/blob/master/imagenes/3.%20realizarApuesta.jpg">
</p>

Luego de realizar la apuesta podemos ver la ruleta con la apuesta realizada:
<p aling="center">
  <img src="https://github.com/oscarsalazar8913/ruleta-api/blob/master/imagenes/4.%20ruletaConApuestaRealizadas.jpg">
</p>

# Cerrar apuestas
El cierre de las apuestas se hace sobre una ruleta de acuerdo a su Id.
<p aling="center">
  <img src="https://github.com/oscarsalazar8913/ruleta-api/blob/master/imagenes/5.%20cerrarApuestas.jpg">
</p>

# Retornar ruletas

<p aling="center">
  <img src="https://github.com/oscarsalazar8913/ruleta-api/blob/master/imagenes/6.%20ruletasConEstado.jpg">
</p>
