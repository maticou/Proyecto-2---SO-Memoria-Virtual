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
public class MFU {

    ArrayList<Integer> paginas;
    ArrayList<Integer> contadores;
    ArrayList<Integer> procesos;
    ArrayList<Integer> antiguedad;
    int index = 0;
    
    public MFU(ArrayList<Integer> procesos) {
        
        this.paginas = new ArrayList<Integer>();
        this.contadores = new ArrayList<Integer>();
        this.antiguedad = new ArrayList<Integer>();
        this.procesos = procesos;
        
        System.out.printf("Bienvenido a MFU \n");
        
        for(Integer i: procesos){
            if(paginas.contains(i) == false){
                agregar_proceso(i);
                this.imprimir(procesos.indexOf(i), true);
            }
            else{
                aumentar_contador(paginas.indexOf(i));
                this.imprimir(procesos.indexOf(i), false);
            }
            index++;
        }
    }    
    
    void agregar_proceso(int proceso){
        if(this.paginas.contains(proceso) == true){
            aumentar_contador(paginas.indexOf(proceso));
        }
        else{
            if(paginas.size() < 3){
                paginas.add(proceso);
                antiguedad.add(this.index+1);
                contadores.add(1);
            }
            else{
                int indice = obtener_indice_mayor();
                paginas.set(indice, proceso);
                antiguedad.set(indice, this.index+1);
                contadores.set(indice, 1);
            }
        }
    }
    
    void aumentar_contador(int indice){
        int valor = this.contadores.get(indice) + 1;
        this.contadores.set(indice, valor);
    }
    
    int obtener_indice_mayor(){
        int indice = 0;
        int anterior = 0;
        
        for(Integer cont : this.contadores){
            if(cont > anterior){
                indice = contadores.indexOf(cont);
                anterior = cont;
            }
            else{
                if(cont == anterior){
                    indice = obtener_indice_antiguo();
                    anterior = cont;
                }
            }
        }
        
        return indice;
    }
    
    int obtener_indice_antiguo(){
        int indice = 0;
        int min = antiguedad.get(0);
        
        for(Integer cont : this.antiguedad){
            if(min > cont){
                indice = antiguedad.indexOf(cont);
                min = cont;
            }
        }
        
        return indice;
    }
    
    private void imprimir (int i, boolean a){        
        if(a){
           System.out.println("\nEl proceso " + this.procesos.get(i) + " se agregó a memoria");            
        }
        else{
            System.out.println("El proceso " + this.procesos.get(i) + " ya está en memoria"); 
        }      
        imprimir_paginas();
        imprimir_contadores();
        imprimir_antiguedad();
    }
    
    void imprimir_paginas(){
        System.out.print("Páginas: ");
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
    
    void imprimir_contadores(){
        System.out.print("Contadores de uso: ");
        for(int j = 0 ; j<this.contadores.size(); j++){
            switch(j){
                case 0: System.out.print("\n|" + this.contadores.get(j));                         
                        break;
                case 1: System.out.print("|" + this.contadores.get(j));                          
                        break;
                case 2: System.out.println("|" + this.contadores.get(j) + "|");                          
                        break;
            }               
        }
    }
    
    void imprimir_antiguedad(){
        System.out.print("Contadores de antiguedad: ");
        for(int j = 0 ; j<this.antiguedad.size(); j++){
            switch(j){
                case 0: System.out.print("\n|" + this.antiguedad.get(j));                         
                        break;
                case 1: System.out.print("|" + this.antiguedad.get(j));                          
                        break;
                case 2: System.out.println("|" + this.antiguedad.get(j) + "|");                          
                        break;
            }               
        }
    }
    
    
}
