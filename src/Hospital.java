import java.util.PriorityQueue;

import java.util.ArrayList;

/***
 * Manejo de las operaciones del hospital para crear la lista de pacientes (heap) y remover al paciente de la lista
 */
public class Hospital {
    //Variable para el menu de la seleccion de la implementación a utilizar
    final static String MENU_IMPLEMENTACION = "\n\t\t\tSeleccione Implementación" +
                                              "\n\t1.) VectorHeap" +
                                              "\n\t2.) PriorityQueue" +
                                              "\n\t3.) Regresar ";

    //Variable del menu para operación dentro de las operaciones hospital
    final static String MENU_HOSPITAL = "\n\t\t\t\tMenú" +
                                      "\n\t1.) Retirar Paciente." +
                                      "\n\t2.) Regresar." +
                                      "\n\t3.) Salir.";

    //Instrucción de Ingreso de la información
    final static String INSTRUCCIONES = "\nIngrese el número de opción del menú: ";

    //Datos para crear el heap
    private ArrayList DATOS;

    /***
     * Recibe los datos para elaborar el heap segun la implementación deseada
     * @param value
     */
    public void setDatos(Object value){
        DATOS = (ArrayList) value;
    }

    /***
     * Clase encargada de las operaciones para el manejo del hospital
     */
    public void manejoHospital(){

        Boolean menu_implementacion = true;
        int opcion_implementacion;

        Boolean menu_heap = false;

        VectorHeap<Paciente> vHeap = null;
        PriorityQueue<Paciente> qHeap = null;


        //Menu para seleccionar el tipo de implementación que se desea utilizar
        while(menu_implementacion){

            //Desplegamos menu de implementación
            System.out.println(MENU_IMPLEMENTACION);

            //Mostramos las instrucciones al usuario
            System.out.print(INSTRUCCIONES);

            //Leemos la opción deseada por el usuario
            int opcion_imp = Keyboard.readInt();

            switch (opcion_imp){
                case 1:
                    // Creamos VectorHeap
                    vHeap = createVectorHeap();
                    menu_heap = true;
                    break;
                case 2:
                    qHeap = createPriorityQueue();
                    menu_heap = true;
                    break;
                case 3:
                    menu_implementacion = false;
            }


            // Realizamos ciclo para que se muestre las opciones hasta que el usuario desee salir del sistema
            while(menu_heap){

                //Mostramos el primer menu a mostrar
                System.out.println(MENU_HOSPITAL);

                //Mostramos las instrucciones al usuario
                System.out.print(INSTRUCCIONES);

                //Leemos la opción deseada por el usuario
                int opcion = Keyboard.readInt();

                switch (opcion){
                    case 1:
                        //Removemos el paciente que sera atendido
                        if(opcion_imp == 1)
                            removePacient(vHeap);
                        if(opcion_imp == 2)
                            removePacient(qHeap);
                        break;
                    case 2:
                        menu_heap = false;
                        break;
                    case 3:
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
        if(heap != null){
            //Se verifica que el heap no este vacio
            if (!heap.isEmpty()){
                //Obtenemos el paciente que le toca ser atendido (por lo cual se quita de la lista)
                paciente = heap.remove();

                //Armamos un string con los datos dle paciente que quitamos de la lista
                String siguiente = String.format("\n\tPaciente a Atender: \n\n\t\tNOMBRE: %s \n\t\tSINTOMA: %s\n",
                        paciente.getNombre()
                        ,paciente.getSintoma());
                System.out.println(siguiente);
            }
            else{
                System.out.println("\n\t\t\tNo hay pacientes en lista de espera.");
            }
        }
        else{
            System.out.println("\n\t\t\tNo hay pacientes en lista de espera.");
        }

    }

    /***
     * Removemos el paciente que estaba en la lista de espera
     * @param heap PriorityQueue con la lista de los pacientes
     */
    public void removePacient(PriorityQueue<Paciente> heap){

        //Se crea instancia de pacientes para obtener el nombre del paciente que sera atentido
        Paciente paciente = null;
        if(heap != null){
            //Se verifica que el heap no este vacio
            if (!heap.isEmpty()){
                //Obtenemos el paciente que le toca ser atendido (por lo cual se quita de la lista)
                paciente = heap.remove();

                //Armamos un string con los datos dle paciente que quitamos de la lista
                String siguiente = String.format("\n\tPaciente a Atender: \n\n\t\tNOMBRE: %s \n\t\tSINTOMA: %s\n",
                        paciente.getNombre()
                        ,paciente.getSintoma());
                System.out.println(siguiente);
            }
            else{
                System.out.println("\n\t\t\tNo hay pacientes en lista de espera.");
            }
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
            pacientes = DATOS.get(control).toString().split(",");
            //System.out.println(java.util.Arrays.toString(pacientes)); //Verificando orden de los datos
            heap.add(new Paciente(pacientes[0],pacientes[1],pacientes[1].replaceAll(" ","")));
        }

        System.out.println("\n\t\t\tSe ha creado el VectorHeap<Paciente>");
        return heap;
    }

    /***
     * Metodo para crear el PriorityQueue
     * @return PriorityQueue con la lista de pacientes
     */
    public PriorityQueue<Paciente> createPriorityQueue(){

        PriorityQueue<Paciente> heap = new PriorityQueue<Paciente>();

        int size = DATOS.size();
        String[] pacientes = null;

        for(int control = 0;control<size;control++){
            pacientes = DATOS.get(control).toString().split(",");
            //System.out.println(java.util.Arrays.toString(pacientes)); //Verificando orden de los datos
            heap.add(new Paciente(pacientes[0],pacientes[1],pacientes[1].replaceAll(" ","")));
        }

        System.out.println("\n\t\t\tSe ha creado el PriorityQueue<Paciente>");
        return heap;
    }

}
