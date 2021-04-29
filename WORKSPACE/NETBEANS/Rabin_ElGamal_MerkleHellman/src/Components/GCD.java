/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Components;

/**
 *
 * @author anhtuan
 */
public class GCD {
    private int a,b,x1 = 0, y1 = 1, x2 = 1, y2 = 0;
    public void setpara(int a, int b){
        this.a = a;
        this.b = b;
    }
    public void calGCD(int d[], int x[], int y[]){
        if(b == 0){
            d[0] = a;
            x[0] = x2;
            y[0] = y2;
        }else{
            while(b>0){
                int e = a/b;
                int r = a - e*b;
                x[0] = x2 - e*x1;
                y[0] = y2 - e*y1;
                a = b;
                b = r;
                x2 = x1;
                x1 = x[0];
                y2 = y1;
                y1 = y[0];
            }
            d[0] = a;
            x[0] = x2;
            y[0] = y2;
        }
    }
}
