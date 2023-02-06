import javax.util.ArrayList;
import javax.xml.bind.annotation.XmlAccesType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


    @XmlRootElement(name= "eguneko salmentak")
    @XmlAccessorType(XnmlAccessType.FIELD)
    public class EgunekoSalmentak {
        public EgunekoSalmentak() {

        }

    @XmlElement (name="salmenta")
    public Salmenta[]salmentak;

    public EgunekoSalmentak(ArrayList<Salmenta>sal){
        salmentak=new Salmenta[sal.size()];

        for (int i =0;i<sal.size();i++){
            salmentak [i]= sal.get(i);
        }

    }





    }




