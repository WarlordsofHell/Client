
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Toolkit;
import sign.signlink;
import java.awt.Dimension;
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

public final class RSFrame extends Frame {



	private static final long serialVersionUID = -3475655830813504073L;
	public RSFrame(RSApplet rsapplet, int width, int height, boolean undecorative, boolean resizable, boolean useMinimum) {
		toolkit = Toolkit.getDefaultToolkit();
        screenSize = toolkit.getScreenSize();
        screenWidth = (int)screenSize.getWidth();
        screenHeight = (int)screenSize.getHeight();
		rsApplet = rsapplet;
		setTitle("Warlords of Hell - Economy - Real Fullscreen");
		setResizable(resizable);
		setUndecorated(undecorative);
		setVisible(true);
		Dimension dimension = new Dimension(780, 600);
		if(useMinimum)
			setMinimumSize(dimension);
		Insets insets = this.getInsets();
		setSize(width + insets.left + insets.right, height + insets.top + insets.bottom);//28
		setLocation((screenWidth - width) / 2, (screenHeight - height) / 2);
		requestFocus();
		toFront();
	}
	

	
	public RSFrame(RSApplet rsapplet, int width, int height) {
		this(rsapplet, width, height, false, false, false);
	}

	public Graphics getGraphics() {
		Graphics g = super.getGraphics();
		Insets insets = this.getInsets();
		g.translate(insets.left ,insets.top);
		return g;
	}
	
	public int getFrameWidth()
    {
        Insets insets = getInsets();
        return getWidth() - (insets.left + insets.right);
    }

    public int getFrameHeight()
    {
        Insets insets = getInsets();
        return getHeight() - (insets.top + insets.bottom);
    }

	public void update(Graphics g)
	{
		rsApplet.update(g);
	}

	public void paint(Graphics g)
	{
		rsApplet.paint(g);
	}

	private final RSApplet rsApplet;
	public static RSFrame frame;
	public Toolkit toolkit = Toolkit.getDefaultToolkit();
	public Dimension screenSize = toolkit.getScreenSize();
	public int screenWidth = (int)screenSize.getWidth();
	public int screenHeight = (int)screenSize.getHeight();
}
