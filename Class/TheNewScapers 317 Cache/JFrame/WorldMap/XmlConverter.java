import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;
import javax.swing.*;

public class XmlConverter
    implements ActionListener, KeyListener
{

    private String itemName[];
    private String itemID[];
    private String fileName;
    private JTextArea namePanel;
    private JTextArea idPanel;
    private JTextArea searchPanel;

    public static String getLocationForFile()
    {
        String as[];
        int i;
        as = (new String[] {
            "a:/", "b:/", "c:/", "d:/", "e:/", "f:/", "g:/", "h:/", "i:/", "j:/", 
            "k:/", "l:/", "m:/", "n:/", "o:/", "p:/", "q:/", "r:/", "s:/", "t:/", 
            "v:/", "w:/", "x:/", "y:/", "z:/"
        });
        i = 0;
_L1:
        if(i >= as.length)
        {
            break MISSING_BLOCK_LABEL_192;
        }
        if((new File(as[i])).exists())
        {
            return as[i];
        }
        i++;
          goto _L1
        Exception exception;
        exception;
        exception.printStackTrace();
        return null;
    }

    public static void main(String args[])
    {
        if((new File((new StringBuilder()).append(getLocationForFile()).append("/zee_store/ItemList.zee").toString())).exists())
        {
            new XmlConverter((new StringBuilder()).append(getLocationForFile()).append("/zee_store/ItemList.zee").toString());
        } else
        {
            System.out.println("Please wait, the list is being written.");
            File file = new File((new StringBuilder()).append(getLocationForFile()).append("/zee_store").toString());
            file.mkdir();
            getList();
            System.out.println("Successfully saved item list, please restart the applet.");
            System.exit(-1);
        }
    }

    public XmlConverter(String s)
    {
        itemName = new String[30000];
        itemID = new String[30000];
        File file = new File(s);
        fileName = file.getName();
        try
        {
            DataInputStream datainputstream = new DataInputStream(new FileInputStream(file));
            readStream(datainputstream);
        }
        catch(IOException ioexception)
        {
            System.out.println("Could not buffer file, please report this error to Zee best.");
            System.exit(-1);
        }
        initUI();
    }

    private void readStream(DataInputStream datainputstream)
        throws IOException
    {
        DataInputStream datainputstream1 = datainputstream;
        int i = 0;
        do
        {
            short word0 = datainputstream1.readShort();
            if(word0 != -1)
            {
                itemID[i] = String.valueOf(word0);
                itemName[i] = datainputstream1.readUTF();
                i++;
            } else
            {
                return;
            }
        } while(true);
    }

    private void initUI()
    {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame jframe = new JFrame("525 Item List");
        jframe.setDefaultCloseOperation(2);
        jframe.getContentPane().setLayout(new BorderLayout());
        namePanel = new JTextArea();
        namePanel.setEditable(false);
        idPanel = new JTextArea();
        idPanel.setEditable(false);
        JPanel jpanel = new JPanel(new FlowLayout());
        jpanel.add(namePanel);
        jpanel.add(idPanel);
        JScrollPane jscrollpane = new JScrollPane(jpanel, 22, 31);
        jscrollpane.setPreferredSize(new Dimension(280, 503));
        boolean flag = false;
        String s = "\n";
        for(int i = 0; i < itemName.length && itemName[i] != null; i++)
        {
            if(flag)
            {
                namePanel.append((new StringBuilder()).append(s).append(itemName[i]).toString());
                idPanel.append((new StringBuilder()).append(s).append(itemID[i]).toString());
            } else
            {
                flag = true;
                namePanel.append(itemName[i]);
                idPanel.append(itemID[i]);
            }
        }

        JButton jbutton = new JButton("Search");
        jbutton.addActionListener(this);
        searchPanel = new JTextArea();
        searchPanel.addKeyListener(this);
        searchPanel.setLineWrap(false);
        searchPanel.setRows(1);
        searchPanel.setColumns(9);
        JPanel jpanel1 = new JPanel(new FlowLayout());
        jpanel1.add(searchPanel);
        jpanel1.add(jbutton);
        jframe.getContentPane().add(jscrollpane, "Center");
        jframe.getContentPane().add(jpanel1, "South");
        jframe.pack();
        jframe.setVisible(true);
        searchPanel.requestFocus();
    }

    private void search()
    {
        String s = searchPanel.getText();
        namePanel.setText("");
        idPanel.setText("");
        boolean flag = false;
        String s1 = "\n";
        for(int i = 0; i < itemName.length && itemName[i] != null; i++)
        {
            if(!itemName[i].toLowerCase().contains(s.toLowerCase()))
            {
                continue;
            }
            if(flag)
            {
                namePanel.append((new StringBuilder()).append(s1).append(itemName[i]).toString());
                idPanel.append((new StringBuilder()).append(s1).append(itemID[i]).toString());
            } else
            {
                flag = true;
                namePanel.append(itemName[i]);
                idPanel.append(itemID[i]);
            }
        }

        if(namePanel.getText().equals(""))
        {
            namePanel.setText("No Results Found");
        }
    }

    public void actionPerformed(ActionEvent actionevent)
    {
        search();
    }

    public void keyPressed(KeyEvent keyevent)
    {
        if(keyevent.getKeyCode() == 10)
        {
            search();
        }
    }

    public void keyReleased(KeyEvent keyevent)
    {
        if(keyevent.getKeyCode() == 10)
        {
            searchPanel.setText(searchPanel.getText().replace("\n", ""));
        }
    }

    public void keyTyped(KeyEvent keyevent)
    {
    }

    public static void getList()
    {
        try
        {
            URL url = new URL("http://www.freewebs.com/zeebest/ItemList.dat");
            File file = new File((new StringBuilder()).append(getLocationForFile()).append("/zee_store/ItemList.zee").toString());
            InputStream inputstream = url.openStream();
            FileOutputStream fileoutputstream = new FileOutputStream(file);
            byte abyte0[] = new byte[500];
            for(int i = 0; (i = inputstream.read(abyte0)) != -1;)
            {
                fileoutputstream.write(abyte0, 0, i);
            }

        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
