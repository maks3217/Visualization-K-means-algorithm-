/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knn;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.TilePane;
import javax.swing.JFileChooser;

/**
 *
 * @author Maks
 */
public class Grafika extends javax.swing.JFrame {

    private ArrayList punkty = new ArrayList<Point>();
    public int k;
    public String wybor;
    public Grafika() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 859, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 582, Short.MAX_VALUE)
        );

        jButton2.setText("Wybierz plik ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Metryka Euklidesowa", "Metryka Miejska", " " }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Głosowanie proste", "Głosowanie ważone" }));

        jButton1.setText("Wybór liczby sąsiadów k");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setText("3");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public int glosowanie(int k)
    {
        Point punkt1 = new Point();
        int i;
        int wynik=0;
        double max=0;
        double[] kolory = new double[6];
        for(i=0;i<kolory.length;i++)
        {
            kolory[i]=0;
        }
        for(i=0;i<k;i++)
        {
            punkt1 = (Point)punkty.get(i);
            if(jComboBox1.getSelectedItem().toString().equals("Głosowanie proste"))
            kolory[punkt1.getKlasa()]++;
            else
            {
            if(jComboBox2.getSelectedItem().toString().equals("Metryka Euklidesowa"))
            kolory[punkt1.getKlasa()]+=1/(punkt1.getOdlegloscE()*punkt1.getOdlegloscE());
            else
            kolory[punkt1.getKlasa()]+=1/(punkt1.getOdlegloscM()*punkt1.getOdlegloscM());
            
            }
        }
         for(i=0;i<kolory.length;i++)
        {
            if(kolory[i]>max) {
                max = kolory[i];
                wynik = i;
            }
        }
         return wynik;
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename = f.getAbsolutePath();
        Graphics2D gr = (Graphics2D)jPanel1.getGraphics();
        ArrayList wspX = new ArrayList<Double>();
        ArrayList wspY = new ArrayList<Double>();
        ArrayList klasy = new ArrayList<Integer>();
        double maxX = 0, maxY= 0;
        double minX= 50, minY = 50;
        double x = 0,y = 0,m=1;
        int klasa=0;
        int i;
        char[] znaki;
        int  flaga = 0;
        String linia;
        //Scanner skaner = new Scanner(new File("dane.txt"));
        Scanner skaner;
        try {
            skaner = new Scanner(new File(filename));
        
        while(skaner.hasNext())
        {
            x=0;
            y=0;
            flaga=0;
            m=1;
            linia = skaner.nextLine();
            znaki = linia.toCharArray();
            for(i=0;i<znaki.length;i++)
            {
                if(znaki[i]=='.')
                {
                    m=m/10;
                }
                if(znaki[i]==',')
                {
                    flaga++;
                    m=1;
                }
                if(znaki[i]!='.' && znaki[i]!=',')
                {
                    if(flaga==0)
                    {
                        x+=((int)znaki[i]-48)*m;
                    }
                    if(flaga==1)
                    {
                        y+=((int)znaki[i]-48)*m;
                    }
                    if(flaga==2)
                    {
                        klasa=(int)znaki[i]-48;
                    }
                }
            }
            if(x < minX) minX = x;
            if(y < minY) minY = y;
            if(x > maxX) maxX = x;
            if(y > maxY) maxY = y;
            wspX.add(x);
            wspY.add(y);
            klasy.add(klasa);
            //System.out.println("x - " + x + " y - " + y + " klasa - " + klasa);
        }
       // System.out.println("maksimum x = " + maxX + "minimum x = " + minX);
       // System.out.println("maksimum y = " + maxY + "minimum x = " + minY);
        for(i=0; i<wspX.size(); i++)
        {
            //System.out.println(wspX.get(i) + " - " + wspY.get(i)+ " Klasa " + klasy.get(i));
            x = (((double)wspX.get(i) - minX)/(maxX- minX))*jPanel1.getWidth();
            y = (((double)wspY.get(i) - minY)/(maxY- minY))*jPanel1.getHeight();
            if((int)klasy.get(i)==1) gr.setColor(Color.red);
            if((int)klasy.get(i)==2) gr.setColor(Color.green);
            if((int)klasy.get(i)==3) gr.setColor(Color.orange);
            if((int)klasy.get(i)==4) gr.setColor(Color.blue);
            if((int)klasy.get(i)==5) gr.setColor(Color.pink);
            Point punkt = new Point((int)Math.round(x),(int)Math.round(y),(int)klasy.get(i));
            punkty.add(punkt);
            gr.fillOval((int)Math.round(x)-7, (int)Math.round(y)-7, 14, 14);
        }
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(Grafika.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
         Point punkt = new Point();
         double mouseX = evt.getX();
         double mouseY = evt.getY();
         int i;
         int kolor=0;
         for(i=0; i<punkty.size(); i++) {
             punkt = (Point)punkty.get(i);
             punkt.setOdlegloscE(mouseX, mouseY);
             punkt.setOdlegloscM(mouseX, mouseY);
             punkty.set(i, punkt);
         }
         Collections.sort(punkty, new Comparator<Point>(){
             @Override
             public int  compare(Point point1, Point point2)
             {   
                 if(jComboBox2.getSelectedItem().toString().equals("Metryka Euklidesowa"))
                 return Double.compare(point1.getOdlegloscE(), point2.getOdlegloscE());
                 else return Double.compare(point1.getOdlegloscM(), point2.getOdlegloscM());
             }
         });
         Graphics2D graf = (Graphics2D)jPanel1.getGraphics();
         graf.setColor(Color.LIGHT_GRAY);
         for(i=0; i<k; i++)
         {
             punkt = (Point)punkty.get(i);
             System.out.println("x = " + punkt.getX() + "y =" + punkt.getY());
             if(jComboBox2.getSelectedItem().toString().equals("Metryka Euklidesowa"))
             graf.drawLine(punkt.getX(), punkt.getY(), (int)Math.round(mouseX),(int)Math.round(mouseY));
             else {
             graf.drawLine(punkt.getX(),punkt.getY(), punkt.getX(),(int)Math.round(mouseY));
             graf.drawLine(punkt.getX(),(int)Math.round(mouseY) ,(int)Math.round(mouseX) ,(int)Math.round(mouseY) );
             }
         }
         kolor = glosowanie(k);
         System.out.println(kolor);
         if(kolor==1) graf.setColor(Color.red);
         if(kolor==2) graf.setColor(Color.green);
         if(kolor==3) graf.setColor(Color.orange);
         if(kolor==4) graf.setColor(Color.blue);
         if(kolor==5) graf.setColor(Color.pink);
         graf.fillRect((int)Math.round(mouseX)-8, (int)Math.round(mouseY)-8, 16 ,16);
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         wybor = jTextField1.getText();
         k =Integer.parseInt(wybor);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String args[]) throws FileNotFoundException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Grafika.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Grafika.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Grafika.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Grafika.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Grafika().setVisible(true);
        });
       
      
}
   
      

        
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}


