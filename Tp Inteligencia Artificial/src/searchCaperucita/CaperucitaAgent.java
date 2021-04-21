package searchCaperucita;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgent;

public class CaperucitaAgent extends SearchBasedAgent {

	public CaperucitaAgent() {
		
		//Caperucita Goal
		CaperucitaGoal goal = new CaperucitaGoal();
		
		//Caperucita Agente Estado
		CaperucitaAgentState CaperucitaState = new CaperucitaAgentState();
		
	}
	
    public Action selectAction() {
    	return null;
    }
    
    public void see(Perception p) {
        this.getAgentState().updateState(p);
    }
    
}
