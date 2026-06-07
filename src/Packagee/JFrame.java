package Packagee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JFrame extends javax.swing.JFrame {

    JTextField txtName;
    JTextField txtRoll;
    JTextField txtSubject;
    JTextField txtExamDate;
    JTextField txtStudyHours;

    JTextArea txtNotes;

    JComboBox<String> comboDifficulty;

    JRadioButton rbHigh;
    JRadioButton rbMedium;

    JButton btnGenerate;
    JButton btnReset;
    JButton btnExit;

    public JFrame() {

        setTitle("AI Based Study Planner");
        setSize(700, 650);
        setLayout(null);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel lblTitle =
                new JLabel("AI Based Study Planner");
        lblTitle.setFont(
                new Font("Arial", Font.BOLD, 22));
        lblTitle.setBounds(200, 20, 300, 30);
        add(lblTitle);

        JLabel lblName =
                new JLabel("Student Name:");
        lblName.setBounds(80, 80, 120, 25);
        add(lblName);

        txtName = new JTextField();
        txtName.setBounds(280, 80, 220, 25);
        add(txtName);

        JLabel lblRoll =
                new JLabel("Roll Number:");
        lblRoll.setBounds(80, 120, 120, 25);
        add(lblRoll);

        txtRoll = new JTextField();
        txtRoll.setBounds(280, 120, 220, 25);

        txtRoll.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {

                char c = e.getKeyChar();

                if (!Character.isDigit(c)
                        && c != KeyEvent.VK_BACK_SPACE
                        && c != KeyEvent.VK_DELETE) {

                    e.consume();
                }
            }
        });

        add(txtRoll);

        JLabel lblSubject =
                new JLabel("Subject Name:");
        lblSubject.setBounds(80, 160, 120, 25);
        add(lblSubject);

        txtSubject = new JTextField();
        txtSubject.setBounds(280, 160, 220, 25);
        add(txtSubject);

        JLabel lblDifficulty =
                new JLabel("Difficulty:");
        lblDifficulty.setBounds(80, 200, 120, 25);
        add(lblDifficulty);

        String difficulties[] = {
                "Select Difficulty",
                "Easy",
                "Medium",
                "Hard"
        };

        comboDifficulty =
                new JComboBox<>(difficulties);

        comboDifficulty.setBounds(
                280, 200, 220, 25);

        add(comboDifficulty);

        JLabel lblPriority =
                new JLabel("Priority:");
        lblPriority.setBounds(80, 240, 120, 25);
        add(lblPriority);

        rbHigh = new JRadioButton("High");
        rbHigh.setBounds(280, 240, 80, 25);
        add(rbHigh);

        rbMedium = new JRadioButton("Medium");
        rbMedium.setBounds(380, 240, 100, 25);
        add(rbMedium);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbHigh);
        bg.add(rbMedium);

        JLabel lblExamDate =
                new JLabel("Exam Date (DD/MM/YYYY):");
        lblExamDate.setBounds(80, 280, 180, 25);
        add(lblExamDate);

        txtExamDate = new JTextField();
        txtExamDate.setBounds(280, 280, 220, 25);
        add(txtExamDate);

        JLabel lblHours =
                new JLabel("Study Hours:");
        lblHours.setBounds(80, 320, 120, 25);
        add(lblHours);

        txtStudyHours = new JTextField();
        txtStudyHours.setBounds(280, 320, 220, 25);
        add(txtStudyHours);

        JLabel lblNotes =
                new JLabel("Progress Notes:");
        lblNotes.setBounds(80, 360, 120, 25);
        add(lblNotes);

        txtNotes = new JTextArea();
        txtNotes.setBounds(280, 360, 220, 80);
        add(txtNotes);

        btnGenerate = new JButton("Generate Plan");
        btnGenerate.setBounds(80, 520, 140, 35);
        add(btnGenerate);

        btnReset = new JButton("Reset");
        btnReset.setBounds(280, 520, 120, 35);
        add(btnReset);

        btnExit = new JButton("Exit");
        btnExit.setBounds(480, 520, 120, 35);
        add(btnExit);

        btnGenerate.addActionListener(
                new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                try {

                    String name = txtName.getText().trim();

                    String roll = txtRoll.getText().trim();

                    String subject = txtSubject.getText().trim();

                    String difficulty = comboDifficulty
                            .getSelectedItem()
                            .toString();

                    String examDate = txtExamDate.getText().trim();

                    String hours = txtStudyHours.getText().trim();

                    String notes = txtNotes.getText().trim();


                    if (name.isEmpty()) {
                        throw new Exception(
                                "Student Name cannot be empty!");
                    }

                    if (!name.matches("[a-zA-Z ]+")) {
                        throw new Exception(
                                "Name must contain only alphabets!");
                    }

                    if (!Classs.isRollValid(roll)) {
                        throw new Exception(
                                "Roll Number must contain numbers only!");
                    }

                    if (subject.isEmpty()) {
                        throw new Exception(
                                "Subject cannot be empty!");
                    }

                    if (comboDifficulty.getSelectedIndex() == 0) {
                        throw new Exception(
                                "Please select Difficulty!");
                    }

                    if (!rbHigh.isSelected()
                            && !rbMedium.isSelected()) {

                        throw new Exception(
                                "Please select Priority!");
                    }

                    if (!examDate.matches(
                            "\\d{2}/\\d{2}/\\d{4}")) {

                        throw new Exception(
                                "Date format must be DD/MM/YYYY");
                    }

                    if (!Classs.isStudyHoursValid(hours)) {

                        throw new Exception(
                                "Study Hours must be between 1 and 24!");
                    }

                    if (notes.isEmpty()) {

                        throw new Exception(
                                "Progress Notes cannot be empty!");
                    }

                    String priority;

                    if (rbHigh.isSelected())
                        priority = "High";
                    else
                        priority = "Medium";

                    String recommendation =
                            Classs.getRecommendation(
                                    difficulty);

                    JOptionPane.showMessageDialog(
                            null,

                            "AI STUDY PLAN GENERATED\n\n"

                            + "Student Name: "
                            + name

                            + "\nRoll Number: "
                            + roll

                            + "\nSubject: "
                            + subject

                            + "\nDifficulty: "
                            + difficulty

                            + "\nPriority: "
                            + priority

                            + "\nExam Date: "
                            + examDate

                            + "\nStudy Hours: "
                            + hours

                            + "\nRecommendation: "
                            + recommendation

                            + "\nNotes: "
                            + notes);

                }

                catch (NumberFormatException ex) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Only numeric values are allowed!",
                            "Number Format Error",
                            JOptionPane.ERROR_MESSAGE);
                }

                catch (Exception ex) {

                    JOptionPane.showMessageDialog(
                            null,
                            ex.getMessage(),
                            "Validation Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnReset.addActionListener(
                new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                txtName.setText("");
                txtRoll.setText("");
                txtSubject.setText("");
                txtExamDate.setText("");
                txtStudyHours.setText("");
                txtNotes.setText("");

                comboDifficulty.setSelectedIndex(0);

                bg.clearSelection();
            }
        });

        btnExit.addActionListener(
                new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {

        new JFrame();
    }
}
