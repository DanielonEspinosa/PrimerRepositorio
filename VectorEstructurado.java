package estructuradedatos;
import java.util.*;
public class VectorEstructurado {
    
    private static Scanner In=new Scanner(System.in);
    private static int mayor, opcion, sub=0, inicio=-1;
    private static int nvClave, nvEdad;
    private static String nvNombre;
    private static char nvEdCivil;
    
    public static void main(String [] args){
        Cliente clientes[] = new Cliente [10];
        while (true){
            MostrarMenu();
            switch (opcion){
                case 1: MostrarMenu1();
                    switch (opcion){
                        case 1: 
                            if (!Registrar(clientes))
                                System.out.println("Clave ya existente\n");
                            else 
                                System.out.println("Registro exitoso\n");
                            break;
                        case 2: MostrarMenu1(); break;
                        case 3: break;
                    }
                    break;
                case 2: break;
                case 3: MostrarClientes(clientes); break;
                case 4: return; 
            }
        }  
    }
    
    public static void MostrarMenu(){
        System.out.print("1. Registrar");
        System.out.print("\n2. Eliminar");
        System.out.print("\n3. Consultar");
        System.out.print("\n4. Salir");
        System.out.print("\nOpcion: ");
        try{
            opcion=In.nextInt();
        } catch (InputMismatchException e){
            System.out.println("\nEl dato proporiconado no es adecuado. Intentelo nuevamente");  
            String a=In.nextLine();
            MostrarMenu();
        }
        if (opcion>4 || opcion<1){
            System.out.println("\nSolo se aceptan apciones de la 1 a la 4");
            MostrarMenu();
        }
    }
    public static void MostrarMenu1(){
        try{
            System.out.print("Clave: ");
            nvClave=In.nextInt();
            System.out.print("Nombre: ");
            nvNombre=In.nextLine();nvNombre=In.nextLine();
            System.out.print("Edad: ");
            nvEdad=In.nextInt();
            System.out.print("Ed. Civil: ");
            nvEdCivil=In.next().charAt(0);
        
            System.out.print("\n1.Registrar\t2.Cancelar\t3.Menu anterior\nOpcion: ");
            opcion=In.nextInt();
        } catch (Exception e){
            System.out.println("\nEl dato proporiconado no es adecuado. Intentelo nuevamente");
            String a=In.nextLine();
            MostrarMenu1();
        }
    }
    public static boolean Registrar(Cliente V[]){
        if (sub==V.length)
            return false;
        if (!VerificarClave(nvClave, V))
            return false;
        
        V[sub]= new Cliente(nvClave, nvEdad, nvEdCivil, nvNombre);
        
        if (inicio == -1){
            inicio=0;
            mayor=0;
            sub++;
            return true;
        }  
        if (nvClave<V[inicio].getClave()){
            V[sub].setSiguiente(inicio);
            inicio=sub;
            sub++;
            return true;
        } 
        if (nvClave>V[mayor].getClave()){
            V[mayor].setSiguiente(sub);
            mayor=sub;
            sub++;
            return true;
        }  
        int ind=inicio, anterior=0;
        while (nvClave>V[ind].getClave()){
            anterior=ind;
            ind=V[ind].getSiguiente();
        }
        V[anterior].setSiguiente(sub);
        V[sub].setSiguiente(ind);
        sub++;
        return true;
    }
    public static boolean VerificarClave(int nvClave, Cliente V[]){
        if (inicio==-1)
            return true;
        
       int ind=inicio; 
       while (V[ind].getSiguiente()!=-1){
           if (nvClave<=V[ind].getClave())
               break;
           ind=V[ind].getSiguiente();
        }
       
           if (nvClave==V[ind].getClave())
               return false;
           else
               return true;
    }
    public static void MostrarClientes(Cliente V[]){
        int ind = inicio;
        while (ind != -1){
            System.out.println("\nClave: "+ V[ind].getClave()+" Nombre: "+
            V[ind].getNombre()+" Edad: "+V[ind].getEdad()+" Ed. Civil: "+V[ind].getEdCivil());
            ind = V[ind].getSiguiente();
        }
    }
    public static boolean Eliminar (Cliente V[]){
        if (inicio==-1)
            return false;
        
        
        return true;
    }
}

