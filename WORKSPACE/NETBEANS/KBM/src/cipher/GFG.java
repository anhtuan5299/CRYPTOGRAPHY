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
public class GFG 
{
  
// This function generates the key in
// a cyclic manner until it's length isi'nt
// equal to the length of original text
public String generateKey(String str, String key)
{
    int x = str.length();
  
    for (int i = 0; ; i++)
    {
        if (x == i)
            i = 0;
        if (key.length() == str.length())
            break;
        key+=(key.charAt(i));
    }
    return key;
}
  
// This function returns the encrypted text
// generated with the help of the key
public String cipherText(String str, String key)
{
    String cipher_text="";
  
    for (int i = 0; i < str.length(); i++)
    {
        // converting in range 0-25
        if(str.charAt(i) == ' ' || str.charAt(i) == '\n')
            cipher_text+= str.charAt(i);
        else{        
            int x = (str.charAt(i) + key.charAt(i)) %26;
            // convert into alphabets(ASCII)
            x += 'A';
            
            cipher_text+=(char)(x);}
    }
    return cipher_text;
}
  
// This function decrypts the encrypted text
// and returns the original text
public String originalText(String cipher_text, String key)
{
    String orig_text="";
  
    for (int i = 0 ; i < cipher_text.length() && 
                            i < key.length(); i++)
    {
        if(cipher_text.charAt(i) == ' ' || cipher_text.charAt(i) == '\n')
            orig_text+=cipher_text.charAt(i);
        else{
            // converting in range 0-25
            int x = (cipher_text.charAt(i) - 
                    key.charAt(i) + 26) %26;           
            // convert into alphabets(ASCII)
            x += 'A';
            orig_text+=(char)(x);
        }
    }
    return orig_text;
}
}
