//Universidad del Valle de Guatemala
//Programación Orientada a Objetos
//Catedrático Tomás Gálvez
//Segundo Semestre 2021
//José Daniel Gómez Cabrera
//Carné 21429
//Sección 11
//Actividad: Ejercicio 3

import java.util.Scanner;

import javax.xml.transform.Source;

import java.time.LocalTime;

/**
 * @author José Daniel Gómez Cabrera
 * @version Class Interfaz 1.1
*/
public class Vista {
    
    private Scanner scan;

    /**
     * Constructor.
     * 
     * @author José Daniel Gómez Cabrera
     * @version Vista 1.1
    */
    public Vista(){
        scan = new Scanner(System.in);
    }

    /**
     * metodo para la interfaz del usuario.
     * 
     * @author José Daniel Gómez Cabrera
     * @version bienvenida_usuario 1.1
    */
    public void bienvenida_usuario(){
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("- BIENVENIDO AL ESTACIONAMIENTO");
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("- Este es el programa de estacionamiento, en el cual podras guaradar los carros de tus clientes.");
        System.out.println("- Recuerda ingresar los datos como te los pide el sistema, y ser amigable con el programa. :)");
        System.out.println("- Elige una opcion del menu para comenzar.");
        System.out.println("- HORA DE APERTURA: "+LocalTime.now().getHour()+" horas con "+LocalTime.now().getMinute()+" minutos.");
        System.out.println("-------------------------------------------------------------------------------------------------");
    }

    /**
     * metodo para la interfaz del usuario.
     * 
     * @author José Daniel Gómez Cabrera
     * @version mostrar_menu 1.1
    */
    public void mostrar_menu(){
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("- MENU PRINCIPAL");
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println(" 1. Mostrar Parqueos.");
        System.out.println(" 2. Ingresar Carro.");
        System.out.println(" 3. Retirar Carro.");
        System.out.println(" 4. Obtener Estadisticas.");
        System.out.println(" 5. Agrandar Parqueo.");
        System.out.println(" 6. Finalizar Programa.");
        System.out.println("-------------------------------------------------------------------------------------------------");
    }

    /**
     * metodo para la interfaz del usuario.
     * 
     * @author José Daniel Gómez Cabrera
     * @version obtener_string 1.1
    */
    public String obtener_string(){
        boolean continuar = true;
        String opcion_usuario = "";
        while(continuar)
            try{
                System.out.print("Ingrese texto aqui: ");
                opcion_usuario = scan.nextLine();
                System.out.println("-------------------------------------------------------------------------------------------------");
                continuar = false;
                
            }
            catch(Exception e){
                System.out.println("Error: Ingrese texto.");
                scan.next();
            }
        return opcion_usuario;
    }

    /**
     * metodo para la interfaz del usuario.
     * 
     * @author José Daniel Gómez Cabrera
     * @version obtener_int 1.1
    */
    public int obtener_int(){
        boolean continuar = true;
        int opcion_usuario = 0;
        while(continuar)
            try{
                System.out.print("Ingrese el numero de parqueos que desea agregar: ");
                opcion_usuario = scan.nextInt();
                System.out.println("Parqueo Agrandado exitosamente.");
                System.out.println("-------------------------------------------------------------------------------------------------");
                // scan.next();
                continuar = false;
                
            }
            catch(Exception e){
                System.out.println("Error: Ingrese un numero entero.");
                scan.next();
            }
        return opcion_usuario;
    }

    /**
     * metodo para la interfaz del usuario.
     * 
     * @author José Daniel Gómez Cabrera
     * @version mostrar_parqueos 1.1
    */
    public void mostrar_parqueos(Estacionamiento local){
        System.out.println("- PARQUEOS");
        System.out.println("-------------------------------------------------------------------------------------------------");
        for(int k = 0; k<(local.get_parqueos_estacionamiento().size()); k++){
            String[] info = local.get_parqueos_estacionamiento().get(k).get_info_parqueo();
            System.out.print(local.get_parqueos_estacionamiento().get(k).get_nombre_parqueo());
            System.out.print(": "+info[1]+", "+info[2]+", "+info[3]);
            if(local.get_parqueos_estacionamiento().get(k).get_parqueo_ocupado()){
                System.out.print(" - OCUPADO ");
                System.out.println("--> "+local.get_parqueos_estacionamiento().get(k).get_car().get_placa());
            }
            else{
                System.out.print(" - LIBRE ");
                System.out.println("--> Sin Carro");
            }
        }
        System.out.println();
    }

