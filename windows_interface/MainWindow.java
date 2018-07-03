package windows_interface

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

/**
 * Start Window
 * @author Grigoriev Ivan
 * @version 1.0
 */

public class MainWindow extends JFrame {
    private JPanel panel;
    private JTextField textFieldEdgeNum;
    private JTextField textFieldVertexNum;
    private JButton getGraphFromFileButton;
    private JButton generateRandomGraphWithButton;

    public MainWindow() {
        super("LETI project");

        this.getContentPane().add(panel);

        getGraphFromFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { getGraphFromFile(); }
        });
    }

    private void getGraphFromFile() {
        JFileChooser file_chooser = new JFileChooser();

        file_chooser.setCurrentDirectory(new File("."));

        file_chooser.setFileFilter(new FileNameExtensionFilter(
                "Text files", "txt"));

        int ret = file_chooser.showOpenDialog(this);
        if (ret != JFileChooser.APPROVE_OPTION) {
            return;
        }
        File file = file_chooser.getSelectedFile();

        try {
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String[] words = sc.nextLine().split("\\s");
                for(String subStr : words) {
                    System.out.print(subStr);
                }
                System.out.print("\n");
            }
            goToGraphVisualizationWindow();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "File is incorrect.",
                    "Format error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    private void goToGraphVisualizationWindow() {
        closeMainWindow();

        GraphVisualizationWindow graphVisualizationWindow = new GraphVisualizationWindow();

        graphVisualizationWindow.pack(); //упаковываем все элементы с нашей формы
        graphVisualizationWindow.setSize(new Dimension(700, 600));
        graphVisualizationWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int locationX = (screenSize.width - 700) / 2;
        int locationY = (screenSize.height - 600) / 2;
        graphVisualizationWindow.setBounds(locationX, locationY, 700, 600);

        graphVisualizationWindow.setVisible(true);
    }

    private void closeMainWindow() {
        removeAll();
        setVisible(false);
        dispose();
    }
}
