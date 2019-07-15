package model;

import sensorclima.TipoClima;

public class Tractor implements Vehiculo{
	
	@Override
	public int getLimiteVelocidad (TipoClima clima) {
		return 60;
	}

}
