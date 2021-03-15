package miniCAD;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.io.Serializable;


public abstract class Shape implements Serializable{
	int x1,y1,x2,y2;
	float brushWidth;
	Color brushColor;
	public void setColor(Color targetColor) {
		this.brushColor=targetColor;
	}
	public void setWidth(Float targetWidthFloat) {
		this.brushWidth=targetWidthFloat;
	}
	abstract void draw(int tx2,int ty2,Graphics G);
	abstract void draw(Graphics G);
	abstract void choose(Graphics G);
	abstract boolean isChosen(int choseX,int choseY);
	
	public void initShape(int tx1,int ty1) {
		this.x1=tx1;
		this.y1=ty1;
	}
	
}


class Line extends Shape{
	@Override
	public void draw(Graphics G) {
		Graphics2D iGraphics2d=(Graphics2D)G;
		Stroke iStroke=new BasicStroke(brushWidth,BasicStroke.CAP_BUTT,BasicStroke.JOIN_ROUND,3.5f,new float[] {1,0,},0f);
		iGraphics2d.setStroke(iStroke);
		iGraphics2d.setColor(brushColor);
		iGraphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		iGraphics2d.drawLine(x1, y1, x2, y2);
	}
	
	@Override
	public void draw(int tx2,int ty2,Graphics G) {
		this.x2=tx2;
		this.y2=ty2;
		Graphics2D iGraphics2d=(Graphics2D)G;
		Stroke iStroke=new BasicStroke(brushWidth,BasicStroke.CAP_BUTT,BasicStroke.JOIN_ROUND,3.5f,new float[] {1,0,},0f);
		iGraphics2d.setStroke(iStroke);
		iGraphics2d.setColor(brushColor);
		iGraphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		iGraphics2d.drawLine(x1, y1, x2, y2);
	}

	@Override
	void choose(Graphics G) {
		Graphics2D iGraphics2d=(Graphics2D)G;
		Stroke iStroke=new BasicStroke(brushWidth*2,BasicStroke.CAP_BUTT,BasicStroke.JOIN_ROUND,3.5f,new float[] {15,10,},0f);
		iGraphics2d.setStroke(iStroke);
		iGraphics2d.setColor(Color.red);
		iGraphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		iGraphics2d.drawRect(Math.min(x1, x2)-1, Math.min(y1, y2)-1, Math.abs(x1-x2)+2, Math.abs(y1-y2)+2);
	}
	
	@Override
	boolean isChosen(int choseX,int choseY) {
		if(choseX<=Math.max(x1, x2)&&choseX>=Math.min(x1, x2)&&choseY<=Math.max(y1, y2)&&choseY>=Math.min(y1, y2)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
}

class Ellipse extends Shape{
	@Override
	public void draw(Graphics G) {
		Graphics2D iGraphics2d=(Graphics2D)G;
		Stroke iStroke=new BasicStroke(brushWidth,BasicStroke.CAP_BUTT,BasicStroke.JOIN_ROUND,3.5f,new float[] {1,0,},0f);
		iGraphics2d.setStroke(iStroke);
		iGraphics2d.setColor(brushColor);
		iGraphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		iGraphics2d.drawOval(Math.min(x1, x2), Math.min(y1, y2),Math.abs(x1-x2),Math.abs(y1-y2));
	}
	
	@Override
	public void draw(int tx2,int ty2,Graphics G) {
		this.x2=tx2;
		this.y2=ty2;
		Graphics2D iGraphics2d=(Graphics2D)G;
		Stroke iStroke=new BasicStroke(brushWidth,BasicStroke.CAP_BUTT,BasicStroke.JOIN_ROUND,3.5f,new float[] {1,0,},0f);
		iGraphics2d.setStroke(iStroke);
		iGraphics2d.setColor(brushColor);
		iGraphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		iGraphics2d.drawOval(Math.min(x1, x2), Math.min(y1, y2),Math.abs(x1-x2),Math.abs(y1-y2));
	}
	@Override
	void choose(Graphics G) {
		Graphics2D iGraphics2d=(Graphics2D)G;
		Stroke iStroke=new BasicStroke(brushWidth*2,BasicStroke.CAP_BUTT,BasicStroke.JOIN_ROUND,0.5f,new float[] {15,10,},0f);
		iGraphics2d.setStroke(iStroke);
		iGraphics2d.setColor(Color.red);
		iGraphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		iGraphics2d.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1-x2), Math.abs(y1-y2));
	}
	@Override
	boolean isChosen(int choseX,int choseY) {
		boolean result;
		if(choseX<=Math.max(x1, x2)&&choseX>=Math.min(x1, x2)&&choseY<=Math.max(y1, y2)&&choseY>=Math.min(y1, y2)) {
			return true;
		}
		else {
			return false;
		}
	}
}

