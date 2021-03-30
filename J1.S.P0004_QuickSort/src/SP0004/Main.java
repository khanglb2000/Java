/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SP0004;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author HI
 */
public class Main {
    public static void main(String[] args) {
        Validation util = new Validation();
        QuickSort obj = new QuickSort();
        Scanner s = new Scanner(System.in);
        String cont;
        System.out.println("======= Quick Sort Program =======");
        
        do {            
            int size = util.getInt("Input size of array", "Size > 0", "Size is an integer", 0);
            int[] a = new int[size];
            Random rd = new Random();
            for(int i = 0; i < size; i++){
                //a[i] = util.getInt("Input an integer", "Input an integer", "Error. Must input an integer");
                a[i] = 1+rd.nextInt(9);
            }
            System.out.println("Unsorted array:");
            obj.printArray(a);
            System.out.println();
            obj.quickSort(a, 0, a.length - 1);
            System.out.println("Sorted array:");
            obj.printArray(a);
            System.out.println();
            
            do {                
                cont = util.getString("Do you want to continue? (Y/N)", "Only Y/N");
                if(!cont.trim().equalsIgnoreCase("Y") && !cont.trim().equalsIgnoreCase("N"))
                    System.out.println("Only Y/N");
            } while (cont.trim().isEmpty() || !cont.trim().equalsIgnoreCase("Y") && !cont.trim().equalsIgnoreCase("N"));
        } while (cont.trim().equalsIgnoreCase("Y"));
    }
    
}
