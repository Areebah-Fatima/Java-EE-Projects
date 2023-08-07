/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImportFiles;

/**
 *
 * @author areebah
 */
public class Postage {
    
    private double length;
    private double width;
    private double height;
    private double weight;
    private int zone;

    // Default contructor
    public Postage() {
       
        this(89, 8, 12, 15, 2);
        
   }
  /** Construct a loan with specified annual interest rate,
      number of years, and loan amount
    */
    
    // Constructor that takes in (len, width, height, weight, and zone) 
    public Postage(double length, int width, double height, double weight, int zone) {
    
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
        this.zone = zone;
    
    }

    // Getter Setters
    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getZone() {
        return zone;
    }

    public void setZone(int zone) {
        this.zone = zone;
    }
    
    
    public double getPostagePayment() {

        double dimensionFactor;
        double len = getLength();
        double wid = getWidth();
        double heig = getHeight();
        double weiht = getWeight();
        double weightFactor;
        double postagePayment;
        int zone = getZone();


        // If l*w*h is less than 288 use 1 for dimension factor otherwise use 1.5
        if((len*wid*heig) < 288){
            
            dimensionFactor=1;

        }
        else{
            
            dimensionFactor=1.5;
        }
        
        
        // If weight less than 10 pounds use 1 else 1.5 
        if(weiht < 10){
            
            weightFactor=1;
        }
        else{
            
            weightFactor=1.5;
        }
        
        // The zone should from 1-4
        if(zone<1 || zone>4){
            
            System.out.println("Zone must be a number from 1 - 4");
        }
        
        // postage:  $10 x dimension factor x weight factor x zone factor
        postagePayment = (10 * dimensionFactor * weightFactor * zone);
        return postagePayment;    
    }
}