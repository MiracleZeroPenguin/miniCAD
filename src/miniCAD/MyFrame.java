package miniCAD;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class MyFrame extends JFrame {
	private MyPanel panel=new MyPanel();
	private MyMenubar menubar=new MyMenubar(panel);
	private MyTool tool=new MyTool(panel);

	/**
	 * Create the frame.
	 */
	public MyFrame() {
		
		setTitle("MiniCAD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		panel.setSize(675, 542);
		panel.setLocation(0, 0);
		getContentPane().add(panel);
		
		setJMenuBar(menubar);
		
		tool.setSize(100, 542);
		tool.setLocation(678,0);
		getContentPane().add(tool);
	}
}
