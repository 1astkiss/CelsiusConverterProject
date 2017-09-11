import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class CelsiusConverterGUI extends JFrame {
	private JTextField tempTextField;
	private JLabel fahrenheitLabel;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CelsiusConverterGUI frame = new CelsiusConverterGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CelsiusConverterGUI() {
		setTitle("Celsius Converter");
		setBounds(100, 100, 373, 244);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		tempTextField = new JTextField();
		tempTextField.setBounds(10, 11, 78, 20);
		getContentPane().add(tempTextField);
		tempTextField.setColumns(10);
		
		JLabel celsiusLabel = new JLabel("Celsius");
		celsiusLabel.setBounds(98, 14, 78, 14);
		getContentPane().add(celsiusLabel);
		
		JButton convertButton = new JButton("Convert");
		convertButton.setBounds(10, 42, 78, 23);
		getContentPane().add(convertButton);
		convertButton.setAction(action);
		
		fahrenheitLabel = new JLabel("Fahrenheit");
		fahrenheitLabel.setBounds(99, 46, 77, 14);
		getContentPane().add(fahrenheitLabel);

	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Convert");
			putValue(SHORT_DESCRIPTION, "Some short description");
			
		}
		public void actionPerformed(ActionEvent e) {
			int tempFahr = (int) ((Double.parseDouble(tempTextField.getText()))*1.8 +32);
			fahrenheitLabel.setText(tempFahr + " Fahrenheit");
		}
	}
}
