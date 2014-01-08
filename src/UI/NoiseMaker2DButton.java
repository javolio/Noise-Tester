package UI;

import NoiseMakers.ContinuousNoiseMaker2D;

/**
 * A radio button associated with a single {@link ContinuousNoiseMaker2D}.
 * 
 * @author Joseph Avolio
 */
@SuppressWarnings("serial")
public class NoiseMaker2DButton extends NoiseMakerButton {
	protected ContinuousNoiseMaker2D n;
	
	/**
	 * Creates a radio button instance
	 * 
	 * @param label The text of the button
	 * @param n The {@link ContinuousNoiseMaker2D} to associate with the button
	 */
	public NoiseMaker2DButton(String label,ContinuousNoiseMaker2D n) {
		super(label);
		this.n=n;
	}
}
