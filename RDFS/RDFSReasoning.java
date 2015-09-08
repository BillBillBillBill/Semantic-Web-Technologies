import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.util.FileManager;


public class RDFSReasoning {

	// print the related turtles in infer model using listStatements
	public static void printStatements(Model m, Resource s, Property p, Resource o) {
    	for (StmtIterator i = m.listStatements(s, p, o); i.hasNext(); ) {
    		Statement stmt = i.nextStatement();
    		System.out.println(stmt.asTriple());
    	}
	}

	public static void main(String[] args) throws UnsupportedEncodingException, IOException {

		// construct
		Model model = FileManager.get().loadModel("tourism.ttl");

		// construct the infer model
		InfModel infmodel = ModelFactory.createRDFSModel(model);

		// display triples about Museion
		Resource museion = infmodel.getResource("http://example.org/inst/Museion");
		printStatements(infmodel, museion, null, null);
		
		// display triples about ChickenHut
		Resource chickenHut = infmodel.getResource("http://example.org/inst/ChickenHut");
		printStatements(infmodel, chickenHut, null, null);
	}
}
