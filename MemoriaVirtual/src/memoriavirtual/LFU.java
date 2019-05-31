/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoriavirtual;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author matiassebastianparra
 */
public class LFU {
    
    ArrayList<Integer> procesos = new ArrayList<>();
    ArrayList<BigDecimal> insertos = new ArrayList<>();
    ArrayList<String> paginas = new ArrayList<>(3);
    ArrayList<Double> repeticiones = new ArrayList<>();
    ArrayList<BigDecimal> lista = new ArrayList<>(3);
    ArrayList<Integer> algo = new ArrayList<>();
    int fallos = 0;
    int posicion = 1;
    int aux = 0;

    public LFU(ArrayList<Integer> procesos ) {
        this.procesos = procesos;  
        this.paginas.add(" ");
        this.paginas.add(" ");
        this.paginas.add(" ");
        for(int q=0;q<this.procesos.size();q++){
            int num = this.procesos.get(q);
            double mu = num;
            this.repeticiones.add(mu);
        }
        simulador();
    }         
    
     private void simulador() {
        double contador = 0;
        int contador2 = 0;
        boolean a;
        
        for(int i=0; i<this.procesos.size(); i++){            
            int valor = this.procesos.get(i);
            for(int j=0; j<this.procesos.size(); j++){
                if(this.procesos.get(j) == valor){
                    contador++;
                }
            }
            for(int k=0;k<this.repeticiones.size();k++){
                double z = valor;
                if(this.repeticiones.get(k) == z){
                    this.repeticiones.set(k, this.repeticiones.get(k)+(contador/10));
                }                
            }
            contador = 0;
        }
        
        for(int k=0;k<this.repeticiones.size();k++){
            BigDecimal bigDecimal = new BigDecimal(String.valueOf(this.repeticiones.get(k)));  
            int intValue = bigDecimal.intValue();
            this.insertos.add(bigDecimal.subtract(new BigDecimal(intValue)));
        }
        
        for(int i=0; i<this.repeticiones.size(); i++){            
            if(!" ".equals(this.paginas.get(2))){
                if(this.paginas.contains(Double.toString(this.procesos.get(i)))){
                    a = false;
                    imprimir(i, a);
                }else{    
                    int min = this.lista.indexOf(Collections.min(this.lista));
                    this.paginas.remove(min);
                    this.paginas.add(min, Double.toString(this.repeticiones.get(i)));
                    this.lista.remove(min);
                    this.lista.add(min, this.insertos.get(i));
                    a = true;
                    imprimir(i, a);
                    this.fallos++;
                    this.posicion++;
                }                 
            }else{
                if(this.paginas.contains(Double.toString(this.procesos.get(i)))){
                    a = false;
                    imprimir(i, a);
                }else{
                    this.paginas.remove(i);
                    this.paginas.add(i, Double.toString(this.repeticiones.get(i)));
                    this.lista.add(this.insertos.get(i));
                    contador++;
                    a = true;
                    imprimir(i, a);
                    this.fallos++;
                }                
            }
        }
        
        System.out.println("\nLa secuencia final es |" + this.paginas.get(0) + "|" + this.paginas.get(1) + "|" + this.paginas.get(2) + "|" + " con " + this.fallos +" fallos");
    }
    
        
    private void imprimir (int i, boolean a){        
        if(a){
           System.out.println("\nEl proceso " + this.procesos.get(i) + " se agregó a memoria");            
        }
        else{
            System.out.println("El proceso " + this.procesos.get(i) + " ya está en memoria"); 
        }      
        for(int j = 0 ; j<this.paginas.size(); j++){
            switch(j){
                case 0: System.out.print("\n|" + this.paginas.get(j));                         
                        break;
                case 1: System.out.print("|" + this.paginas.get(j));                          
                        break;
                case 2: System.out.println("|" + this.paginas.get(j) + "|");                          
                        break;
            }               
        }        
    } 
}
