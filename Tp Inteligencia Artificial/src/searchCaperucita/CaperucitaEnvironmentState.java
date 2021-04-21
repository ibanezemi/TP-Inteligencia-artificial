package searchCaperucita;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import frsf.cidisi.faia.state.EnvironmentState;

public class CaperucitaEnvironmentState extends EnvironmentState {
	char posicion;
	private String bosque;
	private String posiciones_lobo;
	private String posiciones_dulces;
	private String posicion_lobo;

	
	public CaperucitaEnvironmentState(String bosque, String posiciones_lobo, String posiciones_dulces,
			String posicion_lobo) {
		super();
		this.bosque = bosque;
		this.posiciones_lobo = posiciones_lobo;
		this.posiciones_dulces = posiciones_dulces;
		this.posicion_lobo = posicion_lobo;
	}
	
	

	public CaperucitaEnvironmentState() throws FileNotFoundException {
			this.initState();
	}


	@Override
	public void initState() throws FileNotFoundException {
		// TODO Auto-generated method stub
		File ambiente = new File("/Users/nicoc/git/TP-Inteligencia-Artificial/ambiente.txt");
		Scanner scan_ambiente = new Scanner(ambiente);

		this.bosque = scan_ambiente.nextLine();
		this.posiciones_dulces = scan_ambiente.nextLine();
		this.posiciones_lobo = scan_ambiente.nextLine();
		this.posicion_lobo = "A";

		System.out.println("Ambiente: " + bosque);
		System.out.println("Posiciones de los dulces: " + posiciones_dulces);
		System.out.println("Posiciones disponibles para el lobo: " + posiciones_lobo);
		System.out.println("Posicion actual del lobo: " + posicion_lobo);

		scan_ambiente.close();
		
		/*colocamos percepciones vacias, a todos los sucesores */
		String [] listaBosque = bosque.split(",");
		for(int i=0; i<listaBosque.length; i++) {
			listaBosque[i] = CaperucitaPerception.EMPTY_PERCEPTION;
		}
		
		/*De la lista de dulces, asignamos la percepcion dulces*/
		String[] listaDulces = posiciones_dulces.split(",");
		for (int j=0 ; j<listaDulces.length; j++) {
			listaDulces[j] = CaperucitaPerception.FOOD_PERCEPTION;
		}
		/*Posicion del lobo que se vaya cambiando por tiempo, en este caso 10 segundos y agregamos percepcion enemigo */
		final Runnable tarea = () -> {
			this.posicion_lobo = updatePosicionLobo(this.posiciones_lobo);
			posicion_lobo = CaperucitaPerception.ENEMY_PERCEPTION;
		};
		ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
		executorService.scheduleAtFixedRate(tarea, 0, 10, TimeUnit.SECONDS);
		
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
		return null;
	}

	public String getBosque() {
		return bosque;
	}

	public void setBosque(String bosque) {
		this.bosque = bosque;
	}

	public String getPosiciones_lobo() {
		return posiciones_lobo;
	}

	public void setPosiciones_lobo(String posiciones_lobo) {
		this.posiciones_lobo = posiciones_lobo;
	}

	public String getPosiciones_dulces() {
		return posiciones_dulces;
	}

	public void setPosiciones_dulces(String posiciones_dulces) {
		this.posiciones_dulces = posiciones_dulces;
	}

	public String getPosicion_lobo() {
		return posicion_lobo;
	}

	public void setPosicion_lobo(String posicion_lobo) {
		this.posicion_lobo = posicion_lobo;
	}

	public char getAgentPositions() {
		// TODO Auto-generated method stub
		// posi=agent.posicion ---> Deberiamos guardar la posicon del agente, entonces
		// retornamos dicha posicion
		return posicion;
	}

}
