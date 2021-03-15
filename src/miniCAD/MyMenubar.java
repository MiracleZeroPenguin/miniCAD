package miniCAD;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class MyMenubar extends JMenuBar{
	JMenu fileList=new JMenu("FILE");
	JMenuItem openBtn=new JMenuItem("OPEN");
	JMenuItem saveBtn=new JMenuItem("SAVE");
	public MyMenubar(MyPanel panel) {
		fileList.setSize(100, 30);
		add(fileList);
		fileList.add(openBtn);
		fileList.add(saveBtn);
		openBtn.addActionListener(new ActionListener() {
			//´ò¿ª
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser openChooser=new JFileChooser("D://");
				int getValue=openChooser.showOpenDialog(openChooser);
				String fileNameString="";
				if(getValue==JFileChooser.APPROVE_OPTION) {
					fileNameString = openChooser.getSelectedFile().getAbsolutePath();
				}
				if(!fileNameString.isEmpty()) {
					try {
						ObjectInputStream inputShapeStream=new ObjectInputStream(new FileInputStream(fileNameString));
						panel.shapes=(ArrayList<Shape>)inputShapeStream.readObject();
						panel.repaint();
					} 
					catch (Exception error) {
						error.printStackTrace();
					}
				}
			}
		});
		saveBtn.addActionListener(new ActionListener() {
			//±£´æ
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser saveChooser=new JFileChooser("D://");
				saveChooser.showSaveDialog(null);
				File file=saveChooser.getSelectedFile();
				String fileNameString=file.getPath();
				if(!fileNameString.isEmpty()) {
					try {
						ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileNameString));
                        out.writeObject(panel.shapes);
                        out.close();
					}
					catch (Exception error) {
						error.printStackTrace();
					}
				}
			}
		});
		
	}
}