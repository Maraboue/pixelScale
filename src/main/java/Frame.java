import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame implements ActionListener {

    static JLabel l = null;
    static JLabel i = null;

    public Frame(){

    }

    // Method for configure and init frame.
    static void initFrame() {

        // frame to contains GUI elements
        JFrame f = new JFrame("Pixel Scale");

        // set the size of the frame
        f.setSize(600, 400);

        // set the frame's visibility
        f.setVisible(true);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // button to open save dialog
        JButton button1 = new JButton("save");

        // button to open open dialog
        JButton button2 = new JButton("open");

        // make an object of the class filechooser
        Frame f1 = new Frame();

        // Add field for target size

        JTextField sizeInput = new JTextField(2);
        i = new JLabel("Target Size");

        // add action listener to the button to capture user
        // response on buttons
        button1.addActionListener(f1);
        button2.addActionListener(f1);

        // make a panel to add the buttons and labels
        JPanel p = new JPanel();

        // add buttons to the frame
        p.add(button1);
        p.add(button2);
        p.add(i);
        p.add(sizeInput);

        // set the label to its initial value
        l = new JLabel("No dir selected");

        // add panel to the frame
        p.add(l);
        f.add(p);
        f.setVisible(true);

    }

    public String getTarget(){
        if(i.getText()==null)
            return null;
        else
            return i.getText();
    }

    public String getRoute(){
            if(l.getText()==null)
                return null;
            else
                return l.getText();
    }

    public void actionPerformed(ActionEvent e) {

        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Choose image directory");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        // disable the "All files" option.

        chooser.setAcceptAllFileFilterUsed(false);
        //
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            l.setText(chooser.getSelectedFile().getAbsolutePath());
            System.out.println("getCurrentDirectory(): "
                    +  chooser.getCurrentDirectory());
            System.out.println("getSelectedFile() : "
                    +  chooser.getSelectedFile());
        }
        else {
            System.out.println("No Selection ");
        }
    }

}

