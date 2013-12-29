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

@SuppressWarnings("serial")
public class NoiseTesterApplet extends JApplet implements ChangeListener,ActionListener {
	private JSlider xRange,yRange;
	private NoiseMakerButton[] buttons;
	private SwitchableNoisePanel panel;
	private ButtonGroup group;
	
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
		long seed0=generator.nextLong(),seed1=generator.nextLong();
		
		group=new ButtonGroup();
		JPanel buttonPanel=new JPanel(new GridLayout(4,3));
		buttons=new NoiseMakerButton[12];
		
		buttons[0]=new NoiseMaker1DButton("Uninterpolated Noise",new NonInterpolatedNoiseMaker(seed0));
		buttons[1]=new NoiseMaker1DButton("Linear-Interpolated Noise",new LinearInterpolatedNoiseMaker(seed0));
		buttons[2]=new NoiseMaker1DButton("Cosine-Interpolated Noise",new CosineInterpolatedNoiseMaker(seed0));
		buttons[3]=new NoiseMaker1DButton("Perlin Noise, Persistence 5",new PerlinNoiseMaker(seed0,5));
		buttons[4]=new NoiseMaker1DButton("Perlin Noise, Persistence 3.5",new DoublePerlinNoiseMaker(seed0,3.5));
		buttons[5]=new NoiseMaker1DButton("Avolio Noise",new AvolioNoiseMaker(seed0,5,5,new CosineInterpolatedNoiseMaker(seed1)));
		
		buttons[6]=new NoiseMaker2DButton("2D Uninterpolated Noise",new NonInterpolatedNoiseMaker2D(seed0));
		buttons[7]=new NoiseMaker2DButton("2D Linear-Interpolated Noise",new LinearInterpolatedNoiseMaker2D(seed0));
		buttons[8]=new NoiseMaker2DButton("2D Cosine-Interpolated Noise",new CosineInterpolatedNoiseMaker2D(seed0));
		buttons[9]=new NoiseMaker2DButton("2D Perlin Noise, Persistence 4",new PerlinNoiseMaker2D(seed0,4));
		buttons[10]=new NoiseMaker2DButton("2D Perlin Noise, Persistence 3.5",new DoublePerlinNoiseMaker2D(seed0,3.5));
		buttons[11]=new NoiseMaker2DButton("2D Avolio Noise",new AvolioNoiseMaker2D(seed0,8,5,new CosineInterpolatedNoiseMaker2D(seed1)));
		
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
