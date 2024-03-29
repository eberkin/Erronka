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
 * 
 * @author 34665
 */
public class Ticketbaiproiektua {
  public static String pathHarategia = "C:\\Users\\IKALTAMIRAPAAG1\\Desktop\\erronki\\Erronka\\harategia\\Tiketak";
  public static String pathOkindegia =  "C:\\Users\\IKALTAMIRAPAAG1\\Desktop\\erronki\\Erronka\\okindegia\\Tiketak";
  public static String pathFrutategia= "C:\\Users\\IKALTAMIRAPAAG1\\Desktop\\erronki\\Erronka\\frutategia\\Tiketak";
  public static String pathTxarkutegia =  "C:\\Users\\IKALTAMIRAPAAG1\\Desktop\\erronki\\Erronka\\txarkutegia\\Tiketak";
  //EberKinki
  public static String xmlPath = "C:\\Users\\IKALTAMIRAPAAG1\\Desktop\\erronki\\Erronka\\xml\\salmenta.xml";
  public static String xsdPath = "C:\\Users\\IKALTAMIRAPAAG1\\Desktop\\erronki\\Erronka\\xml\\erronkaticketbai.xsd";

  //Mario
  //public static String xmlPath = "C:\\Users\\ikaltamirapaag1\\Documents\\ERRONKA-Ticketbai\\Erronka\\xml\\Salmenta.xml";
  //public static String xsdPath = "C:\\Users\\ikaltamirapaag1\\Documents\\ERRONKA-Ticketbai\\Erronka\\xml\\erronkaticketbai.xsd";

  //Igor
  //public static String xmlPath = "C:\\Users\\ikaltamirapaag1\\Documents\\ERRONKA-Ticketbai\\Erronka\\xml\\Salmenta.xml";
  //public static String xsdPath = "C:\\Users\\ikaltamirapaag1\\Documents\\ERRONKA-Ticketbai\\Erronka\\xml\\erronkaticketbai.xsd";

