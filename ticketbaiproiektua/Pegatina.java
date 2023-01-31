package ticketbaiproiektua;



public class Pegatina {
    
    private Integer id_ticketa;
    private String izena;
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
        this.pisua =pisua;
        this.prezioa_kiloko =prezioa_kiloko;
        this.prezio_totala=prezio_totala;
        this.id_denda = id_denda;
        this.id_langilea=id_langilea;
    }
    public void setEtiketa(String lerroa, String pathFitxategia) {
        String info = lerroa;

        String izena = info.substring(0, info.indexOf("$"));
        info = info.substring(info.indexOf("$")+1);
    
        String saltzaileID = info.substring(0, info.indexOf("$"));
        info = info.substring(info.indexOf("$")+1);
    
        String prezioaKiloko =info.substring(0, info.indexOf("$"));
        info = info.substring(info.indexOf("$")+1);
    
        String pisua= info.substring(0, info.indexOf("$"));
        info = info.substring(info.indexOf("$")+1);
    
        String prezioTotala=info;
        //variable sortu konstruktorearen argumentuak variasble batean gordetzeko
    
            int id_ticketa;
            if(saltzaileID!="autosalmenta")
                id_ticketa=Integer.parseInt(saltzaileID);
            else id_ticketa =0;
       
        double pisuaDouble= Double.parseDouble(pisua);
        double prezioaKilokoDouble=Double.parseDouble(prezioaKiloko);
        double prezioTotalaDouble=Double.parseDouble(prezioTotala);
        //id denda eta id_langilea variableak sartu eta definituak ez badaude definitu
        int id_denda = 0;
        int id_langilea = 0;
        //pegatina objetua sortu
       // Pegatina pgtn = new Pegatina(id_ticketa, izena, null, null, pisuaDouble, prezioaKilokoDouble, prezioTotalaDouble, id_denda, id_langilea);
        //DatuAtera funtziora deituko diogu eta pathfitxategia pasatuko dio denbora ateratzeko
       DataAtera(pathFitxategia);
        
    
        
       
        

    }

    private String DataAtera( String pathfitxategiaString) {
  
        //String ezberdinak sortzen dira eta substringekin ezartzen diogu zer den bakoitza
        String urtea = pathfitxategiaString.substring(0, 4);
        String hilabetea = pathfitxategiaString.substring(5, 6);
        String eguna = pathfitxategiaString.substring(7, 8);
        String ordua = pathfitxategiaString.substring(9, 10);
        String minutua = pathfitxategiaString.substring(11, 12);
        String segundua = pathfitxategiaString.substring(13, 14);
         return pathfitxategiaString;
       }

}
