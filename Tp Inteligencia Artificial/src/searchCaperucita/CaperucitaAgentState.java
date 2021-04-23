package searchCaperucita;
import frsf.cidisi.faia.agent.Perception;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

public class CaperucitaAgentState extends SearchBasedAgentState {
	/*
	 * PosicionInicial esta dado por los sucesores.get(0).get(0)
	 * Posicion esta dada por los sucesores.get(0).get(..)
	 * sucesores.get(0) --> nodosPrincipales ; sucesores.get(1) --> nodosArriba ; sucesores.get(2) --> nodosAbajo
	 * sucesores.get(3) --> nodosDerecha ; sucesores.get(4) --> nodosIzquierda ; Aclaracion, con otro get() optenes el
	 * correspondiente al nodoPrincipal
	 * 
	 */
	
	private String initialPosition;
	private String posicionCaperucita;
	private List<List<String>> sucesores = new ArrayList<List<String>>();
	private int life;
	private int sweet;

	/*
	 * Constructor CaperucitaAgentState, con parametros.
	 */
	public CaperucitaAgentState(String initialPosition, String posicion, List<List<String>> sucesores, int life,
			int sweet) {
		super();
		this.initialPosition = initialPosition;
		this.posicionCaperucita = posicion;
		this.sucesores = sucesores;
		this.life = life;
		this.sweet = sweet;
	}
	
	public CaperucitaAgentState() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/*MAIN*/
	public static void main(String[] args) throws FileNotFoundException {
		 
		
		
		//System.out.println(sucesoresaux[1]);
		
		/*for(int i=0;i<sucesoresaux.length;i++) {
			System.out.println(sucesoresaux[i]);
		}
		*/
		
		
		//El segundo get es el que te indica si nos interesa arriba abajo,... --> System.out.println(sucesores.get(1).get(1));
		
		
		
		/*Movimiento para arriba */
		/*
		for (int i=0; i<sucesores.get(0).size() ; i++) {
			if(sucesores.get(0).get(i).equals(posicionCaperucita)) {
				posicionCaperucita= sucesores.get(4).get(i);
			}
		}
		*/
		//System.out.println(posicionCaperucita);
		
		/*
		System.out.println("caramelos: " + sweet + "vidas: "+ life+ "posicion inicial"+ initialPosition + "Caperucita " + posicionCaperucita);
		
		for (int i=0; i<sucesores.get(0).size() ; i++) {
			if(sucesores.get(0).get(i).equals(posicionCaperucita)) {
				posicionCaperucita= sucesores.get(4).get(i);
			}
		}
		System.out.println("caramelos: " + sweet + "vidas: "+ life+ "posicion inicial"+ initialPosition + "Caperucita " + posicionCaperucita);
		
		/*
		//Para simular que va a arriba la sentencia seria la siguiente. Suponiendo que esta en el sucesor A
		System.out.println(sucesores.get(4).get(0));
		System.out.println("--------------------------");
		System.out.println(sucesores);
		*/
	}

	public void initState() throws FileNotFoundException {
		
		String[] sucesoresaux;
		//Copiamos el archivo agente.txt para inicializar los estados de Caperucita
		
		File definicionSucesores = new File("/Users/nicoc/git/TP-Inteligencia-Artificial/agente.txt");
		Scanner scan_definiciones = new Scanner(definicionSucesores);
		sucesoresaux = scan_definiciones.nextLine().split(",");
		
		/*
		 * Definimos 5 ArrayList dentro, que nos indicara 0 NodosPrincipales ; 1 Arriba ; 2 Abajo ; 3 Derecha ; 4 Izquierda
		 */
		
		for(int i=0;i<=4;i++) {
			this.sucesores.add(new ArrayList<>());
		}
		
		/*
		 * Cargamos los valores mencionados anteriormente, segun el agente.txt cargado.
		 */
		
		for(int i=0 ; i<sucesoresaux.length ; i = (i+5)) {
			this.sucesores.get(0).add(sucesoresaux[i]);
			this.sucesores.get(1).add(sucesoresaux[i+1]);
			this.sucesores.get(2).add(sucesoresaux[i+2]);
			this.sucesores.get(3).add(sucesoresaux[i+3]);
			this.sucesores.get(4).add(sucesoresaux[i+4]);
			}
		
		//Inicializamos los atributos del Agente
		
		this.sweet=0;
		this.life=3;
		this.posicionCaperucita = sucesores.get(0).get(0);
		this.initialPosition = sucesores.get(0).get(0); //no se modifica se conserva en caso que tenga que volver al punto inicial
		
	}
	
/*
	public void updateState(Perception p) {

	}

	public boolean equals(Object obj) {
		if (!(obj instanceof CaperucitaAgentState)) {
            return false;
        }
		return posicionCaperucita.equals(((CaperucitaAgentState) obj).getPosicionCaperucita()) ;
	}
	
/*
	public SearchBasedAgentState clone() {
		CaperucitaAgentState nuevoEstado = new CaperucitaAgentState();
		nuevoEstado.setPosition(position);
		//Seguirlo, no me queda muy claro lo que deberiamos poder clonarle
		String [] visitarPosicion = (String []) successor.clone();
		nuevoEstado.setSuccessor(visitarPosicion);
		return nuevoEstado;
	}
	
*/
	
	@Override
	public String toString() {
		return "CaperucitaAgentState [initialPosition=" + initialPosition + ", posicionCaperucita=" + posicionCaperucita
				+ ", sucesores=" + sucesores + ", life=" + life + ", sweet=" + sweet + "]";
	}

	//Controlamos la cantidad de vidas del Agente
	public boolean itsLive() {
		if (life > 0) {
			return true;
		} else {
			return false;
		}
	}

	//Controlamos que sea el campo de flores (Objetivo)
	public boolean isFlowes() {
		return false;
	}

	/*
	 * Get and Set de las variables, para poder visualizarlas en otras clases de ser
	 * necesario.
	 */
	
	public String getInitialPosition() {
		return initialPosition;
	}

	public void setInitialPosition(String initialPosition) {
		this.initialPosition = initialPosition;
	}

	public String getPosicionCaperucita() {
		return posicionCaperucita;
	}

	public void setPosicionCaperucita(String posicionCaperucita) {
		this.posicionCaperucita = posicionCaperucita;
	}

	public List<List<String>> getSucesores() {
		return sucesores;
	}

	public void setSucesores(List<List<String>> sucesores) {
		this.sucesores = sucesores;
	}

	public String getInitialposition() {
		return initialPosition;
	}

	public void setInitialposition(String initialposition) {
		this.initialPosition = initialposition;
	}

	public int getSweet() {
		return sweet;
	}

	public void setSweet(int sweet) {
		this.sweet = sweet;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

}
