package UI;

import NoiseMakers.ContinuousNoiseMaker;

@SuppressWarnings("serial")
public class NoiseMaker1DButton extends NoiseMakerButton {
	protected ContinuousNoiseMaker n;
	
	public NoiseMaker1DButton(String label,ContinuousNoiseMaker n) {
		super(label);
		this.n=n;
	}
	
}
