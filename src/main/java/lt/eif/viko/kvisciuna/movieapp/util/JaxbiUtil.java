package lt.eif.viko.kvisciuna.movieapp.util;

import javax.xml.bind.*;
import java.io.File;
/**
 * Utility class for JAXB (Java Architecture for XML Binding) operations.
 * This class provides static methods for transforming Java objects to XML and vice versa using JAXB.
 */
public class JaxbiUtil {
    /**
     * Transforms the given object to XML format and saves it to a file named "Movie.xml".
     * Additionally, the XML representation of the object is printed to the standard output.
     * @param object The object to transform to XML.
     * @param <T> The type of the object.
     * @throws JAXBException If an error occurs during JAXB marshalling.
     */
    public static <T> void transformToXml(T object) throws JAXBException {
        // init jaxb marshaler
        JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

// set this flag to true to format the output
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

// marshaling of java objects in xml (output to file and standard output)
        jaxbMarshaller.marshal(object, new File("Movie.xml"));
        jaxbMarshaller.marshal(object, System.out);
    }
    public static <T> T transformToPojo(T object) throws JAXBException{
        File file = new File( "Movie.xml" );
        JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());

//the only difference with the marshaling operation is here
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        T object1 = (T)jaxbUnmarshaller.unmarshal(file);
        System.out.println(object1);
        return object1;
    }
}

