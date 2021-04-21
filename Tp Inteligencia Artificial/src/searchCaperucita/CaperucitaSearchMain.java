package searchCaperucita;
import java.io.FileNotFoundException;
import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;


public class CaperucitaSearchMain {
    
    public static void main(String[] args) throws PrologConnectorException, FileNotFoundException {
        CaperucitaAgent caperucitaAgent = new CaperucitaAgent();
        
        CaperucitaEnvironment caperucitaEnvironment = new CaperucitaEnvironment();
        
        SearchBasedAgentSimulator simulator =
                new SearchBasedAgentSimulator(caperucitaEnvironment, caperucitaAgent);
        
        simulator.start();
    }
}
