/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviebooking;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import moviebooking.entities.Movie;
import moviebooking.entities.MovieDAO;
import moviebooking.entities.Shows;
import moviebooking.entities.ShowsDAO;
import moviebooking.entities.Theater;
import moviebooking.entities.TheaterDAO;
import moviebooking.entities.Timings;

/**
 *
 * @author Parth Shah
 */
public class AdminHome extends javax.swing.JFrame {

    /**
     * Creates new form AdminHome
     */
    private int moviePosition = 0;
    private int theaterPosition = 0;
    private int timePosition = 0;

    public AdminHome() {
        initComponents();
        movieDropDown.removeAllItems();
        theaterDropDown.removeAllItems();
        timeDropDown.removeAllItems();
        for (Movie movie : MovieDAO.getAll()) {
            movieDropDown.addItem(movie.getName());
        }
        for (Theater theater : TheaterDAO.getAll()) {
            theaterDropDown.addItem(theater.getName());
        }

        for (Timings time : Timings.values()) {
            timeDropDown.addItem(time.toString()+":00");
        }

        createMovie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Movie movie = MovieDAO.getMovie(movie_name.getText());
                //same name
                if(movie != null)
                {
                    JOptionPane.showMessageDialog(null,"Movie already Exists!","Error", JOptionPane.PLAIN_MESSAGE);
                    movie_name.setText("");
                    movie_rating.setText("");
                }
                //blank
                else if(movie_name.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Cannot be Empty!","Error", JOptionPane.PLAIN_MESSAGE);
                }
                else
                {
                    MovieDAO.save(new Movie(movie_name.getText(), Float.valueOf(movie_rating.getText())));
                    movieDropDown.removeAllItems();
                    for(Movie m : MovieDAO.getAll()) {
                        movieDropDown.addItem(m.getName());
                    }
                    movie_name.setText("");
                    movie_rating.setText("");
                    JOptionPane.showMessageDialog(null,"Movie Added!","", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });

        createTheater.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                Theater theater = TheaterDAO.getTheater(theaterName.getText());
                //same name
                if(theater != null)
                {
                    JOptionPane.showMessageDialog(null,"Theater already Exists!","Error", JOptionPane.PLAIN_MESSAGE);
                    theaterName.setText("");
                }
                //blank
                else if(theaterName.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Cannot be Empty!","Error", JOptionPane.PLAIN_MESSAGE);
                }
                else
                {
                TheaterDAO.save(new Theater(theaterName.getText()));
                theaterDropDown.removeAllItems();
                for (Theater t : TheaterDAO.getAll()) {
                    theaterDropDown.addItem(t.getName());
                }
                theaterName.setText("");
                JOptionPane.showMessageDialog(null,"Theater Added!","", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });

        theaterDropDown.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                theaterPosition = theaterDropDown.getSelectedIndex();
            }
        });

        movieDropDown.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                moviePosition = movieDropDown.getSelectedIndex();
            }
        });

        timeDropDown.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                timePosition = timeDropDown.getSelectedIndex();
            }
        });
        
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
                new Login().setVisible(true);
            }
        });

        addShowToTheater.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Movie movie = MovieDAO.getAll().get(moviePosition);
                Theater theater = TheaterDAO.getAll().get(theaterPosition);
                Timings timings = Timings.values()[timePosition];
                int price = Integer.parseInt((amount.getText()));
                //System.out.println(datePicker.getText());
                LocalDate date = LocalDate.parse(datePicker.getText(), DateTimeFormatter.ofPattern("dd/MM/yy"));
                Shows shows = new Shows(timings, movie, date, theater, price);
                ShowsDAO.save(shows);
                JOptionPane.showMessageDialog(null,"Show Added!","", JOptionPane.PLAIN_MESSAGE);
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        theaterName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        movieDropDown = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        amount = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        datePicker = new datechooser.beans.DateChooserCombo();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        movie_rating = new javax.swing.JTextField();
        movie_name = new javax.swing.JTextField();
        theaterDropDown = new javax.swing.JComboBox<>();
        createMovie = new javax.swing.JButton();
        createTheater = new javax.swing.JButton();
        addShowToTheater = new javax.swing.JButton();
        timeDropDown = new javax.swing.JComboBox<>();
        logout = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(theaterName, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 280, 98, -1));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel3.setText("Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, 40, 20));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel5.setText("Create Theatre");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 150, -1));

        movieDropDown.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        movieDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        movieDropDown.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        movieDropDown.setMinimumSize(new java.awt.Dimension(160, 23));
        movieDropDown.setPreferredSize(new java.awt.Dimension(160, 23));
        jPanel1.add(movieDropDown, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 400, 160, -1));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ADMIN");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 190, 50));
        jPanel1.add(amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 400, 60, -1));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel2.setText("Create Movie");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 140, -1));

        datePicker.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 12));
        jPanel1.add(datePicker, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 400, 90, 23));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel7.setText("Add Movie to Theatre (Shows)");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, 270, 20));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel8.setText("Amount");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 400, -1, 20));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel6.setText("Name");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 280, 40, 20));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel4.setText("Rating");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 160, -1, -1));
        jPanel1.add(movie_rating, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 160, 69, -1));
        jPanel1.add(movie_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, 97, -1));

        theaterDropDown.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        theaterDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        theaterDropDown.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        theaterDropDown.setMinimumSize(new java.awt.Dimension(110, 23));
        theaterDropDown.setPreferredSize(new java.awt.Dimension(110, 23));
        jPanel1.add(theaterDropDown, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 400, 110, -1));

        createMovie.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        createMovie.setText("Create Movie");
        createMovie.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(createMovie, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 160, -1, -1));

        createTheater.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        createTheater.setText("Create Theatre");
        createTheater.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(createTheater, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 280, -1, -1));

        addShowToTheater.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        addShowToTheater.setText("Add Show to Theatre");
        addShowToTheater.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(addShowToTheater, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 450, -1, 30));

        timeDropDown.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        timeDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        timeDropDown.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        timeDropDown.setMinimumSize(new java.awt.Dimension(90, 23));
        timeDropDown.setPreferredSize(new java.awt.Dimension(90, 23));
        jPanel1.add(timeDropDown, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 400, 90, -1));

        logout.setBackground(new java.awt.Color(255, 255, 255));
        logout.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        logout.setText("Logout");
        logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 20, 90, 30));

        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 720, 10));

        jSeparator2.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 720, 20));

        jSeparator3.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 720, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 530));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AdminHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addShowToTheater;
    private javax.swing.JTextField amount;
    private javax.swing.JButton createMovie;
    private javax.swing.JButton createTheater;
    private datechooser.beans.DateChooserCombo datePicker;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton logout;
    private javax.swing.JComboBox<String> movieDropDown;
    private javax.swing.JTextField movie_name;
    private javax.swing.JTextField movie_rating;
    private javax.swing.JComboBox<String> theaterDropDown;
    private javax.swing.JTextField theaterName;
    private javax.swing.JComboBox<String> timeDropDown;
    // End of variables declaration//GEN-END:variables
}
