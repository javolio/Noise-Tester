package UI;

import javax.swing.JRadioButton;

/**
 * A radio button.
 * 
 * @author Joseph Avolio
 */
@SuppressWarnings("serial")
public abstract class NoiseMakerButton extends JRadioButton {
	/**
	 * Creates a radio button instance
	 * 
	 * @param label The text of the button
	 */
	public NoiseMakerButton(String label) {
		super(label);
	}
}