    /**
     * metodo para la interfaz del usuario.
     * 
     * @author José Daniel Gómez Cabrera
     * @version pedir_datos_carro 1.1
    */
    public String[] pedir_datos_carro(){
        try{
            System.out.println("- Ingrese los datos de su carro.");
            System.out.println("-------------------------------------------------------------------------------------------------");
            String[] datos = new String[4];
            System.out.print(" Ingrese el nombre de vehiculo: ");
            datos[0] = scan.nextLine();
            System.out.print(" Ingrese el numero de placa: ");
            datos[1] = scan.nextLine();
            System.out.print(" Ingrese la marca del vehiculo: ");
            datos[2] = scan.nextLine();
            System.out.print(" Ingrese el modelo de vehiculo: ");
            datos[3] = scan.nextLine();
            System.out.println();
            System.out.println("- Carro Ingresado exitosamente.");
            System.out.println("- Hora de Entrada del carro: "+LocalTime.now().getHour()+" horas con "+LocalTime.now().getMinute()+" minutos.");
            return datos;
        }
        catch(Exception e){
            String s = "Vista: pedir_datos_carro: "+e.getMessage();
            throw new RuntimeException(s);
        }
    }

    /**
     * metodo para la interfaz del usuario.
     * 
     * @author José Daniel Gómez Cabrera
     * @version print_parqueo_lleno 1.1
    */
    public void print_parqueo_lleno(){
        System.out.println();
        System.out.println("Parqueo lleno. El carro no puede aceptarse en el Estacionamiento");
    }

    /**
     * metodo para la interfaz del usuario.
     * 
     * @author José Daniel Gómez Cabrera
     * @version pedir_placa 1.1
    */
    public String pedir_placa(){
        try{
            System.out.print("Ingrese la placa para retirar el carro: ");
            String placa = scan.nextLine();
            return placa;
        }
        catch(Exception e){
            String s = "Vista: pedir_placa: Debe ingresar una placa: "+e.getMessage();
            throw new RuntimeException(s);
        }
    }

    /**
     * metodo para la interfaz del usuario.
     * 
     * @author José Daniel Gómez Cabrera
     * @version carro_retirado 1.1
    */
    public void carro_retirado(Boolean exito, int tiempo){
        if(exito){
            System.out.println();
            System.out.println("- Carro Retirado exitosamente.");
            System.out.println("- Hora de Salida del carro: "+LocalTime.now().getHour()+" horas con "+LocalTime.now().getMinute()+" minutos.");
            System.out.println("- Tiempo de Estancia: "+tiempo+" minutos.");
        }
        else{
            System.out.println();
            System.out.println(" Carro No Encontrado, ingrese de nuevo la placa.");
        }
    }

    /**
     * metodo para la interfaz del usuario.
     * 
     * @author José Daniel Gómez Cabrera
     * @version mensaje_error 1.1
    */
    public void mensaje_error(){
        System.out.println("Error: debe ingresar una opcion del menu.");
    }

    /**
     * metodo para la interfaz del usuario.
     * 
     * @author José Daniel Gómez Cabrera
     * @version despedida 1.1
    */
    public void despedida(){
        System.out.println("- Muchas gracias por usar el estacionamiento...");
        System.out.println("- Recuerda que tus datos estaran disponibles cuando inicies el programa de nuevo.");
        System.out.println("- HORA DE CIERRE: "+LocalTime.now().getHour()+" horas con "+LocalTime.now().getMinute()+" minutos.");
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("- PROGRAMA FINALIZADO");
        System.out.println("-------------------------------------------------------------------------------------------------");
    }

    /**
     * metodo para la interfaz del usuario.
     * 
     * @author José Daniel Gómez Cabrera
     * @version mostrar_estadisticas 1.1
    */
    public void mostrar_estadisticas(Estacionamiento local){
        System.out.println();
        System.out.println("- ESTADISTICAS");
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.print("Horarios de mayor movimiento: ");
        for(int i = 0; i < local.get_horarios().size(); i++){
            System.out.print(local.get_horarios().get(i)+", ");
        }
        System.out.println();
        System.out.println("Carros Rechazados por Parqueo Lleno: "+local.get_carros_rechazados());

    }
}
