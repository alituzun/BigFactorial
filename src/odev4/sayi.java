/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odev4;

import java.math.BigInteger;



public class sayi implements Runnable
{
    private int  sayi;
    public sayi(int s)
    {
        sayi=s;
    }
    public static String SerifaktoriyelHesapla(int sayi)
        {
       BigInteger fact = new BigInteger("1");
       for (int i = 1; i <= sayi; i++) {
           fact = fact.multiply(new BigInteger(i + ""));
       }
       return fact.toString();
       }
   
    @Override
    public void run()
    {
       BigInteger fact = new BigInteger("1");
       for (int i = 1; i <= sayi; i++) 
       {
        fact = fact.multiply(new BigInteger(i + ""));
       }
        
    }
    
}
