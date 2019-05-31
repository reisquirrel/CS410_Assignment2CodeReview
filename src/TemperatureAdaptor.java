import java.awt.Color;

import sensor.TemperatureSensor;

public class TemperatureAdaptor implements Sensor{
	private TemperatureSensor adaptee;
	static String report1;

    public TemperatureAdaptor(TemperatureSensor ts) {
        this.adaptee = ts;
    }
	
	@Override
	public double getValue() {
		return adaptee.senseTemperature();
	}

	@Override
	public String getReport() {
		report1 = adaptee.getTempReport();
		return report1;
	}

	@Override
	public String getType() {
		return adaptee.getSensorType();
	}

	@Override
	public Color getColor() {
		Color c = null;
		if(report1 == "OK") {
			return c.green;
		}else if(report1 == "CRITICAL") {
			return c.YELLOW;
		}else if(report1 == "DANGER") {
			return c.red;
		}
		return c;
		
	}

}
