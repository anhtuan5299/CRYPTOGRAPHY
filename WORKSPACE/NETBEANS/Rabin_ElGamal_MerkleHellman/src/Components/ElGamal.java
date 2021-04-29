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
public class ElGamal {
    private int p, alpha, a, A, k, x, KCK[] = new int[3];
    private int y1 = 1, y2 = 1;
    public ElGamal(int p, int x, int k, int alpha, int a){
        this.p = p;
        this.a = a;
        this.k = k;
        this.x = x;
        this.KCK[2] = 1;
        this.alpha = alpha;
        this.KCK[1] = alpha;
        this.KCK[0] = p;
        for(int i = 0; i < this.a; i++)
            this.KCK[2] = (this.KCK[2] % this.p) * ( this.alpha % this.p);
        this.KCK[2] = this.KCK[2] % this.p;
        for(int i = 0; i < this.k; i++)
            this.y1 = (this.y1 % this.p) * ( this.alpha % this.p);
        this.y1 = this.y1 % this.p;
        for(int i = 0; i < this.k; i++)
            this.y2 = (this.y2 % this.p) * (this.KCK[2] % this.p);
        this.y2 = (this.x * this.y2) % this.p;
    }
    public int[] Y(){
        int y[] = new int[2];
        y[0] = this.y1;
        y[1] = this.y1;
        return y;
    }
    
    public int X(){
        return _X();
    }
    private int _X(){
        int y_1 = 1;
        for(int i = 0 ; i < this.p - 1 - this.a; i++){
            y_1 = (y_1 % this.p) * (this.y1 % this.p);
        }
        y_1 = y_1 % this.p;
        return ((y_1 * this.y2) % this.p);
    }
    public static void main(String[] args){
        ElGamal el = new ElGamal(211,34, 23, 39, 113);
        System.out.println(el.X());
        int y[] = el.Y();
        System.out.println(y[0]);
    }
}