class Rectangle extends Shape{
	@Override
	public void draw(Graphics G) {
		Graphics2D iGraphics2d=(Graphics2D)G;
		Stroke iStroke=new BasicStroke(brushWidth,BasicStroke.CAP_BUTT,BasicStroke.JOIN_ROUND,3.5f,new float[] {1,0,},0f);
		iGraphics2d.setStroke(iStroke);
		iGraphics2d.setColor(brushColor);
		iGraphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		iGraphics2d.drawRect(Math.min(x1, x2), Math.min(y1, y2),Math.abs(x1-x2),Math.abs(y1-y2));
	}
	
	@Override
	public void draw(int tx2,int ty2,Graphics G) {
		this.x2=tx2;
		this.y2=ty2;
		Graphics2D iGraphics2d=(Graphics2D)G;
		Stroke iStroke=new BasicStroke(brushWidth,BasicStroke.CAP_BUTT,BasicStroke.JOIN_ROUND,3.5f,new float[] {1,0,},0f);
		iGraphics2d.setStroke(iStroke);
		iGraphics2d.setColor(brushColor);
		iGraphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		iGraphics2d.drawRect(Math.min(x1, x2), Math.min(y1, y2),Math.abs(x1-x2),Math.abs(y1-y2));
	}
	@Override
	void choose(Graphics G) {
		Graphics2D iGraphics2d=(Graphics2D)G;
		Stroke iStroke=new BasicStroke(brushWidth*2,BasicStroke.CAP_BUTT,BasicStroke.JOIN_ROUND,0.5f,new float[] {15,10,},0f);
		iGraphics2d.setStroke(iStroke);
		iGraphics2d.setColor(Color.red);
		iGraphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		iGraphics2d.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1-x2), Math.abs(y1-y2));
	}
	@Override
	boolean isChosen(int choseX,int choseY) {
		boolean result;
		if(choseX<=Math.max(x1, x2)&&choseX>=Math.min(x1, x2)&&choseY<=Math.max(y1, y2)&&choseY>=Math.min(y1, y2)) {
			return true;
		}
		else {
			return false;
		}
	}
}

class Text extends Shape{
	String textString="";
	
	@Override
	public void draw(Graphics G) {
		int size=1;
		Graphics2D iGraphics2d=(Graphics2D)G;
		Stroke iStroke=new BasicStroke(brushWidth,BasicStroke.CAP_BUTT,BasicStroke.JOIN_ROUND,3.5f,new float[] {1,0,},0f);
		iGraphics2d.setStroke(iStroke);
		iGraphics2d.setColor(brushColor);
		
		FontMetrics fm;
		if(x2 == 0 && y2 == 0){
            G.setFont(new Font ("SansSerif", Font.BOLD, 16));
            fm = G.getFontMetrics();
            x2 = x1 + fm.stringWidth(textString);
            y2 = y1 + fm.getAscent();
        }
        else{
            int setWidth = Math.abs(x2 - x1);

            G.setFont(new Font ("SansSerif", Font.BOLD, size));
            fm = G.getFontMetrics();
            while(fm.stringWidth(textString) < setWidth ){
                size++;
                G.setFont(new Font ("SansSerif", Font.BOLD, size));
                fm = G.getFontMetrics();
            }
        }
		fm=G.getFontMetrics();
		G.drawString(textString, Math.min(x1, x2), Math.min(y1, y2)+fm.getAscent());
	}
	
	@Override
	public void draw(int tx2,int ty2,Graphics G) {}
	@Override
	void choose(Graphics G) {
		Graphics2D iGraphics2d=(Graphics2D)G;
		Stroke iStroke=new BasicStroke(brushWidth*2,BasicStroke.CAP_BUTT,BasicStroke.JOIN_ROUND,0.5f,new float[] {15,10,},0f);
		iGraphics2d.setStroke(iStroke);
		iGraphics2d.setColor(Color.red);
		iGraphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		iGraphics2d.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1-x2), Math.abs(y1-y2));
	}
	@Override
	boolean isChosen(int choseX,int choseY) {
		boolean result;
		if(choseX<=Math.max(x1, x2)&&choseX>=Math.min(x1, x2)&&choseY<=Math.max(y1, y2)&&choseY>=Math.min(y1, y2)) {
			return true;
		}
		else {
			return false;
		}
	}
}