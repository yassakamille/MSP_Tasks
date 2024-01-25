/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.util.*;

/**
 *
 * @author yassa
 */
public class JavaApplication1 {

 public static void Sort( ArrayList<Double> arr) {
        int n = arr.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                
                if (arr.get(j) > arr.get(j + 1)) {
                    double temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                }
            }
        }
    } 
    public static void main(String[] args) {
        
         Scanner s =new Scanner(System.in);
           int l,w,hc,hr,r,n;
           long f;
           double v,remain;
           int choice;
          ArrayList<Double> volumes = new ArrayList<>();
           ArrayList<Double> remaining = new ArrayList<>();
            System.out.print("Enter number of containers : ");
         n=s.nextInt();
          for(int i=0;i<n;i++){
         System.out.print("Enter 1 to create a cylinder, 2 to create a rectangle :");
        choice=s.nextInt();
             switch (choice) {
                 case 1 -> {
                     System.out.print("Enter Radius :");
                     r=s.nextInt();
                     System.out.print("Enter Height :");
                     hc=s.nextInt();
                     cylinder cylind =new cylinder(r,hc);
                     v= cylind.calculate_volume(r,hc);
                     System.out.print("Enter Filled amount in cubic meters :");
                     volumes.add(v);
                     f=s.nextLong();
                     remain=v-f;
                     remaining.add(remain);
                 }
                 case 2 -> {
                     System.out.print("Enter Height :");
                     hr=s.nextInt();
                     System.out.print("Enter Width :");
                     w=s.nextInt();
                     System.out.print("Enter Length :");
                     l=s.nextInt();
                     rectangle rect =new rectangle(l,hr,w);
                     v= rect.calculate_volume(l, hr, w);
                     System.out.print("Enter Filled amount in cubic meters :");
                     volumes.add(v);
                     f=s.nextLong();
                     remain=v-f;
                     remaining.add(remain);
                     
                 }
                 default -> System.out.println("Invalid number " );
             }
        
             
          }
          Sort(volumes);
          Sort(remaining);
        
       for(int i =0 ;i<n;i++){
          System.out.println(i+1 +":");
          System.out.println("volume :" + volumes.get(i).toString());
          System.out.println("Remain :" + remaining.get(i).toString());
       }
             
    }
    
}
