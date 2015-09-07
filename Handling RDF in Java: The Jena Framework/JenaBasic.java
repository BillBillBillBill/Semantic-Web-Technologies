import org.apache.jena.rdf.model.*;
import org.apache.jena.riot.Lang;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.VCARD;  

import java.io.InputStream;

public class JenaBasic {

  
    public static void main(String[] args){  

        String personURI = "http://example.org/resource/huangxiongbiao";  
        String ns = "http://example.org/property/"; 
        Model model = ModelFactory.createDefaultModel();
          
        Resource my = model.createResource(personURI); 
        Property P = model.createProperty(ns + "said");
        my.addProperty(P, model.createLiteral("Hello World!", "en"));

        model.write(System.out, "RDF/XML-ABBREV");
        System.out.println();
        model.write(System.out, "N-TRIPLE");
        System.out.println();
        model.write(System.out, "TURTLE");

}
    
}
