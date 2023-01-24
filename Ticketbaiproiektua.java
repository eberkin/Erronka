/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ticketbaiproiektua;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.jar.Attributes.Name;

/**
 *
 * @author 34665
 */
public class Ticketbaiproiektua {


public static ArrayList <String> KarpetaGuztialIrakurri(){
    String pathHarategia = "C:\\USERS\\34665\\Desktop\\erronk.txt";
    String pathOkindegia =  "C:\\USERS\\34665\\Desktop\\erronk.txt";
    String pathFrutategia= "C:\\USERS\\34665\\Desktop\\erronk.txt";
    String pathTxarkutegia =  "C:\\USERS\\34665\\Desktop\\erronk.txt";


    KarpetaIrakurri(pathHarategia);
    KarpetaIrakurri(pathOkindegia);
    KarpetaIrakurri(pathFrutategia);
    KarpetaIrakurri(pathTxarkutegia);
}    

public static ArrayList <Pegatina>  KarpetaIrakurri(String pathKarpeta){
 ArrayList <String> etiketaZerrenda = new ArrayList<>();
 ArrayList <String> etiketaZerrendaTmp = new ArrayList<>();
    //String sKarpeta= PathName("C:/USERS/34665/Desktop/ERRONKA2");
  File karpeta = new File(pathKarpeta);
  String[]fitxategiZerrenda = karpeta.list();
  if (fitxategiZerrenda==null||fitxategiZerrenda.length ==0){
    System.out.println ("ez dago karpetarik");
    return null;
  }
else{
    for (int i =0; i<fitxategiZerrenda.length;i++){
      //  System.out.println(fitxategiZerrenda[i]);
      etiketaZerrendaTmp = FitxategiaIrakurri(pathKarpeta + "\\"+ fitxategiZerrenda[i]);
      for(int j=0;j<etiketaZerrendaTmp.size(); j++) {
        etiketaZerrenda.add(etiketaZerrendaTmp.get(j));
      }
    }

}
return etiketaZerrenda;
}


    /**
     * @param args the command line arguments
     */
public static  ArrayList<String> FitxategiaIrakurri(String pathFitxategia){
    ArrayList<String>datuakGorde = new ArrayList<String>();
    Pegatina
    try {
        //DOKUMENTUA IRAKURRI
         File dokumentua = new File(pathFitxategia);
         FileReader fr = new FileReader(dokumentua);
         BufferedReader br = new BufferedReader(fr);

         String lerroa;

         while ((lerroa = br.readLine()) != null) {
             
             datuakGorde.add(lerroa);
         } 

     } catch (Exception e) {
        
         System.out.println("Ezin izan da dokumentua topatu" + e);

     }


     return datuakGorde;
 }
 public static void main(String[] args) {

    KarpetaGuztialIrakurri ();
    // TODO code application logic here
}


}