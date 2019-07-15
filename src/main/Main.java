package main;
import calculador.CalculadorMultas;
import sensorclima.*;
import sensorvelocidad.*;

public class Main {

	public static void main(String[] args) {
		sensorclima.Sensor sensorClima = new sensorclima.Sensor();
		sensorvelocidad.Sensor sensorVel = new sensorvelocidad.Sensor(); 
		
		DatosVehiculo datos;		
		
		TipoClima clima = sensorClima.sensar();
		
		while(true) {
			datos = sensorVel.sensarVehiculo();
			System.out.println(clima);
			System.out.println(datos.patente);
			System.out.println(datos.velocidadMedida);
			System.out.println(datos.tipoVehiculo.toString());
			System.out.println("Monto: " +
					CalculadorMultas.calcularMulta(datos, clima));
		}
			



	}

}
