package searchCaperucita;
import frsf.cidisi.faia.agent.Perception;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

public class CaperucitaAgentState extends SearchBasedAgentState {
	private String initialNode;
	/*
	 * Variables del agente, que indiquen el estado del mismo. VERLO
	 */

	private String initialPosition;
	private String position;
	private String[] successor;
	private int life;
	private int sweet;
	private String[] directions;

	/*
	 * Creando Constructores de la clase CaperucitaAgentState, inicializando las
	 * variables por parametro y otra sin paramentros-
	 */
	public CaperucitaAgentState(String inicio, String[] suc, int li, int sw) {
		this.initialPosition = inicio;
		this.position = inicio;
		this.successor = suc;
		this.life = li;
		this.sweet = sw;

	}

	public CaperucitaAgentState() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 * initState() --> Considerando que pasamos por .txt los sucesores de cada nodo
	 * existente, es decir, cada nodo estara conformado por
	 * "arriba,abajo,derecha,izquierda", por lo que hacemos referencia a la primera
	 * posicion a la posicion siguiente arriba, y asi sucesivamente. Ej: A =
	 * {B,C,D,E} --> A[1]=Arriba ; A[2]=Abajo ; A[3]=Derecha ; A[4]=Izquierda. Si
	 * alguno de estos es vacio = null ; entonces sabemos que no se podra mover para
	 * dicha posicion.
	 */

	public void initState() throws FileNotFoundException {
		File definicionSucesores = new File("/Users/marco_000/git/InitialStateCaperucita.txt");
		Scanner scan_definiciones = new Scanner(definicionSucesores);
		
		String sucesores = "";
		
		//Se define la cantidad de sucesores
		String cantidad_sucesores = "";
		cantidad_sucesores = scan_definiciones.nextLine() ;
		
		//Se pasa el nodo inicial
		String nodo_inicial = "";
		nodo_inicial = scan_definiciones.nextLine() ;
		
		String[] lista_sucesores = new String[Integer.parseInt(cantidad_sucesores)];
		
		//while para asignar los sucesores
		while (scan_definiciones.hasNextLine()) {
			sucesores = scan_definiciones.nextLine();
		}
		
		String[] parts = sucesores.split("/");    
		
		for(int j = 0; j<Integer.parseInt(cantidad_sucesores); j++) {
			lista_sucesores[j] = Arrays.asList(parts).get(j);
			System.out.println(lista_sucesores[j]);
		}
		
		scan_definiciones.close();
		
		this.initialPosition = nodo_inicial;
		this.position = nodo_inicial;
		this.successor = lista_sucesores; //Aca para asignar los sucesores hay que ir recorriendolos, asi como esta ahora no se puede.
		this.life = 3;
		this.sweet = 0;	
		
		scan_definiciones.close();
	}

	public void updateState(Perception p) {

	}

	public boolean equals(Object obj) {
		if (!(obj instanceof CaperucitaAgentState)) {
            return false;
        }
		return position.equals(((CaperucitaAgentState) obj).getPosition()) ;
	}

	public SearchBasedAgentState clone() {
		CaperucitaAgentState nuevoEstado = new CaperucitaAgentState();
		nuevoEstado.setPosition(position);
		//Seguirlo, no me queda muy claro lo que deberiamos poder clonarle
		String [] visitarPosicion = (String []) successor.clone();
		nuevoEstado.setSuccessor(visitarPosicion);
		return nuevoEstado;
	}
	
	@Override
	public String toString() {
		return "CaperucitaAgentState [initialNode=" + initialNode + ", initialPosition=" + initialPosition
				+ ", position=" + position + ", successor=" + Arrays.toString(successor) + ", life=" + life + ", sweet="
				+ sweet + "]";
	}

	/*
	 * Verificamos, que el agente, tenga al menos una vida, de esta forma sabemos
	 * que esta vivo.
	 */
	public boolean itsLive() {
		// TODO Auto-generated method stub
		if (life > 0) {
			return true;
		} else {
			return false;
		}

	}

	public boolean isFlowes() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * Get and Set de las variables, para poder visualizarlas en otras clases de ser
	 * necesario.
	 */

	public String getInitialposition() {
		return initialPosition;
	}

	public void setInitialposition(String initialposition) {
		this.initialPosition = initialposition;
	}

	public String[] getSuccessor() {
		return successor;
	}

	public void setSuccessor(String[] successor) {
		this.successor = successor;
	}

	public int getSweet() {
		return sweet;
	}

	public void setSweet(int sweet) {
		this.sweet = sweet;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public void setInitNode(String node) {
		this.initialNode = node;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

}
