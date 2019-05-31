import java.awt.Color;

import sensor.PressureSensor;

public class PressureSensorAdaptor implements Sensor{
	private  PressureSensor adaptee;
	static String report3;
	
    public PressureSensorAdaptor(PressureSensor rs) {
        this.adaptee = rs;
    }
	@Override
	public double getValue() {
		return adaptee.readValue();
	}

	@Override
	public String getReport() {
		report3 = adaptee.getReport();
		return report3;
	}

	@Override
	public String getType() {
		return adaptee.getSensorName();
	}
	@Override
	public Color getColor() {
		Color c = null;
		if(report3 == "OK") {
			return c.green;
		}else if(report3 == "CRITICAL") {
			return c.YELLOW;
		}else if(report3 == "DANGER") {
			return c.red;
		}
		return c;
	}
	
}
