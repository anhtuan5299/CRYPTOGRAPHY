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
public class Rabin {
    private int r = 1, s = 1, p, q, n, y, a[] = new int[1], b[] = new int[1], d[]= new int[1];
    private int x;
    private GCD gcd = new GCD();
    public Rabin(int p, int q, int x){
        this.p = p;
        this.q = q;
        this.n = this.q * this.p;
        this.x = x;
        this.y = ((this.x % this.n) * ( this.x % this.n)) % this.n;
        this.gcd.setpara(this.p, this.q);
        gcd.calGCD(this.d, this.a, this.b);
        int r = this.a[0];
        int s = this.b[0] * (-1);
        for(int i = 0; i < r; i++)
            this.r = (this.r % this.q) * (this.y % this.q);
        this.r = this.r % this.q;
        for(int i = 0; i < s; i++)
            this.s = (this.s % this.p) * (this.y % this.p);
        this.s = this.s % this.p;
        
    }
    public int Y(){
        return this.y;
    }
    public int[] X(){
        return xX();
    }
    private int[] xX(){
        int a = this.b[0];
        int b = this.a[0];
        int p = this.q;
        int q = this.p;
        int aps = a*p*s;
        int bqr = b*q*r;
        int rel[] = new int [4];
        rel[0] = -((aps - bqr) % this.n);
        rel[1] = -((aps + bqr) % this.n);
        rel[2] = this.n - rel[0];
        rel[3] = this.n - rel[1];
        return rel;
    }
    public static void main(String[] args){
        Rabin r = new Rabin(23,19, 329);
        int x[] = new int [4];
        x = r.X();
        for(int i = 0 ; i< 4; i++){
            System.out.println(x[i]);
        }
    }
    
}
