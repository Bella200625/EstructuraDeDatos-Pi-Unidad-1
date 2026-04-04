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
                    System.out.print("Escribe el nombre o correo que desea buscar: ");
                    
                    String criterio = sc.nextLine ();
                    
                        bucarContactos (criterio);
                        break;
                        
                case 3:
                    if (contador > 0) {
                    System.out.println("Generando archivo de texto...");
                    EXParchivo();
                } else {
                    System.out.println("No hay datos para exportar. Registra alguien primero.");}
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
        tels [contador] = tel;
        correos [contador] = correo;
        
        
            contador++;
            
        System.out.println ("El contacto ha sido guardado"); }
    }// cierra metodo registrarContactos
    
    //Metodos para buscar nombre o correo 
    
    public static void bucarContactos (String criterio){
        boolean encontrado = false;
        String busqueda = criterio.toLowerCase(); //pasaremos todo lo que el usuario escribio en minusculas
        
        System.out.println (" ");
        System.out.println ("----- Buscando coincidencias, porfavor, espere un momento ----- ");
        //revisamos si el nombre o el correo esta guardado 
        for (int i = 0; i < contador; i++){
        //Pasamos el nombre guardado a minúsculas SOLO para comparar
            if (nombres[i].toLowerCase().contains(busqueda) || 
                correos[i].toLowerCase().contains(busqueda)){
        System.out.println ("-------- RESULTADOS --------");
        System.out.println (" ");
        System.out.println("Estos son los contactos que coinciden con"+ criterio +" :");       
        System.out.println("Nombre: " + nombres[i] + " | Tel: " + tels[i] + " | Correo: " + correos[i]);    
         encontrado = true; 
            
            }
        }
        System.out.println (" ");
        if (!encontrado) {
        System.out.println("No se encontro ningun contacto que coincida con: " + criterio);
        System.out.println (" ");
        }
    }//cierra metodo buscar contactos
    
    
    // hagamos el ultimo metodo para exportar archivos
    public static void EXParchivo (){
        /*PrintWriter es una herramienta que te facilita escribir texto 
        en un archivo, y escritor es simplemente el nombre que le pongo 
        pa poder usarlo en el código; la palabra new 
        le indica al programa que cree ese objeto en la memoria en ese momento, 
        mientras que FileWriter es el que se encarga de escribir directamente 
        en el archivo; "agenda_contactos.txt" es el archivo donde
        se almacenará todo lo que escriba, y el valor true indica que el programa 
        añadirá el contenido al final sin borrar lo anterior (si fuera false, 
        eliminaría lo existente y empezaría desde cero)*/
        
        try (PrintWriter escritor = new PrintWriter(new FileWriter("agenda_contactos.txt",true))) {
        
        escritor.println("------- MI AGENDA -------"); // Escribe en el archivo
        
        // Recorremos los arreglos 
        for (int i = 0; i < contador; i++) {
            // Usamos 'escritor' en vez de 'System.out'
         
            escritor.println("- " + nombres[i] + " | " + tels[i] + " | " + correos[i]);
        }
        escritor.close();
        // todo salio bien
        System.out.println("El archivo se ha guardo en tu computadora.");

    } catch (IOException e) { 
        // Si el try falla
        System.out.println("No pude guardar porque: " + e.getMessage());
    }
}// cierra metodo EXParchivo
    
} //Cierra clase