    /** hainbat karpetatako pegatinak irakurtzen dituen metodo bat deitu
    *  hainbat karpetatako pegatinak salmentaGuztiak ArrayList-era gehitu
     * 
     * @return salmentaGuztiak Arraylist itzultzen du
     */
    public static ArrayList <Pegatina> PegatinaGuztiakIrakurri(){
        // Path bakoitza sortzeko
        //path eber
       
        //path mario el crack
      //  String pathHarategia = "C:\\Users\\ikaltamirapaag1\\Documents\\ERRONKA-Ticketbai\\Erronka\\harategia\\Tiketak";
      //  String pathOkindegia =  "C:\\Users\\ikaltamirapaag1\\Documents\\ERRONKA-Ticketbai\\Erronka\\okindegia\\Tiketak";
      //  String pathFrutategia= "C:\\Users\\ikaltamirapaag1\\Documents\\ERRONKA-Ticketbai\\Erronka\\frutategia\\Tiketak";
      //  String pathTxarkutegia =  "C:\\Users\\ikaltamirapaag1\\Documents\\ERRONKA-Ticketbai\\Erronka\\txarkutegia\\Tiketak";
      //  path igor 
        //String pathHarategia = "C:\\Users\\34665\\Desktop\\PROGRAMAZIOA\\githuberronka\\Erronka\\harategia\\Tiketak";
        //String pathOkindegia =  "C:\\Users\\34665\\Desktop\\PROGRAMAZIOA\\githuberronka\\Erronka\\okindegia\\Tiketak";
        //String pathFrutategia= "C:\\Users\\34665\\Desktop\\PROGRAMAZIOA\\githuberronka\\Erronka\\frutategia\\Tiketak";
        //String pathTxarkutegia =  "C:\\Users\\34665\\Desktop\\PROGRAMAZIOA\\githuberronka\\Erronka\\txarkutegia\\Tiketak";
      // salmentaGuztiak ArrayList-a sortzeko
        ArrayList<Pegatina> salmentaGuztiak = new ArrayList<>();

       
        ArrayList <Pegatina> harategikoPegatinak = KarpetaIrakurri(pathHarategia, "2");
        ArrayList <Pegatina> okindegikoPegatinak= KarpetaIrakurri(pathOkindegia, "4");
        ArrayList <Pegatina> frutategikoPegatinak= KarpetaIrakurri(pathFrutategia, "3");
        ArrayList <Pegatina> txarkutegikoPegatinak = KarpetaIrakurri(pathTxarkutegia, "1");

        
        if(harategikoPegatinak!=null) salmentaGuztiak.addAll(harategikoPegatinak);
        if(okindegikoPegatinak!=null)salmentaGuztiak.addAll(okindegikoPegatinak);
        if(frutategikoPegatinak!=null)salmentaGuztiak.addAll(frutategikoPegatinak);
        if(txarkutegikoPegatinak!=null)salmentaGuztiak.addAll(txarkutegikoPegatinak);

        
        return salmentaGuztiak;
    }    
    /**
     * @param salmentaGuztiak Eguneko salmentak klasea aterata , hasierako dokumentutik 
     * informazioa balidatzeko JAXBContext erabiliko dugu, new instance metodo estatikoa erabiliko
     * dugu,konstruktoreak erabili gabe parametro bezala klasea pasatzen zaiolarik.
     * marshall metodoari deitzen diogu idatzi nahi dugun java objetuarekin set property erabiliaz lehenago
     * bestela lerroi bakar batean idatziko digu, gero gure objetuaren xml kodea sortuko delarik eta ondoren balidatuz.
     */
    public static void Xmlsortu( ArrayList<Pegatina> salmentaGuztiak){

      try{
      EgunekoSalmentak salmentaZerrenda = new EgunekoSalmentak(salmentaGuztiak);
      JAXBContext  contexto =JAXBContext.newInstance(EgunekoSalmentak.class);
      Marshaller m = contexto.createMarshaller();
      m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
      m.marshal(salmentaZerrenda,new FileWriter(xmlPath));  
      try {
                  SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
      
                  Source schemaFile = new StreamSource(new File(xsdPath));
                  Schema schema = factory.newSchema(schemaFile);
      
                  Validator validator = schema.newValidator();
                  Source source = new StreamSource(xmlPath);
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




              
    /**
     * 

    - @param pathKarpeta - Fitxategiak dituen karpetaren path-a.
    - @return etiketaZerrenda - Fitxategi guztien etiketak biltzen dituen ArrayList.
     *   KarpetaIrakurri metodoa:
    -    Metodo honek, pasatutako path-a izan ezkero fitxategi zerrenda bat irakurtzen du,
        eta bakoitza irakurtzeko FitxategiaIrakurri metodoari deitzen dio.
        -Irakurritako fitxategi guztien etiketak ArrayList batean biltzen ditu.
     * @param pathKarpeta
     * @param idDenda
     * @return
     */
    public static ArrayList <Pegatina>  KarpetaIrakurri(String pathKarpeta, String idDenda){
    
  
    
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
         * @param args fitxategia irakurri objetu berria sortu pegatina eta objetua listan sartu
         * eta lortutako datuak gorde.
         *///DOKUMENTUA IRAKURRI
    public static  ArrayList<Pegatina> FitxategiaIrakurri(String pathFitxategia, String idDenda){
      ArrayList<Pegatina> datuakGorde = new ArrayList<Pegatina>();
      try {
          
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
          fr.close();
       

      } catch (Exception e) {
          System.out.println("Ezin izan da dokumentua topatu" + e);
      }

      return datuakGorde;
    }
      
    
   
    /**
     * @param info  //pegatina funtzioa sortzen dugu izena lortzeko info substringa sortzen digu
                    //izena bakarrik ateratzeko $arte irakurtzeko esaten diogu indexOf ekin
                   //hau eta gero esaten diogusub string en bitartze  info hasiko dela $ aurrera
     * @param fitxategiIzena
     * @return
     */
    private static Pegatina SortuPegatina(String info, String fitxategiIzena)
    {
      
      return null;
        
    } 

    /**
     * @param pathFitxategia  Ruta del archivo de origen
     * path archivoOrigen  Obtiene la ruta del archivo origen como un objeto Path Path 
     * Path archivoDestino  Obtiene la ruta del archivo destino como un objeto Path, files copy kin artxiboa kopiatzen du , eta arazo 
     * bat baldin badago exzepzioara pasatzen da 
     */ 
    public static void FitxategiaKopiatu(String pathFitxategia){
      String origen = pathFitxategia; 
        String destino = "C:\\Users\\IKALTAMIRAPAAG1\\Desktop\\erronki\\Erronka\\TicketakTemp"; // Ruta de la carpeta de destino
      try {
        Path archivoOrigen = Paths.get(origen);
        Path archivoDestino = Paths.get(destino, archivoOrigen.getFileName().toString()); //
        Files.copy(archivoOrigen, archivoDestino);
    } catch (IOException e) {
        System.out.println("Fitxategia kopiatzeko arazoak: " + e.getMessage());
    }
    }
    /**
     * @param pathFitxategia borratu behar dugun artxiboaren ibilbidea
     * artxiboaren ibilbidearekinfile objetu bat sortzen dugu
     * exzepzioarekin deletekin artxiboa borratzen dugu
     * arazoren bat baldin badago mezu bat azalduko da
     * 
     */
    public static void FitxategiaEzabatu(String pathFitxategia) {
      String rutaArchivo = pathFitxategia; 
        File archivo = new File(rutaArchivo);
        try {
          
          boolean res = archivo.delete();
          System.out.println(res); 
      } catch (Exception e) {
          System.out.println("Fitxategia ezabatzeko arazoak: " + e.getMessage()); 
          
      }
    }
    
    
    
    public static void Backup(){
      /*errutaren karpeten path */
      BackupKarpeta(pathHarategia);
      BackupKarpeta(pathTxarkutegia );
      BackupKarpeta(pathFrutategia);
      BackupKarpeta(pathOkindegia);
    }
    /**
     * @param pathKarpeta file objetu bat sortzen da iturburu karpetan, lista bat sortzen da artxiboen karpeten izenekin
     * artxiborik ez badago , mezu bat azaltzen da eta hor amaitzen da.
     * karpetako artxibo bakoitza beste ubikazio batera kopiatzen da, kopiatu ondoren originala borratzen da
     */
    public static void BackupKarpeta(String pathKarpeta){
      File karpeta = new File(pathKarpeta);
      String[]fitxategiZerrenda = karpeta.list(); 
      if (fitxategiZerrenda==null||fitxategiZerrenda.length ==0){
        System.out.println ("ez dago karpetarik"); 
      
      }
    else{
        for (int i =0; i<fitxategiZerrenda.length;i++){
          FitxategiaKopiatu(pathKarpeta + "\\" + fitxategiZerrenda[i]);
          FitxategiaEzabatu(pathKarpeta + "\\" + fitxategiZerrenda[i]);
        }
      }
    }
    /**
     * @param args salmentak ArrayLista sortu eta PegatinaGuztiakIrakurri funtzioa erabiliz bete
     *  Xmlsortu funtzioa erabiliz XML fitxategia sortu 
     *  mySQLkonexioa klaseko obtener metodoa erabiliz, salmentak datu basera gehitu 
     *  Backup metodoa erabiliz datu-basearen segurtasun kopia sortuko dugu
      * 
     */
    public static void main(String[] args) {

        ArrayList<Pegatina>  salmentak = PegatinaGuztiakIrakurri();
        Xmlsortu(salmentak);
        
        try{
          

        mySQLkonexioa nereKonexioa = new mySQLkonexioa();
        
        mySQLkonexioa.obtener(salmentak);
        
        Backup();
        }
        catch(Exception ex)
        {// Sartzeko erroreak maneiatu
          ex.toString();
          System.out.println("Datu basera sartzeko arazoak...");
          ex.printStackTrace();


        }





}


}
