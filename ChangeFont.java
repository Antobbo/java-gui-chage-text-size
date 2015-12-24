/*ChangeFont.java*/
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JScrollPane;
public class ChangeFont extends JFrame{
	private JPanel panel;
	private JButton increment;
	private JButton decrement;
	private JTextArea textArea;
	private BorderLayout borderLayout;	
	private GridLayout gridLayout;
	private Font font;
	private int fontQuota;
	
	
	public ChangeFont(){//constructor
		super("Change font size application");
		panel = new JPanel();
		gridLayout = new GridLayout(1,2,10,0);//create new gridbag 1 row and 2 cols	
		fontQuota = 9;
		textArea = new JTextArea(5,15);
		increment = new JButton("Increment");
		decrement = new JButton("Decrement");		
		borderLayout = new BorderLayout();
		panel.setLayout(gridLayout);//set layout of panel
		
		setLayout(borderLayout);//set layout of JFrame		
		panel.add(increment);//add to the JPanel
		panel.add(decrement);//add to the JPanel
		add(new JScrollPane(textArea), BorderLayout.NORTH);//add scrollbar if necessary and add textarea to JFrame directly
		add(panel, BorderLayout.SOUTH);//add JPanel to JFrame
		font = new Font("Serif", Font.PLAIN,fontQuota);//set new font to serif, plain 9px size
		textArea.setFont(font);//set the new font
		//event handling code
		decrement.addActionListener(new FontResizer(-2));
		increment.addActionListener(new FontResizer(2));
		
		
	}//end of constructor
	private class FontResizer implements ActionListener{//named class
		int delta;//increment/decrement to be added to fontQuota
		public FontResizer(int delta){
			this.delta = delta;
		}
		public void actionPerformed(ActionEvent event){
			fontQuota += delta;
			textArea.setFont(new Font("Serif", Font.PLAIN, fontQuota));  
		}
	}

}//end of ChangeFont class
