package UI;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JApplet;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import NoiseMakers.AvolioNoiseMaker;
import NoiseMakers.AvolioNoiseMaker2D;
import NoiseMakers.CosineInterpolatedNoiseMaker;
import NoiseMakers.CosineInterpolatedNoiseMaker2D;
import NoiseMakers.DoublePerlinNoiseMaker;
import NoiseMakers.DoublePerlinNoiseMaker2D;
import NoiseMakers.LinearInterpolatedNoiseMaker;
import NoiseMakers.LinearInterpolatedNoiseMaker2D;
import NoiseMakers.NonInterpolatedNoiseMaker;
import NoiseMakers.NonInterpolatedNoiseMaker2D;
import NoiseMakers.PerlinNoiseMaker;
import NoiseMakers.PerlinNoiseMaker2D;

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
		int[] s= {93,2904,412,301};
		int[][] c= { {193,211,307,149}, {7309,7541,7753,7237}, {15739,14281,15271,15817}, {26497,27997,25633,27259}};
		
		group=new ButtonGroup();
		JPanel buttonPanel=new JPanel(new GridLayout(4,3));
		buttons=new NoiseMakerButton[12];
		
		buttons[0]=new NoiseMaker1DButton("Uninterpolated Noise",new NonInterpolatedNoiseMaker(s[0],c[0][0],c[1][0],c[2][0],c[3][0]));
		buttons[1]=new NoiseMaker1DButton("Linear-Interpolated Noise",new LinearInterpolatedNoiseMaker(s[0],c[0][0],c[1][0],c[2][0],c[3][0]));
		buttons[2]=new NoiseMaker1DButton("Cosine-Interpolated Noise",new CosineInterpolatedNoiseMaker(s[0],c[0][0],c[1][0],c[2][0],c[3][0]));
		buttons[3]=new NoiseMaker1DButton("Perlin Noise, Persistence 5",new PerlinNoiseMaker(s[0],c[0][0],c[1][0],c[2][0],c[3][0],5));
		buttons[4]=new NoiseMaker1DButton("Perlin Noise, Persistence 3.5",new DoublePerlinNoiseMaker(s[0],c[0][0],c[1][0],c[2][0],c[3][0],3.5));
		buttons[5]=new NoiseMaker1DButton("Avolio Noise",new AvolioNoiseMaker(s[0],c[0][0],c[1][0],c[2][0],c[3][0],5,new CosineInterpolatedNoiseMaker(s[1],c[0][1],c[1][1],c[2][1],c[3][1])));
		
		buttons[6]=new NoiseMaker2DButton("2D Uninterpolated Noise",new NonInterpolatedNoiseMaker2D(s[0],c[0][0],c[1][0],c[2][0],c[3][0],c[0][1],c[1][1],c[2][1],c[3][1]));
		buttons[7]=new NoiseMaker2DButton("2D Linear-Interpolated Noise",new LinearInterpolatedNoiseMaker2D(s[0],c[0][0],c[1][0],c[2][0],c[3][0],c[0][1],c[1][1],c[2][1],c[3][1]));
		buttons[8]=new NoiseMaker2DButton("2D Cosine-Interpolated Noise",new CosineInterpolatedNoiseMaker2D(s[0],c[0][0],c[1][0],c[2][0],c[3][0],c[0][1],c[1][1],c[2][1],c[3][1]));
		buttons[9]=new NoiseMaker2DButton("2D Perlin Noise, Persistence 4",new PerlinNoiseMaker2D(s[0],c[0][0],c[1][0],c[2][0],c[3][0],c[0][1],c[1][1],c[2][1],c[3][1],4));
		buttons[10]=new NoiseMaker2DButton("2D Perlin Noise, Persistence 3.5",new DoublePerlinNoiseMaker2D(s[0],c[0][0],c[1][0],c[2][0],c[3][0],c[0][1],c[1][1],c[2][1],c[3][1],3.5));
		buttons[11]=new NoiseMaker2DButton("2D Avolio Noise",new AvolioNoiseMaker2D(s[0],c[0][0],c[1][0],c[2][0],c[3][0],c[0][1],c[1][1],c[2][1],c[3][1],8,new CosineInterpolatedNoiseMaker2D(s[1],c[0][2],c[1][2],c[2][2],c[3][2],c[0][3],c[1][3],c[2][3],c[3][3])));
		
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
