package caperucitaActions;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class AdvanceUpWolf extends SearchAction {

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		// Creamos una instancia de caperucitaState y la inicializamos con lo pasado en
		// el parametro.

		// CaperucitaAgentState caperucitaState = (CaperucitaAgentState) s;

		// Obtenemos la posicion actual de caperucita segun su estado.
		// char posicion = caperucitaState.getPosition();

		/*
		 * Definimos funcion de avanzar si el casillero esta vacio, Debemos actualizar
		 * la posicion del estado de caperucita? o tambien tener una variable del
		 * mundo???--> El profesor nos dijo que el mundo se actualiza en la funcion
		 * EnvironmentState execute Con la posicion obtenida, sabemos que es un array de
		 * 4, entonces como en este caso la accion es moverse para arriba, tenemos
		 * definido que es Posicion[1], ya que cada sucesor es un array con los
		 * sucesores siguientes conformado.
		 * 
		 * if (posicion[1] != null && posicion[1] ==
		 * CaperucitaPerception.ENEMY_PERCEPTION) { Si cae en la posicion que esta el
		 * lobo, actualizamos el estado de caperucita, Arranca desde la posicionInicial,
		 * y a su vez se le consume una vida, como restable la cantidad de dulces a
		 * cero.
		 * 
		 * char posicionInicial = caperucitaState.getInitialposition();
		 * caperucitaState.setPosition(posicionInicial);
		 * 
		 * int vida = caperucitaState.getLife() - 1 ; caperucitaState.setLife(vida);
		 * 
		 * caperucitaState.setSweet(0);
		 * 
		 * return caperucitaState; }
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
		return null;
	}

}
