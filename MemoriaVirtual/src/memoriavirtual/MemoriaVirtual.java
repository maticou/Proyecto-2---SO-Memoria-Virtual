/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoriavirtual;

import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author matiassebastianparra
 */
public class MemoriaVirtual {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here   
        ArrayList<Integer> procesos = new ArrayList<>();
        procesos.add(7);procesos.add(0);procesos.add(1);procesos.add(2);procesos.add(0);procesos.add(3);procesos.add(0);
        procesos.add(4);procesos.add(2);procesos.add(3);procesos.add(0);procesos.add(3);procesos.add(0);procesos.add(3);
        procesos.add(2);procesos.add(1);procesos.add(2);procesos.add(0);procesos.add(1);procesos.add(7);procesos.add(0);
        procesos.add(1);
        
        while(true){
            Scanner in = new Scanner(System.in);        
            System.out.print("Bienvenido al simulador de memoria virtual \n");
            System.out.print("1.- FIFO \n");
            System.out.print("2.- LFU \n");
            System.out.print("3.- LRU \n");
            System.out.print("4.- MFU \n");
            System.out.print("5.- Optimal Algorithm \n");
            System.out.print("6.- Salir \n");
            System.out.print("\n");
            System.out.print("Ingrese qué tipo de simulación desea ver: ");
            if(in.hasNextInt()){
                
                int opcion = in.nextInt();  
                
                if(opcion>0 && opcion<7){
                   switch(opcion){
                        case 1: new FIFO(procesos);
                                break;
                        case 2: new LFU(procesos);
                                break;
                        case 3: new LRU(procesos);
                                break;
                        case 4: new MFU(procesos);
                                break;
                        case 5: new OptimalAlgorithm(procesos);
                                break;
                        case 6: exit(0);
                                break;
                    } 
                    System.out.println(""); 
                }else{
                    System.out.println("");
                    System.out.println("INGRESE UN NÚMERO VÁLIDO!!!");
                    System.out.println("");
                }
            }else{
                System.out.println("");
                System.out.println("INGRESE UN NÚMERO VÁLIDO!!!");
                System.out.println("");
            }
            
        }
    }    
}
