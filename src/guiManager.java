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
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JSlider;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JProgressBar;
import javax.swing.JTabbedPane;

public class guiManager implements Observer{

	private Globals data;
	private JLabel lblConnectedToDevice;
	private JLabel lblGbRemaining;
	private JLabel lblOfGb;
	private JLabel lblDaysLeft;
	private JLabel lblgbADay;
	private JProgressBar progressBar;
	guiManager(Globals data){
		this.data=data;
	}
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("data update recieved.");
		
		lblGbRemaining.setText(
				data.getTotalRemaining()+" "+data.getRemainingUnit()+" Remaining");

		lblOfGb.setText("Of "+data.getTotalGigs()+" "+data.getAllowanceUnit());

		lblDaysLeft.setText(data.getDaysRemaing()+" Days Left: ");

		
		lblgbADay.setText(data.getGigsDay()+" GB a day");
		
		if(data.isOnNetwork()){
			lblConnectedToDevice.setText("Connected to Device");
			lblGbRemaining.setEnabled(true);
			 lblOfGb.setEnabled(true);
			lblDaysLeft.setEnabled(true);
			lblgbADay.setEnabled(true);
			progressBar.setEnabled(true);
			}else{
				lblGbRemaining.setEnabled(false);
				 lblOfGb.setEnabled(false);
				lblDaysLeft.setEnabled(false);
				lblgbADay.setEnabled(false);
				progressBar.setEnabled(false);
				lblConnectedToDevice.setText("Not Connected to Device");
			}
		
		progressBar.setMaximum(data.getDataForProgressBar()[1]);
		progressBar.setValue(data.getDataForProgressBar()[0]);
	
	}
	
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void createMainGUI(){
		JFrame frame = new JFrame("Configure Settings");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// Display the window.
		frame.pack();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Status", null, panel, null);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.window);
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.NORTH);
		
		JLabel lblCurrentStatus = new JLabel("Current Status:");
		panel_3.add(lblCurrentStatus);
		if(data.isOnNetwork()){
		lblConnectedToDevice = new JLabel("Connected to Device");
		}else{
			lblConnectedToDevice = new JLabel("Not Connected to Device");
		}
		panel_3.add(lblConnectedToDevice);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		progressBar = new JProgressBar();
		progressBar.setMaximum((int)data.getTotalGigs());
		progressBar.setValue((int)data.getTotalRemaining());
		panel_4.add(progressBar, BorderLayout.NORTH);
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5, BorderLayout.SOUTH);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6, BorderLayout.NORTH);
		panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblGbRemaining = new JLabel(
				data.getTotalRemaining()+" "+data.getRemainingUnit()+" Remaining");
		panel_6.add(lblGbRemaining);
		
		lblOfGb = new JLabel("Of "+data.getTotalGigs()+" "+data.getAllowanceUnit());
		panel_6.add(lblOfGb);
		
		JPanel panel_7 = new JPanel();
		panel_5.add(panel_7, BorderLayout.SOUTH);
		
		lblDaysLeft = new JLabel(data.getDaysRemaing()+" Days Left");
		panel_7.add(lblDaysLeft);
		
		lblgbADay = new JLabel("1.6GB a day");
		panel_7.add(lblgbADay);
		
		JPanel panel_8 = new JPanel();
		tabbedPane.addTab("Alarms", null, panel_8, null);
		
		JPanel panel_10 = new JPanel();
		tabbedPane.addTab("Settings", null, panel_10, null);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_10.add(panel_1);
		panel_1.setLayout(new BorderLayout());
		
		JToggleButton tglbtnEnableMonitoring = new JToggleButton("Enable Monitoring");
		tglbtnEnableMonitoring.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tglbtnEnableMonitoring.isSelected()){
				data.setRefeshCycle(false);
				}else{
					data.setRefeshCycle(true);
				}
				
			}
		});
		tglbtnEnableMonitoring.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(tglbtnEnableMonitoring, BorderLayout.WEST);
		
		JPanel panel_11 = new JPanel();
		panel_1.add(panel_11, BorderLayout.CENTER);
		panel_11.setLayout(new BorderLayout(0, 0));
		
		JSlider slider = new JSlider();
		panel_11.add(slider);
		slider.setValue(10);
		slider.setPaintLabels(true);
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(1);
		slider.setMaximum(10);
		slider.setToolTipText("Update Frequency");
		
		JPanel panel_12 = new JPanel();
		panel_11.add(panel_12, BorderLayout.NORTH);
		
		JLabel lblSetUpdateFrequency = new JLabel("Set Update Frequency (Min)");
		panel_12.add(lblSetUpdateFrequency);
		
		JPanel panel_9 = new JPanel();
		frame.getContentPane().add(panel_9, BorderLayout.NORTH);
		
		JLabel lblEeOspreyData = new JLabel("EE Osprey Data Monitor");
		lblEeOspreyData.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		panel_9.add(lblEeOspreyData);
		frame.pack();
		frame.setVisible(true);
	}
	
	
	public  void TrayIconLaunch(){
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
