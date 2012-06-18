package UI;

import NoiseMakers.NoiseMaker;

@SuppressWarnings("serial")
public class NoiseMaker1DButton extends NoiseMakerButton {
	protected NoiseMaker n;
	
	public NoiseMaker1DButton(String label,NoiseMaker n) {
		super(label);
		this.n=n;
	}
	
}
