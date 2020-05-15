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

<p aling="center">
  <img src="https://github.com/oscarsalazar8913/ruleta-api/blob/master/imagenes/7.%20ruletaApiDocumentacion.jpg">
</p>

A continuacion se muestran los endpoints desarrollados de acuerdo a las especificaciones de la prueba. Se utilizo Postman
para visualizar y probar los endpoints.

# Crear ruleta
Con este endpoint se crea la ruleta sin parametros. Cuando se crea se retorna el Id de la ruleta. El estado incial de la ruleta es creado.

<p aling="center">
  <img src="https://github.com/oscarsalazar8913/ruleta-api/blob/master/imagenes/1.%20crearRuleta.jpg">
</p>

# Abrir ruleta
Una vez se tenga una ruleta creada, se realiza la apertura de la ruleta mandando como parametro del Id de la ruleta. Si el Id es correcto y la ruleta esta en estado "creado" se notifica que la acción fue exitosa, en caso contrario se notifica denegado.
<p aling="center">
  <img src="https://github.com/oscarsalazar8913/ruleta-api/blob/master/imagenes/2.%20abrirRuleta.jpg">
</p>

# Realizar apuesta
Sobre una ruleta que este abierta, se realizan las apuestas. Donde se envia como parametros la información de la apuesta a realizar.Se tienen las validaciones en caso de que la ruleta a la que se va a realizar la apuesta no exista o no este abierta, que el número de la apuesta no sea valido y el valor de la apuesta no este permitido.
<p aling="center">
  <img src="https://github.com/oscarsalazar8913/ruleta-api/blob/master/imagenes/3.%20realizarApuesta.jpg">
</p>

Luego de realizar la apuesta podemos ver la ruleta con la apuesta realizada:
<p aling="center">
  <img src="https://github.com/oscarsalazar8913/ruleta-api/blob/master/imagenes/4.%20ruletaConApuestaRealizadas.jpg">
</p>

# Cerrar apuestas
El cierre de las apuestas se hace sobre una ruleta de acuerdo a su Id.Cuendo se realiza el cierre de las apuesta sobre una ruleta, se retornan todas las apuesta realizadas sobre la ruleta que se esta cerrando.
<p aling="center">
  <img src="https://github.com/oscarsalazar8913/ruleta-api/blob/master/imagenes/5.%20cerrarApuestas.jpg">
</p>

# Retornar ruletas
Con este endpoint se obtienen todas las ruletas con los estados respectivamente.
<p aling="center">
  <img src="https://github.com/oscarsalazar8913/ruleta-api/blob/master/imagenes/6.%20ruletasConEstado.jpg">
</p>
