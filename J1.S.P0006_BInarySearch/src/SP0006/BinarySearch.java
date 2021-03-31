/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SP0006;

import java.util.Random;

/**
 *
 * @author HI
 */
public class BinarySearch {
    int[] arr;
    int size;
    Validation util = new Validation();
    
    //methods
    public void inputElement(){
        size = util.getInt("Input size of array", "Size must >= 0", "Size is a positive integer", 0);
        arr = new int[size];
        Random rd = new Random();
        for(int i = 0; i < size; i++)
            arr[i] = 1+rd.nextInt(25);
        System.out.println("Unsorted array:");
        printArray(arr);
    }
    
    public void printArray(int[] arr){
        if(arr.length == 0)
            System.out.println("Array is empty!");
        else{
            System.out.print("[");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]);
                if (i < arr.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("]");
        }
        System.out.println();
    }
    
    public void BubbleSort(int a[]){
        for(int i = 0; i < a.length - 1; i++){
            for(int j = 0 ; j < a.length - i - 1; j++){
                if(a[j] > a[j + 1]){
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }
    
    public void printSortedArray(){
        BubbleSort(arr);
        System.out.println("Sorted array:");
        printArray(arr);
    }
    
    public int BinarySearch(int[] a, int n, int left, int right){
        if(left > right)
            return -1;
        int mid = (left + right) / 2;
        if(a[mid] == n)
            return mid;
        else if(a[mid] > n)
            return BinarySearch(a, n, left, mid - 1);
        else
            return BinarySearch(a, n, mid + 1, right);
    }

    public void binarySearchResult(){
        if(arr.length <= 0){
            System.out.println("Array is empty");
        } else{
            int search = util.getInt("Input number to search", "Number is >= 0", "NUmber is a positive integer", 0);
            int result = BinarySearch(arr, search, 0 , size - 1);
            if(result < 0)
                System.out.println("Number is not in array");
            else
                System.out.println(search + " is at index of " + result);
        }
        //Ko de quy
//        int result2 = binarySearch(arr, size, search);
//        if(result2 < 0)
//            System.out.println("Number is not in array");
//        else
//            System.out.println(search + " is at index of " + result);
    }
    
    //    
//    public int binarySearch(int arr[], int n, int x){
//      int right = n - 1; 
//      int left = 0; 
//      while (right >= left){
//        int mid = left + (right - left) / 2; 
//        if (arr[mid] == x)
//          return mid;
//        if (arr[mid] > x)
//            right = mid - 1;
//        left = mid + 1;
//      }
//      return -1;
//    }
    
}
