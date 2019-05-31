/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoriavirtual;

import java.util.ArrayList;

/**
 *
 * @author matiassebastianparra
 */
public class LRU {
    
    ArrayList<Integer> procesos = new ArrayList<>();
    ArrayList<Integer> insertos = new ArrayList<>();
    ArrayList<String> paginas = new ArrayList<>(3);
    ArrayList<String> anteriores = new ArrayList<>(3);
    int fallos = 0;
    int posicion = 1;

    public LRU(ArrayList<Integer> procesos) {
        this.procesos = procesos;  
        this.paginas.add(" ");
        this.paginas.add(" ");
        this.paginas.add(" ");
        simulador();
    }           
    
    
    private void simulador() {
        int contador = 0;
        boolean a;
        
        for(int i=0; i<this.procesos.size(); i++){            
            if(this.paginas.get(2) != " "){
                if(this.paginas.contains(Integer.toString(this.procesos.get(i)))){
                    a = false;
                    imprimir(i, a);
                }else{
                    
                    while(this.anteriores.size()<3){
                        if(this.anteriores.contains(Integer.toString(this.procesos.get(i-this.posicion)))){
                            this.posicion++;
                        }else{
                            this.anteriores.add(Integer.toString(this.procesos.get(i-this.posicion)));
                            this.posicion++;
                        }                        
                    }
                    
                    int indice = 0;
                    indice = this.paginas.indexOf(this.anteriores.get(2));
                    this.paginas.remove(this.anteriores.get(2));
                    this.paginas.add(indice, Integer.toString(this.procesos.get(i)));
                    this.insertos.add(this.procesos.get(i));
                    a = true;
                    imprimir(i, a);
                    this.fallos++;
                    this.posicion = 1;
                    this.anteriores.clear();
                }                 
            }else{
                if(this.paginas.contains(Integer.toString(this.procesos.get(i)))){
                    a = false;
                    imprimir(i, a);
                }else{
                    this.paginas.remove(i);
                    this.paginas.add(contador, Integer.toString(this.procesos.get(i)));
                    this.insertos.add(this.procesos.get(i));
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
