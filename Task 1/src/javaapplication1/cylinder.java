/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author yassa
 */
public class cylinder {
    int Radius;
    int Height;
    final double pi =3.14;
    long  filled;
    cylinder(int Radius, int Height) {
        this.Radius = Radius;
        this.Height = Height;
    }

    public double calculate_volume(int Radius, int Height){
         double volume =0;
         volume = pi*Radius*Radius*Height;
           
        return volume;
         
     };
    
}
