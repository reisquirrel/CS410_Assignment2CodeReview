import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.TitledBorder;

import sensor.PressureSensor;
import sensor.RadiationSensor;
import sensor.TemperatureSensor;

public class SensorApplication extends JFrame {
	private Label print;
	private JProgressBar bar;
	private double value;
	private int valueTemp; 
	private String report;
	public SensorApplication() {
		setTitle("Sensor Tracker");
		setLayout(new GridLayout(3,1));
		Sensor[] sensors = {new PressureSensorAdaptor(new PressureSensor()),
				new RadiationSensorAdaptor(new RadiationSensor()),
				new TemperatureAdaptor(new TemperatureSensor())};
		
		for (Sensor sensor : sensors) {
			//create a panel
			JPanel  Pnl1 = new JPanel();
			Pnl1.setBorder(new TitledBorder(sensor.getType()));
			add(Pnl1);
			
			
			//create a label
			value =  sensor.getValue();
			valueTemp = (int)value;
			report = sensor.getReport();
			bar = new JProgressBar();
			bar.setForeground(sensor.getColor());
			bar.setValue(valueTemp);
			bar.setOpaque(true);
			Pnl1.add(bar);
			System.out.println("1: " + value);
			System.out.println("2: " + value);
			print = new Label(report + "-->" + value);
			Pnl1.add(print);
			
		}
		setPreferredSize(new Dimension(600,600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		pack();
	}

	public static void main(String[] args) {
		SensorApplication app = new SensorApplication();
	}
}
