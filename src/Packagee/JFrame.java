package Packagee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JFrame extends javax.swing.JFrame implements ActionListener {

    // Labels
    JLabel titleLabel;
    JLabel nameLabel, rollLabel, bookTitleLabel;
    JLabel categoryLabel, issueDateLabel, returnDateLabel;
    JLabel remarksLabel, typeLabel;

    // Text Fields
    JTextField nameField, rollField;
    JTextField bookTitleField;
    JTextField issueDateField, returnDateField;

    // Text Area
    JTextArea remarksArea;

    // Combo Box
    JComboBox<String> categoryBox;

    // Radio Buttons
    JRadioButton newEdition, oldEdition;
    ButtonGroup editionGroup;

    // Buttons
    JButton issueButton, resetButton, exitButton;

    // Constructor
    public JFrame() {

        // Frame Settings
        setTitle("Library Book Issue System");
        setSize(700, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        // Title
        titleLabel = new JLabel("Library Book Issue System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(170, 20, 350, 40);
        getContentPane().add(titleLabel);

        // Student Name
        nameLabel = new JLabel("Student Name:");
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
        nameLabel.setBounds(100, 90, 120, 30);
        getContentPane().add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(320, 91, 200, 30);
        getContentPane().add(nameField);

        // Roll Number
        rollLabel = new JLabel("Roll Number:");
        rollLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
        rollLabel.setBounds(100, 130, 120, 30);
        getContentPane().add(rollLabel);

        rollField = new JTextField();
        rollField.setBounds(320, 131, 200, 30);
        getContentPane().add(rollField);

        // Book Title
        bookTitleLabel = new JLabel("Book Title:");
        bookTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
        bookTitleLabel.setBounds(100, 168, 120, 30);
        getContentPane().add(bookTitleLabel);

        bookTitleField = new JTextField();
        bookTitleField.setBounds(320, 169, 200, 30);
        getContentPane().add(bookTitleField);

        // Book Category
        categoryLabel = new JLabel("Book Category:");
        categoryLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
        categoryLabel.setBounds(100, 216, 120, 30);
        getContentPane().add(categoryLabel);

        String[] categories = {
                "Programming",
                "Artificial Intelligence",
                "Databases",
                "Networking"
        };

        categoryBox = new JComboBox<>(categories);
        categoryBox.setFont(new Font("Tahoma", Font.BOLD, 10));
        categoryBox.setBounds(320, 216, 200, 30);
        getContentPane().add(categoryBox);

        // Book Type
        typeLabel = new JLabel("Book Type:");
        typeLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
        typeLabel.setBounds(100, 267, 120, 30);
        getContentPane().add(typeLabel);

        newEdition = new JRadioButton("New Edition");
        newEdition.setFont(new Font("Tahoma", Font.BOLD, 10));
        newEdition.setBounds(320, 267, 120, 30);
        getContentPane().add(newEdition);

        oldEdition = new JRadioButton("Old Edition");
        oldEdition.setFont(new Font("Tahoma", Font.BOLD, 10));
        oldEdition.setBounds(450, 267, 120, 30);
        getContentPane().add(oldEdition);

        editionGroup = new ButtonGroup();
        editionGroup.add(newEdition);
        editionGroup.add(oldEdition);

        // Issue Date
        issueDateLabel = new JLabel("Issue Date:");
        issueDateLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
        issueDateLabel.setBounds(100, 317, 120, 30);
        getContentPane().add(issueDateLabel);

        issueDateField = new JTextField();
        issueDateField.setBounds(320, 318, 200, 30);
        getContentPane().add(issueDateField);

        // Return Date
        returnDateLabel = new JLabel("Return Date:");
        returnDateLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
        returnDateLabel.setBounds(100, 354, 120, 30);
        getContentPane().add(returnDateLabel);

        returnDateField = new JTextField();
        returnDateField.setBounds(320, 355, 200, 30);
        getContentPane().add(returnDateField);

        // Remarks
        remarksLabel = new JLabel("Remarks:");
        remarksLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
        remarksLabel.setBounds(100, 400, 120, 30);
        getContentPane().add(remarksLabel);

        remarksArea = new JTextArea();
        remarksArea.setBounds(320, 403, 200, 59);
        getContentPane().add(remarksArea);

        // Buttons
        issueButton = new JButton("Issue Book");
        issueButton.setBounds(100, 503, 120, 35);
        getContentPane().add(issueButton);

        resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Tahoma", Font.BOLD, 10));
        resetButton.setBounds(279, 503, 120, 35);
        getContentPane().add(resetButton);

        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Tahoma", Font.BOLD, 10));
        exitButton.setBounds(466, 503, 120, 35);
        getContentPane().add(exitButton);

        // Action Listener
        issueButton.addActionListener(this);
        resetButton.addActionListener(this);
        exitButton.addActionListener(this);

        setVisible(true);
    }

    // ActionListener Method
    public void actionPerformed(ActionEvent e) {

        // Issue Button
        if (e.getSource() == issueButton) {

            try {

                String name = nameField.getText();
                String roll = rollField.getText();
                String bookTitle = bookTitleField.getText();
                String category = (String) categoryBox.getSelectedItem();
                String issueDate = issueDateField.getText();
                String returnDate = returnDateField.getText();
                String remarks = remarksArea.getText();

                // Empty Field Validation
                if (name.isEmpty() || roll.isEmpty() || bookTitle.isEmpty()
                        || issueDate.isEmpty() || returnDate.isEmpty()) {

                    throw new Exception("All fields are required!");
                }

                // Roll Number Validation
                int rollNo = Integer.parseInt(roll);

                // Book Type Validation
                String bookType = "";

                if (newEdition.isSelected()) {
                    bookType = "New Edition";
                }
                else if (oldEdition.isSelected()) {
                    bookType = "Old Edition";
                }
                else {
                    throw new Exception("Please select Book Type!");
                }

                // Date Format Validation
                if (!issueDate.matches("\\d{2}/\\d{2}/\\d{4}")
                        || !returnDate.matches("\\d{2}/\\d{2}/\\d{4}")) {

                    throw new Exception("Date format must be DD/MM/YYYY");
                }

                // Success Message
                JOptionPane.showMessageDialog(this,
                        "Book Issued Successfully!\n\n" +
                        "Student Name: " + name +
                        "\nRoll Number: " + rollNo +
                        "\nBook Title: " + bookTitle +
                        "\nCategory: " + category +
                        "\nBook Type: " + bookType +
                        "\nIssue Date: " + issueDate +
                        "\nReturn Date: " + returnDate +
                        "\nRemarks: " + remarks);

            }

            // Number Format Exception
            catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(this,
                        "Roll Number must be numeric!",
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE);
            }

            // General Exception
            catch (Exception ex) {

                JOptionPane.showMessageDialog(this,
                        ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        // Reset Button
        else if (e.getSource() == resetButton) {

            nameField.setText("");
            rollField.setText("");
            bookTitleField.setText("");
            issueDateField.setText("");
            returnDateField.setText("");
            remarksArea.setText("");
            categoryBox.setSelectedIndex(0);
            editionGroup.clearSelection();
        }

        // Exit Button
        else if (e.getSource() == exitButton) {

            System.exit(0);
        }
    }

    // Main Method
    public static void main(String[] args) {

        new JFrame();
    }
}