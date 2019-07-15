package model;

import sensorclima.TipoClima;

public class Camion implements Vehiculo{
	
	@Override
	public int getLimiteVelocidad (TipoClima clima) {
		int limite = 0;
		switch(clima) {
			case NORMAL:
			limite = 90;
			break;
			case LLUVIAS_MODERADAS:
			limite = 80;
			break;
			case LLUVIAS_TORRENCIALES:
			limite = 70;
			break;
		}
	return limite;
	}


}
