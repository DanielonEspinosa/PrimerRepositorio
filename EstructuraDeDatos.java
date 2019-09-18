package estructuradedatos;
import java.util.*;
public class EstructuraDeDatos {
    private static Scanner In = new Scanner(System.in);
    private static boolean signo=false, expo=false;
    public static void main(String[] args) {
        float numero;
        int exponente;
        System.out.print("Numero: ");
        numero = In.nextFloat();
        
        if (numero>0)
            signo=true;
        else
            numero*=-1;
        if (numero>=1)
            expo=true;
        
        String binario=Convertir(numero);
        if (expo)
            exponente=(binario.indexOf('.')-1)+127;
        else{
            int contador=0;
            while(binario.charAt(contador+2)=='0')
                contador++;
            exponente=127-(contador+1);
        }
        String binarioExpo=ConvertirParteEntera(exponente);
        
        String mantisa="",pFlotante;
        if (expo){
            for (int i=1; i<binario.length(); i++)
                if (binario.charAt(i)!='.')
                    mantisa+=binario.charAt(i);
        }
        else
            mantisa=binario.substring(((exponente-127)*-1)+2, binario.length());
            
        if (signo)
            pFlotante="0 "+PonCeros(binarioExpo, 8)+" "+PonCeros(mantisa, 23);
        else
           pFlotante="1 "+PonCeros(binarioExpo, 8)+" "+PonCeros(mantisa, 23); 
        System.out.println(pFlotante);
    }
    
    public static String ConvertirParteEntera(float numero){
       //Parte entera
       if (numero==0)
           return "0";
       Stack pila = new Stack();
        while (numero>0){
            if (numero%2==0){
                numero/=2;
                pila.push(0);
            } else {
                numero--;
                numero/=2;
                pila.push(1);
            }   
        } 
        String binario="";
        while (!pila.empty()){
            binario+=pila.pop();
        }
        
        return binario;
    }
    public static String Convertir(float numero){
        
        float numDecimal;
        String decimal, nvDecimal="0.";
       
        decimal=numero+"";
        int a = decimal.indexOf('.');
        
        nvDecimal += decimal.substring(a+1, decimal.length());
        //System.out.println(nvDecimal);
        
        numDecimal=Float.parseFloat(nvDecimal);
        numero-=numDecimal;
        String binario=ConvertirParteEntera(numero);
        
        decimal="";
        while (true){
            numDecimal*=2;
            if (numDecimal>1){
                decimal+=1;
                numDecimal--;
            } else if (numDecimal<1){
                decimal+=0;
            }
            if (numDecimal==1){
                decimal+=1;
                break;
            }
            if (decimal.length()+binario.length()>=24)
                break;    
        }
        binario=binario+"."+decimal;
        return binario;
    }
    public static String PonCeros(String Texto,int Tamaño){
  	  while (Texto.length() <Tamaño)
  		  Texto+="0";
  	  return Texto;
    }
    
}

