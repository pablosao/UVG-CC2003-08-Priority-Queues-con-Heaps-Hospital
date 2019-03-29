
import java.util.PriorityQueue;
import java.util.Stack;

/***
 * Manejo de las operaciones del hospital para crear la lista de pacientes (heap) y remover al paciente de la lista
 */
public class Hospital {
    //Variable para el menu de la seleccion de la implementación a utilizar
    final static String MENU_IMPLEMENTACION = "Implementación";

    //Variable del menu para operación dentro de las operaciones hospital
    final static String MENU = "\n\t\t\t\tMenú" +
                                      "\n\t1.) Retirar Paciente." +
                                      "\n\t2.) Salir.";

    //Instrucción de Ingreso de la información
    final static String INSTRUCCIONES = "\nIngrese el número de opción del menú: ";

    //Datos para crear el heap
    private Stack DATOS;

    /***
     * Recibe los datos para elaborar el heap segun la implementación deseada
     * @param value
     */
    public void setDatos(Object value){

        java.util.ArrayList datos = (java.util.ArrayList) value;
        DATOS = new Stack();

        for(int control = 0;control<datos.size();control++){
            DATOS.push(datos.get(control));
        }
    }

    /***
     * Clase encargada de las operaciones para el manejo del hospital
     */
    public void manejoHospital(){

        Boolean control_menu = true;
        int opcion_implementacion;

        VectorHeap<Paciente> vHeap = new VectorHeap<Paciente>();

        //Menu para seleccionar el tipo de implementación que se desea utilizar
        while(control_menu){

            // Creamos heap
            vHeap = createVectorHeap();


            // Realizamos ciclo para que se muestre las opciones hasta que el usuario desee salir del sistema
            while(true){

                //Mostramos el primer menu a mostrar
                System.out.println(MENU);

                //Mostramos las instrucciones al usuario
                System.out.print(INSTRUCCIONES);

                //Leemos la opción deseada por el usuario
                int opcion = Keyboard.readInt();

                switch (opcion){
                    case 1:
                        //Removemos el paciente que sera atendido
                        removePacient(vHeap);
                        break;
                    case 2:
                        System.exit(0);
                }
            }

        }

    }

    /***
     * Removemos el paciente que estaba en la lista de espera
     * @param heap VectorHeap con la lista de los pacientes
     */
    public void removePacient(VectorHeap<Paciente> heap){

        //Se crea instancia de pacientes para obtener el nombre del paciente que sera atentido
        Paciente paciente = null;

        //Se verifica que el heap no este vacio
        if (!heap.isEmpty()){
            //Obtenemos el paciente que le toca ser atendido (por lo cual se quita de la lista)
            paciente = heap.remove();

            //Armamos un string con los datos dle paciente que quitamos de la lista
            String siguiente = String.format("\n\tPaciente a Atender: \n\n\t\tNOMBRE: %s \n\t\tSINTOMA: %s",
                                              paciente.getNombre()
                                             ,paciente.getSintoma());
            System.out.println(siguiente);
        }
        else{
            System.out.println("\n\t\t\tNo hay pacientes en lista de espera.");
        }
    }

    /***
     * Metodo para crear el VectorHeap
     * @return VectorHeap con la lista de pacientes
     */
    public VectorHeap<Paciente> createVectorHeap(){

        VectorHeap<Paciente> heap = new VectorHeap<Paciente>();

        int size = DATOS.size();
        String[] pacientes = null;

        for(int control = 0;control<size;control++){
            pacientes = DATOS.pop().toString().split(",");
            //System.out.println(java.util.Arrays.toString(pacientes)); //Verificando orden de los datos
            heap.add(new Paciente(pacientes[0],pacientes[1],pacientes[1].replaceAll(" ","")));
        }

        System.out.println("\n\t\t\tSe ha creado el VectorHeap<Paciente>");
        return heap;
    }


}
