package ticketbaiproiektua;

import javax.xml.bind.annotation.*;

@XmlRootElement (name="ticketa")//aita elementua ticketa izango da
@XmlType(propOrder ={"id_ticketa","izena","urtea_data","hilabetea_data","eguna_data","pisua","prezioa_kiloko","prezio_totala","id_denda","id_langilea"})
@XmlAccessorType(XmlAccessType.FIELD)



public class Pegatina {
  @XmlElement(name="id_ticketa")
  private Integer id_ticketa;
  @XmlElement(name="izena")
  private String izena;
  @XmlElement(name="pisua")
  private double pisua;
  @XmlElement(name="prezioa_kiloko")
  private double prezioa_kiloko;
  @XmlElement(name="prezio_totala")
  private double prezio_totala;
  @XmlElement(name="id_denda")
  private String id_denda;
  @XmlElement(name="id_langilea")
  private Integer id_langilea;
  @XmlElement(name="eguna_data")
  private Integer eguna_data;
  @XmlElement(name="hilabetea_data")
  private Integer hilabetea_data;
  @XmlElement(name="urtea_data")
  private Integer urtea_data;

  public void etiketazerrenda(){

  }
  public void etiketazerrenda(Integer id_ticketa,String izena,double pisua, double prezioa_kiloko,double prezio_totala,String id_denda,Integer id_langilea){
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
  public String getId_denda() {
      return id_denda;
  }
  public void setId_denda(String id_denda) {
      this.id_denda = id_denda;
  }
  public Integer getId_langilea() {
      return id_langilea;
  }
  public void setId_langilea(Integer id_langilea) {
      this.id_langilea = id_langilea;
  }
  //pegatina ondo


    public Pegatina(){

    }
    public Pegatina(Integer id_ticketa,String izena,double pisua, double prezioa_kiloko,double prezio_totala,String id_denda,Integer id_langilea){
        this.id_ticketa =id_ticketa;
        this.izena= izena;
        this.pisua =pisua;
        this.prezioa_kiloko =prezioa_kiloko;
        this.prezio_totala=prezio_totala;
        this.id_denda = id_denda;
        this.id_langilea=id_langilea;
    }
    public void setEtiketa(String lerroa, String pathFitxategia, String idDenda) {
      try {

        String info = lerroa;

        this.id_denda=idDenda;

        izena = info.substring(0, info.indexOf("$"));
        info = info.substring(info.indexOf("$")+1);
    
        String saltzaileID = info.substring(0, info.indexOf("$"));
        info = info.substring(info.indexOf("$")+1);
    
        String prezioaKiloko =info.substring(0, info.indexOf("$"));
        info = info.substring(info.indexOf("$")+1);
    
        String pisua_p= info.substring(0, info.indexOf("$"));
        info = info.substring(info.indexOf("$")+1);
    
        String prezioTotala=info;

        //String ezberdinak sortzen dira eta substringekin ezartzen diogu zer den bakoitza
        String urtea = pathFitxategia.substring(0, 4);
        String hilabetea = pathFitxategia.substring(4, 6);
        String eguna = pathFitxategia.substring(6, 8);
        String ordua = pathFitxategia.substring(8, 10);
        String minutua = pathFitxategia.substring(10, 12);
        String segundua = pathFitxategia.substring(12, 14);
        //variable sortu konstruktorearen argumentuak variasble batean gordetzeko
    
            int id_ticketa;
            
            id_ticketa=Integer.parseInt(saltzaileID);
            
            id_langilea=Integer.parseInt(saltzaileID);
            pisua_p= pisua_p.replace(",", ".");
            pisua = Double.parseDouble(pisua_p);

          //Data parseatuko ditugu intera
        int urteaInt = Integer.parseInt(urtea);
        int hilabeteaInt = Integer.parseInt(hilabetea);
        int egunaInt = Integer.parseInt(eguna);
        int orduaInt = Integer.parseInt(ordua);
        int minutuaInt = Integer.parseInt(minutua);
        int segunduaInt = Integer.parseInt(segundua);
          
        hilabetea_data = hilabeteaInt;
        eguna_data= egunaInt;
        urtea_data = urteaInt;
        prezioaKiloko = prezioaKiloko.replace(",", ".");
        prezioa_kiloko =Double.parseDouble(prezioaKiloko);
        prezioTotala = prezioTotala.replace(",", ".");
        prezio_totala =Double.parseDouble(prezioTotala);
       
        
    
        //pegatina objetua sortu
       // Pegatina pgtn = new Pegatina(id_ticketa, izena, null, null, pisuaDouble, prezioaKilokoDouble, prezioTotalaDouble, id_denda, id_langilea);
        //DatuAtera funtziora deituko diogu eta pathfitxategia pasatuko dio denbora ateratzeko
       
        
      } catch (Exception e) {
        System.out.println(e.toString());
      }
    
    }

}
