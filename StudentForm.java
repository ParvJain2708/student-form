import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

class Student {
    String name, email;
    Student(String name, String email) {
        this.name = name;
        this.email = email;
    }
}

public class StudentForm extends JFrame {
    JTextField nameField, emailField;
    JButton submit, show;
    ArrayList<Student> students = new ArrayList<>();

    public StudentForm() {
        setTitle("Student Registration");
        setSize(350, 250);
        setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(30, 40, 80, 20);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(100, 40, 200, 20);
        add(nameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(30, 70, 80, 20);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(100, 70, 200, 20);
        add(emailField);

        submit = new JButton("Register");
        submit.setBounds(100, 110, 100, 25);
        add(submit);

        show = new JButton("Show Students");
        show.setBounds(100, 150, 130, 25);
        add(show);

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String email = emailField.getText();
                if (name.isEmpty() || email.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all fields!");
                    return;
                }
                students.add(new Student(name, email));
                JOptionPane.showMessageDialog(null, "✅ Registered Successfully!");
                nameField.setText("");
                emailField.setText("");
            }
        });

        show.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder sb = new StringBuilder("Registered Students:\n");
                for (Student s : students)
                    sb.append(s.name).append(" - ").append(s.email).append("\n");
                JOptionPane.showMessageDialog(null, sb.toString());
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new StudentForm();
    }
}
