import org.apache.jena.rdf.model.*;
import org.apache.jena.riot.Lang;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.VCARD;  

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;

public class JenaManipulation {
    public static void main(String[] args) throws Exception {
    	
    	// Load your RDF file into an object of the Model class of Jena
        // create an empty model
        Model model = ModelFactory.createDefaultModel();
        String inputFileName = "foaf.xml";
        InputStream in = FileManager.get().open( inputFileName );
        
        if (in == null) {
            throw new IllegalArgumentException(
                    "File: " + inputFileName + " not found");
        }

        // read the RDF/XML file
        model.read(in, null);

        // write it to standard out
        //model.write(System.out, "TURTLE");

        //rite Jena code that adds some RDF description of one of your friend
        String personURI = "http://example.org/resource/$student-name";  
        String ns = "ex:"; 
        // get the resource
        Resource my = model.getResource("http://weibo.com/billbillbillbill");
        // adds some RDF description
        Property P = model.createProperty(ns + "friendDscription");
        my.addProperty(P, model.createLiteral("goooood!", "en"));

        // Use Jena to generate Turtle and RDF/XML documents about your extended data set
        // XML format
        File outputFile = new File( "13331093_huangxiongbiao.xml" );
        OutputStream xmlOut = new FileOutputStream(outputFile, false);
        
        // turtle format
        File outputFile2 = new File( "13331093_huangxiongbiao.ttl" );
        OutputStream turtleOut = new FileOutputStream(outputFile2, false);

        model.write(xmlOut, "RDF/XML-ABBREV");
        model.write(turtleOut, "TURTLE");

}
    
}
