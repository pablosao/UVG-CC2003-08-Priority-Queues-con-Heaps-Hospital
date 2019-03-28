/***
 * Clase principal para el manejo de la aplicación
 * @author Pablo Sao
 * @version 27/03/2019
 */

public class SistemaIngreso {

    //Variable que contiene el menú inicial a mostrar
    final static String MENU_INICIO = "\n\t\tMenú" +
                                      "\n1.) Cargar Archivo de Pacientes." +
                                      "\n2.) Salir.";
    final static String INSTRUCCIONES = "Ingrese el número de opción del menú: ";

    public static void main(String[] args){

        // Realizamos ciclo para que se muestre las opciones hasta que el usuario desee salir del sistema
        while(true){

            //Mostramos el primer menu a mostrar
            System.out.println(MENU_INICIO);

            //Mostramos las instrucciones al usuario
            System.out.println(INSTRUCCIONES);

            //Leemos la opción deseada por el usuario
            int opcion = Keyboard.readInt();

            switch (opcion){
                case 1:
                    System.out.print("Ingrese el path del archivo: ");
                    String path = Keyboard.readString();

                    if(DataManager.getExists(path)){
                        //Llamado a la clase para realizar proceso
                    }
                    else{
                        System.out.println("El archivo no fue encontrado");
                    }
                    break;
                case 2:
                    System.exit(0);
            }
        }
    }
}
