package searchCaperucita;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import frsf.cidisi.faia.state.EnvironmentState;

public class CaperucitaEnvironmentState extends EnvironmentState {
	private List<String> bosque = new ArrayList<String>();
	private List<String> posiciones_lobo = new ArrayList<String>();
	private List<String> posiciones_dulces = new ArrayList<String>();
	private String posicion_lobo;
	private String posicion_caperucita;
	private int vidas;
	
	

	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	public String getPosicion_caperucita() {
		return posicion_caperucita;
	}

	public void setPosicion_caperucita(String posicion_caperucita) {
		this.posicion_caperucita = posicion_caperucita;
	}

	/*Constructor*/
	public CaperucitaEnvironmentState() throws FileNotFoundException {
			this.initState();
	}

	/*MAIN*/
	public static void main(String[] args) throws FileNotFoundException {
		
	}
	

	@Override
	public void initState() throws FileNotFoundException {
		// TODO Auto-generated method stub
		 String[] bosqueaux;
		 List<String> bosaux = new ArrayList<String>();
	  	 String[] posiciones_lobo_aux;
		 String[] posiciones_dulces_aux;
		 String posicion_lobo;
		
		File ambiente = new File("/Users/nicoc/git/TP-Inteligencia-Artificial/ambiente.txt");
		Scanner scan_ambiente = new Scanner(ambiente);

		bosqueaux = scan_ambiente.nextLine().split(",");
		posiciones_dulces_aux = scan_ambiente.nextLine().split(",");
		posiciones_lobo_aux = scan_ambiente.nextLine().split(",");
		posicion_lobo = "A";
		posicion_caperucita = "I";
	
		//Inicializamos al bosque con las percepcion vacias "V"
		//Agregamos bosaux para luego compararlo con los dulces y de esa manera cambiarle la Percepcion
		for(int i=0 ; i<bosqueaux.length ; i++) {
			this.bosque.add(bosqueaux[i]);
			bosaux.add(bosqueaux[i]);
			this.bosque.set(i, CaperucitaPerception.EMPTY_PERCEPTION);
		}
		for(int i=0 ; i<posiciones_dulces_aux.length ; i++) {
			this.posiciones_dulces.add(posiciones_dulces_aux[i]);
		}
		//Asignamos a las posiciones de los dulces, la percepcion de los dulces.
		for(int i=0 ; i<bosaux.size() ; i++) {
			for(int j=0 ; j<this.posiciones_dulces.size(); j++) {
				if(bosaux.get(i).equals(this.posiciones_dulces.get(j))) {
					this.bosque.set(i, CaperucitaPerception.FOOD_PERCEPTION);
				}
			}
		}
		
		this.setVidas(3);
		
		/*
		Pruebas de salida para ver funcionamiento en main.
		System.out.println(this.bosque);
		
		System.out.println("----------------------------------------------------------------------------------");
		
		System.out.println("Ambiente: " + this.bosque);
		System.out.println("Posiciones de los dulces: " + this.posiciones_dulces);
		System.out.println("Posiciones disponibles para el lobo: " + this.posiciones_lobo);
		System.out.println("Posicion actual del lobo: " + this.posicion_lobo);
		System.out.println("Posicion inicial: " + this.posicion_caperucita);
		System.out.println("----------------------------------------------------------------------------------");
		*/
		
		//Posicion del lobo que se vaya cambiando por tiempo, en este caso 10 segundos y agregamos percepcion enemigo
		final Runnable tarea = () -> {
			//posicion_lobo = updatePosicionLobo(this.posiciones_lobo);
			//posicion_lobo = CaperucitaPerception.ENEMY_PERCEPTION;
		};
		ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
		executorService.scheduleAtFixedRate(tarea, 0, 10, TimeUnit.SECONDS);
		
		scan_ambiente.close();
		
	}

	public static String updatePosicionLobo(String posiciones_lobo) {
		return posicionLoboRandom(posiciones_lobo);
	}
	public static String posicionLoboRandom(String pos) {
		// TODO Auto-generated method stub
		String[] posiciones_permitidas_lobo = pos.split(",");
		Random proximo_nodo_lobo = new Random();
		int valorDado = proximo_nodo_lobo.nextInt(posiciones_permitidas_lobo.length);		
		return posiciones_permitidas_lobo[valorDado];
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.bosque.toString();
	}

}
