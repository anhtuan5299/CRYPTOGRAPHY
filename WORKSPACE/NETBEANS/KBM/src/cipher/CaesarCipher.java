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
public class CaesarCipher
{
    // Encrypts text using a shift od s
    public StringBuffer encrypt(String text, int s)
    {
        StringBuffer result= new StringBuffer();
  
        for (int i=0; i<text.length(); i++)
        {
            if (Character.isUpperCase(text.charAt(i)))
            {
                char ch = (char)(((int)text.charAt(i) +
                                  s - 65) % 26 + 65);
                result.append(ch);
            }
            else if(text.charAt(i) == ' ' || text.charAt(i) == '\n')
                result.append(text.charAt(i));
            else
            {
                char ch = (char)(((int)text.charAt(i) +
                                  s - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result;
    }
    public StringBuffer decrypt(String text, int s)
    {
        StringBuffer result= new StringBuffer();
  
        for (int i=0; i<text.length(); i++)
        {
            if (Character.isUpperCase(text.charAt(i)))
            {
                char ch = (char)(((int)text.charAt(i) -
                                  s - 65) % 26 + 65);
                result.append(ch);
            }
            else if(text.charAt(i) == ' ' || text.charAt(i) == '\n')
                result.append(text.charAt(i));
            else
            {
                char ch = (char)(((int)text.charAt(i) -
                                  s - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result;
    }
}