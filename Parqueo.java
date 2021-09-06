//Universidad del Valle de Guatemala
//Programación Orientada a Objetos
//Catedrático Tomás Gálvez
//Segundo Semestre 2021
//José Daniel Gómez Cabrera
//Carné 21429
//Sección 11
//Actividad: Ejercicio 3

/**
 * @author José Daniel Gómez Cabrera
 * @version Class Parqueo 1.1
*/
public class Parqueo {
    private String no_parqueo;
    private String tamano;
    private boolean parqueo_techado;
    private boolean parqueo_aereo;
    private int frecuencia_de_uso;
    private int tiempo_de_uso; //EN MINUTOS
    private boolean parqueo_ocupado;
    private Carro car;

    /**
     * Constructor Parqueo con propiedades.
     * 
     * @author José Daniel Gómez Cabrera
     * @version Parqueo 1.1
     * @param Propiedades
    */
    public Parqueo(String no_parqueo, String tamano, boolean parqueo_techado, boolean parqueo_aereo, int frecuencia, int tiempo_total, boolean parqueo_ocupado){
        this.no_parqueo = no_parqueo;
        this.tamano = tamano;
        this.parqueo_techado = parqueo_techado;
        this.parqueo_aereo = parqueo_aereo;
        this.frecuencia_de_uso = frecuencia;
        this.tiempo_de_uso = tiempo_total;
        this.parqueo_ocupado = parqueo_ocupado;
    }

    /**
     * Constructor Carro adicional para acceder al constructor real en clase Carro.
     * 
     * @author José Daniel Gómez Cabrera
     * @version set_car 1.1
     * @param Propiedades
    */
    public void set_car(String vehiculo, String hora, String minuto, String placa, String marca, String modelo){
        car = new Carro(vehiculo, hora, minuto, placa, marca, modelo);
    }

    /**
     * Constructor Carro adicional para acceder al constructor real en clase Carro.
     * Es para solamente almacenar valores de cierto tipo.
     * 
     * @author José Daniel Gómez Cabrera
     * @version set_car 1.2
     * @param Propiedades
    */
    public void set_car2(String vehiculo, String placa, String marca, String modelo){
        car = new Carro(vehiculo, placa, marca, modelo);
    }

    /**
     * getter del carro.
     * 
     * @author José Daniel Gómez Cabrera
     * @version get_car 1.1
     * @return Carro
    */
    public Carro get_car(){
        return this.car;
    }

    /**
     * Getter para que vista imprima informacion de un parqueo a traves de un String[].
     * 
     * @author José Daniel Gómez Cabrera
     * @version get_info_parqueo 1.1
     * @return String[]
    */
    public String[] get_info_parqueo(){
        String[] info_parqueo = new String[7];
        info_parqueo[0] = this.no_parqueo;
        info_parqueo[1] = this.tamano;
        if(parqueo_techado){
            info_parqueo[2] = "Techado";
        }
        else{
            info_parqueo[2] = "No Techado";
        }
        if(parqueo_aereo){
            info_parqueo[3] = "Aereo";
        }
        else{
            info_parqueo[3] = "No Aereo";
        }
        info_parqueo[4] = Integer.toString(this.frecuencia_de_uso);
        info_parqueo[5] = Integer.toString(this.tiempo_de_uso);
        if(parqueo_ocupado){
            info_parqueo[6] = "Parqueo Ocupado.";
        }
        else{
            info_parqueo[6] = "Parqueo Libre.";
        }
        return info_parqueo;
    }

    /**
     * setter de parqueo ocupado.
     * 
     * @author José Daniel Gómez Cabrera
     * @version ocupar_parqueo 1.1
    */
    public void ocupar_parqueo(){
        this.parqueo_ocupado = true;
    }

    /**
     * método para actualizar la frecuencia del parqueo, el tiempo total que se uso por todos los carros, y cambiarlo a falso para poder almacenar un carro nuevo.
     * 
     * @author José Daniel Gómez Cabrera
     * @version actualizar_parqueo 1.1
     * @param Carro
    */
    public void actualizar_parqueo(Carro car){
        this.frecuencia_de_uso += 1;
        this.tiempo_de_uso += car.get_tiempo_estancia();
        this.parqueo_ocupado = false;
    }

    /**
     * Getter de frecuencia de uso.
     * 
     * @author José Daniel Gómez Cabrera
     * @version get_frecuencia_de_uso 1.1
     * @return int
    */
    public int get_frecuencia_de_uso(){
        return this.frecuencia_de_uso;
    }

    /**
     * Getter de tiempo de uso. EN MINUTOS
     * 
     * @author José Daniel Gómez Cabrera
     * @version get_tiempo_de_uso 1.1
     * @return int
    */
    public int get_tiempo_de_uso(){
        return this.tiempo_de_uso;
    }

    /**
     * Getter de parqueo ocupado. Para usar en clase Estacionamiento.
     * 
     * @author José Daniel Gómez Cabrera
     * @version get_parqueo_ocupado 1.1
     * @return boolean
    */
    public boolean get_parqueo_ocupado(){
        return this.parqueo_ocupado;
    }

    /**
     * getter del nombre del parqueo.
     * 
     * @author José Daniel Gómez Cabrera
     * @version get_nombre_parqueo 1.1
    */
    public String get_nombre_parqueo(){
        return this.no_parqueo;
    }
}
