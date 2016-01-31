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

		
		dataCheckManager dcm = new dataCheckManager();
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GUIlaunch();
				TrayIconLaunch();
			}
		});
	}

	public static void GUIlaunch() {
		JFrame frame = new JFrame("Configure Settings");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JLabel emptyLabel = new JLabel("");
		emptyLabel.setPreferredSize(new Dimension(175, 100));
		frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void TrayIconLaunch(){
		TrayIcon trayIcon = null;
		if (SystemTray.isSupported()) {
			// get the SystemTray instance
			SystemTray tray = SystemTray.getSystemTray();
			// load an image
			URL imageURL = null;
			try {
		
						 imageURL= new URL("http://cdn1.iconfinder.com/data/icons/Hypic_Icon_Pack_by_shlyapnikova/16/forum_16.png");
								
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Image image = Toolkit.getDefaultToolkit().getImage(imageURL);
			// create a action listener to listen for default action executed on
			
			ActionListener listener = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("action");
					// execute default action of the application
					// ...
				}
			};
			
			PopupMenu popup = new PopupMenu();
			// create menu item for the default action
			MenuItem defaultItem = new MenuItem("Do the action");
			defaultItem.addActionListener(listener);
			popup.add(defaultItem);
			/// ... add other items
			// construct a TrayIcon
			trayIcon = new TrayIcon(image, "Tray Demo", popup);
			// set the TrayIcon properties
			trayIcon.addActionListener(listener);
			// ...
			// add the tray image
			try {
				tray.add(trayIcon);
			} catch (AWTException e) {
				System.err.println(e);
			}
			// ...
		} else {
			// disable tray option in your application or
			// perform other actions
			// ...
		}
		// ...
		// some time later
		// the application state has changed - update the image
		if (trayIcon != null) {
			// trayIcon.setImage(updatedImage);
		}

		// create a action listener to listen for default action executed on the
		// tray icon
	}

}
