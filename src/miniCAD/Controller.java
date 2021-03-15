package miniCAD;

import java.awt.Canvas;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;


public abstract class Controller{
	abstract void mousePress(MyPanel panel,MouseEvent event);
	abstract void mouseRelease(MyPanel panel,MouseEvent event);
	abstract void mouseClick(MyPanel panel,MouseEvent event);
	abstract void mouseMove(MyPanel panel,MouseEvent event);
}

class nopeCtrl extends Controller{
	@Override
	public void mousePress(MyPanel panel,MouseEvent event) {}
	@Override
	public void mouseRelease(MyPanel panel,MouseEvent event) {}
	@Override
	public void mouseClick(MyPanel panel,MouseEvent event) {}
	@Override
	public void mouseMove(MyPanel panel,MouseEvent event) {}
}

class lineCtrl extends Controller{
	@Override
	public void mousePress(MyPanel panel,MouseEvent event) {
		panel.tmpShape=new Line();
		panel.initX=event.getX();
		panel.initY=event.getY();
		panel.tmpShape.setColor(panel.brushColor);
		panel.tmpShape.setWidth(panel.brushWidth);
		panel.tmpShape.initShape(panel.initX, panel.initY);
		
	}
	@Override
	public void mouseRelease(MyPanel panel,MouseEvent event) {
		if(panel.tmpShape.x1==0||panel.tmpShape.x2==0||panel.tmpShape.y1==0||panel.tmpShape.y2==0) {
			panel.tmpShape=null;
		}
		else {
			panel.shapes.add(panel.tmpShape);
			panel.tmpShape=null;
		}
	}
	@Override
	public void mouseClick(MyPanel panel,MouseEvent event) {
		
	}
	@Override
	public void mouseMove(MyPanel panel,MouseEvent event) {
		panel.chooseShape=null;
		panel.tmpX=event.getX();
		panel.tmpY=event.getY();
		panel.repaint();
	}
}

class ellipseCtrl extends Controller{
	@Override
	public void mousePress(MyPanel panel,MouseEvent event) {
		panel.tmpShape=new Ellipse();
		panel.initX=event.getX();
		panel.initY=event.getY();
		panel.tmpShape.setColor(panel.brushColor);
		panel.tmpShape.setWidth(panel.brushWidth);
		panel.tmpShape.initShape(panel.initX, panel.initY);
		
	}
	@Override
	public void mouseRelease(MyPanel panel,MouseEvent event) {
		if(panel.tmpShape.x1==0||panel.tmpShape.x2==0||panel.tmpShape.y1==0||panel.tmpShape.y2==0) {
			panel.tmpShape=null;
		}
		else {
			panel.shapes.add(panel.tmpShape);
			panel.tmpShape=null;
		}
	}
	@Override
	public void mouseClick(MyPanel panel,MouseEvent event) {
		
	}
	@Override
	public void mouseMove(MyPanel panel,MouseEvent event) {
		panel.repaint();
		panel.tmpX=event.getX();
		panel.tmpY=event.getY();
		panel.repaint();
	}
}

class rectangleCtrl extends Controller{
	@Override
	public void mousePress(MyPanel panel,MouseEvent event) {
		panel.tmpShape=new Rectangle();
		panel.initX=event.getX();
		panel.initY=event.getY();
		panel.tmpShape.setColor(panel.brushColor);
		panel.tmpShape.setWidth(panel.brushWidth);
		panel.tmpShape.initShape(panel.initX, panel.initY);
		
	}
	@Override
	public void mouseRelease(MyPanel panel,MouseEvent event) {
		if(panel.tmpShape.x1==0||panel.tmpShape.x2==0||panel.tmpShape.y1==0||panel.tmpShape.y2==0) {
			panel.tmpShape=null;
		}
		else {
			panel.shapes.add(panel.tmpShape);
			panel.tmpShape=null;
		}
	}
	@Override
	public void mouseClick(MyPanel panel,MouseEvent event) {
		
	}
	@Override
	public void mouseMove(MyPanel panel,MouseEvent event) {
		panel.repaint();
		panel.tmpX=event.getX();
		panel.tmpY=event.getY();
		panel.repaint();
	}
}

class textCtrl extends Controller{
	@Override
	public void mousePress(MyPanel panel,MouseEvent event) {}
	@Override
	public void mouseRelease(MyPanel panel,MouseEvent event) {}
	@Override
	public void mouseClick(MyPanel panel,MouseEvent event) {
		panel.chooseShape=null;
		panel.initX=event.getX();
		panel.initY=event.getY();
		panel.tmpShape=new Text();
		panel.tmpShape.setColor(panel.brushColor);
		panel.tmpShape.setWidth(panel.brushWidth);
		panel.tmpShape.initShape(panel.initX, panel.initY);
		JFrame textFrame = new JFrame("INPUT window:");
        textFrame.setLayout(null);
        textFrame.setSize(400, 150);
        // Center the frame
        textFrame.setLocationRelativeTo(null);
        textFrame.setResizable(false);
        JTextField textField = new JTextField();
        textField.setSize(300,30);
        textField.setLocation(50,20);

        JButton btnOK = new JButton("OK");
        btnOK.setSize(50,30);
        btnOK.setLocation(175,80);
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                ((Text)panel.tmpShape).textString = text;
                panel.shapes.add(panel.tmpShape);
                panel.tmpShape = null;
                textFrame.dispose();
                panel.repaint();
            }
        });

        textFrame.add(textField);
        textFrame.add(btnOK);
        textFrame.setVisible(true);
				
	}
	@Override
	public void mouseMove(MyPanel panel,MouseEvent event) {}
	
}

class chooseCtrl extends Controller{
	
	boolean hasShape=false;
	@Override
	public void mousePress(MyPanel panel,MouseEvent event) {
	}
	@Override
	public void mouseRelease(MyPanel panel,MouseEvent event) {

	}
	@Override
	public void mouseClick(MyPanel panel,MouseEvent event) {
		panel.tmpShape=null;
		Shape clickShape;
		//选择画布上合适的shape
		//在选中范围内最新创建的形状
		Shape targetShape=null;
		for(Shape iShape:panel.shapes) {
			if(iShape.isChosen(event.getX(), event.getY())) {
				targetShape=iShape;
			}
		}
		if(targetShape!=null) {
			panel.chooseShape=targetShape;
			hasShape=true;
		}else {
			panel.chooseShape=null;
		}
		panel.repaint();
	}
	@Override
	public void mouseMove(MyPanel panel,MouseEvent event) {
		if(hasShape) {
			panel.tmpX=event.getX();
			panel.tmpY=event.getY();
			int width=panel.chooseShape.x2-panel.chooseShape.x1;
			int height=panel.chooseShape.y2-panel.chooseShape.y1;
			panel.chooseShape.initShape(event.getX(), event.getY());
			panel.chooseShape.x2=event.getX()+width;
			panel.chooseShape.y2=event.getY()+height;
			panel.repaint();
		}
	}
}

class resizeCtrl extends chooseCtrl{
	@Override
	public void mouseMove(MyPanel panel,MouseEvent event) {
		if(hasShape) {
			panel.chooseShape.x1=event.getX();
			panel.chooseShape.y1=event.getY();
			panel.repaint();
		}
	}
}

