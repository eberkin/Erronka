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
        this.ordua =ordua;
        this.pisua =pisua;
        this.prezioa_kiloko =prezioa_kiloko;
        this.prezio_totala=prezio_totala;
        this.id_denda = id_denda;
        this.id_langilea=id_langilea;
    }
    public void setEtiketa(String lerroa) {
    }

}
