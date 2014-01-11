package UI;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.JApplet;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import NoiseMakers.*;

/**
 * Displays a {@link SwitchableNoisePanel} and controls to interact with it
 * 
 * @author Joseph Avolio
 */
@SuppressWarnings("serial")
public class NoiseTesterApplet extends JApplet implements ChangeListener,ActionListener {
	private JSlider xRange,yRange;
	private NoiseMakerButton[] buttons;
	private SwitchableNoisePanel panel;
	private ButtonGroup group;
	
	/**
	 * Creates an applet instance
	 */
	public NoiseTesterApplet() {
		super();
		setPreferredSize(new Dimension(520,600));
		setMinimumSize(new Dimension(520,600));
		setLayout(new GridBagLayout());
		GridBagConstraints cons;
		
		//Noise Panel
		panel=new SwitchableNoisePanel(500,500,20,20);
		cons=new GridBagConstraints();
		cons.gridx=0;
		cons.gridy=0;
		cons.weightx=1;
		cons.weighty=1;
		this.add(panel,cons);
		
		//Sliders
		xRange=new JSlider(JSlider.HORIZONTAL,0,200,20);
		xRange.setMajorTickSpacing(20);
		xRange.setMinorTickSpacing(5);
		xRange.addChangeListener(this);
		xRange.setPaintTicks(true);
		xRange.setPaintLabels(true);
		cons=new GridBagConstraints();
		cons.gridx=0;
		cons.gridy=1;
		cons.fill=GridBagConstraints.HORIZONTAL;
		this.add(xRange,cons);
		
		yRange=new JSlider(JSlider.VERTICAL,0,200,20);
		yRange.setMajorTickSpacing(20);
		yRange.setMinorTickSpacing(5);
		yRange.addChangeListener(this);
		yRange.setPaintTicks(true);
		yRange.setPaintLabels(true);
		cons=new GridBagConstraints();
		cons.gridx=1;
		cons.gridy=0;
		cons.fill=GridBagConstraints.VERTICAL;
		this.add(yRange,cons);
		
		//RadioButtons
		Random generator=new Random();
		long seed0=generator.nextLong(),seed1=generator.nextLong(),seed2=generator.nextLong(),seed3=generator.nextLong();
		
		group=new ButtonGroup();
		JPanel buttonPanel=new JPanel(new GridLayout(4,3));
		buttons=new NoiseMakerButton[] { //Add any other buttons here
		new NoiseMaker1DButton("PI Noise",new PiecewiseInterpolatedIntegerLatticeValueNoiseMaker(new IntegerLatticeValueNoiseMaker(seed0))), //Piecewise Interpolated 1D
				new NoiseMaker1DButton("NNPI 1D",new NearestNeighborPiecewiseInterpolatedIntegerLatticeValueNoiseMaker(new IntegerLatticeValueNoiseMaker(seed0))), //Nearest-Neighbor Interpolated 1D
				new NoiseMaker1DButton("LI 1D",new LinearInterpolatedIntegerLatticeValueNoiseMaker(new IntegerLatticeValueNoiseMaker(seed0))), //Linear Interpolated 1D
				new NoiseMaker1DButton("CI 1D",new CosineInterpolatedIntegerLatticeValueNoiseMaker(new IntegerLatticeValueNoiseMaker(seed0))), //Cosine Interpolated 1D
				new NoiseMaker1DButton("SS 1D, O = 5",new SpectralSynthesisNoiseMaker(new CosineInterpolatedIntegerLatticeValueNoiseMaker(new IntegerLatticeValueNoiseMaker(seed0)),5)), //Spectral Synthesis 1D 
				new NoiseMaker1DButton("POSS 1D, O = 3.5",new PartialOctaveSpectralSynthesisNoiseMaker(new CosineInterpolatedIntegerLatticeValueNoiseMaker(new IntegerLatticeValueNoiseMaker(seed0)),3.5)), //Partial Octave Spectral Synthesis 1D 
				new NoiseMaker1DButton("VOSS 1D, O <= 5",new VariableOctaveSpectralSynthesisNoiseMaker(new CosineInterpolatedIntegerLatticeValueNoiseMaker(new IntegerLatticeValueNoiseMaker(seed0)),new CosineInterpolatedIntegerLatticeValueNoiseMaker(new IntegerLatticeValueNoiseMaker(seed1)),5,5.1)), //Variable Octave Spectral Synthesis 1D
				new NoiseMaker1DButton("T 1D",new TurbulenceNoiseMaker(new SpectralSynthesisNoiseMaker(new CosineInterpolatedIntegerLatticeValueNoiseMaker(new IntegerLatticeValueNoiseMaker(seed0)),5),new CosineInterpolatedIntegerLatticeValueNoiseMaker(new IntegerLatticeValueNoiseMaker(seed1)),2.1)), //Turbulence Noise 1D
				
				new NoiseMaker2DButton("PI 2D",new PiecewiseInterpolatedIntegerLatticeValueNoiseMaker2D(new IntegerLatticeValueNoiseMaker2D(seed0))), //Piecewise Interpolated 2D
				new NoiseMaker2DButton("NNPI 2D",new NearestNeighborPiecewiseInterpolatedIntegerLatticeValueNoiseMaker2D(new IntegerLatticeValueNoiseMaker2D(seed0))), //Nearest-Neighbor Interpolated 2D
				new NoiseMaker2DButton("LI 2D",new LinearInterpolatedIntegerLatticeValueNoiseMaker2D(new IntegerLatticeValueNoiseMaker2D(seed0))), //Linear Interpolated 2D
				new NoiseMaker2DButton("CI 2D",new CosineInterpolatedIntegerLatticeValueNoiseMaker2D(new IntegerLatticeValueNoiseMaker2D(seed0))), //Cosine Interpolated 2D
				new NoiseMaker2DButton("SS 2D, O = 4",new SpectralSynthesisNoiseMaker2D(new CosineInterpolatedIntegerLatticeValueNoiseMaker2D(new IntegerLatticeValueNoiseMaker2D(seed0)),4)), //Spectral Synthesis 2D
				new NoiseMaker2DButton("POSS 2D, O = 3.5",new PartialOctaveSpectralSynthesisNoiseMaker2D(new CosineInterpolatedIntegerLatticeValueNoiseMaker2D(new IntegerLatticeValueNoiseMaker2D(seed0)),3.5)), //Partial Octave Spectral Synthesis 2D
				new NoiseMaker2DButton("VOSS 2D, O <= 8",new VariableOctaveSpectralSynthesisNoiseMaker2D(new CosineInterpolatedIntegerLatticeValueNoiseMaker2D(new IntegerLatticeValueNoiseMaker2D(seed0)),new CosineInterpolatedIntegerLatticeValueNoiseMaker2D(new IntegerLatticeValueNoiseMaker2D(seed1)),8,5.1)), //Variable Octave Spectral Synthesis 2D
				new NoiseMaker2DButton("T 2D",new TurbulenceNoiseMaker2D(new SpectralSynthesisNoiseMaker2D(new CosineInterpolatedIntegerLatticeValueNoiseMaker2D(new IntegerLatticeValueNoiseMaker2D(seed0)),4),new CosineInterpolatedIntegerLatticeValueNoiseMaker2D(new IntegerLatticeValueNoiseMaker2D(seed1)),new CosineInterpolatedIntegerLatticeValueNoiseMaker2D(new IntegerLatticeValueNoiseMaker2D(seed2)),2.1)) //Turbulence Noise 2D
		};
		
		for (int i=0;i<buttons.length;i++) {
			buttons[i].addActionListener(this);
			group.add(buttons[i]);
			buttonPanel.add(buttons[i]);
		}
		cons=new GridBagConstraints();
		cons.gridx=0;
		cons.gridy=2;
		add(buttonPanel,cons);
	}
	
	/**
	 * Used by the {@link JSlider JSliders}
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
		Object src=e.getSource();
		if (src instanceof JSlider) {
			JSlider slider=(JSlider) src;
			if (slider==xRange)
				panel.setXRange(slider.getValue());
			else
				panel.setYRange(slider.getValue());
		}
		panel.repaint();
	}
	
	/**
	 * Used by the {@link NoiseMakerButton NoiseMakerButtons}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src=e.getSource();
		if (src instanceof NoiseMakerButton) {
			if (e.getSource() instanceof NoiseMaker1DButton)
				//1D
				panel.setNoiseMaker(((NoiseMaker1DButton) e.getSource()).n);
			else
				//2D
				panel.setNoiseMaker(((NoiseMaker2DButton) e.getSource()).n);
		}
		panel.repaint();
	}
}
