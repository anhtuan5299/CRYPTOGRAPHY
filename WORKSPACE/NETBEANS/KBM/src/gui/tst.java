/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author anhtuan
 */
public class tst {
    public static void main(String args[]) {
        
        double r= 2,t=59;
        double a = r;
        double output;
        double i;
        for(i = 1; i < t*2; i++){
            double k = r % t;
            System.out.println(k);
            System.out.println(r);
            if(k == 1)break;
            r = r*a;
        }
        System.out.println(i);
    }
}