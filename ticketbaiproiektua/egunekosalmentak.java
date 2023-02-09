package ticketbaiproiektua;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


    @XmlRootElement(name = "EgunekoSalmentak")
    @XmlAccessorType(XmlAccessType.FIELD)
    public class EgunekoSalmentak {
        public EgunekoSalmentak() {

        }

    @XmlElement (name = "salmenta")
    public Pegatina[]salmentak;

    public EgunekoSalmentak(ArrayList<Pegatina>sal){
        salmentak = new Pegatina[sal.size()];

        for (int i =0;i<sal.size();i++){
            salmentak [i]= sal.get(i);
        }

    }
}