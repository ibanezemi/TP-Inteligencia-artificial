package searchCaperucita;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class CaperucitaPerception extends Perception {
	
	/*
	 * Si en la siguiente posicion esta vacia tiene valor cero
	 * Si en la siguiente posicion esta el lobo tiene valor 1
	 * Si en la siguiente posicion hay dulces tiene el valor 2
	 */
	public static String EMPTY_PERCEPTION = "V";
    public static String ENEMY_PERCEPTION = "E";
    public static String FOOD_PERCEPTION = "C";
    
    /*
     * Definimos los sensores que tendra caperucita para determinar
     * lo que hay en la proxima accion que tome
     */
    private String upSensor;
    private String donwSensor;
    private String leftSensor;
    private String rightSensor;
   
    public CaperucitaPerception(Agent agent, Environment environment) {
    	super(agent, environment);
    }
    
    public CaperucitaPerception() {
		
	}
    
    
	@Override
	public void initPerception(Agent agent, Environment environment) {
		//Creamos agente, ambiente, y estado ambiente
		CaperucitaAgent caperucitaAgent = (CaperucitaAgent) agent;
		CaperucitaEnvironment caperucitaEnvironment = (CaperucitaEnvironment) environment;
		CaperucitaEnvironmentState environmentState = caperucitaEnvironment.getEnvironmentState();
		
		//definimos la posicion del agente, para luego comprarla con lo que hay en el siguiente movimiento
		String posicion = environmentState.getPosicion_caperucita();
		/*
		this.setUpSensor(caperucitaEnvironment.getUpPosition(posicion));
		this.setDonwSensor(caperucitaEnvironment.getDownPosition(posicion));
		this.setLeftSensor(caperucitaEnvironment.getLeftPosition(posicion));
		this.setRightSensor(caperucitaEnvironment.getRightPosition());
		*/
		
	}


	public static String getEMPTY_PERCEPTION() {
		return EMPTY_PERCEPTION;
	}


	public static void setEMPTY_PERCEPTION(String eMPTY_PERCEPTION) {
		EMPTY_PERCEPTION = eMPTY_PERCEPTION;
	}


	public static String getENEMY_PERCEPTION() {
		return ENEMY_PERCEPTION;
	}


	public static void setENEMY_PERCEPTION(String eNEMY_PERCEPTION) {
		ENEMY_PERCEPTION = eNEMY_PERCEPTION;
	}


	public static String getFOOD_PERCEPTION() {
		return FOOD_PERCEPTION;
	}


	public static void setFOOD_PERCEPTION(String fOOD_PERCEPTION) {
		FOOD_PERCEPTION = fOOD_PERCEPTION;
	}


	public String getUpSensor() {
		return upSensor;
	}


	public void setUpSensor(String upSensor) {
		this.upSensor = upSensor;
	}


	public String getDonwSensor() {
		return donwSensor;
	}


	public void setDonwSensor(String donwSensor) {
		this.donwSensor = donwSensor;
	}


	public String getLeftSensor() {
		return leftSensor;
	}


	public void setLeftSensor(String leftSensor) {
		this.leftSensor = leftSensor;
	}


	public String getRightSensor() {
		return rightSensor;
	}


	public void setRightSensor(String rightSensor) {
		this.rightSensor = rightSensor;
	}

	
	
    
}
