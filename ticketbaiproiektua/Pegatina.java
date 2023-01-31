package ticketbaiproiektua;

import java.time.LocalDate;
import java.time.LocalTime;

public class Pegatina {
    
    private Integer id_ticketa;
    private String izena;
    private LocalDate date;
    private LocalTime ordua;
    private double pisua;
    private double prezioa_kiloko;
    private double prezio_totala;
    private Integer id_denda;
    private Integer id_langilea;


    public Pegatina(){

    }
    public Pegatina(Integer id_ticketa,String izena,double pisua, double prezioa_kiloko,double prezio_totala,Integer id_denda,Integer id_langilea){
        this.id_ticketa =id_ticketa;
        this.izena= izena;
        this.date = date;
        this.ordua = ordua;
        this.pisua =pisua;
        this.prezioa_kiloko =prezioa_kiloko;
        this.prezio_totala=prezio_totala;
        this.id_denda = id_denda;
        this.id_langilea=id_langilea;
    }
    public void setEtiketa(String lerroa, String pathFitxategia) {
        this.date=pathFitxategia;
        String info = lerroa;

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
        //variable sortu konstruktorearen argumentuak variasble batean gordetzeko
    
        int id_ticketa=Integer.parseInt(saltzaileID);
        double pisuaDouble= Double.parseDouble(pisua);
        double prezioaKilokoDouble=Double.parseDouble(prezioaKiloko);
        double prezioTotalaDouble=Double.parseDouble(prezioTotala);
        //id denda eta id_langilea variableak sartu eta definituak ez badaude definitu
        int id_denda = 0;
        int id_langilea = 0;
        //pegatina objetua sortu
       // Pegatina pgtn = new Pegatina(id_ticketa, izena, null, null, pisuaDouble, prezioaKilokoDouble, prezioTotalaDouble, id_denda, id_langilea);
    DataAtera(pathFitxategia);
        //return pgtn;
        return null;

    }

    private String DataAtera( String pathfitxategiaString) {
  
  
        String urtea = pathfitxategiaString.substring(0, 4);
        String hilabetea = pathfitxategiaString.substring(5, 6);
        String eguna = pathfitxategiaString.substring(7, 8);
        String ordua = pathfitxategiaString.substring(9, 10);
        String minutua = pathfitxategiaString.substring(11, 12);
        String segundua = pathfitxategiaString.substring(13, 14);
         return pathfitxategiaString;
       }

}
