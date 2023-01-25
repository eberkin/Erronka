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


public static ArrayList <Pegatina> PegatinaGuztiakIrakurri(){
    String pathHarategia = "eberkin\Erronka\harategia\Tiketak";
    String pathOkindegia =  "eberkin\Erronka\okindegia\Tiketak";
    String pathFrutategia= "eberkin\Erronka\frutategia\Tiketak";
    String pathTxarkutegia =  "eberkin\Erronka\txarkutegia\Tiketak";

    ArrayList<Pegatina> salmentaGuztiak = new ArrayList<>();


    ArrayList <Pegatina> harategikoPegatinak = KarpetaIrakurri(pathHarategia);
    ArrayList <Pegatina> okindegikoPegatinak= KarpetaIrakurri(pathOkindegia);
    ArrayList <Pegatina> frutategikoPegatinak= KarpetaIrakurri(pathFrutategia);
    ArrayList <Pegatina> txarkutegikoPegatinak = KarpetaIrakurri(pathTxarkutegia);

    salmentaGuztiak.addAll(harategikoPegatinak);
    salmentaGuztiak.addAll(okindegikoPegatinak);
    salmentaGuztiak.addAll(frutategikoPegatinak);
    salmentaGuztiak.addAll(txarkutegikoPegatinak);
    

    return salmentaGuztiak;
}    

public static ArrayList <Pegatina>  KarpetaIrakurri(String pathKarpeta){
 ArrayList <Pegatina> etiketaZerrenda = new ArrayList<>();
 ArrayList <Pegatina> etiketaZerrendaTmp = new ArrayList<>();
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
public static  ArrayList<Pegatina> FitxategiaIrakurri(String pathFitxategia){
    ArrayList<Pegatina>datuakGorde = new ArrayList<Pegatina>();
    Pegatina pg = new Pegatina();
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
 //pegatina funtzioa sortzen dugu izena lortzeko info substringa sortzen digu
 //izena bakarrik ateratzeko $arte irakurtzeko esaten diogu indexOf ekin
 //hau eta gero esaten diogusub string en bitartze  info hasiko dela $ aurrera
 private static Pegatina SortuPegatina(String info, String fitxategiIzena)
 {
    String izena = info.substring(0, info.indexOf("$"));
    info = info.substring(info.indexOf("$"));

    String saltzaileID = info.substring(0, info.indexOf("$"));
    info = info.substring(info.indexOf("$"));

    String prezioaKiloko =info.substring(0, info.indexOf("$"));
    info = info.substring(info.indexOf("$"));

    String pisua= info.substring(0, info.indexOf("$"));
    info = info.substring(info.indexOf("$"));

    String prezioTotala=info.substring(0, info.indexOf("$"));
    info = info.substring(info.indexOf("$"));


  Pegatina pgtn = new Pegatina(Integer id_ticketa,String izena, LocalDate date, LocalTime ordua,double pisua, double prezioa_kiloko,double prezio_totala,Integer id_denda,Integer id_langilea);
  
  return pgtn;
 } 
 public static void main(String[] args) {

    ArrayList<Pegatina>  salmentak = PegatinaGuztiakIrakurri();
    // TODO code application logic here

    
}


}
