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
public class Merkle_Hellman {
    private int n, M[], m, w, pi[], a[], c = 0, MM;
    public Merkle_Hellman(int n, int M[], int m, int w, int MM){
        this.n = n;
        this.M = new int[M.length];
        this.pi = new int[M.length];
        this.a = new int[M.length];
        for(int i = 0; i < n; i++)
            this.M[i] = M[i];
        this.m = m;
        this.w = w;
        this.MM = MM;
        for(int i = 0; i < n; i++){
            int p = i+1;
            if(p != n){
                pi[i] = p;
            }
            else
                pi[i] = 0;
        }
        for(int i = 0; i < n; i++)
            a[i] = (w * this.M[this.pi[i]]) % this.m;
        int temp = this.MM;
        for(int i = 0; i < n; i++){
            this.c+= (temp % 10) * this.a[this.n-1-i];
            temp /= 10;
        }
    }
    public int C(){
        return this.c;
    }
    public int[] GiaiMa(){
        return _GiaiMa();
    }
    private int[] _GiaiMa(){
        int W_1[] = new int[1], d[] = new int[1], d1[] = new int[1];
        int gM[] = new int[this.n];
        GCD gcd = new GCD();
        gcd.setpara(this.m, this.w);
        gcd.calGCD(d, d1, W_1);
        W_1[0] += this.m;
        int gm = (this.c * W_1[0]) % this.m;
        for(int i = this.n - 1 ; i >= 0;i--){
            int temp = gm - this.M[i];
            if(temp >= 0){
                gm = temp;
                gM[i] = 1;
            }else
                gM[i] = 0;
        }
        int temp[] = new int[this.n];
        for(int i = 0; i < this.n; i++){
            if(i+1 != this.n)
                temp[i] = gM[i+1];
            else
                temp[i] = gM[0];
        }
        return temp;
    }
    public static void main(String[] args){
        int M[] ={12,17,33,74,157,316};
        Merkle_Hellman mh = new Merkle_Hellman(6, M, 737,635,101101);
        System.out.println(mh.C());
        int gm[] = mh.GiaiMa();
        for(int i = 0; i < 6; i++){
            System.out.println(gm[i]);
        }
    }
}
