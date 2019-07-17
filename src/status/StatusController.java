package status;

import java.util.Calendar;
import java.util.Date;

import sensorclima.TipoClima;
import sensorvelocidad.DatosVehiculo;

public class StatusController {
	
	private TipoClima clima;
	private Date ultimoSensado;	
	private sensorclima.Sensor sensorClima;
	private sensorvelocidad.Sensor sensorVel; 
	
	public StatusController() {
		sensorClima = new sensorclima.Sensor();
		sensorVel = new sensorvelocidad.Sensor();
		ultimoSensado = new Date();
		clima = sensorClima.sensar();
	}
	
	public TipoClima getClima() {
		Calendar calendarNow = Calendar.getInstance();
		calendarNow.setTime(new Date());
		Long timeNowMls = calendarNow.getTimeInMillis();
		calendarNow.setTime(ultimoSensado);
		Long diffTimeMls = timeNowMls - calendarNow.getTimeInMillis();
		if(diffTimeMls > 3600000L) {
			System.out.println("Realizando nueva medicion del Clima...");
			ultimoSensado = new Date();
			clima = sensorClima.sensar();
		}
		return clima;
	}
	
	public DatosVehiculo getDatosVehiculoSensado() {
		return sensorVel.sensarVehiculo();
	}
	
	public static boolean esDomingo() {
		Calendar calendarNow = Calendar.getInstance();
		calendarNow.setTime(new Date());
		int day = calendarNow.get(Calendar.DAY_OF_WEEK);
		return day == 1;
	}

}
