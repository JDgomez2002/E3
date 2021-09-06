//Universidad del Valle de Guatemala
//Programación Orientada a Objetos
//Catedrático Tomás Gálvez
//Segundo Semestre 2021
//José Daniel Gómez Cabrera
//Carné 21429
//Sección 11
//Actividad: Ejercicio 3

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clas FileReader que se encarga de leer archivos txt de parqueos.txt, carros.txt, estacionamiento.txt.
 * Con el objetivo de poseer siempre persistencia de datos.
 * 
 * @author José Daniel Gómez Cabrera
 * @version Class FileReader 1.1
*/
public class FileReader {
    
    /**
     * metodo para leer con clase File los datos del archivo parqueos.txt.
     * recibe todos los datos, y lo regresa todo como arreglo con toda la información.
     * El constructor de parqueo recibe el arreglo para poder inicializar las ArrayList de Estacionamiento cada vez que se ejecuta el programa.
     * 
     * @author José Daniel Gómez Cabrera
     * @version leer_parqueos 1.1
     * @return String[]
    */
    public static String[] leer_parqueos(){
        try{
            File parqueos_txt = new File("parqueos.txt");
            Scanner scan1 = new Scanner(parqueos_txt);
            String parqueos = "";
            while(scan1.hasNextLine()){
                parqueos = parqueos.concat(scan1.nextLine()+":");
            }
            String[] parqueos_separados = parqueos.split(":");
            return parqueos_separados;
        }
        catch(Exception e){
            String s = "FileReader_Parqueos: Archivo Desaparecido o Corrompido: "+e.getMessage();
            throw new RuntimeException(s);
        }
    }
    
    /**
     * metodo para leer con clase File los datos del archivo carros.txt.
     * recibe todos los datos, y lo regresa todo como arreglo con toda la información.
     * El constructor de carro recibe el arreglo para poder inicializar las ArrayList de Estacionamiento cada vez que se ejecuta el programa.
     * 
     * @author José Daniel Gómez Cabrera
     * @version leer_carros 1.1
     * @return String[]
    */
    public static String[] leer_carros(){
        try{
            File carros_txt = new File("carros.txt");
            Scanner scan2 = new Scanner(carros_txt);
            String carros = "";
            while(scan2.hasNextLine()){
                carros = carros.concat(scan2.nextLine()+":");
            }
            String[] carros_separados = carros.split(":");
            return carros_separados;
        }
        catch(Exception e){
            String s = "FileReader_Carros: Archivo Desaparecido o Corrompido: "+e.getMessage();
            throw new RuntimeException(s);
        }
    }
    
    /**
     * metodo para leer con clase File los datos del archivo infoEstacionamiento.txt.
     * recibe todos los datos, y lo regresa todo como arreglo con toda la información.
     * El constructor de Estacionamiento recibe el arreglo para poder inicializar las propiedades de Estacionamiento cada vez que se ejecuta el programa.
     * 
     * @author José Daniel Gómez Cabrera
     * @version leer_info_estacionamiento 1.1
     * @return String[]
    */
    public static String[] leer_info_estacionamiento(){
        try{
            File estacionamiento_txt = new File("infoEstacionamiento.txt");
            Scanner scan3 = new Scanner(estacionamiento_txt);
            String estacionamiento = scan3.nextLine();
            String[] info_estacionamiento = estacionamiento.split(",");
            return info_estacionamiento;
        }
        catch(Exception e){
            String s = "FileReader_Estacionamiento: Archivo Desaparecido o Corrompido: "+e.getMessage();
            throw new RuntimeException(s);
        }
    }

    /**
     * metodo para leer con clase File los datos del archivo horariosMayorMovimiento.txt.
     * recibe todos los datos, y lo regresa todo como arreglo dinámico con toda la información.
     * El constructor de Estacionamiento recibe el arreglo para poder inicializar las propiedades de Estacionamiento cada vez que se ejecuta el programa.
     * 
     * @author José Daniel Gómez Cabrera
     * @version leer_horarios_mayor_mov 1.1
     * @return String[]
    */
    public static ArrayList<String> leer_horarios_mayor_mov(){
        try{
            File horarios_txt = new File("horariosMayorMovimiento.txt");
            Scanner scan4 = new Scanner(horarios_txt);
            String[] horarios = scan4.nextLine().split(",");
            ArrayList<String> horarios_mayor_mov = new ArrayList<String>();
            for(int i = 0; i < horarios.length; i++){
                horarios_mayor_mov.add(horarios[i]);
            }
            return horarios_mayor_mov;
        }
        catch(Exception e){
            String s = "FileReader_HorariosMayorMovimiento: Archivo Desaparecido o Corrompido: "+e.getMessage();
            throw new RuntimeException(s);
        }
    }
}
