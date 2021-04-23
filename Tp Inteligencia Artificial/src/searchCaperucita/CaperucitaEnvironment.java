package searchCaperucita;
import java.io.FileNotFoundException;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class CaperucitaEnvironment extends Environment {
	
	public CaperucitaEnvironment() throws FileNotFoundException {
        // Create the environment state
        this.environmentState = new CaperucitaEnvironmentState();
    }
	
	@Override
    public CaperucitaEnvironmentState getEnvironmentState() {
        return (CaperucitaEnvironmentState) super.getEnvironmentState();
    }
	
	@Override
	public Perception getPercept() {
		//Creamos la percepcion que vamos a retornar.
		CaperucitaPerception percepcion = new CaperucitaPerception();
		
		String posicionCaperucita = this.getEnvironmentState().getPosicion_caperucita();
		
		return percepcion;
	}
	
	//Prueba de fallo, esto ocurre cuando el agente se queda sin vidas.
	@Override
    public boolean agentFailed(Action actionReturned) {

        CaperucitaEnvironmentState ambienteEstado =
                this.getEnvironmentState();

        int vidasCaperucita = ambienteEstado.getVidas();

        if (vidasCaperucita <= 0)
            return true;

        return false;
    }
	
	
	public int getUpPosition(String posicion) {
		return 0;
	}



	public int getDownPosition(String posicion) {
		// TODO Auto-generated method stub
		return 0;
	}



	public int getLeftPosition(String posicion) {
		// TODO Auto-generated method stub
		return 0;
	}



	public int getRightPosition(String posicion) {
		// TODO Auto-generated method stub
		return 0;
	}



	public int getRightPosition() {
		// TODO Auto-generated method stub
		return 0;
	}

}

