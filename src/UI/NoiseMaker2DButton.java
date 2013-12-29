package UI;

import NoiseMakers.ContinuousNoiseMaker2D;

@SuppressWarnings("serial")
public class NoiseMaker2DButton extends NoiseMakerButton {
	protected ContinuousNoiseMaker2D n;
	
	public NoiseMaker2DButton(String label,ContinuousNoiseMaker2D n) {
		super(label);
		this.n=n;
	}
	
}
