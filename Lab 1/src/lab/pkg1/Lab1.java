/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab.pkg1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;




/**
 *Shai Rashada-Parasram
 * INFO 5100
 * 9/17/2026
 * Creates a Swing application for entering and viewing a product.
 * @author shai8
 */


public class Lab1 extends JFrame {

    private Product product;

    private final Color DARK_RED = new Color(153, 0, 0);
    private final Color LIGHT_RED = new Color(255, 235, 235);

    private JTextField nameField;
    private JTextField descriptionField;
    private JTextField availNumField;
    private JTextField priceField;

    private JTextField manufactureStreetField;
    private JTextField manufactureUnitField;
    private JTextField manufactureCityField;
    private JTextField manufactureZipField;

    private JTextField shippingStreetField;
    private JTextField shippingUnitField;
    private JTextField shippingCityField;
    private JTextField shippingZipField;

    private JPanel displayPanel;

    /**
     * Sets up the main application window.
     */
    public Lab1() {

        setTitle("Product Application");
        setSize(1100, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel inputPanel = createInputPanel();

        displayPanel = new JPanel(new BorderLayout());
        displayPanel.setBackground(LIGHT_RED);

        JLabel welcomeLabel = new JLabel(
            "Product details will appear here.",
            SwingConstants.CENTER
        );

        welcomeLabel.setForeground(DARK_RED);
        welcomeLabel.setFont(
            new Font("Arial", Font.BOLD, 18)
        );

        displayPanel.add(welcomeLabel, BorderLayout.CENTER);

        // The left side collects input and the right side displays it.
        JSplitPane splitPane = new JSplitPane(
            JSplitPane.HORIZONTAL_SPLIT,
            new JScrollPane(inputPanel),
            new JScrollPane(displayPanel)
        );

        splitPane.setDividerLocation(480);
        splitPane.setResizeWeight(0.45);

        add(splitPane);
    }

    /**
     * Creates the form for entering product information.
     */
    private JPanel createInputPanel() {

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBackground(LIGHT_RED);

        panel.setBorder(
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );

        JLabel title = new JLabel("Create Product");

        title.setForeground(DARK_RED);
        title.setFont(new Font("Arial", Font.BOLD, 22));

        panel.add(title, BorderLayout.NORTH);

        JPanel fields = new JPanel(
            new GridLayout(15, 2, 8, 8)
        );

        fields.setBackground(LIGHT_RED);

        nameField = new JTextField();
        descriptionField = new JTextField();
        availNumField = new JTextField();
        priceField = new JTextField();

        manufactureStreetField = new JTextField();
        manufactureUnitField = new JTextField();
        manufactureCityField = new JTextField();
        manufactureZipField = new JTextField();

        shippingStreetField = new JTextField();
        shippingUnitField = new JTextField();
        shippingCityField = new JTextField();
        shippingZipField = new JTextField();

        // Product details.
        addField(fields, "Product Name:", nameField);
        addField(fields, "Description:", descriptionField);
        addField(fields, "Available Quantity:", availNumField);
        addField(fields, "Price:", priceField);

        // Manufacturing address.
        addSection(fields, "Manufacturing Address");

        addField(fields, "Street Name:", manufactureStreetField);
        addField(fields, "Unit Number:", manufactureUnitField);
        addField(fields, "City:", manufactureCityField);
        addField(fields, "ZIP Code:", manufactureZipField);

        // Shipping address.
        addSection(fields, "Shipping Address");

        addField(fields, "Street Name:", shippingStreetField);
        addField(fields, "Unit Number:", shippingUnitField);
        addField(fields, "City:", shippingCityField);
        addField(fields, "ZIP Code:", shippingZipField);

        panel.add(fields, BorderLayout.CENTER);

        JButton saveButton = new JButton("Create Product");

        saveButton.setBackground(DARK_RED);
        saveButton.setForeground(Color.WHITE);
        saveButton.setFont(new Font("Arial", Font.BOLD, 14));
        saveButton.setFocusPainted(false);
        saveButton.setOpaque(true);
        saveButton.setBorderPainted(false);

        saveButton.addActionListener(e -> saveProduct());

        panel.add(saveButton, BorderLayout.SOUTH);

        return panel;
    }

    /**
     * Adds a label and its text field to a form.
     */
    private void addField(JPanel panel, String label,
                          JTextField field) {

        panel.add(new JLabel(label));
        panel.add(field);
    }

    /**
     * Adds a heading to separate address information.
     */
    private void addSection(JPanel panel, String heading) {

        JLabel label = new JLabel(heading);

        label.setForeground(DARK_RED);
        label.setFont(new Font("Arial", Font.BOLD, 15));

        panel.add(label);
        panel.add(new JLabel(""));
    }

    /**
     * Checks that a required text field is not empty.
     */
    private String required(JTextField field, String name) {

        String value = field.getText().trim();

        if (value.isEmpty()) {

            throw new IllegalArgumentException(
                "Please enter " + name + "."
            );

        } else {

            return value;
        }
    }

    /**
     * Validates the form and creates a single Product object.
     */
    private void saveProduct() {

        try {

            String name = required(nameField, "Product Name");
            String description = required(
                descriptionField, "Description"
            );

            int availNum = Integer.parseInt(
                required(availNumField, "Available Quantity")
            );

            double price = Double.parseDouble(
                required(priceField, "Price")
            );

            if (availNum < 0 || price < 0
                    || !Double.isFinite(price)) {

                throw new IllegalArgumentException(
                    "Quantity and price must be valid, non-negative numbers."
                );
            }

            // Collect the manufacturing address.
            Address manufactureAddress = new Address(
                required(manufactureStreetField, "Manufacturing Street"),
                required(manufactureUnitField, "Manufacturing Unit"),
                required(manufactureCityField, "Manufacturing City"),
                required(manufactureZipField, "Manufacturing ZIP Code")
            );

            // Collect the shipping address.
            Address shippingAddress = new Address(
                required(shippingStreetField, "Shipping Street"),
                required(shippingUnitField, "Shipping Unit"),
                required(shippingCityField, "Shipping City"),
                required(shippingZipField, "Shipping ZIP Code")
            );

            // Create and store the product.
            product = new Product(
                name,
                description,
                availNum,
                price,
                manufactureAddress,
                shippingAddress
            );

            showProduct();

        } catch (NumberFormatException ex) {

            showError(
                "Quantity must be a whole number and price must be numeric."
            );

        } catch (IllegalArgumentException ex) {

            showError(ex.getMessage());
        }
    }

    /**
     * Displays an error if the entered information is invalid.
     */
    private void showError(String message) {

        JOptionPane.showMessageDialog(
            this,
            message,
            "Input Error",
            JOptionPane.ERROR_MESSAGE
        );
    }

    /**
     * Displays the saved product in separate text fields.
     */
    private void showProduct() {

        displayPanel.removeAll();

        JPanel fields = new JPanel(
            new GridLayout(15, 2, 8, 8)
        );

        fields.setBackground(LIGHT_RED);

        Address manufacture = product.getManufactureAddress();
        Address shipping = product.getShippingAddress();

        addDisplayField(fields, "Product Name:", product.getName());

        addDisplayField(
            fields, "Description:", product.getDescription()
        );

        addDisplayField(
            fields, "Available Quantity:",
            String.valueOf(product.getAvailNum())
        );

        addDisplayField(
            fields, "Price:",
            String.valueOf(product.getPrice())
        );

        addSection(fields, "Manufacturing Address");

        addDisplayField(
            fields, "Street Name:", manufacture.getStreetName()
        );

        addDisplayField(
            fields, "Unit Number:", manufacture.getUnitNum()
        );

        addDisplayField(
            fields, "City:", manufacture.getCity()
        );

        addDisplayField(
            fields, "ZIP Code:", manufacture.getZipCode()
        );

        addSection(fields, "Shipping Address");

        addDisplayField(
            fields, "Street Name:", shipping.getStreetName()
        );

        addDisplayField(
            fields, "Unit Number:", shipping.getUnitNum()
        );

        addDisplayField(
            fields, "City:", shipping.getCity()
        );

        addDisplayField(
            fields, "ZIP Code:", shipping.getZipCode()
        );

        displayPanel.add(fields, BorderLayout.CENTER);

        displayPanel.revalidate();
        displayPanel.repaint();
    }

    /**
     * Adds a read-only field to the product details panel.
     */
    private void addDisplayField(JPanel panel, String label,
                                 String value) {

        JTextField field = new JTextField(value);
        field.setEditable(false);

        panel.add(new JLabel(label));
        panel.add(field);
    }

    /**
     * Starts the Swing application.
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            Lab1 app = new Lab1();
            app.setVisible(true);

        });
    }
}
