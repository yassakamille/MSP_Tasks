package javaapplication1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yassa
 */
public class rectangle {
     
    int Length;
    int Height;
    int width;
    long  filled;
    rectangle(int Length, int Height,int width) {
        this.Length = Length;
        this.width = width;
        this.Height = Height;
    }

    public double calculate_volume(int Length, int Height,int width){
         double volume =0;
         volume = Length*width*Height;
           
        return volume;
         
     };
    
}
