package COPIAK;


import javax.xml.bind.annotation.*;

@XmlRootElement (name="ticketa")//aita elementua ticketa izango da
@XmlType(propOrder ={"izena","date","ordua","pisua","prezioa_kiloko","prezio_totala","id_denda","id_langilea"})
@XmlAccessorType(XmlAccessType.FIELD)

public class ticketa {
    @XmlAttribute(required=true)
    private Integer id_ticketa;
    @XmlElement(name="izena")
    private String izena;
    private double pisua;
    private double prezioa_kiloko;
    private double prezio_totala;
    private Integer id_denda;
    private Integer id_langilea;

    public void etiketazerrenda(){

    }
    public void etiketazerrenda(Integer id_ticketa,String izena,double pisua, double prezioa_kiloko,double prezio_totala,Integer id_denda,Integer id_langilea){
        this.id_ticketa =id_ticketa;
        this.izena= izena;
        this.pisua =pisua;
        this.prezioa_kiloko =prezioa_kiloko;
        this.prezio_totala=prezio_totala;
        this.id_denda = id_denda;
        this.id_langilea=id_langilea;
    }
    public Integer getId_ticketa() {
        return id_ticketa;
    }
    public void setId_ticketa(Integer id_ticketa) {
        this.id_ticketa = id_ticketa;
    }
    public String getIzena() {
        return izena;
    }
    public void setIzena(String izena) {
        this.izena = izena;
    }
    
    public double getPisua() {
        return pisua;
    }
    public void setPisua(double pisua) {
        this.pisua = pisua;
    }
    public double getPrezioa_kiloko() {
        return prezioa_kiloko;
    }
    public void setPrezioa_kiloko(double prezioa_kiloko) {
        this.prezioa_kiloko = prezioa_kiloko;
    }
    public double getPrezio_totala() {
        return prezio_totala;
    }
    public void setPrezio_totala(double prezio_totala) {
        this.prezio_totala = prezio_totala;
    }
    public Integer getId_denda() {
        return id_denda;
    }
    public void setId_denda(Integer id_denda) {
        this.id_denda = id_denda;
    }
    public Integer getId_langilea() {
        return id_langilea;
    }
    public void setId_langilea(Integer id_langilea) {
        this.id_langilea = id_langilea;
    }
    //pegatina ondo
}
