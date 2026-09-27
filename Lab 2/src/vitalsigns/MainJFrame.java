/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vitalsigns;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 *
 * @author shai8
 */
public class MainJFrame extends JFrame {

    private VitalSignsHistory history;
    private JPanel workArea;
    private JButton btnCreate;
    private JButton btnView;

    public MainJFrame() {

        history = new VitalSignsHistory();

        initializeUI();
    }

    private void initializeUI() {

        setTitle("Vital Signs Application");

        setSize(750, 500);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel navigationPanel = new JPanel();

        navigationPanel.setLayout(new FlowLayout());

        btnCreate = new JButton("Create Vital Signs");

        btnView = new JButton("View Vital Signs");

        navigationPanel.add(btnCreate);

        navigationPanel.add(btnView);

        add(navigationPanel, BorderLayout.NORTH);

        workArea = new JPanel();

        workArea.setLayout(new BorderLayout());

        add(workArea, BorderLayout.CENTER);

        btnCreate.addActionListener(e -> openCreatePanel());

        btnView.addActionListener(e -> openViewPanel());

        openCreatePanel();
    }

    private void openCreatePanel() {

        CreateJPanel createPanel =
                new CreateJPanel(history);

        workArea.removeAll();

        workArea.add(createPanel, BorderLayout.CENTER);

        workArea.revalidate();

        workArea.repaint();
    }

    private void openViewPanel() {

        ViewJPanel viewPanel =
                new ViewJPanel(history);

        workArea.removeAll();

        workArea.add(viewPanel, BorderLayout.CENTER);

        workArea.revalidate();

        workArea.repaint();
    }

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(() -> {

            new MainJFrame().setVisible(true);

        });
    }
}
