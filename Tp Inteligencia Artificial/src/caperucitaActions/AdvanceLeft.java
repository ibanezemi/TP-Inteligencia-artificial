package caperucitaActions;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class AdvanceLeft extends SearchAction {

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		// TODO Auto-generated method stub
		
		//Creamos una instancia de caperucitaState y la inicializamos con lo pasado en el parametro.
		
				//CaperucitaAgentState caperucitaState = (CaperucitaAgentState) s;
	
		//Obtenemos la posicion actual de caperucita segun su estado.
				//char posicion = caperucitaState.getPosition();
	
		/*
		 * Definimos funcion de avanzar si el casillero esta vacio, 
		 * Debemos actualizar la posicion del estado de caperucita? o tambien tener una variable del mundo???
		 * 
			 	* if (caperucitaState.getPosition(posicion+SIGLEF) == CaperucitaPerception.EMPTY_PERCEOTION)
			 	* 		{
			 	* 			caperucitaState.setPosition(posicion+SIGLEF);
			 	* 			return caperucitaState;
			 	* 		}	
			 	* 
		*/
		return null;
	}

	@Override
	public Double getCost() {
		// TODO Auto-generated method stub
		return new Double(0);
	}

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "AdvanceLeft";
	}

}
