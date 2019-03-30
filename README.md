# Priority Queues con Heaps

El laboratorio N|8 para la clase de Algoritmos y Estructura de Datos de la univerisdad del Valle de Guatemala, consiste en la elaboración de un control de lista de espera de pacientes.

Donde existe un código de emergencia, el cual es una letra de la A a la E, que indica la prioridad con que debe ser atendido el paciente. La prioridad A es la que más rápido debe ser atendida y la E es la que puede atenderse más lentamente, ya que no presenta una condición mortal o de gran peligro para el paciente. 
 
Usted decide hacer el sistema basado en una Priority Queue en la que se ingresan las fichas del paciente y se retira de esa cola al paciente que tenga la prioridad de atención más rápida. Las fichas del paciente vendrán en un archivo de texto (debe llamarse pacientes.txt) con los campos separados por comas. Por ejemplo: 

```
Juan Perez, fractura de pierna, C
Maria Ramirez, apendicitis, A
Lorenzo Toledo, chikunguya, E
Carmen Sarmientos, dolores de parto, B
```

El sistema permite indicar cual paciente debe ser atendido. Así, que cuando el doctor pide el siguiente paciente, se retira de la cola y se muestra su nombre, síntoma y prioridad. El orden en que serán retirados los pacientes, uno a la vez.

Para esto se debe de utilizar la implementación de:

* VectorHeap
*  PriorityQueue, de JCF

### Prerequisitos

Para ejecutar el programa es necesario contar con:

* Java >= 8.0.172
* Compilar y ejecutar la clase **SistemaIngreso.java**

## Referencias

* Bailey, D. (2007). _Data Structures in Java for the Principled Programmer_. Edición 7. Nueva York, Estados Unidos:  McGraw-Hill. 315 - 329 pp.


## Autor

* **Pablo Sao** - [psao](https://github.com/psao)
