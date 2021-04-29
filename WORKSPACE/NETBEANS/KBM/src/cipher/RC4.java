/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cipher;

/**
 *
 * @author anhtuan
 */
public class RC4 {
    static int max = 256;
    private int T[], S[];
    private String Plain, Cipher, Key;
    private int plain[], cipher[], key[];
    public void setPlain(String text){
        int len = text.length();
        StringBuilder sb = new StringBuilder(len);
        for(int i = 0; i < len; i++){
            sb.append(text.charAt(i));
        }
        this.Plain = sb.toString();
        this.plain = new int[sb.length()];
        for(int i = 0; i < this.plain.length; i++)
            this.plain[i] = (int) sb.charAt(i);
    }
    public void setCipher(String text){
        int len = text.length();
        StringBuilder sb = new StringBuilder(len);
        for(int i = 0; i < len; i++){
            sb.append(text.charAt(i));
        }
        this.Cipher = sb.toString();
        this.cipher = new int[sb.length()];
        for(int i = 0; i < len; i++){
            this.cipher[i] = (int) sb.charAt(i);
        }
    }
    public void setKey(String text){
        int len = text.length();
        StringBuilder sb = new StringBuilder(len);
        for(int i = 0; i < len; i++){
            sb.append(text.charAt(i));
        }
        this.Key = sb.toString();
    }
    private void initial_S(){
        this.T = new int[max];
        this.S = new int[max];
        int i = 0;
        int len = this.Key.length();
        while(i < 256){
            this.T[i] = (int) this.Key.charAt(i % len);
            i++;
        }
        while(i > 0){
            this.S[256-i] = 256-i;
            i--;
        }
    }
    private void KSA(){
        int i,j;
        i = 0;
        j = 0;
        while(i < max){
            j = (j + this.S[i] + this.T[i]) % max;
            int temp = this.S[i];
            this.S[i] = this.S[j];
            this.S[j] = temp;
            i++;
        }
    }
    private void PRGA(){
        int i, j, k, u;
        i = 0; j = 0; k  = 0;
        int len = this.Plain.length();
        this.key = new int[len];
        while(k < len){
            i = (i+1) % 256;
            j = (j +this.S[i]) % 256;
            int temp = this.S[i];
            this.S[i] = this.S[j];
            this.S[j] = temp;
            u = this.S[(this.S[i] + this.S[j]) % 256];
            this.key[k] = this.S[u]; 
            k++;
        }
    }
    private StringBuilder Xor(){
        initial_S();
        KSA();
        PRGA();
        
        StringBuilder rel;
        int len = this.plain.length;
        rel = new StringBuilder(len);
        int i = 0;
        while(i < len){
            int a = this.plain[i] ^ key[i];
            rel.append((char)a);
            i++;
        }
        return rel;
    }
    public String Encryption(){
        return Xor().toString();
    }
}
