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
 * @version Class DriverProgram 1.1
*/
public class DriverProgram {
    public static void main(String[] args) {
        Estacionamiento local = new Estacionamiento();
        Vista interfaz1 = new Vista();

        interfaz1.bienvenida_usuario();

        String opcion_usuario = "";

        while(!(opcion_usuario.equals("6"))){
            interfaz1.mostrar_menu();
            opcion_usuario = interfaz1.obtener_string();
            switch (opcion_usuario) {
                case "1"://mostrar parqueos
                    interfaz1.mostrar_parqueos(local);
                    break;
            
                case "2"://ingresar carro
                    if(!(local.get_parqueo_lleno())){
                        String[] datos = interfaz1.pedir_datos_carro();
                        local.ingresar_carro(datos[0], datos[1], datos[2], datos[3]);
                        local.actualizar_horarios();
                    }
                    else{
                        interfaz1.print_parqueo_lleno();
                        local.set_carros_rechazados();
                    }
                    break;

                case "3"://retirar carro
                    String placa_carro = interfaz1.pedir_placa();
                    boolean exito = local.retirar_carro(placa_carro);
                    int timepo_total = local.obtener_estancia(placa_carro);
                    interfaz1.carro_retirado(exito, timepo_total);
                    break;
        
                case "4":// estadisticas
                    interfaz1.mostrar_estadisticas(local);
                    break;

                case "5"://agrandar parqueo
                    int no_parqueos_nuevos = interfaz1.obtener_int();
                    local.agrandar_estacionamiento(no_parqueos_nuevos);
                    break;
    
                case "6"://finalizar programa
                    interfaz1.despedida();
                    
                    break;

                default:
                    interfaz1.mensaje_error();
                    break;
            }
        }
    }
        



}
