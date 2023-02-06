package ticketbaiproiektua;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;

public class marshaller {
    public static void main(String[] args) throws Exception {
        // Crear un modelo de objeto Java que represente la estructura del archivo XML
        MyModel model = new MyModel();
        model.setName("ticketa");
        model.setAge(30);

        // Crear una instancia de JAXBContext
        JAXBContext context = JAXBContext.newInstance(MyModel.class);

        // Crear un objeto Marshaller y configurarlo
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // Escribir el contenido del modelo de objeto en un archivo XML
        marshaller.marshal(model, new File("model.xml"));
    }
}
