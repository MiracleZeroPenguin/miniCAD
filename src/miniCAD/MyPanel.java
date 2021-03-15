package miniCAD;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.JPanel;

public class MyPanel extends JPanel {
	ArrayList<Shape> shapes=new ArrayList<>();
	
	Shape tmpShape;
	Shape chooseShape;
	int initX,initY;
	int tmpX,tmpY;
	Color brushColor=Color.black;
	float brushWidth=1.0f;
	Controller tmpController=new nopeCtrl();
	/**
	 * Create the panel.
	 */
	public MyPanel() {
		setBackground(Color.WHITE);
		tmpShape=null;
		chooseShape=null;
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent iEvent) {
				tmpController.mousePress(MyPanel.this, iEvent);
			}
			@Override
			public void mouseReleased(MouseEvent iEvent) {
				tmpController.mouseRelease(MyPanel.this, iEvent);
			}
			@Override
			public void mouseClicked(MouseEvent iEvent) {
				tmpController.mouseClick(MyPanel.this, iEvent);
			}
			
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent iEvent) {
				tmpController.mouseMove(MyPanel.this, iEvent);
			}
		});
	}
	
	@Override
	public void paint(Graphics iGraphics) {
		super.paint(iGraphics);
		for(Shape iShape:shapes) {
			iShape.draw(iGraphics);
			if(iShape==chooseShape) {
				iShape.choose(iGraphics);
			}
		}
		if(tmpShape!=null) {
			tmpShape.draw(tmpX, tmpY, iGraphics);
		}
	}

}
