/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estructuradatos.pi;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
/**
 Importamos lo que necesitamos para este ejercicio 
 como el scanner para pedir datos al usuario luego
 importar FileWriter y PrintWriter para poder 
 comunicarnos con el disco duro, y IOException
 para estar prevenidos por si algo falla al escribir el archivo.
 */
public class EstructuraDatosPi {
        
        //Definimos variables
        static final int MAX = 3;
        static int contador = 0;
        
        //arreglos paralelos 
        static String[] nombres = new String [MAX];
        static String[] correos = new String [MAX];
        static String[] tels = new String [MAX];
    
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner (System.in);
        int opcion = 0;
        
        /* Crearemos un bucle para que el programa funcione hasta que
           el usuario decida salir*/
        do {
        
        System.out.println ("-------- AGENDA --------");
        System.out.println("Pon 0, si deseas Salir");
        System.out.println("Pon 1, si deseas Registrar un contacto");
        System.out.println("Pon 2, si deseas buscar un contacto");
        System.out.println("Pon 3, Exportar a TXT");
        System.out.println("Tu respuesta aqui: ");
            opcion = sc.nextInt();
            sc.nextLine(); //estoes para limpiar el buffer
        
        
            switch (opcion) {
            
                case 0: 
             
                    System.out.println("CHAO!!"); 
                        break;
                        
                case 1: 
                    if (contador < MAX){
                    System.out.println("Por favor, ingrese el nombre: ");
                        String nom = sc.nextLine();
                    System.out.println("Ingrese el telefono: ");
                        String tel = sc.nextLine();
                    System.out.println("Ingrese el correo: ");
                        String correo = sc.nextLine();
                    
                    
                    registrarContactos(nom,tel,correo);
                    } else {System.out.println ("Esta agenda telefonica esta llena");}
                        break;
                case 2:
                    
                        break;
                        
                case 3:
                        break;
                        
                default:
                        System.out.println("Opcion no valida intentelo de nuevo.");
                        System.out.println (" ");
                        break; 
                    
        }
        } while (opcion != 0);
        
        
} //Cierra main 
    
    //Crearemos un metodo para registrar 
    
    public static void registrarContactos (String nombre,String tel, String correo){
        if (contador < MAX){
        nombres [contador] = nombre;
        correos [contador] = correo;
        tels [contador] = tel;
        
            contador++;
            
        System.out.println ("El contacto ha sido guardado"); }
    }// cierra metodo registrarContactos
    
} //Cierra clase
