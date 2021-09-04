//Universidad del Valle de Guatemala
//Programación Orientada a Objetos
//Catedrático Tomás Gálvez
//Segundo Semestre 2021
//José Daniel Gómez Cabrera
//Carné 21429
//Sección 11
//Actividad: Ejercicio 3

import java.time.LocalTime;

/**
 * Clase Carro.
 * 
 * @author José Daniel Gómez Cabrera
 * @version Class Carro 1.1
*/
public class Carro {
    private String vehiculo;
    private int[] hora_entrada = new int[2];
    private int[] hora_salida = new int[2];
    private int tiempo_estancia;
    private String placa;
    private String marca;
    private String modelo;

    

    /**
     * Constructor Carro.
     * 
     * @author José Daniel Gómez Cabrera
     * @version Carro 1.1
    */
    public Carro(){
        this.vehiculo = "";
        this.hora_entrada[0] = 0;
        this.hora_entrada[1] = 0;
        this.hora_salida[0] = 0;
        this.hora_salida[1] = 0;
        this.tiempo_estancia = 0;
        this.placa = "";
        this.marca = "";
        this.modelo = "";
    }

    /**
     * Constructor Carro con propiedades.
     * 
     * @author José Daniel Gómez Cabrera
     * @version Carro 1.2
     * @param Propiedades
    */
    public Carro(String vehiculo, String placa, String marca, String modelo){
        this.vehiculo = vehiculo;
        set_hora_entrada();
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
    }

    /**
     * setter de hora de entrada.
     * 
     * @author José Daniel Gómez Cabrera
     * @version set_hora_entrada 1.1
    */
    private void set_hora_entrada(){
        this.hora_entrada[0] = LocalTime.now().getHour();
        this.hora_entrada[1] = LocalTime.now().getMinute();
    }
    
    /**
     * setter de hora de salida.
     * 
     * @author José Daniel Gómez Cabrera
     * @version set_hora_salida 1.1
    */
    private void set_hora_salida(){
        this.hora_salida[0] = LocalTime.now().getHour();
        this.hora_salida[1] = LocalTime.now().getMinute();
    }

    /**
     * setter de tiempo de estancia.
     * establece el tiempo de parqueo del carro en MINUTOS.
     * 
     * @author José Daniel Gómez Cabrera
     * @version set_tiempo_estancia 1.1
    */
    public void set_tiempo_estancia(){
        set_hora_salida();
        int horas_a_minutos = (hora_salida[0]-hora_entrada[0])*60;
        int diferencia_minutos = (hora_salida[1]-hora_entrada[1]);
        this.tiempo_estancia = (horas_a_minutos + diferencia_minutos); //EN MINUTOS
    }

    /**
     * getter de tiempo de estancia.
     * 
     * @author José Daniel Gómez Cabrera
     * @version get_tiempo_estancia 1.1
     * @return double
    */
    public int get_tiempo_estancia(){
        return this.tiempo_estancia;
    }

    /**
     * getter de placa.
     * 
     * @author José Daniel Gómez Cabrera
     * @version get_placa 1.1
     * @return String
    */
    public String get_placa(){
        return this.placa;
    }

    /**
     * Método para obtener la información en un Array.
     * 
     * @author José Daniel Gómez Cabrera
     * @version get_info_carro 1.1
     * @return String[]
    */
    public String[] get_info_carro(){
        String[] info_carro = new String[4];
        info_carro[0] = this.vehiculo;
        info_carro[1] = this.placa;
        info_carro[2] = this.marca;
        info_carro[3] = this.modelo;
        return info_carro;
    }
}
