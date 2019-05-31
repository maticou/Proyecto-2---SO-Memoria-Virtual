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
public class OptimalAlgorithm {
    ArrayList<Integer> paginas;
    ArrayList<Integer> procesos;
    ArrayList<Integer> contadores_uso;
    int indice_actual = 0;
    
    public OptimalAlgorithm(ArrayList<Integer> procesos) {
        this.paginas = new ArrayList<Integer>();
        this.contadores_uso = new ArrayList<Integer>();
        this.procesos = procesos;
        
        System.out.printf("Bienvenido a Optimal Algorithm \n");
        
        for(Integer i: procesos){
            if(paginas.contains(i) == false){
                agregar_proceso(i);
                this.imprimir(procesos.indexOf(i), true);
            }
            else{
                this.actualizar_contadores_uso();
                this.imprimir(procesos.indexOf(i), false);
            }
            
            this.indice_actual++;
        }
    }
    
    void agregar_proceso(int proceso){
        if(paginas.size() < 3){
            paginas.add(proceso);
            this.contadores_uso.add(0);
        }
        else{
            actualizar_contadores_uso();
            paginas.set(obtener_pos_menos_usado(), proceso);
        }
    }
    
    void actualizar_contadores_uso(){
        int indice = 0;
        int aux_num = 0;
        int proceso_actual;
        
        contadores_uso.set(0, 0);
        contadores_uso.set(1, 0);
        contadores_uso.set(2, 0);
        
        for(int i = indice_actual; i < procesos.size(); i++){
            if(procesos.get(i) == paginas.get(0)){
                aux_num = contadores_uso.get(0)+1;
                contadores_uso.set(0, aux_num);
            }
            else if(procesos.get(i) == paginas.get(1)){
                aux_num = contadores_uso.get(1)+1;
                contadores_uso.set(1, aux_num);
            }
            else if(procesos.get(i) == paginas.get(2)){
                aux_num = contadores_uso.get(2)+1;
                contadores_uso.set(2, aux_num);
            }
        }
    }
    
    int obtener_pos_menos_usado(){
        int indice = 0;
        int min = this.contadores_uso.get(0);
        
        for(Integer cont : this.contadores_uso){
            if(min > cont){
                indice = contadores_uso.indexOf(cont);
                min = cont;
            }
        }
        
        return indice;
    }
    
    void imprimir(int i, boolean a){
        if(a){
           System.out.println("\nEl proceso " + this.procesos.get(i) + " se agregó a memoria");            
        }
        else{
            System.out.println("El proceso " + this.procesos.get(i) + " ya está en memoria"); 
        }      
        imprimir_paginas();
        //imprimir_contadores();
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
        System.out.print("contadores: ");
        for(int j = 0 ; j<this.contadores_uso.size(); j++){
            switch(j){
                case 0: System.out.print("\n|" + this.contadores_uso.get(j));                         
                        break;
                case 1: System.out.print("|" + this.contadores_uso.get(j));                          
                        break;
                case 2: System.out.println("|" + this.contadores_uso.get(j) + "|");                          
                        break;
            }               
        }  
    }
}
