//Universidad del Valle de Guatemala
//Programación Orientada a Objetos
//Catedrático Tomás Gálvez
//Segundo Semestre 2021
//José Daniel Gómez Cabrera
//Carné 21429
//Sección 11
//Actividad: Ejercicio 3

import java.util.ArrayList;

/**
 * @author José Daniel Gómez Cabrera
 * @version Class Estacionamiento 1.1
*/
public class Estacionamiento{
    private String nombre;
    private String direccion;
    private double precio;
    private ArrayList<Parqueo> parqueos = new ArrayList<Parqueo>();
    private ArrayList<Carro> carros = new ArrayList<Carro>();
    private ArrayList<String> horarios_mayor_movimiento = new ArrayList<String>();
    private double tiempo_promedio;
    private boolean parqueo_lleno;
    private int carros_rechazados_parqueo_lleno;

    public Estacionamiento(){
        this.nombre = "ESTACIONAMIENTO 1";
        this.direccion = "Ubicacion Desconocida";
        this.precio = 0.0;

    }



}