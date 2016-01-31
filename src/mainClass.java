import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class mainClass {

	public static void main(String[] args) throws AWTException, MalformedURLException {

	
		Globals data = new Globals();
		regex.createRegex(data);
		dataCheckManager dcm = new dataCheckManager(data);
		dcm.start();
		guiManager guiM = new guiManager(data);
		data.addObserver(guiM);
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				guiM.createMainGUI();
				guiM.TrayIconLaunch();
			}
		});
	}

	
	
	

}
