package ticketbaiproiektua;



public class Pegatina {
    
    private Integer id_ticketa;
    private String izena;
    private double pisua;
    private double prezioa_kiloko;
    private double prezio_totala;
    private String id_denda;
    private Integer id_langilea;


    public Pegatina(){

    }
    public Pegatina(Integer id_ticketa,String izena,double pisua, double prezioa_kiloko,double prezio_totala,Integer id_denda,Integer id_langilea){
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
