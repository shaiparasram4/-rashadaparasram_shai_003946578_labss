/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vitalsigns;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author shai8
 */
public class ViewJPanel extends JPanel {

    private VitalSignsHistory history;

    private JTable tableVitals;
    private DefaultTableModel tableModel;

    private JButton btnView;
    private JButton btnDelete;

    public ViewJPanel(VitalSignsHistory history) {

        this.history = history;

        initializeUI();

        populateTable();
    }

    private void initializeUI() {

        setLayout(new BorderLayout());

        String[] columns = {
            "Date",
            "Temperature",
            "Blood Pressure",
            "Pulse"
        };

        tableModel = new DefaultTableModel(columns, 0) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tableVitals = new JTable(tableModel);

        JScrollPane scrollPane =
                new JScrollPane(tableVitals);

        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel =
                new JPanel(new FlowLayout());

        btnView = new JButton("View");

        btnDelete = new JButton("Delete");

        buttonPanel.add(btnView);

        buttonPanel.add(btnDelete);

        add(buttonPanel, BorderLayout.SOUTH);

        btnView.addActionListener(
                e -> viewSelectedVitals()
        );

        btnDelete.addActionListener(
                e -> deleteSelectedVitals()
        );
    }

    private void populateTable() {

        tableModel.setRowCount(0);

        for (VitalSigns vitalSigns
                : history.getHistory()) {

            Object[] row = new Object[4];

            row[0] = vitalSigns.getDate();
            row[1] = vitalSigns.getTemperature();
            row[2] = vitalSigns.getBloodPressure();
            row[3] = vitalSigns.getPulse();

            tableModel.addRow(row);
        }
    }

    private void viewSelectedVitals() {

        int selectedRow =
                tableVitals.getSelectedRow();

        if (selectedRow < 0) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please select a row to view."
            );

            return;
        }

        VitalSigns selectedVitals =
                history.getHistory().get(selectedRow);

        String message =
                "Date: "
                + selectedVitals.getDate()
                + "\nTemperature: "
                + selectedVitals.getTemperature()
                + "\nBlood Pressure: "
                + selectedVitals.getBloodPressure()
                + "\nPulse: "
                + selectedVitals.getPulse();

        JOptionPane.showMessageDialog(
                this,
                message,
                "Vital Signs Details",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    private void deleteSelectedVitals() {

        int selectedRow =
                tableVitals.getSelectedRow();

        if (selectedRow < 0) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please select a row to delete."
            );

            return;
        }

        int choice =
                JOptionPane.showConfirmDialog(
                        this,
                        "Are you sure you want to delete this record?",
                        "Confirm Delete",
                        JOptionPane.YES_NO_OPTION
                );

        if (choice == JOptionPane.YES_OPTION) {

            VitalSigns selectedVitals =
                    history.getHistory().get(selectedRow);

            history.deleteVitals(selectedVitals);

            populateTable();

            JOptionPane.showMessageDialog(
                    this,
                    "Vital Signs record deleted."
            );
        }
    }
}