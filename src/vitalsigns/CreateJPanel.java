/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vitalsigns;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author shai8
 */
public class CreateJPanel extends JPanel {

    private VitalSignsHistory history;

    private JTextField txtDate;
    private JTextField txtTemperature;
    private JTextField txtBloodPressure;
    private JTextField txtPulse;

    private JButton btnSave;

    public CreateJPanel(VitalSignsHistory history) {

        this.history = history;

        initializeUI();
    }

    private void initializeUI() {

        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Date
        gbc.gridx = 0;
        gbc.gridy = 0;

        add(new JLabel("Date:"), gbc);

        txtDate = new JTextField(15);

        gbc.gridx = 1;

        add(txtDate, gbc);

        // Temperature
        gbc.gridx = 0;
        gbc.gridy = 1;

        add(new JLabel("Temperature:"), gbc);

        txtTemperature = new JTextField(15);

        gbc.gridx = 1;

        add(txtTemperature, gbc);

        // Blood Pressure
        gbc.gridx = 0;
        gbc.gridy = 2;

        add(new JLabel("Blood Pressure:"), gbc);

        txtBloodPressure = new JTextField(15);

        gbc.gridx = 1;

        add(txtBloodPressure, gbc);

        // Pulse
        gbc.gridx = 0;
        gbc.gridy = 3;

        add(new JLabel("Pulse:"), gbc);

        txtPulse = new JTextField(15);

        gbc.gridx = 1;

        add(txtPulse, gbc);

        // Save button
        btnSave = new JButton("Save");

        gbc.gridx = 1;
        gbc.gridy = 4;

        add(btnSave, gbc);

        btnSave.addActionListener(e -> saveVitals());
    }

    private void saveVitals() {

        try {

            String date = txtDate.getText();

            float temperature =
                    Float.parseFloat(txtTemperature.getText());

            double bloodPressure =
                    Double.parseDouble(txtBloodPressure.getText());

            int pulse =
                    Integer.parseInt(txtPulse.getText());

            if (date.trim().isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter a date."
                );

                return;
            }

            VitalSigns vitalSigns =
                    history.addNewVitals();

            vitalSigns.setDate(date);
            vitalSigns.setTemperature(temperature);
            vitalSigns.setBloodPressure(bloodPressure);
            vitalSigns.setPulse(pulse);

            JOptionPane.showMessageDialog(
                    this,
                    "Vital Signs Saved Successfully!"
            );

            clearFields();

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter valid numbers for temperature, blood pressure, and pulse."
            );
        }
    }

    private void clearFields() {

        txtDate.setText("");
        txtTemperature.setText("");
        txtBloodPressure.setText("");
        txtPulse.setText("");
    }
}
