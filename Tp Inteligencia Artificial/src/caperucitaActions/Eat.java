package caperucitaActions;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;


public class Eat extends SearchAction {

	
	
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
		* if (caperucitaState.getPosition(posicion+SIGU) == CaperucitaPerception.FOOD_PERCEPTION)
	 	* 		{
	 * Si cae en la posicion que esta el lobo, actualizamos el estado de caperucita,
	 * Arranca desde la posicionInicial, y a su vez se le consume una vida, como restable la cantidad
	 * de dulces a cero.
	 	* 			char posicionInicial = caperucitaState.getInitialposition();
	 	* 			caperucitaState.setPosition(posicion+SIGU);
	 	* 
	 	* 			int dulces = caperucitaState.getSweet();
	 	* if (dulces<3){		
	 	* 			caperucitaState.setSweet(dulces+1);
	 	* 			}
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
		return "Eat";
	}
	
}
