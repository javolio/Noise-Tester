package UI;

import java.awt.Dimension;
import javax.swing.JFrame;

public class NoiseTester {
	public static void main(String[] args) {
		JFrame frame=new JFrame("Noise Tester");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(600,700));
		frame.setContentPane(new NoiseTesterApplet());
		frame.pack();
		frame.setVisible(true);
	}
	
}
