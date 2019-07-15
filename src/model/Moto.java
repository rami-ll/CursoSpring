package model;

import sensorclima.TipoClima;

public class Moto implements Vehiculo{
	
	@Override
	public int getLimiteVelocidad (TipoClima clima) {
		int limite = 0;
		switch(clima) {
			case NORMAL:
			limite = 130;
			break;
			case LLUVIAS_MODERADAS:
			limite = 110;
			break;
			case LLUVIAS_TORRENCIALES:
			limite = 90;
			break;
		}
	return limite;
	}

}
