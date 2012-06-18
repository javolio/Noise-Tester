package UI;

import NoiseMakers.NoiseMaker2D;

@SuppressWarnings("serial")
public class NoiseMaker2DButton extends NoiseMakerButton {
	protected NoiseMaker2D n;
	
	public NoiseMaker2DButton(String label,NoiseMaker2D n) {
		super(label);
		this.n=n;
	}
	
}
