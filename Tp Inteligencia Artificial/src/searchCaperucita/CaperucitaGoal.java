package searchCaperucita;
import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class CaperucitaGoal extends GoalTest{

	@Override
	public boolean isGoalState(AgentState agentState) {
		// TODO Auto-generated method stub
		/**
		 * itsLive() metodo a implementar en CaperucitaAgentState --> si la cantidad de vidas es mayor a cero
		 * isFlowes() metodo a implementar en CaperucitaAgentState --> si llego a objetivo (campo de flores)
		 * VER: CONDICION DE CANTIDAD DE DULCES? CREO QUE NO PORQUE NO ES CONDICION NECESARIA TENER LOS DULCES!
		 */
		if(((CaperucitaAgentState) agentState).itsLive() && ((CaperucitaAgentState) agentState).isFlowes())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	
}
