# Magneto Serivce

Magneto quiere reclutar la mayor cantidad de mutantes para poder luchar
contra los X-Men.

Este servicio detecta si un humano es mutante basándose en su secuencia de ADN, si se encuentra en él más de una secuencia de cuatro letras
iguales, de forma oblicua, horizontal o vertical es un mutante.

El servicio se encuentra desarrollado en Java 8 relacionado con una base de datos de MongoDB.

## Recursos

### GET /health

Informa el estado de la aplicación.

url local: localhost:8080/health

url remoto: https://magneto-service.herokuapp.com/health

#### Eespuesta
En caso de que la aplicación este bien instanciada:

    http status: 200
    

### POST /mutants

Crea un nuevo registro de adn y notifica si el ingresado es mutante o no.

url local: localhost:8080/mutant

url remoto: https://magneto-service.herokuapp.com/mutant

Body: Debe ser un array de Strings, este debe tener la misma cantidad de caracteres por línea que objetos contenidos. Las letras de los Strings solo pueden ser: (A,T,C,G), las
      cuales representa cada base nitrogenada del ADN. 

```
{
    "dna":[ "TAGTCA", 	
            "CAGTGC", 	
            "TTATGT", 	
            "AGAAGG", 		
            "CTCCTA", 	
            "TCACTG"]
}
	
```

#### Posibles respuestas
En caso de ser mutante:

    http status: 200
    
En caso de no ser mutante:

    http status: 403
    
En caso de no respetar los requisitos en el Body:

    http status: 400    
    
### GET /stats

Informa la cantidad de ADN registrado, mutantes y normales y la proporción existente de mutantes en relación a los otros. 

url local: localhost:8080/stats

url remoto: https://magneto-service.herokuapp.com/stats

#### Respuesta
    http status: 200
```
{
    “count_mutant_dna”:40, 
    “count_human_dna”:100: 
    “ratio”:0.4
}
	
```
    
## Dependencias de cada instancia 

Instancia de la base de datos: https://cloud.mongodb.com/
Localizado en : mongodb+srv://dna-xq0ap.mongodb.net/test

Instancia del micro servicio de Java: https://www.heroku.com/
Localizado en : https://magneto-service.herokuapp.com/

## Autor

* **Fiamma Castiñeiras** - [fcastineiras](https://github.com/fcastineiras)

