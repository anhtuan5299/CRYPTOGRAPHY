/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rabin_elgamal_merkleHellman;
import Components.*;
/**
 *
 * @author anhtuan
 */
public class Rabin_ElGamal_MerkleHellman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("============SIDE OF RABIN ALGORITHMS============");
        Rabin r = new Rabin(23,19, 329);
        int x[] = new int [4];
        x = r.X();
        System.out.println("--CIPHER:");
        System.out.println(r.Y());
        
        System.out.println("--PLAIN TEXT:");
        for(int i = 0 ; i< 4; i++){
            System.out.println(x[i]);
        }
        System.out.println("============ END SIDE OF RABIN ALGORITHMS============");
        
        System.out.println("============SIDE OF ELGAMAL ALGORITHMS============");
        ElGamal el = new ElGamal(211,34, 23, 39, 113);
        System.out.println("--CIPHER:");
        System.out.println(el.X());
        int y[] = el.Y();
        System.out.println("--PLAIN TEXT:");
        System.out.println(y[0]);
        System.out.println("============ END SIDE OF ELGAMAL ALGORITHMS============");
        
        System.out.println("============SIDE OF MERKLE HELLMAN ALGORITHMS============");
        int M[] ={12,17,33,74,157,316};
        Merkle_Hellman mh = new Merkle_Hellman(6, M, 737,635,101101);
        System.out.println("--CIPHER:");
        System.out.println(mh.C());
        int gm[] = mh.GiaiMa();
        System.out.println("--PLAIN TEXT:");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 6; i++){
            sb.append(gm[i]);
        }
        System.out.println(sb.toString());
        System.out.println("============ END SIDE OF MERKLE HELLMAN ALGORITHMS============");
    }
    
}
