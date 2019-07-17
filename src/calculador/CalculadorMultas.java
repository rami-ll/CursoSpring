package calculador;

import sensorclima.TipoClima;
import sensorvelocidad.DatosVehiculo;
import status.StatusController;
import model.*;

public class CalculadorMultas {
	
	private static Auto auto = new Auto();
	private static Moto moto = new Moto();
	private static Camion camion = new Camion();
	private static Tractor tractor = new Tractor();
	
	public static int calcularMulta(DatosVehiculo vehiculo, TipoClima clima) {
		int montoMulta = 0;
		float limite = 0;
		switch (vehiculo.tipoVehiculo) {
			case Auto:
				limite = auto.getLimiteVelocidad(clima);
				break;
			case Camion:
				limite = camion.getLimiteVelocidad(clima);
				break;
			case Tractor:
				limite = tractor.getLimiteVelocidad(clima);
				break;
			case Moto:
				limite = moto.getLimiteVelocidad(clima);
				break;
		}
		float exceso = (vehiculo.velocidadMedida/limite);
		if(StatusController.esDomingo()) {
			exceso += 0.1;
			System.out.println("Es domingo hay tolerancia del 10%");
		}
		System.out.println(String.format("Limite: %f", limite));
		System.out.println("Exceso: " + exceso);
		if(exceso > 1.1) {
			montoMulta = 1000;
		} 
		if (exceso > 1.2) {
			montoMulta = 5000;
		}
		return montoMulta;
	}

}
