import java.awt.Color;

import sensor.RadiationSensor;

public class RadiationSensorAdaptor implements Sensor{
	private  RadiationSensor adaptee;
	static String report2;

    public RadiationSensorAdaptor(RadiationSensor rs) {
        this.adaptee = rs;
    }
	@Override
	public double getValue() {
		return adaptee.getRadiationValue();
	}

	@Override
	public String getReport() {
		report2 = adaptee.getStatusInfo();
		return report2;
	}

	@Override
	public String getType() {
		return adaptee.getName();
	}
	@Override
	public Color getColor() {
		Color c = null;
		if(report2 == "OK") {
			return c.green;
		}else if(report2 == "CRITICAL") {
			return c.YELLOW;
		}else if(report2 == "DANGER") {
			return c.red;
		}
		return c;
		
	}

}
