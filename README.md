# Parcial de Tendencias en Ingeniería de Software

Presentado por: Sebastián Leonardo Bejarano Medellín

Profesor: Alvaro Espinel Ortega

Código: 20221495002

## Como correr en local

Para correr en local asegúrate de tener una base de datos en PostgreSQL en el puerto 5432, con una 
base de datos que tenga los siguientes datos:
- Nombre de la base de datos: parcial
- Usuario de la base de datos: parcial
- Contraseña de la base de datos: parcial

Luego de tener la base de datos lista, pueden ejecutar el programa de dos maneras.

### Primera manera

A través del wrapper de gradle que hay en el repositorio puedes ejecutar el siguiente comando
```
./gradlew bootRun
```
Sin embargo esto pasa por todos los pasos de preconstrucción de gradle, aunque funciona igual, el
arranque de la aplicación se demora un poco más.

### Segunda manera

Primero hay que construir el proyecto utilizando el comando
```
./gradlew build
```
Y finalmente ejecutar mediante la máquina virtual de java
```
java -jar build/libs/parcial-1.0.jar
```

## Correr utilizando Docker Compose

Hay que tener Docker instalado junto con Docker compose para poder levantar la aplicación de manera
automática.

El archivo docker-compose levanta una instancia de la base de datos con las características anteriormente
mencionadas, así que no es necesario que se preocupen por eso, sólo por ejecutar el comando:
```
docker-compose up
```
En la raiz del proyecto.

Después de que se levante, ya se pueden acceder a

http://localhost:8080