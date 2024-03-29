import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;
import org.passay.CharacterData;

class Javaproject extends JFrame {
    String password = "";

  Javaproject() {
    setTitle("Password Generator");
    setSize(500, 500);
    JPanel p = new JPanel(new GridLayout(2, 3, 3, 3));
    JButton b = new JButton("System-generated"),
    b2 = new
    JButton("Customization");
    p.add(b);
    p.add(b2);
    getContentPane().add(p);
    b.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        CharacterRule alphabets = new
        CharacterRule(EnglishCharacterData.Alphabetical);
        CharacterRule digits = new
        CharacterRule(EnglishCharacterData.Digit);

        CharacterRule special = new CharacterRule(new CharacterData()

        {

          @Override
          public String getErrorCode() {
            return "ERROR_CODE";
          }@Override
          public String getCharacters() {
            return "!@#$%^&*()_+-={}[]|;':\",./<>?\\";
          }
        });
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        String password = passwordGenerator.generatePassword(8,

        alphabets, digits, special);

        JOptionPane.showMessageDialog(null, "Generated Password: " +

        password);

        password = "";
      }
    });
    JPanel t = new JPanel(new GridLayout(2, 3, 3, 3));
    JButton c = new JButton("Without Hints"),
    c2 = new JButton("With
Hints");
    t.add(c);
    t.add(c2);
    b2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        getContentPane().removeAll();
        getContentPane().add(t);
        revalidate();
      }
    });
    c.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String n = JOptionPane.showInputDialog(null, "Enter the

size:");

        int len = Integer.parseInt(n);
        CharacterRule specialCharacterRule = new CharacterRule(new

        CharacterData() {

          @Override
          public String getErrorCode() {
            return "SAMPLE_ERROR_CODE";
          }@Override
          public String getCharacters() {
            return "!@#$%^&*()[]{}_-;:'/<>~";
          }
        });
        CharacterRule alphabets = new
        CharacterRule(EnglishCharacterData.Alphabetical);
        CharacterRule digits = new
        CharacterRule(EnglishCharacterData.Digit);

        PasswordGenerator passwordGenerator = new PasswordGenerator();
        String password = passwordGenerator.generatePassword(len,

        alphabets, digits, specialCharacterRule);

        JOptionPane.showMessageDialog(null, "Generated Password: " +

        password);

        password = "";
      }
    });
    JPanel j = new JPanel(new GridLayout(2, 3, 3, 3));
    JButton s = new JButton("Moderate"),
    s2 = new JButton("Strong");
    j.add(s);
    j.add(s2);
    c2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        getContentPane().removeAll();
        getContentPane().add(j); // Add the third panel
        revalidate();
      }
    });
    JPanel w = new JPanel(new GridLayout(6, 10, 5, 5));
    JButton r = new JButton("Date of Birth"),
    r2 = new JButton("Favourite
Colour"),

    r3 = new JButton("Place of Birth"),
    r4 = new JButton("Name"),
    r5 = new JButton("Name and Date of

birth");
    w.add(r);
    w.add(r2);
    w.add(r3);
    w.add(r4);
    w.add(r5);
    s.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        getContentPane().removeAll();
        getContentPane().add(w); // Add the third panel
        revalidate();
      }
    });
    r.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String hint = JOptionPane.showInputDialog(null, "Enter your

birth date (in format DDMMYYYY):");

        password = password.concat(hint.substring(0, 2));
        password = (password.concat("d")).concat("@");
        int month = Integer.parseInt(hint.substring(2, 4));
        String monthname = "";
        switch (month) {
        case 1:
          monthname = "Jan";

          break;
        case 2:
          monthname = "Feb";
          break;
        case 3:
          monthname = "Mar";
          break;
        case 4:
          monthname = "Apr";
          break;
        case 5:
          monthname = "May";
          break;
        case 6:
          monthname = "Jun";
          break;
        case 7:
          monthname = "Jul";
          break;
        case 8:
          monthname = "Aug";
          break;
        case 9:
          monthname = "Sep";
          break;
        case 10:
          monthname = "Oct";
          break;
        case 11:
          monthname = "Nov";
          break;
        case 12:
          monthname = "Dec";
          break;
        }
        password = (password.concat(monthname)).concat("@");
        password = password.concat(hint.substring(6));
        password = password.concat("@");
        JOptionPane.showMessageDialog(null, "Generated Password: " +

        password);

        password = "";
      }
    });
    r2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        String n = JOptionPane.showInputDialog(null, "Enter your

favorite colour:");

        String hint = n;
        password = password.concat("*");
        password = password.concat(hint.toUpperCase());
        password = password.concat("*");
        JOptionPane.showMessageDialog(null, "Generated Password: " +

        password);

        password = "";
      }
    });
    r3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String n = JOptionPane.showInputDialog(null, "Enter the place

of birth:");

        String hint = n;
        int mid_len = hint.length() / 2;
        password = password.concat(hint.substring(0, mid_len));
        password = password.concat("$");
        password = password.concat(hint.substring(mid_len));
        JOptionPane.showMessageDialog(null, "Generated Password: " +

        password);

        password = "";
      }
    });
    r4.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String n = JOptionPane.showInputDialog(null, "Enter the

name:");

        String hint = n;
        password = password.concat("*");
        password = password.concat(hint.toUpperCase());
        password = password.concat("*");
        JOptionPane.showMessageDialog(null, "Generated Password: " +

        password);

        password = "";
      }
    });
    r5.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String n = JOptionPane.showInputDialog(null, "Enter the

Name:");

        String s = JOptionPane.showInputDialog(null, "Date of

Birth:");

        String hint = n + s;

        password = password.concat("@");
        password = password.concat(hint.toUpperCase());
        password = password.concat("@");
        JOptionPane.showMessageDialog(null, "Generated Password: " +

        password);

        password = "";
      }
    });
    JPanel n = new JPanel(new GridLayout(6, 10, 5, 5));
    JButton k = new JButton("Date of Birth"),
    k2 = new JButton("Favourite
colour"),

    k3 = new JButton("Place of Birth"),
    k4 = new JButton("Name"),
    k5 = new JButton("Name and Date of birth");
    n.add(k);
    n.add(k2);
    n.add(k3);
    n.add(k4);
    n.add(k5);
    s2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        getContentPane().removeAll();
        getContentPane().add(n); // Add the third panel
        revalidate();
      }
    });
    k.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String hint = JOptionPane.showInputDialog(null, "Enter your

birth date (in format DDMMYYYY):");

        password = password.concat(hint.substring(0, 2));
        password = (password.concat("d")).concat("$");
        int month = Integer.parseInt(hint.substring(2, 4));
        String monthname = "";
        switch (month) {
        case 1:
          monthname = "Jan";
          break;
        case 2:
          monthname = "Feb";
          break;
        case 3:
          monthname = "Mar";
          break;
        case 4:

          monthname = "Apr";
          break;
        case 5:
          monthname = "May";
          break;
        case 6:
          monthname = "Jun";
          break;
        case 7:
          monthname = "Jul";
          break;
        case 8:
          monthname = "Aug";
          break;
        case 9:
          monthname = "Sep";
          break;
        case 10:
          monthname = "Oct";
          break;
        case 11:
          monthname = "Nov";
          break;
        case 12:
          monthname = "Dec";
          break;
        }
        password = (password.concat(monthname)).concat("M$");
        password = password.concat(hint.substring(6));
        password = password.concat("y$");
        JOptionPane.showMessageDialog(null, "Generated Password: " +

        password);

        password = "";
      }
    });
    k2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String n = JOptionPane.showInputDialog(null, "Enter the

favorite colour:");

        String hint = n; // Add this line to define the hint variable
        password = password.concat("*");
        int mid_len = hint.length() / 2;
        password = password.concat(hint.substring(0,

        mid_len).toUpperCase());

        password = password.concat("/");

        password =

        password.concat(hint.substring(mid_len).toLowerCase());
        password = password.concat("*");
        int dpw = hint.length() * hint.length();
        Integer ob = new Integer(10);
        String dpws = ob.toString(dpw);
        password = password.concat(dpws);
        JOptionPane.showMessageDialog(null, "Generated Password: " +

        password);

        password = "";
      }
    });
    k3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String n = JOptionPane.showInputDialog(null, "Enter the place

of birth:");

        String hint = n; // Add this line to define the hint variable
        password = password.concat("$");
        int mid_len = hint.length() / 2;
        password = password.concat(hint.substring(0,

        mid_len).toLowerCase());

        password = password.concat("~");
        password =

        password.concat(hint.substring(mid_len).toUpperCase());
        password = password.concat("$");
        int dpw = hint.length() * hint.length();
        Integer ob = new Integer(10);
        String dpws = ob.toString(dpw);
        password = password.concat(dpws);
        JOptionPane.showMessageDialog(null, "Generated Password: " +

        password);

        password = "";
      }
    });
    k4.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String n = JOptionPane.showInputDialog(null, "Enter the

Name:");

        String hint = n; // Add this line to define the hint variable
        password = password.concat("*");
        int mid_len = hint.length() / 2;
        password = password.concat(hint.substring(0,

        mid_len).toUpperCase());

        password = password.concat("/");
        password =

        password.concat(hint.substring(mid_len).toLowerCase());

        password = password.concat("*");
        int dpw = hint.length() * hint.length();
        Integer ob = new Integer(10);
        String dpws = ob.toString(dpw);
        password = password.concat(dpws);
        JOptionPane.showMessageDialog(null, "Generated Password: " +

        password);

        password = "";
      }
    });
    k5.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String n = JOptionPane.showInputDialog(null, "Enter the

Name:");

        String s = JOptionPane.showInputDialog(null, "Date of

Birth:");

        String hint = n + s;
        password = password.concat("@");
        int mid_len = hint.length() / 2;
        password = password.concat(hint.substring(0,

        mid_len).toUpperCase());

        password = password.concat("/");
        password =

        password.concat(hint.substring(mid_len).toLowerCase());
        password = password.concat("@");
        int dpw = hint.length() * hint.length();
        Integer ob = new Integer(10);
        String dpws = ob.toString(dpw);
        password = password.concat(dpws);
        JOptionPane.showMessageDialog(null, "Generated Password: " +

        password);

        password = "";
      }
    });
    getContentPane().add(p);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

    public static void main(String[] args) {
        Javaproject p = new Javaproject();
    }
}