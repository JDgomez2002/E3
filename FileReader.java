//Universidad del Valle de Guatemala
//Programación Orientada a Objetos
//Catedrático Tomás Gálvez
//Segundo Semestre 2021
//José Daniel Gómez Cabrera
//Carné 21429
//Sección 11
//Actividad: Ejercicio 3

import java.io.File;
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
     * método para leer con clase File los datos del archivo parqueos.txt.
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
     * método para leer con clase File los datos del archivo carros.txt.
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
    
    public static String[] leer_info_parqueo(){
        
    }

}
