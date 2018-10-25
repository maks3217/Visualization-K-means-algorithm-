/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knn;

/**
 *
 * @author Maks
 */
public class Point {
    private int x;
    private int y;
    private int klasa;
    private double odlegloscE;
    private double odlegloscM;
    public Point() {
        x=0;
        y=0;
        klasa=0;
    }
    public Point(int x, int y, int klasa)
    {
        this.x=x;
        this.y=y;
        this.klasa = klasa;
    }
    
    int getX() {
        return x;
    }
    
    int getY() {
        return y;
    }
    
    int getKlasa() {
     return klasa; 
   }
   
   void setX(int x) {
       this.x=x;
   } 
   void setY(int y) {
       this.y=y;
   }
   
   void setKlasa(int klasa) {
       this.klasa=klasa;
   }
    
    void setOdlegloscE(double xp, double yp) {
        this.odlegloscE = Math.sqrt(((this.x - xp)*(this.x -xp)) + ((this.y - yp)*(this.y - yp)));
    }
   
   void setOdlegloscM(double xp, double yp) {
        this.odlegloscM = Math.abs(this.x - xp) + Math.abs(this.y - yp);
   }
   
   double getOdlegloscE() {
       return this.odlegloscE;
   }
   
   double getOdlegloscM() {
       return this.odlegloscM;
   }
}
