/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllersTier;

/**
 *
 * @author anhtuan
 */
public class Product_Controller {
    public int checkProductId(String id){
        return _checkProductId(id);
    }
    public int checkProductName(String name){
        return _checkProductName(name);
    }
    public String modifierProductPrice(String price){
        return _modifierProductPrice(price);
    }
    public boolean checkProductPrice(String price){
        return _checkProductPrice(price);
    }
    public String setPrePrice(String price){
        if(checkProductPrice(price) == false)
            return _setPrePrice(price);
        else
            return modifierProductPrice(price);
    }
    private int _checkProductId(String id){
        int len = id.length() - 1;
        int i = 0;
        while(i <= len){
            if(id.charAt(i) < '0' || id.charAt(i) > '9'){
                return 1;
            }
        }
        return 0;
    }
    private int _checkProductName(String name){
        int len = name.length() - 1;
        int i = len;
        while(i >= 0){
            if(name.charAt(i) >= '0' && name.charAt(i) <= '9')
                return 1;
        }
        return 0;
    }
    private boolean _checkProductPrice(String price){
        int len = price.length() - 1;
        int i = len;
        String temp = new String();
        while(i >= 0){
            if((price.charAt(i) < '0' || price.charAt(i) > '9') && price.charAt(i) != ',')
                return false;
            i--;
        }
        return true;
    }
    private String _modifierProductPrice(String price){
        int len = price.length() - 1;
        String temp = new String();
        char ch;
        int i = 0;
        int locate;
        int count = 0;
        
        while(i <= len){
            if(price.charAt(i) == ',') count++;
            i++;
        }
        i = 0;
        locate = len + 1 - count;
        while(i <= len){
            ch = price.charAt(i);
            if( (locate)%3 == 0 && i != 0 && ch != ',')
                temp += "" + ',' + ch;
            else if(ch != ',')
                temp += "" + price.charAt(i);
            else
                locate++;
            locate--;
            i++;
        }
        return temp;
    }
    private String _setPrePrice(String price){
        int len = price.length() - 1;
        int i = 0;
        String temp = new String();
        while(i <= len){
            if((price.charAt(i) >= '0' && price.charAt(i) <= '9') || price.charAt(i) == ',')
                temp += "" + price.charAt(i);
            i++;
        }
        return temp;
    }
}
