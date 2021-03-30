/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SP0004;

import java.util.Scanner;

/**
 *
 * @author HI
 */
public class QuickSort {
    //Validation util = new Validation();
    Scanner s = new Scanner(System.in);
    
    //Xuat mang
    public void printArray(int[] a){
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i]);
            if(i < a.length - 1)
                System.out.print(", ");
        }
    }
    
    //Phan chia mang tu cot moc tu chon
    //Pivot = a[mid]
    public int arrayPartition(int[] a, int left, int right){
        int tmp;
        int pivot = a[(left + right) / 2];
        while(left <= right){
            while(a[left] < pivot)
                left++;
            while(pivot < a[right])
                right--;
            if(left <= right){
                swap(a, left, right);
                left++;
                right--;
            }
        }
        return left;
    }
    
    public void swap(int[] a, int left, int right){
        int tmp = a[left];
        a[left] = a[right];
        a[right] = tmp;
    }
    
    //Quick Sort
    public void quickSort(int[] a, int left, int right){
        int index = arrayPartition(a, left, right);
        if (left < index - 1) {
            quickSort(a, left, index - 1);
        }
        if (index < right) {
            quickSort(a, index, right);
        }
    }
    
    
//    //Pivot = a[first]
//    public int arrayPartitionFirst(int[] a, int left, int right){
//        int tmp;
//        int pivot = a[left];
//        int i = left + 1;
//        while(i <= right){
//            while(a[i] < pivot)
//                i++;
//            while(a[right] > pivot)
//                right--;
//            if(i <= right){
//                tmp = a[i];
//                a[i] = a[right];
//                a[right] = tmp;
//                i++;
//                right--;
//            }
//        }
//        return i;
//    }
//    
//    public void quickSortFirst(int[] a, int left, int right){
//        int index = arrayPartitionFirst(a, left, right);
//        if (left < index - 1) {
//            quickSort(a, left, index - 1);
//        }
//        if (index < right) {
//            quickSort(a, index, right);
//        }
//    }
//    
//    //Pivot = a[last]
//    public int arrayPartitionLast(int[] a, int left, int right){
//        int tmp;
//        int pivot = a[right];
//        int i = (left-1);
//        for (int j=left; j<right; j++) { 
//            if (a[j] < pivot) { 
//                i++; 
//  
//                int temp = a[i]; 
//                a[i] = a[j]; 
//                a[j] = temp; 
//            } 
//        } 
//        int temp = a[i+1]; 
//        a[i+1] = a[right]; 
//        a[right] = temp; 
//  
//        return i+1; 
//    }
//    
//    public void quickSortLast(int[] a, int left, int right){
//        if (left < right){ 
//            int pi = arrayPartitionLast(a, left, right); 
//           
//            arrayPartitionLast(a, left, pi-1); 
//            arrayPartitionLast(a, pi+1, right); 
//        } 
//    }
    
}
