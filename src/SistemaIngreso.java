import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;

/***
 * Clase principal para el manejo de la aplicación
 * @author Pablo Sao
 * @version 27/03/2019
 */

public class SistemaIngreso {

    //Variable que contiene el menú inicial a mostrar
    final static String MENU_INICIO = "\n\t\t\t\tMenú" +
                                      "\n\t1.) Cargar Archivo de Pacientes." +
                                      "\n\t2.) Salir.";
    final static String INSTRUCCIONES = "\nIngrese el número de opción del menú: ";

    public static void main(String[] args){

        // Realizamos ciclo para que se muestre las opciones hasta que el usuario desee salir del sistema
        while(true){

            //Mostramos el primer menu a mostrar
            System.out.println(MENU_INICIO);

            //Mostramos las instrucciones al usuario
            System.out.print(INSTRUCCIONES);

            //Leemos la opción deseada por el usuario
            int opcion = Keyboard.readInt();

            switch (opcion){
                case 1:
                    System.out.print("\nIngrese el path del archivo: ");
                    String path = Keyboard.readString();

                    if(DataManager.getExists(path)){
                        //Llamado a la clase para realizar proces

                        String dato = DataManager.getDataFile(path,"\t");
                        try{
                            ArrayList info = (ArrayList)DataManager.getStringTokens("\t",dato);

                            if(!info.isEmpty()){
                                Hospital h = new Hospital();
                                h.setDatos(info);
                                h.manejoHospital();
                            }
                            else{
                                System.out.println("\n\n\t\t\tEl archivo se encuentra vacio");
                            }

                        }
                        catch (Exception e){
                            System.out.println(e.toString());
                        }

                    }
                    else{
                        System.out.println("\n\t\tEl archivo no fue encontrado\n");
                    }
                    break;
                case 2:
                    System.exit(0);
            }
        }
    }
}
