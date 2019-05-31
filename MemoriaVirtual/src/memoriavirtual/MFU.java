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
    
    public MFU(ArrayList<Integer> procesos) {
        
        this.paginas = new ArrayList<Integer>();
        this.contadores = new ArrayList<Integer>();
        
        System.out.printf("Bienvenido a MFU \n");
        
        for(Integer i: procesos){
            if(paginas.contains(i) == false){
                agregar_proceso(i);
            }
            else{
                aumentar_contador(paginas.indexOf(i));
            }
        }
        
        System.out.println(paginas);
        
    }    
    
    void agregar_proceso(int proceso){
        if(this.paginas.contains(proceso) == true){
            aumentar_contador(paginas.indexOf(proceso));
        }
        else{
            if(paginas.size() < 3){
                paginas.add(proceso);
                contadores.add(1);
            }
            else{
                int indice = obtener_indice_mayor();
                paginas.set(indice, proceso);
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
        }
        
        return indice;
    }
    
    
}
