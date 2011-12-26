import sign.signlink;
import java.net.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.PrintStream;
import java.net.MalformedURLException;
import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;


public class Jframe extends client implements ActionListener {

    private static JMenuItem menuItem;
	public static JFrame frame;
	public static JPanel gamePanel;

	public Jframe(String args[]) {
		super();
		try {
			sign.signlink.startpriv(InetAddress.getByName(server));
			initUI();
		} catch (Exception ex) {
			//ex.printStackTrace();
		}
	}	

			public static void setCursor(int id) {
Toolkit toolkit = Toolkit.getDefaultToolkit();
String location = signlink.findcachedir() + "/Sprites/Cursors/";
Cursor cursor = toolkit.createCustomCursor(toolkit.getImage(location+"CURSOR "+id+".PNG"), new Point(0,0), location+"CURSOR "+id+".PNG");
frame.setCursor(cursor);
}


	public void initUI() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			JPopupMenu.setDefaultLightWeightPopupEnabled(false);
			frame = new JFrame("Warlords of Hell - Economy");
			frame.setLayout(new BorderLayout());
			frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JPanel gamePanel = new JPanel();

			gamePanel.setLayout(new BorderLayout());
			gamePanel.add(this);
			gamePanel.setPreferredSize(new Dimension(765, 503));

			frame.getContentPane().add(gamePanel, BorderLayout.CENTER);
			frame.pack();

			frame.setVisible(true); // can see the client
			frame.setResizable(false); // resizeable frame

			init();
		} catch (Exception e) {
				e.printStackTrace();
		}
	}

	public URL getCodeBase() {
		try {
			return new URL("http://" + server + "/cache");
		} catch (Exception e) {
			return super.getCodeBase();
		}
	}

	public URL getDocumentBase() {
		return getCodeBase();
	}

	public void loadError(String s) {
		System.out.println("loadError: " + s);
	}

	public String getParameter(String key) {
			return "";
	}

	private static void openUpWebSite(String url) {
		Desktop d = Desktop.getDesktop();
		try {
			d.browse(new URI(url)); 	
		} catch (Exception e) {
		}
	}

	public void actionPerformed(ActionEvent evt) {
		String cmd = evt.getActionCommand();
		try {
			if (cmd != null) {
				if (cmd.equalsIgnoreCase("exit")) {
					System.exit(0);
				}
				if (cmd.equalsIgnoreCase("Rune-Server")) {
					openUpWebSite("http://www.rune-server.org/");
				}	
			}
		} catch (Exception e) {
		}
	}
}