package main;
import calculador.CalculadorMultas;
import sensorclima.*;
import sensorvelocidad.*;
import status.StatusController;

public class Main {

	public static void main(String[] args) {
		
		StatusController controller = new StatusController();
		
		DatosVehiculo datos;
		TipoClima clima;		
			
		while(true) {
			clima = controller.getClima();
			datos = controller.getDatosVehiculoSensado();
			System.out.println(clima);
			System.out.println(datos.patente);
			System.out.println(datos.velocidadMedida);
			System.out.println(datos.tipoVehiculo.toString());
			System.out.println("Monto: " +
					CalculadorMultas.calcularMulta(datos, clima));
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
			



	}

}
