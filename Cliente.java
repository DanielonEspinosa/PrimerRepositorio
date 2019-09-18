
package estructuradedatos;

public class Cliente {
    private int clave, edad, siguiente;
    private String nombre;
    private char edCivil;
    
    
    public Cliente (int clave, int edad, char edCivil, String nombre){
        this.clave=clave;
        this.siguiente=-1;
        this.edCivil=edCivil;
        this.edad=edad;
        this.nombre=nombre;
    }
    

    public void setClave(int clave) {
        this.clave = clave;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSiguiente(int siguiente) {
        this.siguiente = siguiente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdCivil(char edCivil) {
        this.edCivil = edCivil;
    }
    
    public int getClave() {
        return clave;
    }

    public int getEdad() {
        return edad;
    }

    public int getSiguiente() {
        return siguiente;
    }

    public String getNombre() {
        return nombre;
    }

    public char getEdCivil() {
        return edCivil;
    }
}

