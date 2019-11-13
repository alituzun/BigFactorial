package odev4;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static odev4.sayi.SerifaktoriyelHesapla;

public class Odev4 
{
    public static void DosyaOlustur()
    {
        
    File f = new File("sayi.txt");
    
    try {
        if(!f.exists()){ 
            f.createNewFile(); 
        }else{
            System.out.println("Dosya olduğundan oluşturma işlemi yapılmayacaktır. ");
        }
    } catch (IOException e) 
    { 
       
        e.printStackTrace();
    }
}
      private static void DosyayaYaz(String dosyaAdi,String yazilacak,int a){
            try{
                  FileWriter yazici = new FileWriter(dosyaAdi,true);
                  BufferedWriter DosyayaYaz = new BufferedWriter(yazici);
                 
                  DosyayaYaz.write(a+":"+yazilacak);
                  DosyayaYaz.newLine();
                  DosyayaYaz.close();
            }
            catch (Exception hata)
            {
                  hata.printStackTrace();
            }
      }
 
  
    public static void main(String[] args) 
    {
        try
        {
        DosyaOlustur();
        
        Scanner oku= new Scanner(System.in);
        System.out.print("Faktoriyeli alınacak sayıyı giriniz: ");
        int sayi=oku.nextInt();
        long seriBaslangic=System.nanoTime();
        String sonuc=SerifaktoriyelHesapla(sayi);
        long seriBitis=System.nanoTime();
      
        DosyayaYaz("sayi.txt",sonuc,sayi);
       
        ExecutorService havuz = Executors.newFixedThreadPool(sayi%100);
        long paralelBaslangic=System.nanoTime();
         havuz.execute(new sayi(sayi));   
          havuz.shutdown(); 
          while(!havuz.isTerminated()){  } 
          
          long paralelBitis=System.nanoTime();
          double seriSure=(seriBitis-seriBaslangic)/10000000.0;
          double paralelSure=(paralelBitis-paralelBaslangic)/10000000.0;
          String sure=new DecimalFormat("##.##").format(seriSure);
          String zaman=new DecimalFormat("##.##").format(paralelSure);
           
        System.out.println("seri faktoriyel hesabında gecen sure:"+sure+" milisaniye");
        System.out.println("paralel faktoriyel hesabında gecen sure:"+zaman+" milisaniye");
        System.out.print("sonuc dosyaya yazildi");
        
        
        }
        
        catch (Exception hata)
                {
                    hata.printStackTrace();
                }
     
    }
    
}
