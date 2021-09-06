//Universidad del Valle de Guatemala
//Programación Orientada a Objetos
//Catedrático Tomás Gálvez
//Segundo Semestre 2021
//José Daniel Gómez Cabrera
//Carné 21429
//Sección 11
//Actividad: Ejercicio 3

import java.util.ArrayList;
import java.time.LocalTime;

/**
 * @author José Daniel Gómez Cabrera
 * @version Class Estacionamiento 1.1
*/
public class Estacionamiento{
    private String nombre;
    private String direccion;
    private double precio;
    private ArrayList<Parqueo> parqueos = new ArrayList<Parqueo>();
    // private ArrayList<Carro> carros = new ArrayList<Carro>();
    private ArrayList<String> horarios_mayor_movimiento = new ArrayList<String>();
    private double tiempo_promedio;//no
    private boolean parqueo_lleno;
    private int carros_rechazados_parqueo_lleno;

    /**
     * Constructor.
     * 
     * @author José Daniel Gómez Cabrera
     * @version Estacionamiento 1.1
    */
    public Estacionamiento(){
        try{
            String[] info_parqueo = FileReader.leer_info_estacionamiento();
            this.nombre = info_parqueo[0];
            this.direccion = info_parqueo[1];
            this.precio = Double.parseDouble((info_parqueo[2]));
            obtener_parqueos();
            this.horarios_mayor_movimiento = FileReader.leer_horarios_mayor_mov();
            this.parqueo_lleno = Boolean.parseBoolean(info_parqueo[3]);
            this.carros_rechazados_parqueo_lleno = Integer.parseInt(info_parqueo[4]);
        }
        catch(Exception e){
            String s = "Estacionamiento: Constructor: "+e.getMessage();
            throw new RuntimeException(s);
        }
    }

    /**
     * metodo para incluir en constructor.
     * 
     * @author José Daniel Gómez Cabrera
     * @version obtener_parqueos 1.1
    */
    public void obtener_parqueos(){
        try{
            String [] parqueos = FileReader.leer_parqueos();
            String [] carros = FileReader.leer_carros();
            for(int k = 0; k < parqueos.length; k++){
                String[] parqueo_k = (parqueos[k]).split(",");
                String[] carro_k = (carros[k]).split(",");
                Parqueo parqueo = new Parqueo(parqueo_k[0],parqueo_k[1],Boolean.parseBoolean(parqueo_k[2]),Boolean.parseBoolean(parqueo_k[3]),Integer.parseInt(parqueo_k[4]),Integer.parseInt(parqueo_k[5]),Boolean.parseBoolean(parqueo_k[6]));
                parqueo.set_car(carro_k[0], carro_k[1], carro_k[2], carro_k[3], carro_k[4], carro_k[5]);
                this.parqueos.add(parqueo);
            }
        }
        catch(Exception e){
            String s = "Estacionamiento: obtener_parqueos: "+e.getMessage();
            throw new RuntimeException(s);
        }
    }

    /**
     * getter de parqueos.
     * 
     * @author José Daniel Gómez Cabrera
     * @version get_parqueos_estacionamiento 1.1
    */
    public ArrayList<Parqueo> get_parqueos_estacionamiento(){
        return this.parqueos;
    }

    /**
     * metodo para ingresar datos de carro.
     * 
     * @author José Daniel Gómez Cabrera
     * @version ingresar_carro 1.1
     * @param propiedades de Carro
    */
    public int ingresar_carro(String vehiculo, String placa, String marca, String modelo){
        boolean continuar_buscando = true;
        int num_parqueos = ((this.parqueos.size())-1);
        int parqueo_t = 0;
        while(continuar_buscando && (parqueo_t<num_parqueos)){
            if((this.parqueos.get(parqueo_t).get_parqueo_ocupado())==false){
                this.parqueos.get(parqueo_t).set_car2(vehiculo, placa, marca, modelo);
                this.parqueos.get(parqueo_t).ocupar_parqueo();
                continuar_buscando = false;
            }
            else{
                parqueo_t += 1;
            }
        }
        if(parqueo_t==(num_parqueos+1)){
            this.parqueo_lleno = true;
        }
        return (parqueo_t+1);
    }

    /**
     * metodo para retirar Carro.
     * 
     * @author José Daniel Gómez Cabrera
     * @version retirar_carro 1.1
     * @param String para barrer los parqueos
    */
    public boolean retirar_carro(String placa){
        boolean carro_encontrado = false;
        for(int k = 0; k < parqueos.size(); k++){
            if(placa.equals(this.parqueos.get(k).get_car().get_placa())){
                this.parqueos.get(k).get_car().set_tiempo_estancia();
                this.parqueos.get(k).actualizar_parqueo(this.parqueos.get(k).get_car());
                this.parqueos.get(k).set_car("vacio", "0", "0", "vacio", "vacio", "vacio");
                carro_encontrado = true;
            }
        }
        return carro_encontrado;
    }

    /**
     * metodo para obtener los minutos de estancia e imprimirlos en pantalla.
     * 
     * @author José Daniel Gómez Cabrera
     * @version obtener_estancia 1.1
     * @param String para barrer los parqueos
     * @return int con minutos de instancia.
    */
    public int obtener_estancia(String placa){
        int tiempo = 0;
        for(int k = 0; k < this.parqueos.size(); k++){
            if(placa.equals(this.parqueos.get(k).get_car().get_placa())){
                tiempo = this.parqueos.get(k).get_car().get_tiempo_estancia();
            }
        }
        return tiempo;
    }

    /**
     * getter de parqueo lleno
     * 
     * @author José Daniel Gómez Cabrera
     * @version get_parqueo_lleno 1.1
     * @return boolean
    */
    public boolean get_parqueo_lleno(){
        return this.parqueo_lleno;
    }


    public ArrayList<String> get_horarios(){
        return this.horarios_mayor_movimiento;
    }

    /**
     * getter de parqueo lleno
     * 
     * @author José Daniel Gómez Cabrera
     * @version actualizar_horarios 1.1
    */
    public void actualizar_horarios(){
        if(this.horarios_mayor_movimiento.get(0).equals("Sin horarios con mayor movimiento,")){
            this.horarios_mayor_movimiento.remove("Sin horarios con mayor movimiento,");
        }
        else{
            String horario = LocalTime.now().getHour()+" horas.";
            this.horarios_mayor_movimiento.add(horario);
        }
    }


    /**
     * suma la unidad del contador de carros rechazados.
     * 
     * @author José Daniel Gómez Cabrera
     * @version set_carros_rechazados 1.1
    */
    public void set_carros_rechazados(){
        this.carros_rechazados_parqueo_lleno += 1;
    }

    /**
     * getter de carros rechazados para imprimirlo en estadisticas.
     * 
     * @author José Daniel Gómez Cabrera
     * @version set_carros_rechazados 1.1
     * @return int
    */
    public int get_carros_rechazados(){
        return this.carros_rechazados_parqueo_lleno;
    }


    /**
     * recibe la cantidad de parqueos que desea agregar el usuario y los suma al ArrayList
     * 
     * @author José Daniel Gómez Cabrera
     * @version set_carros_rechazados 1.1
     * @param int
    */
    public void agrandar_estacionamiento(int nuevos_parqueos){
        int numero = this.parqueos.size();
        for(int i = 0; i<nuevos_parqueos; i++){
            String no_parqueo= "Parqueo "+((i+1)+numero);
            Parqueo mi_parqueo = new Parqueo(no_parqueo, "Mediano", false, false, 0, 0, false);
            this.parqueos.add(mi_parqueo);
        }
    }


}