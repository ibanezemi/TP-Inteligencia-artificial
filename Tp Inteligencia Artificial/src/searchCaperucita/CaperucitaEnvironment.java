package searchCaperucita;
import java.io.FileNotFoundException;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class CaperucitaEnvironment extends Environment {
	
	public CaperucitaEnvironment() throws FileNotFoundException {
        // Create the environment state
        this.environmentState = new CaperucitaEnvironmentState();
    }
	
	@Override
	public Perception getPercept() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	public int getUpPosition(char posicion) {
		// TODO Auto-generated method stub
		return 0;
	}



	public int getDownPosition(char posicion) {
		// TODO Auto-generated method stub
		return 0;
	}



	public int getLeftPosition(char posicion) {
		// TODO Auto-generated method stub
		return 0;
	}



	public int getRightPosition(char posicion) {
		// TODO Auto-generated method stub
		return 0;
	}



	public int getRightPosition() {
		// TODO Auto-generated method stub
		return 0;
	}



	public CaperucitaEnvironmentState getEnvironmentState() {
		// TODO Auto-generated method stub
		return null;
	}

}
