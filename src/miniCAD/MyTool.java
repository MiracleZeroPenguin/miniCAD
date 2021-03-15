package miniCAD;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class MyTool extends JPanel {
	MyPanel panel;

	JButton btnLine = new JButton("Line");
	JButton btnEllipse = new JButton("Ellipse");
	JButton btnRectangle = new JButton("Rectangle");
	JButton btnText = new JButton("Text");
	JButton btnChoose = new JButton("Choose");
	JButton btnResize = new JButton("Resize");
	JButton btnDelete = new JButton("Delete");
	JButton btnRed = new JButton("");
	JButton btnPink = new JButton("");
	JButton btnOrange = new JButton("");
	JButton btnMagenta = new JButton("");
	JButton btnGreen = new JButton("");
	JButton btnYellow = new JButton("");
	JButton btnGray = new JButton("");
	JButton btnBlue = new JButton("");
	JButton btnCyan = new JButton("");
	JButton btnBlack = new JButton("");
	JRadioButton rdbtnThin = new JRadioButton("Thin");
	JRadioButton rdbtnMid = new JRadioButton("Middle");
	JRadioButton rdbtnThick = new JRadioButton("Thick");
	private final JButton btnSetWidth = new JButton("Set");
	
	/**
	 * Create the panel.
	 */
	public MyTool(MyPanel panel) {
		super();
		this.panel=panel;
		init();//初始化工具台
		
		btnLine.addActionListener(new ActionListener() {
			//画线
			@Override
			public void actionPerformed(ActionEvent e) {
				MyTool.this.panel.tmpController=new lineCtrl();
			}
		});
		btnEllipse.addActionListener(new ActionListener() {
			//画圆
			@Override
			public void actionPerformed(ActionEvent e) {
				MyTool.this.panel.tmpController=new ellipseCtrl();
			}
		});
		btnRectangle.addActionListener(new ActionListener() {
			//画矩形
			@Override
			public void actionPerformed(ActionEvent e) {
				MyTool.this.panel.tmpController=new rectangleCtrl();
			}
		});
		btnText.addActionListener(new ActionListener() {
			//文本
			@Override
			public void actionPerformed(ActionEvent e) {
				MyTool.this.panel.tmpController=new textCtrl();
				
			}
		});
		
		btnChoose.addActionListener(new ActionListener() {
			//选中
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MyTool.this.panel.tmpController=new chooseCtrl();
			}
		});
		
		btnRed.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MyTool.this.panel.brushColor=Color.red;
				if(MyTool.this.panel.chooseShape!=null) {
					MyTool.this.panel.chooseShape.brushColor=Color.red;
					repaint();
				}
			}
		});
		btnPink.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MyTool.this.panel.brushColor=Color.pink;
				if(MyTool.this.panel.chooseShape!=null) {
					MyTool.this.panel.chooseShape.brushColor=Color.pink;
					repaint();
				}
			}
		});
		btnOrange.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MyTool.this.panel.brushColor=Color.orange;
				if(MyTool.this.panel.chooseShape!=null) {
					MyTool.this.panel.chooseShape.brushColor=Color.orange;
					repaint();
				}
			}
		});
		btnMagenta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MyTool.this.panel.brushColor=Color.magenta;
				if(MyTool.this.panel.chooseShape!=null) {
					MyTool.this.panel.chooseShape.brushColor=Color.magenta;
					repaint();
				}
			}
		});
		btnGreen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MyTool.this.panel.brushColor=Color.green;
				if(MyTool.this.panel.chooseShape!=null) {
					MyTool.this.panel.chooseShape.brushColor=Color.green;
					repaint();
				}
			}
		});
		btnYellow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MyTool.this.panel.brushColor=Color.yellow;
				if(MyTool.this.panel.chooseShape!=null) {
					MyTool.this.panel.chooseShape.brushColor=Color.yellow;
					repaint();
				}
			}
		});
		btnGray.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MyTool.this.panel.brushColor=Color.gray;
				if(MyTool.this.panel.chooseShape!=null) {
					MyTool.this.panel.chooseShape.brushColor=Color.gray;
					repaint();
				}
			}
		});
		btnBlue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MyTool.this.panel.brushColor=Color.blue;
				if(MyTool.this.panel.chooseShape!=null) {
					MyTool.this.panel.chooseShape.brushColor=Color.blue;
					repaint();
				}
			}
		});
		btnCyan.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MyTool.this.panel.brushColor=Color.cyan;
				if(MyTool.this.panel.chooseShape!=null) {
					MyTool.this.panel.chooseShape.brushColor=Color.cyan;
					repaint();
				}
			}
		});
		btnBlack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MyTool.this.panel.brushColor=Color.black;
				if(MyTool.this.panel.chooseShape!=null) {
					MyTool.this.panel.chooseShape.brushColor=Color.black;
					repaint();
				}
			}
		});
		rdbtnThick.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(rdbtnThick.isSelected()) {
					rdbtnMid.setSelected(false);
					rdbtnThin.setSelected(false);
					MyTool.this.panel.brushWidth=5.0f;
				}
			}
		});
		rdbtnThin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(rdbtnThin.isSelected()) {
					rdbtnMid.setSelected(false);
					rdbtnThick.setSelected(false);
					MyTool.this.panel.brushWidth=1.0f;
				}
			}
		});
		rdbtnMid.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(rdbtnMid.isSelected()) {
					rdbtnThick.setSelected(false);
					rdbtnThin.setSelected(false);
					MyTool.this.panel.brushWidth=3.0f;
				}
			}
		});
		btnSetWidth.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(MyTool.this.panel.chooseShape!=null) {
					if(rdbtnThin.isSelected()) {
						MyTool.this.panel.chooseShape.brushWidth=1.0f;
					}else if(rdbtnMid.isSelected()) {
						MyTool.this.panel.chooseShape.brushWidth=3.0f;
					}else {
						MyTool.this.panel.chooseShape.brushWidth=5.0f;
					}
					repaint();
				}
			}
		});
		btnResize.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MyTool.this.panel.tmpController=new resizeCtrl();
			}
		});
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(MyTool.this.panel.chooseShape!=null) {
					
					for(int i=0;i<MyTool.this.panel.shapes.size();i++) {
						
						if(MyTool.this.panel.shapes.get(i)==MyTool.this.panel.chooseShape) {
							MyTool.this.panel.shapes.remove(i);
							repaint();
							break;
						}
					}
				}
			}
		});
	}
	private void init() {
		setBackground(Color.WHITE);
		setSize(100, 542);
		setLayout(null);
		rdbtnThin.setSelected(true);
		
		btnLine.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		btnLine.setBounds(0, 0, 99, 35);
		add(btnLine);
		
		btnEllipse.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		btnEllipse.setBounds(0, 35, 99, 35);
		add(btnEllipse);
		
		btnRectangle.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		btnRectangle.setBounds(0, 70, 99, 35);
		add(btnRectangle);
		
		btnText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		btnText.setBounds(0, 105, 99, 35);
		add(btnText);
		
		btnChoose.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		btnChoose.setBounds(0, 426, 99, 35);
		add(btnChoose);
		
		btnResize.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		btnResize.setBounds(0, 461, 99, 35);
		add(btnResize);
		
		btnDelete.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		btnDelete.setBounds(0, 496, 99, 35);
		add(btnDelete);
		
		btnRed.setBounds(0, 175, 33, 33);
		btnRed.setBackground(Color.red);
		add(btnRed);
		
		btnPink.setBackground(Color.PINK);
		btnPink.setBounds(33, 175, 33, 33);
		add(btnPink);
		
		btnOrange.setBackground(Color.ORANGE);
		btnOrange.setBounds(66, 175, 33, 33);
		add(btnOrange);
		
		btnMagenta.setBackground(Color.MAGENTA);
		btnMagenta.setForeground(Color.BLACK);
		btnMagenta.setBounds(66, 207, 33, 33);
		add(btnMagenta);
		
		btnGreen.setBackground(Color.GREEN);
		btnGreen.setForeground(Color.GREEN);
		btnGreen.setBounds(33, 207, 33, 33);
		add(btnGreen);
		
		btnYellow.setBackground(Color.YELLOW);
		btnYellow.setBounds(0, 207, 33, 33);
		add(btnYellow);
		
		btnGray.setBackground(Color.LIGHT_GRAY);
		btnGray.setBounds(66, 238, 33, 33);
		add(btnGray);
		
		btnBlue.setBackground(Color.BLUE);
		btnBlue.setBounds(33, 238, 33, 33);
		add(btnBlue);
		
		btnCyan.setBackground(Color.CYAN);
		btnCyan.setBounds(0, 238, 33, 33);
		add(btnCyan);
		
		btnBlack.setBackground(Color.BLACK);
		btnBlack.setBounds(0, 140, 99, 35);
		add(btnBlack);
		
		
		rdbtnThin.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		rdbtnThin.setBackground(Color.WHITE);
		rdbtnThin.setBounds(0, 290, 99, 23);
		add(rdbtnThin);
		
		rdbtnMid.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		rdbtnMid.setBackground(Color.WHITE);
		rdbtnMid.setBounds(0, 316, 99, 23);
		add(rdbtnMid);
		
		rdbtnThick.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		rdbtnThick.setBackground(Color.WHITE);
		rdbtnThick.setBounds(0, 342, 99, 23);
		add(rdbtnThick);
		btnSetWidth.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		btnSetWidth.setBounds(0, 372, 99, 35);
		
		add(btnSetWidth);
		
	}
}
