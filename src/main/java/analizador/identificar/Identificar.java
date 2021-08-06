package analizador.identificar;

import java.util.ArrayList;

/**
 *
 * @author pabloluis
 */
public class Identificar {
    
    
    private ArrayList<String> identificados;

    //constructor
    public Identificar() {
        this.identificados = new ArrayList<>();
    }
    
    public void analizar(String linea){
        int tamaño = linea.length();
        
        for(int i=0; i<(tamaño-1); i++){//recorremos todo el texto
            int pos=i;
            char caracter = linea.charAt(pos);//analizamos caracter por caracter el texto
            
            if(caracter != ' ' && Character.isDigit(caracter)){//si inicia con un numero
                int cantPuntosDecimal=0; //para verificar si es un numero decimal que solo 1 punto haya sino sera error
                int contador = pos+1;//para analizar los caracteres que estan delate del anterior caracter
                caracter = linea.charAt(contador);
               
                while(caracter != ' ' && cantPuntosDecimal<=1 && (Character.isDigit(caracter) || caracter=='.') && contador<tamaño){
                    if(caracter == '.'){
                        cantPuntosDecimal++;
                    }
                    contador++;
                    caracter = linea.charAt(contador);
                }
                
                if(Character.isLetter(caracter)){
                    identificados.add(TipoToken.ERROR.getTipo()+linea.substring(pos, contador));//si hay una letra
                }
                
                if(cantPuntosDecimal==0){
                    identificados.add(TipoToken.ENTERO.getTipo()+linea.substring(pos, contador));//dato identificado
                } else if(cantPuntosDecimal == 1) {
                    identificados.add(TipoToken.DECIMAL.getTipo()+linea.substring(pos, contador));//dato identificado
                } else {
                    identificados.add(TipoToken.ERROR.getTipo()+linea.substring(pos, contador));//dato identificado
                }
                
                i = contador;//para avanzar a la siguiete palabra y no repetir 
                
            } else if(Character.isLetter(caracter)){//si inicia con una letra
                int contador = pos+1;//para analizar el siguiente caracter
                caracter = linea.charAt(contador);
                while(Character.isLetter(caracter) || Character.isDigit(caracter) && contador < tamaño){//para verificar y que no se exceda del tamaño del texto
                    contador++;
                }
                
                identificados.add(TipoToken.ID.getTipo()+linea.substring(pos, contador));
            } else if(caracter != ' ') {
                identificados.add(TipoToken.SIMBOLO.getTipo()+caracter);
            }
        }
        
    }
    
  
   

    
    
    
}
