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
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import moviebooking.entities.Booking;
import moviebooking.entities.BookingDAO;
import moviebooking.entities.Movie;
import moviebooking.entities.MovieDAO;
import moviebooking.entities.Shows;
import static moviebooking.entities.ShowsDAO.getshows;
import moviebooking.entities.Theater;
import moviebooking.entities.User;
import moviebooking.entities.UserDAO;

/**
 *
 * @author Parth Shah
 */
public class BookTicket extends javax.swing.JFrame {
    
    Theater theTheater;
    Movie theMovie;
    private int moviePosition = 0;
    private int showPosition = 0;
    /**
     * Creates new form BookTicket
     * @param user
     */
    public BookTicket(User user) {
        initComponents();
        movieDropDown.removeAllItems();
        showDropDown.removeAllItems();
                
        List<Movie> movies = MovieDAO.getAll();
        
        for (Movie movie : movies) {
            movieDropDown.addItem(movie.getName());
        }
        
        movieDropDown.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                moviePosition = movieDropDown.getSelectedIndex();
                showDropDown.removeAllItems();
                List<Shows> shows = getshows(movies.get(moviePosition));
                for (Shows show : shows) {
                    showDropDown.addItem(show.getTheater().getName() + "-" + show.getDate().toString() + "-" + show.getTime().toString() + "- Rs." + show.getAmount() + "/-");
                }
            }
        });
        
        movieDropDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                moviePosition = movieDropDown.getSelectedIndex();
                showDropDown.removeAllItems();
                List<Shows> shows = getshows(movies.get(moviePosition));
                for (Shows show : shows) {
                    showDropDown.addItem(show.getTheater().getName() + " - " + show.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yy")) + " - " + show.getTime().toString() + ":00 - Rs." + show.getAmount() + "/-");
                }
            }
        });
        
        showDropDown.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                showPosition = showDropDown.getSelectedIndex();
            }
        });
         
         book.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                List<Shows> shows = getshows(movies.get(moviePosition));
                if (user.getWalletBalance() - shows.get(showPosition).getAmount()>=0){
                    user.setWalletBalance(user.getWalletBalance() - shows.get(showPosition).getAmount());
                    Booking booking = new Booking(user, shows.get(showPosition));
                    BookingDAO.save(booking);
                    UserDAO.update(user);
                    new Receipt(booking).setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Insufficient Wallet Balance","",JOptionPane.PLAIN_MESSAGE);
                }
                
            }
        });
         
         backToUserHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new UserHome(user).setVisible(true);
            }
        });
        /*if (!theaters.isEmpty()) {
            theTheater = theaters.get(0);
            
            ShowsDAO.getshows(theTheater).forEach(show -> showDropDown.addItem(show.getMovie().getName() + "-" + show.getTime() + "-" + show.getDate().toString() + "-" + show.getAmount()));
            
        }*/
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
        jLabel1 = new javax.swing.JLabel();
        movieDropDown = new javax.swing.JComboBox<>();
        showDropDown = new javax.swing.JComboBox<>();
        book = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        backToUserHome = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1020, 530));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 153, 153));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Let's Book Tickets!");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 520, 70));

        movieDropDown.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        movieDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        movieDropDown.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        movieDropDown.setMinimumSize(new java.awt.Dimension(170, 22));
        movieDropDown.setPreferredSize(new java.awt.Dimension(170, 22));
        movieDropDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movieDropDownActionPerformed(evt);
            }
        });
        jPanel1.add(movieDropDown, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 370, 170, 30));

        showDropDown.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        showDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        showDropDown.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        showDropDown.setMinimumSize(new java.awt.Dimension(280, 22));
        showDropDown.setPreferredSize(new java.awt.Dimension(280, 22));
        jPanel1.add(showDropDown, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 370, 280, 30));

        book.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        book.setText("Book");
        book.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(book, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 440, 170, 40));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/BookingPage.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1020, 260));

        backToUserHome.setBackground(new java.awt.Color(255, 255, 255));
        backToUserHome.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        backToUserHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/Left Arrow.png"))); // NOI18N
        backToUserHome.setText("Home");
        backToUserHome.setBorder(null);
        backToUserHome.setBorderPainted(false);
        backToUserHome.setContentAreaFilled(false);
        backToUserHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backToUserHome.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(backToUserHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 530));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void movieDropDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movieDropDownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_movieDropDownActionPerformed

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
            java.util.logging.Logger.getLogger(BookTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backToUserHome;
    private javax.swing.JButton book;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> movieDropDown;
    private javax.swing.JComboBox<String> showDropDown;
    // End of variables declaration//GEN-END:variables
}
