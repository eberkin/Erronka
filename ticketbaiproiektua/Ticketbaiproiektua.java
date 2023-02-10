/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ticketbaiproiektua;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.jar.Attributes.Name;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import javax.xml.bind.JAXBException;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.catalog.Catalog;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;

//import com.mysql.cj.xdevapi.Statement;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import java.text.SimpleDateFormat;
/**
 *
 * @author 34665
 */
public class Ticketbaiproiektua {


    public static ArrayList <Pegatina> PegatinaGuztiakIrakurri(){
        // Path bakoitza sortzeko
        //path eber
        //String pathHarategia = "C:\\Users\\IKALTAMIRAPAAG1\\Desktop\\erronki\\Erronka\\harategia\\Tiketak";
        //String pathOkindegia =  "C:\\Users\\IKALTAMIRAPAAG1\\Desktop\\erronki\\Erronka\\okindegia\\Tiketak";
        //String pathFrutategia= "C:\\Users\\IKALTAMIRAPAAG1\\Desktop\\erronki\\Erronka\\frutategia\\Tiketak";
        //String pathTxarkutegia =  "C:\\Users\\IKALTAMIRAPAAG1\\Desktop\\erronki\\Erronka\\txarkutegia\\Tiketak";
        //path mario el crack
        String pathHarategia = "C:\\Users\\ikaltamirapaag1\\Documents\\ERRONKA-Ticketbai\\Erronka\\harategia\\Tiketak";
        String pathOkindegia =  "C:\\Users\\ikaltamirapaag1\\Documents\\ERRONKA-Ticketbai\\Erronka\\okindegia\\Tiketak";
        String pathFrutategia= "C:\\Users\\ikaltamirapaag1\\Documents\\ERRONKA-Ticketbai\\Erronka\\frutategia\\Tiketak";
        String pathTxarkutegia =  "C:\\Users\\ikaltamirapaag1\\Documents\\ERRONKA-Ticketbai\\Erronka\\txarkutegia\\Tiketak";
        //path igor 
        //String pathHarategia = "C:\\Users\\34665\\Desktop\\PROGRAMAZIOA\\githuberronka\\Erronka\\harategia\\Tiketak";
        //String pathOkindegia =  "C:\\Users\\34665\\Desktop\\PROGRAMAZIOA\\githuberronka\\Erronka\\okindegia\\Tiketak";
        //String pathFrutategia= "C:\\Users\\34665\\Desktop\\PROGRAMAZIOA\\githuberronka\\Erronka\\frutategia\\Tiketak";
        //String pathTxarkutegia =  "C:\\Users\\34665\\Desktop\\PROGRAMAZIOA\\githuberronka\\Erronka\\txarkutegia\\Tiketak";
      // salmentaGuztiak ArrayList-a sortzeko
        ArrayList<Pegatina> salmentaGuztiak = new ArrayList<>();

        // hainbat karpetatako pegatinak irakurtzen dituen metodo bat deitu
        ArrayList <Pegatina> harategikoPegatinak = KarpetaIrakurri(pathHarategia, "Harategia");
        ArrayList <Pegatina> okindegikoPegatinak= KarpetaIrakurri(pathOkindegia, "Okindegia");
        ArrayList <Pegatina> frutategikoPegatinak= KarpetaIrakurri(pathFrutategia, "Frutategia");
        ArrayList <Pegatina> txarkutegikoPegatinak = KarpetaIrakurri(pathTxarkutegia, "Txarkutegia");

        // hainbat karpetatako pegatinak salmentaGuztiak ArrayList-era gehitu
        salmentaGuztiak.addAll(harategikoPegatinak);
        salmentaGuztiak.addAll(okindegikoPegatinak);
        salmentaGuztiak.addAll(frutategikoPegatinak);
        salmentaGuztiak.addAll(txarkutegikoPegatinak);

        // salmentaGuztiak ArrayList-a itzultzen da
        return salmentaGuztiak;
    }    
    public static void Xmlsortu( ArrayList<Pegatina> salmentaGuztiak){

      try{
      EgunekoSalmentak salmentaZerrenda = new EgunekoSalmentak(salmentaGuztiak);
      JAXBContext  contexto =JAXBContext.newInstance(EgunekoSalmentak.class);
      Marshaller m = contexto.createMarshaller();
      m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
      m.marshal(salmentaZerrenda,new FileWriter("C:\\Users\\ikaltamirapaag1\\Documents\\ERRONKA-Ticketbai\\Erronka\\xml\\Salmenta.xml"));  
      try {
                  SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
      
                  Source schemaFile = new StreamSource(new File("C:\\Users\\ikaltamirapaag1\\Documents\\ERRONKA-Ticketbai\\Erronka\\xml\\erronkaticketbai.xsd"));
                  Schema schema = factory.newSchema(schemaFile);
      
                  Validator validator = schema.newValidator();
                  Source source = new StreamSource("C:\\Users\\ikaltamirapaag1\\Documents\\ERRONKA-Ticketbai\\Erronka\\xml\\Salmenta.xml");
                  validator.validate(source);
                  System.out.println("ONDO BALIDATUTA DAGO");
              } catch (SAXException  ex) {
                  ex.printStackTrace();
                }

    }
  
  catch(Exception ex2){
    System.out.println(ex2);
  }
  
}




              
    public static ArrayList <Pegatina>  KarpetaIrakurri(String pathKarpeta, String idDenda){
    /*
    KarpetaIrakurri metodoa:
    - Metodo honek, pasatutako path-a izan ezkero fitxategi zerrenda bat irakurtzen du,
    eta bakoitza irakurtzeko FitxategiaIrakurri metodoari deitzen dio.
    -Irakurritako fitxategi guztien etiketak ArrayList batean biltzen ditu.
    - @param pathKarpeta - Fitxategiak dituen karpetaren path-a.
    - @return etiketaZerrenda - Fitxategi guztien etiketak biltzen dituen ArrayList.
    */
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
          etiketaZerrendaTmp = FitxategiaIrakurri(pathKarpeta + "\\"+ fitxategiZerrenda[i], idDenda);
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
    public static  ArrayList<Pegatina> FitxategiaIrakurri(String pathFitxategia, String idDenda){
      ArrayList<Pegatina> datuakGorde = new ArrayList<Pegatina>();
      try {
          //DOKUMENTUA IRAKURRI
          File dokumentua = new File(pathFitxategia);
          FileReader fr = new FileReader(dokumentua);
          BufferedReader br = new BufferedReader(fr);
          String lerroa;

          while ((lerroa = br.readLine()) != null) {
              // Objetu berria sortu
              Pegatina pg = new Pegatina();
              int barraIndex = pathFitxategia.lastIndexOf("\\");
              int puntoIndex = pathFitxategia.lastIndexOf(".");
              String izena = pathFitxategia.substring(barraIndex+1,puntoIndex);
              pg.setEtiketa(lerroa,izena, idDenda);
              // Objetua listan sartu
              datuakGorde.add(pg);
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
      
      return null;
        
    } 


    
    /**
     * @param args
     */
    public static void main(String[] args) {

        ArrayList<Pegatina>  salmentak = PegatinaGuztiakIrakurri();
        Xmlsortu(salmentak);
        // TODO code application logic here

}


}
