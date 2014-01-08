package UI;

import NoiseMakers.ContinuousNoiseMaker;

/**
 * A radio button associated with a single {@link ContinuousNoiseMaker}.
 * 
 * @author Joseph Avolio
 */
@SuppressWarnings("serial")
public class NoiseMaker1DButton extends NoiseMakerButton {
	protected ContinuousNoiseMaker n;
	
	/**
	 * Creates a radio button instance
	 * 
	 * @param label The text of the button
	 * @param n The {@link ContinuousNoiseMaker} to associate with the button
	 */
	public NoiseMaker1DButton(String label,ContinuousNoiseMaker n) {
		super(label);
		this.n=n;
	}
}
