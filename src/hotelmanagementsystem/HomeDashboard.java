/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

import static hotelmanagementsystem.Booking.enumerateBookings;
import static hotelmanagementsystem.Booking.readBooking;
import static hotelmanagementsystem.Guest.enumerateGuests;
import static hotelmanagementsystem.Guest.searchGuest;
import static hotelmanagementsystem.Settings.resetSystem;
import static hotelmanagementsystem.Startup.checkDaysDirectory;
import static hotelmanagementsystem.Startup.checkDirectory;
import static hotelmanagementsystem.Utilities.daysToInt;
import static hotelmanagementsystem.Utilities.generateRoomNumbers;
import java.awt.CardLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class HomeDashboard extends javax.swing.JFrame {

    // Card layout UI
    CardLayout cardLayout;

    public HomeDashboard() {
        initComponents();

        cardLayout = (CardLayout) (homeDashboardPanel.getLayout());
    }

    public void checkAvailability() {

        // Get selected day range 
        int check_in = checkInCombobox.getSelectedIndex();
        int check_out = checkOutCombobox.getSelectedIndex();

        ArrayList<String> booked_days = new ArrayList<String>();
        int[] selected_range = daysToInt(check_in, check_out);

        // Read files within the selected range and store all booked rooms 
        for (int i : selected_range) {
            try {
                String currentDirectory = System.getProperty("user.dir");
                File myObj = new File(currentDirectory + "/bookingdays/" + i + ".txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    booked_days.add(data);
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

        // Generate a list of all possible rooms 
        ArrayList<String> total_days = generateRoomNumbers(20);

        // Remove booked rooms from all possible rooms
        for (String i : booked_days) {
            total_days.remove(new String(i));
        }

        // Display available rooms to jTable 
        DefaultListModel demoList = new DefaultListModel();

        for (String j : total_days) {
            demoList.addElement(j);
        }

        availableRoomList.setModel(demoList);
    }

    public void loadGuestTableContents() {

        // Get file names of each guest in the guest information directory 
        String[] guestBookingsDirectory = enumerateGuests();
        int i;

        // Clearing existing table contents first ( otherwise they stack up )
        DefaultTableModel model = (DefaultTableModel) guestTable.getModel();
        model.setRowCount(0);

        // Loop through each guest file's contents
        for (i = 0; i < guestBookingsDirectory.length; i++) {

            try {
                String[] guest_details = new String[4];

                // Read guests details and store them to an array
                Scanner scanner = new Scanner(new File(guestBookingsDirectory[i]));
                for (int j = 0; j < 4; j++) {
                    guest_details[j] = scanner.next();
                }

                scanner.close();

                // Display guest details to the guest table 
                model.addRow(guest_details);

            } catch (Exception e) {
                System.out.println("Failed to read file");
            }

        }

    }

    public void fillGuestInformation(String ic_number) {

        String currentDirectory = System.getProperty("user.dir");
        String guestBookingsDirectory = currentDirectory + "/guestinformation/" + ic_number + ".txt";

        try {
            String[] guest_details = new String[4];

            // Read guests details and store them to an array
            Scanner scanner = new Scanner(new File(guestBookingsDirectory));
            for (int j = 0; j < 4; j++) {
                guest_details[j] = scanner.next();
            }

            scanner.close();

            // Display guest details to the guest table 
            nameTextBox.setText(guest_details[1]);
            contactTextBox.setText(guest_details[3]);
            emailTextBox.setText(guest_details[2]);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        usernameLabel1 = new javax.swing.JTextField();
        passwordLabel1 = new javax.swing.JTextField();
        jButton14 = new javax.swing.JButton();
        sideNavigationPanel = new javax.swing.JPanel();
        reservationsButton = new javax.swing.JButton();
        guestButton = new javax.swing.JButton();
        paymentButton = new javax.swing.JButton();
        settingsButton = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        homeDashboardPanel = new javax.swing.JPanel();
        reservationsPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        searchTextField = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        bookingTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        guestsPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        guestTable = new javax.swing.JTable();
        jLabel33 = new javax.swing.JLabel();
        searchTextField1 = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        paymentPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        queryTextField = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        addPaymentButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        paymentTable = new javax.swing.JTable();
        settingsPanel = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        checkAvailabilityPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        checkInCombobox = new javax.swing.JComboBox<>();
        checkOutCombobox = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        availableRoomList = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        customerInfoPanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        roomNumberLabel = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lengthOfStayLabel = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        durationOfStayLabel = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        nameTextBox = new javax.swing.JTextField();
        icNumberTextBox = new javax.swing.JTextField();
        emailTextBox = new javax.swing.JTextField();
        contactTextBox = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        paymentDetailsPanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        roomChargesLabel = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        totalChargesLabel = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        paymentAmountTextField = new javax.swing.JTextField();
        customerICLabel = new javax.swing.JLabel();
        bookingIDLabel = new javax.swing.JLabel();
        customerNameLabel = new javax.swing.JLabel();
        lengthOfStaylabel = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        bookedRoomLabel = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        paymentreceiptPanel = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        bookingIDLabel_Payment = new javax.swing.JLabel();
        amountPaidLabel_Payment = new javax.swing.JLabel();
        changeAmountLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();

        jLabel35.setText("Password");

        jLabel36.setText("Username ");

        jButton14.setText("Sign In");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrame1Layout.createSequentialGroup()
                .addContainerGap(245, Short.MAX_VALUE)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jFrame1Layout.createSequentialGroup()
                        .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36)
                            .addComponent(jLabel35))
                        .addGap(58, 58, 58)
                        .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usernameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jFrame1Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jButton14)))
                .addGap(197, 197, 197))
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrame1Layout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(usernameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(passwordLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(jButton14)
                .addGap(61, 61, 61))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 153, 153));
        setForeground(new java.awt.Color(102, 255, 102));

        sideNavigationPanel.setBackground(new java.awt.Color(0, 128, 128));

        reservationsButton.setBackground(new java.awt.Color(0, 128, 128));
        reservationsButton.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        reservationsButton.setForeground(new java.awt.Color(253, 253, 253));
        reservationsButton.setText("Reservations");
        reservationsButton.setContentAreaFilled(false);
        reservationsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservationsButtonActionPerformed(evt);
            }
        });

        guestButton.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        guestButton.setForeground(new java.awt.Color(253, 253, 253));
        guestButton.setText("Guests");
        guestButton.setBorderPainted(false);
        guestButton.setContentAreaFilled(false);
        guestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guestButtonActionPerformed(evt);
            }
        });

        paymentButton.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        paymentButton.setForeground(new java.awt.Color(253, 253, 253));
        paymentButton.setText("Payment");
        paymentButton.setContentAreaFilled(false);
        paymentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentButtonActionPerformed(evt);
            }
        });

        settingsButton.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        settingsButton.setForeground(new java.awt.Color(253, 253, 253));
        settingsButton.setText("Settings");
        settingsButton.setContentAreaFilled(false);
        settingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsButtonActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(253, 253, 253));
        jLabel34.setText("Space Hotel");

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotelmanagementsystem/logo.png"))); // NOI18N

        javax.swing.GroupLayout sideNavigationPanelLayout = new javax.swing.GroupLayout(sideNavigationPanel);
        sideNavigationPanel.setLayout(sideNavigationPanelLayout);
        sideNavigationPanelLayout.setHorizontalGroup(
            sideNavigationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(settingsButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(guestButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(reservationsButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(paymentButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sideNavigationPanelLayout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(sideNavigationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sideNavigationPanelLayout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sideNavigationPanelLayout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(78, 78, 78))))
        );
        sideNavigationPanelLayout.setVerticalGroup(
            sideNavigationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideNavigationPanelLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel34)
                .addGap(18, 18, 18)
                .addComponent(jLabel22)
                .addGap(35, 35, 35)
                .addComponent(reservationsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(guestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(paymentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(settingsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(172, 172, 172))
        );

        homeDashboardPanel.setBackground(new java.awt.Color(253, 253, 253));
        homeDashboardPanel.setLayout(new java.awt.CardLayout());

        reservationsPanel.setBackground(new java.awt.Color(253, 253, 253));
        reservationsPanel.setForeground(new java.awt.Color(0, 128, 128));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 55)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 128, 128));
        jLabel1.setText("Reservations.");

        searchTextField.setText("Search Booking ID");
        searchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextFieldActionPerformed(evt);
            }
        });
        searchTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTextFieldKeyReleased(evt);
            }
        });

        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        bookingTable.setAutoCreateRowSorter(true);
        bookingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Booking ID", "IC/Passport No.", "Name", "Room No.", "Check In", "Check Out", "Length of Stay"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bookingTable.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                bookingTablePropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(bookingTable);

        jButton1.setText("Add Reservation");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton10.setText("Delete Reservation");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout reservationsPanelLayout = new javax.swing.GroupLayout(reservationsPanel);
        reservationsPanel.setLayout(reservationsPanelLayout);
        reservationsPanelLayout.setHorizontalGroup(
            reservationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reservationsPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 897, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reservationsPanelLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(reservationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(reservationsPanelLayout.createSequentialGroup()
                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addGroup(reservationsPanelLayout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jButton10)))
                .addGap(50, 50, 50))
        );
        reservationsPanelLayout.setVerticalGroup(
            reservationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reservationsPanelLayout.createSequentialGroup()
                .addGroup(reservationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(reservationsPanelLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(reservationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(reservationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton10)))
                    .addGroup(reservationsPanelLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(58, 58, 58)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        homeDashboardPanel.add(reservationsPanel, "reservationsCard");

        guestsPanel.setBackground(new java.awt.Color(253, 253, 253));

        guestTable.setAutoCreateRowSorter(true);
        guestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IC/Passport No.", "Name", "Email", "Contact"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        guestTable.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                guestTablePropertyChange(evt);
            }
        });
        jScrollPane4.setViewportView(guestTable);

        jLabel33.setFont(new java.awt.Font("Roboto", 1, 55)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 128, 128));
        jLabel33.setText("Guests Information.");

        searchTextField1.setText("Search IC/Passport Num.");
        searchTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextField1ActionPerformed(evt);
            }
        });
        searchTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTextField1KeyReleased(evt);
            }
        });

        jButton13.setText("Search");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton15.setText("Delete Record");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setText("Edit Record");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout guestsPanelLayout = new javax.swing.GroupLayout(guestsPanel);
        guestsPanel.setLayout(guestsPanelLayout);
        guestsPanelLayout.setHorizontalGroup(
            guestsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(guestsPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(guestsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(guestsPanelLayout.createSequentialGroup()
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(guestsPanelLayout.createSequentialGroup()
                        .addComponent(searchTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton13)))
                .addGap(44, 44, 44))
            .addGroup(guestsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(guestsPanelLayout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 897, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)))
        );
        guestsPanelLayout.setVerticalGroup(
            guestsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(guestsPanelLayout.createSequentialGroup()
                .addGroup(guestsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(guestsPanelLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(guestsPanelLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(guestsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(9, 9, 9)
                .addGroup(guestsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton16)
                    .addComponent(jButton15))
                .addContainerGap(503, Short.MAX_VALUE))
            .addGroup(guestsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(guestsPanelLayout.createSequentialGroup()
                    .addGap(181, 181, 181)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(70, Short.MAX_VALUE)))
        );

        homeDashboardPanel.add(guestsPanel, "guestsCard");

        paymentPanel.setBackground(new java.awt.Color(253, 253, 253));

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 55)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 128, 128));
        jLabel4.setText("Payments.");

        queryTextField.setText("Search Booking ID");

        jButton5.setText("Search");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        addPaymentButton.setText("Add Payment");
        addPaymentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPaymentButtonActionPerformed(evt);
            }
        });

        paymentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Booking ID", "IC/Passport No.", "Name", "Room No.", "Check In", "Check Out", "Length of Stay"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(paymentTable);

        javax.swing.GroupLayout paymentPanelLayout = new javax.swing.GroupLayout(paymentPanel);
        paymentPanel.setLayout(paymentPanelLayout);
        paymentPanelLayout.setHorizontalGroup(
            paymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentPanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(paymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paymentPanelLayout.createSequentialGroup()
                        .addComponent(queryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5))
                    .addComponent(addPaymentButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59))
            .addGroup(paymentPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 897, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        paymentPanelLayout.setVerticalGroup(
            paymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentPanelLayout.createSequentialGroup()
                .addGroup(paymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paymentPanelLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(paymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(queryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addComponent(addPaymentButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paymentPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addGap(47, 47, 47)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        homeDashboardPanel.add(paymentPanel, "paymentCard");

        settingsPanel.setBackground(new java.awt.Color(253, 253, 253));

        jLabel32.setFont(new java.awt.Font("Roboto", 1, 55)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 128, 128));
        jLabel32.setText("Settings.");

        jButton9.setText("Clear System");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        resetButton.setText("Reset System ");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel3.setText("To perform a full factory reset , use the Reset System function. This will reset all data currently in the system.");

        jLabel37.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel37.setText("To reset the system after 7 days , use the Clear System function. ");

        jLabel38.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel38.setText("This will remove all booking and payment data , but retains guest information.");

        javax.swing.GroupLayout settingsPanelLayout = new javax.swing.GroupLayout(settingsPanel);
        settingsPanel.setLayout(settingsPanelLayout);
        settingsPanelLayout.setHorizontalGroup(
            settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingsPanelLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addComponent(jLabel37)
                    .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        settingsPanelLayout.setVerticalGroup(
            settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingsPanelLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel32)
                .addGap(60, 60, 60)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel38)
                .addGap(38, 38, 38)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jLabel3)
                .addGap(31, 31, 31)
                .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(194, Short.MAX_VALUE))
        );

        homeDashboardPanel.add(settingsPanel, "settingsCard");

        checkAvailabilityPanel.setBackground(new java.awt.Color(253, 253, 253));

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 55)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 128, 128));
        jLabel5.setText("Check Availability");

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(47, 51, 55));
        jLabel6.setText("Check Out");

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(47, 51, 55));
        jLabel7.setText("Check In ");

        checkInCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Monday ", "Tuesday", "Wednesday", "Thursday ", "Friday ", "Saturday ", "Sunday " }));
        checkInCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkInComboboxActionPerformed(evt);
            }
        });

        checkOutCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Monday ", "Tuesday", "Wednesday", "Thursday ", "Friday ", "Saturday ", "Sunday " }));
        checkOutCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkOutComboboxActionPerformed(evt);
            }
        });

        availableRoomList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(availableRoomList);

        jPanel2.setBackground(new java.awt.Color(0, 128, 128));

        jButton3.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(253, 253, 253));
        jButton3.setText("Book Room");
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setFocusPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout checkAvailabilityPanelLayout = new javax.swing.GroupLayout(checkAvailabilityPanel);
        checkAvailabilityPanel.setLayout(checkAvailabilityPanelLayout);
        checkAvailabilityPanelLayout.setHorizontalGroup(
            checkAvailabilityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(checkAvailabilityPanelLayout.createSequentialGroup()
                .addContainerGap(227, Short.MAX_VALUE)
                .addGroup(checkAvailabilityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, checkAvailabilityPanelLayout.createSequentialGroup()
                        .addGroup(checkAvailabilityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(checkAvailabilityPanelLayout.createSequentialGroup()
                                .addGap(153, 153, 153)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(checkAvailabilityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, checkAvailabilityPanelLayout.createSequentialGroup()
                                    .addGroup(checkAvailabilityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7))
                                    .addGap(66, 66, 66)
                                    .addGroup(checkAvailabilityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(checkInCombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(checkOutCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(69, 69, 69))))
                        .addGap(205, 205, 205))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, checkAvailabilityPanelLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(229, 229, 229))))
        );
        checkAvailabilityPanelLayout.setVerticalGroup(
            checkAvailabilityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(checkAvailabilityPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(checkAvailabilityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(checkInCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(checkAvailabilityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(checkAvailabilityPanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel6))
                    .addGroup(checkAvailabilityPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(checkOutCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        homeDashboardPanel.add(checkAvailabilityPanel, "addReservationCard");

        customerInfoPanel.setBackground(new java.awt.Color(253, 253, 253));
        customerInfoPanel.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                customerInfoPanelComponentAdded(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 128, 128));
        jLabel8.setText("Customer Information");

        jLabel9.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(47, 51, 55));
        jLabel9.setText("Room Number");

        roomNumberLabel.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        roomNumberLabel.setForeground(new java.awt.Color(47, 51, 55));
        roomNumberLabel.setText("R004");

        jLabel11.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(47, 51, 55));
        jLabel11.setText("Length of Stay");

        lengthOfStayLabel.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lengthOfStayLabel.setForeground(new java.awt.Color(47, 51, 55));
        lengthOfStayLabel.setText("Monday - Tuesday");

        jLabel13.setFont(new java.awt.Font("Roboto", 1, 55)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 128, 128));
        jLabel13.setText("Confirm Booking");

        durationOfStayLabel.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        durationOfStayLabel.setForeground(new java.awt.Color(47, 51, 55));
        durationOfStayLabel.setText("2 days");

        jLabel15.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(47, 51, 55));
        jLabel15.setText("Duration of Stay");

        nameTextBox.setText("Name");
        nameTextBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextBoxActionPerformed(evt);
            }
        });

        icNumberTextBox.setText("IC No.");
        icNumberTextBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                icNumberTextBoxFocusLost(evt);
            }
        });
        icNumberTextBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                icNumberTextBoxActionPerformed(evt);
            }
        });

        emailTextBox.setText("Email");
        emailTextBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTextBoxActionPerformed(evt);
            }
        });

        contactTextBox.setText("Contact");
        contactTextBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactTextBoxActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 128, 128));

        jButton4.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(253, 253, 253));
        jButton4.setText("Complete Booking");
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout customerInfoPanelLayout = new javax.swing.GroupLayout(customerInfoPanel);
        customerInfoPanel.setLayout(customerInfoPanelLayout);
        customerInfoPanelLayout.setHorizontalGroup(
            customerInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customerInfoPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(309, 309, 309))
            .addGroup(customerInfoPanelLayout.createSequentialGroup()
                .addGroup(customerInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customerInfoPanelLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(customerInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(customerInfoPanelLayout.createSequentialGroup()
                                .addGroup(customerInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addGroup(customerInfoPanelLayout.createSequentialGroup()
                                        .addGap(60, 60, 60)
                                        .addComponent(roomNumberLabel)))
                                .addGroup(customerInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(customerInfoPanelLayout.createSequentialGroup()
                                        .addGap(185, 185, 185)
                                        .addComponent(jLabel11)
                                        .addGap(94, 94, 94))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customerInfoPanelLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lengthOfStayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(86, 86, 86)))
                                .addGroup(customerInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addGroup(customerInfoPanelLayout.createSequentialGroup()
                                        .addGap(69, 69, 69)
                                        .addComponent(durationOfStayLabel))))))
                    .addGroup(customerInfoPanelLayout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addGroup(customerInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(icNumberTextBox)
                            .addComponent(contactTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(76, 76, 76)
                        .addGroup(customerInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nameTextBox)
                            .addComponent(emailTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(115, Short.MAX_VALUE))
            .addGroup(customerInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(customerInfoPanelLayout.createSequentialGroup()
                    .addGap(71, 71, 71)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(364, Short.MAX_VALUE)))
        );
        customerInfoPanelLayout.setVerticalGroup(
            customerInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerInfoPanelLayout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addGroup(customerInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(customerInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(jLabel11))
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(customerInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(roomNumberLabel)
                    .addGroup(customerInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(durationOfStayLabel)
                        .addComponent(lengthOfStayLabel)))
                .addGap(57, 57, 57)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(customerInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(icNumberTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(customerInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contactTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
            .addGroup(customerInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(customerInfoPanelLayout.createSequentialGroup()
                    .addGap(64, 64, 64)
                    .addComponent(jLabel13)
                    .addContainerGap(528, Short.MAX_VALUE)))
        );

        homeDashboardPanel.add(customerInfoPanel, "confirmBookingPanel");

        paymentDetailsPanel.setBackground(new java.awt.Color(253, 253, 253));

        jLabel10.setFont(new java.awt.Font("Roboto", 1, 55)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 128, 128));
        jLabel10.setText("Payment Details.");

        jLabel12.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(47, 51, 55));
        jLabel12.setText("Customer IC ");

        jLabel14.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(47, 51, 55));
        jLabel14.setText("Booking ID");

        jLabel16.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(47, 51, 55));
        jLabel16.setText("Customer Name");

        jLabel17.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(47, 51, 55));
        jLabel17.setText("Length of Stay ");

        jLabel18.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel18.setText("Room Charges");

        jLabel19.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel19.setText("Tourism Tax");

        jLabel20.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel20.setText("Service Tax ");

        jLabel21.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel21.setText("Total");

        jLabel23.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(47, 51, 55));
        jLabel23.setText("10%");

        roomChargesLabel.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        roomChargesLabel.setForeground(new java.awt.Color(47, 51, 55));
        roomChargesLabel.setText("Room Charges");

        jLabel25.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(47, 51, 55));
        jLabel25.setText("RM 10 / night");

        totalChargesLabel.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        totalChargesLabel.setForeground(new java.awt.Color(47, 51, 55));
        totalChargesLabel.setText("totalChargesLabel");

        jLabel24.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel24.setText("Enter payment amount");

        paymentAmountTextField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        paymentAmountTextField.setForeground(new java.awt.Color(47, 51, 55));
        paymentAmountTextField.setText("Eg. 150");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel19)
                    .addComponent(jLabel18)
                    .addComponent(jLabel21)
                    .addComponent(jLabel24))
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel23)
                        .addComponent(roomChargesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(totalChargesLabel)
                        .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(paymentAmountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(roomChargesLabel)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel23)
                        .addGap(61, 61, 61)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(jLabel19))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totalChargesLabel)
                            .addComponent(jLabel21)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel20)))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(paymentAmountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        customerICLabel.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        customerICLabel.setText("Customer IC ");

        bookingIDLabel.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        bookingIDLabel.setText("Booking ID");

        customerNameLabel.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        customerNameLabel.setText("Customer Name");

        lengthOfStaylabel.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lengthOfStaylabel.setText("Length of Stay ");

        jLabel26.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(47, 51, 55));
        jLabel26.setText("Booked Room ");

        bookedRoomLabel.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        bookedRoomLabel.setText("Booked Room ");

        jPanel6.setBackground(new java.awt.Color(0, 128, 128));
        jPanel6.setForeground(new java.awt.Color(0, 128, 128));

        jButton7.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(253, 253, 253));
        jButton7.setText("Make payment ");
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.setFocusPainted(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout paymentDetailsPanelLayout = new javax.swing.GroupLayout(paymentDetailsPanel);
        paymentDetailsPanel.setLayout(paymentDetailsPanelLayout);
        paymentDetailsPanelLayout.setHorizontalGroup(
            paymentDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paymentDetailsPanelLayout.createSequentialGroup()
                .addContainerGap(333, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(315, 315, 315))
            .addGroup(paymentDetailsPanelLayout.createSequentialGroup()
                .addGroup(paymentDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paymentDetailsPanelLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(paymentDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel26))
                        .addGap(55, 55, 55)
                        .addGroup(paymentDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bookedRoomLabel)
                            .addComponent(customerICLabel)
                            .addComponent(bookingIDLabel)
                            .addComponent(customerNameLabel)
                            .addComponent(lengthOfStaylabel)))
                    .addGroup(paymentDetailsPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        paymentDetailsPanelLayout.setVerticalGroup(
            paymentDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentDetailsPanelLayout.createSequentialGroup()
                .addGroup(paymentDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paymentDetailsPanelLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(paymentDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(paymentDetailsPanelLayout.createSequentialGroup()
                                .addGap(258, 258, 258)
                                .addComponent(lengthOfStaylabel))
                            .addGroup(paymentDetailsPanelLayout.createSequentialGroup()
                                .addComponent(customerICLabel)
                                .addGap(54, 54, 54)
                                .addComponent(customerNameLabel)
                                .addGap(44, 44, 44)
                                .addComponent(bookingIDLabel)
                                .addGap(29, 29, 29)
                                .addComponent(bookedRoomLabel))
                            .addGroup(paymentDetailsPanelLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(54, 54, 54)
                                .addComponent(jLabel16)
                                .addGap(44, 44, 44)
                                .addComponent(jLabel14)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel26)
                                .addGap(39, 39, 39)
                                .addComponent(jLabel17)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paymentDetailsPanelLayout.createSequentialGroup()
                        .addContainerGap(112, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)))
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );

        homeDashboardPanel.add(paymentDetailsPanel, "paymentDetailsCard");

        paymentreceiptPanel.setBackground(new java.awt.Color(253, 253, 253));

        jLabel27.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 128, 128));
        jLabel27.setText("Payment Succesful.");

        jLabel28.setForeground(new java.awt.Color(51, 153, 0));
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotelmanagementsystem/greentick.png"))); // NOI18N

        jLabel29.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(47, 51, 55));
        jLabel29.setText("Booking ID :");

        jLabel30.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(47, 51, 55));
        jLabel30.setText("Amount Paid :");

        jLabel31.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(47, 51, 55));
        jLabel31.setText("Change :");

        bookingIDLabel_Payment.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        bookingIDLabel_Payment.setText("Booking ID :");

        amountPaidLabel_Payment.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        amountPaidLabel_Payment.setText("Amount Paid :");

        changeAmountLabel.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        changeAmountLabel.setText("Change :");

        jPanel4.setBackground(new java.awt.Color(0, 128, 128));
        jPanel4.setForeground(new java.awt.Color(0, 128, 128));

        jButton8.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jButton8.setForeground(new java.awt.Color(253, 253, 253));
        jButton8.setText("Return Home");
        jButton8.setBorderPainted(false);
        jButton8.setContentAreaFilled(false);
        jButton8.setFocusPainted(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout paymentreceiptPanelLayout = new javax.swing.GroupLayout(paymentreceiptPanel);
        paymentreceiptPanel.setLayout(paymentreceiptPanelLayout);
        paymentreceiptPanelLayout.setHorizontalGroup(
            paymentreceiptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentreceiptPanelLayout.createSequentialGroup()
                .addGap(44, 299, Short.MAX_VALUE)
                .addGroup(paymentreceiptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paymentreceiptPanelLayout.createSequentialGroup()
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(362, 362, 362))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paymentreceiptPanelLayout.createSequentialGroup()
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(220, 220, 220))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paymentreceiptPanelLayout.createSequentialGroup()
                        .addGroup(paymentreceiptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(paymentreceiptPanelLayout.createSequentialGroup()
                                .addGroup(paymentreceiptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel30)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel31))
                                .addGap(58, 58, 58)
                                .addGroup(paymentreceiptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(amountPaidLabel_Payment)
                                    .addComponent(bookingIDLabel_Payment)
                                    .addComponent(changeAmountLabel)))
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(262, 262, 262))))
        );
        paymentreceiptPanelLayout.setVerticalGroup(
            paymentreceiptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentreceiptPanelLayout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(paymentreceiptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(bookingIDLabel_Payment))
                .addGap(18, 18, 18)
                .addGroup(paymentreceiptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(amountPaidLabel_Payment))
                .addGap(29, 29, 29)
                .addGroup(paymentreceiptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(changeAmountLabel))
                .addGap(62, 62, 62)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );

        homeDashboardPanel.add(paymentreceiptPanel, "paymentreceiptCard");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sideNavigationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(homeDashboardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 955, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sideNavigationPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(homeDashboardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reservationsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reservationsButtonActionPerformed
        cardLayout.show(homeDashboardPanel, "reservationsCard");
        
        // Get file names of each booking in the booking directory 
        String[] existingBookingsDirectory = enumerateBookings();
        int i;

        // Clearing existing table contents first ( otherwise they stack up )
        DefaultTableModel model = (DefaultTableModel) bookingTable.getModel();
        model.setRowCount(0);

        // Loop through each booking file's contents
        for (i = 0; i < existingBookingsDirectory.length; i++) {
            String[] filedata = readBooking(existingBookingsDirectory[i]);
            model.addRow(filedata);
        }
    }//GEN-LAST:event_reservationsButtonActionPerformed

    private void guestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guestButtonActionPerformed
        cardLayout.show(homeDashboardPanel, "guestsCard");

        // Load guests information from text files 
        loadGuestTableContents();
    }//GEN-LAST:event_guestButtonActionPerformed

    private void paymentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentButtonActionPerformed
        cardLayout.show(homeDashboardPanel, "paymentCard");

        // Get file names of each booking in the booking directory 
        String[] existingBookingsDirectory = enumerateBookings();
        int i;

        // Clearing existing table contents first ( otherwise they stack up )
        DefaultTableModel model = (DefaultTableModel) paymentTable.getModel();
        model.setRowCount(0);

        // Loop through each booking file's contents
        for (i = 0; i < existingBookingsDirectory.length; i++) {
            String[] filedata = readBooking(existingBookingsDirectory[i]);
            model.addRow(filedata);
        }
    }//GEN-LAST:event_paymentButtonActionPerformed

    private void settingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsButtonActionPerformed
        cardLayout.show(homeDashboardPanel, "settingsCard");
    }//GEN-LAST:event_settingsButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cardLayout.show(homeDashboardPanel, "addReservationCard");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        DefaultTableModel model = (DefaultTableModel) bookingTable.getModel();
        TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<DefaultTableModel>(model);
        bookingTable.setRowSorter(rowSorter);

        // Get search query and filter the table based on the query 
        String query = searchTextField.getText();
        rowSorter.setRowFilter(RowFilter.regexFilter(query));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void checkInComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkInComboboxActionPerformed
        checkAvailability();
    }//GEN-LAST:event_checkInComboboxActionPerformed

    private void checkOutComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkOutComboboxActionPerformed
        checkAvailability();
    }//GEN-LAST:event_checkOutComboboxActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        if (checkOutCombobox.getSelectedIndex() < checkInCombobox.getSelectedIndex()) {
            // Validate day selection to make sure check in is before check out
            JOptionPane.showMessageDialog(homeDashboardPanel, "Check in cannot be after check out date. Please recheck your selection.");
        } else if (availableRoomList.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(homeDashboardPanel, "Please select a room.");
        } else {

            cardLayout.show(homeDashboardPanel, "confirmBookingPanel");

            // Pass selected check in and check out days
            String check_in = checkInCombobox.getSelectedItem().toString();
            String check_out = checkOutCombobox.getSelectedItem().toString();
            String length_stay = check_in + " - " + check_out;
            lengthOfStayLabel.setText(length_stay);

            // Psss calculated stay duration 
            int stay_duration = 1 + (checkOutCombobox.getSelectedIndex() - checkInCombobox.getSelectedIndex());
            durationOfStayLabel.setText(Integer.toString(stay_duration) + " days");

            // Pass selected room number
            roomNumberLabel.setText(availableRoomList.getSelectedValue());

            // Clear room list 
            DefaultListModel model = new DefaultListModel();
            model.removeAllElements();
            availableRoomList.setModel(model);

        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void nameTextBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextBoxActionPerformed

    private void icNumberTextBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_icNumberTextBoxActionPerformed

    }//GEN-LAST:event_icNumberTextBoxActionPerformed

    private void emailTextBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTextBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTextBoxActionPerformed

    private void contactTextBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactTextBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactTextBoxActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        try {

            // String to int conversion
            String ic_number = icNumberTextBox.getText();
            String contact = contactTextBox.getText();

            // Generate booking ID
            Random rand = new Random();
            int number = rand.nextInt(999999);
            String number_string = Integer.toString(number);
            String booking_id = "#" + number_string;

            // Creating new booking object 
            Booking newbooking = new Booking();
            newbooking.setBookingID(booking_id);
            newbooking.setICNumber(Integer.valueOf(ic_number));
            newbooking.setCustomerName(nameTextBox.getText());
            newbooking.setCustomerEmail(emailTextBox.getText());
            newbooking.setContactNumber(Integer.valueOf(contact));
            newbooking.setRoomNumber(roomNumberLabel.getText());
            newbooking.setCheckIn(checkInCombobox.getSelectedItem().toString());
            newbooking.setCheckOut(checkOutCombobox.getSelectedItem().toString());
            newbooking.setBookedDaysInt(daysToInt(checkInCombobox.getSelectedIndex(), checkOutCombobox.getSelectedIndex()));

            newbooking.bookRoom();

            // Clear old booking data 
            icNumberTextBox.setText("IC Number/Passport");
            nameTextBox.setText("Name");
            emailTextBox.setText("Email");
            contactTextBox.setText("Contact");

            // Redirect to home page , to prevent a second booking wihtout validation
            JOptionPane.showMessageDialog(homeDashboardPanel, "Booking added succesfully !");
            cardLayout.show(homeDashboardPanel, "reservationsCard");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(homeDashboardPanel, "Invalid details ! Please recheck information entered.");
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void customerInfoPanelComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_customerInfoPanelComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_customerInfoPanelComponentAdded

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        DefaultTableModel model = (DefaultTableModel) paymentTable.getModel();
        TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<DefaultTableModel>(model);
        paymentTable.setRowSorter(rowSorter);

        // Get search query and filter the table based on the query 
        String query = queryTextField.getText();
        rowSorter.setRowFilter(RowFilter.regexFilter(query));
    }//GEN-LAST:event_jButton5ActionPerformed

    private void addPaymentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPaymentButtonActionPerformed

        if (paymentTable.getSelectionModel().isSelectionEmpty()) {
            // Check if any payment record ws selected
            JOptionPane.showMessageDialog(homeDashboardPanel, "Please select a payment record.");
        } else {

            cardLayout.show(homeDashboardPanel, "paymentDetailsCard");

            // Get selected row 
            int row = paymentTable.getSelectedRow();

            // Pass selected row data 
            customerICLabel.setText(paymentTable.getModel().getValueAt(row, 1).toString());
            customerNameLabel.setText(paymentTable.getModel().getValueAt(row, 2).toString());
            bookedRoomLabel.setText(paymentTable.getModel().getValueAt(row, 3).toString());
            lengthOfStaylabel.setText(paymentTable.getModel().getValueAt(row, 6).toString());
            bookingIDLabel.setText(paymentTable.getModel().getValueAt(row, 0).toString());

            // Calculation of total charges and room charges #quickmaff
            int length_stay = Integer.parseInt(paymentTable.getModel().getValueAt(row, 6).toString());
            int room_charges = length_stay * 350;
            int total_charges = room_charges + ((room_charges * 10) / 100) + (length_stay * 10);

            // Set total and room charges labels
            roomChargesLabel.setText("RM " + room_charges);
            totalChargesLabel.setText("RM " + total_charges);
        }
    }//GEN-LAST:event_addPaymentButtonActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        try {

            // Calculating room charges and getting payment amount from textbox
            int paid_amount = Integer.parseInt(paymentAmountTextField.getText());
            int room_charges = Integer.parseInt(lengthOfStaylabel.getText()) * 350;

            Payment newPayment = new Payment(bookingIDLabel.getText());
            boolean isSufficient = newPayment.checkPaymentAmount(paid_amount, room_charges);

            if (isSufficient == true) {
                // Confirm payment if amount paid is sufficient
                cardLayout.show(homeDashboardPanel, "paymentreceiptCard");

                // Move paid bookings to the paidbooking folder
                try {
                    newPayment.moveFolders();
                } catch (IOException ex) {
                    System.out.println(ex);
                }

                // Pass variables to receipt page 
                bookingIDLabel_Payment.setText(bookingIDLabel.getText());
                amountPaidLabel_Payment.setText("RM " + paymentAmountTextField.getText());

                // Calculate and display change 
                int change = paid_amount - room_charges;
                changeAmountLabel.setText("RM " + String.valueOf(change));
            } else {
                JOptionPane.showMessageDialog(null, "Insufficient payment amount made.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(homeDashboardPanel, "Invalid amount entered.");
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        cardLayout.show(homeDashboardPanel, "paymentCard");

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        // Confirm clear system action
        int option = JOptionPane.showConfirmDialog(
                homeDashboardPanel,
                "Confirm clear system ? This action is irreversible.",
                "Confirm clear system",
                JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION) {

            // Delete all existing folder data
            resetSystem("bookingdays");
            resetSystem("bookinglist");
            resetSystem("paidbookings");

            // Check for days and bookinglist and paidbookings directories
            checkDaysDirectory();
            checkDirectory("bookinglist");
            checkDirectory("paidbookings");

            JOptionPane.showMessageDialog(null, "System cleared succesfully");

        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void searchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextFieldActionPerformed

    }//GEN-LAST:event_searchTextFieldActionPerformed

    private void searchTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldKeyReleased

    }//GEN-LAST:event_searchTextFieldKeyReleased

    private void bookingTablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_bookingTablePropertyChange

    }//GEN-LAST:event_bookingTablePropertyChange

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed

        if (bookingTable.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(homeDashboardPanel, "No record selected !");
        } else {
            // Confirm delete action
            int option = JOptionPane.showConfirmDialog(
                    homeDashboardPanel,
                    "Confirm delete action?",
                    "Confirm delete",
                    JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {

                // Get selected row's bookingID
                int row = bookingTable.getSelectedRow();
                String bookingID = bookingTable.getModel().getValueAt(row, 0).toString();

                // Create new bookign object and call its deleteRecord() method
                Booking deletedBooking = new Booking();
                deletedBooking.setBookingID(bookingID);
                deletedBooking.deleteRecord();
            }
        }


    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

    private void guestTablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_guestTablePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_guestTablePropertyChange

    private void searchTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextField1ActionPerformed

    private void searchTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextField1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextField1KeyReleased

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        DefaultTableModel model = (DefaultTableModel) guestTable.getModel();
        TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<DefaultTableModel>(model);
        guestTable.setRowSorter(rowSorter);

        // Get search query and filter the table based on the query 
        String query = searchTextField1.getText();
        rowSorter.setRowFilter(RowFilter.regexFilter(query));
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed

        if (guestTable.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(homeDashboardPanel, "No record selected !");
        } else {
            // Confirm delete action
            int option = JOptionPane.showConfirmDialog(
                    homeDashboardPanel,
                    "Confirm delete action?",
                    "Confirm delete",
                    JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {

                // Get selected row's bookingID
                int row = guestTable.getSelectedRow();
                String guestID = guestTable.getModel().getValueAt(row, 0).toString();

                // Create new bookign object and call its deleteRecord() method
                Guest deletedGuest = new Guest();
                deletedGuest.setguestID(guestID);
                deletedGuest.deleteRecord();

            }
        }

    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        if (guestTable.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(homeDashboardPanel, "No record selected !");
        } else {
            // Get selected row's information
            int row = guestTable.getSelectedRow();
            String guestID = guestTable.getModel().getValueAt(row, 0).toString();
            String custname = guestTable.getModel().getValueAt(row, 1).toString();
            String custemail = guestTable.getModel().getValueAt(row, 2).toString();
            String custcontact = guestTable.getModel().getValueAt(row, 3).toString();

            // Create new guest object and call the EditRecord method 
            Guest editedGuest = new Guest();
            editedGuest.setguestID(guestID);
            editedGuest.setCustomerName(custname);
            editedGuest.setCustomerEmail(custemail);
            editedGuest.setContactNumber(custcontact);
            
            editedGuest.EditRecord();
            
            JOptionPane.showMessageDialog(homeDashboardPanel, "Record updated !");
        }

    }//GEN-LAST:event_jButton16ActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed

        // Confirm reset system action
        int option = JOptionPane.showConfirmDialog(
                homeDashboardPanel,
                "Confirm reset system ? This action is irreversible.",
                "Confirm reset system",
                JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION) {

            // Delete all existing folder data
            resetSystem("bookingdays");
            resetSystem("bookinglist");
            resetSystem("paidbookings");
            resetSystem("guestinformation");

            // Recreate all necessary system directories
            checkDaysDirectory();
            checkDirectory("bookinglist");
            checkDirectory("paidbookings");
            checkDirectory("guestinformation");

            JOptionPane.showMessageDialog(null, "System reset succesfully");

        }


    }//GEN-LAST:event_resetButtonActionPerformed

    private void icNumberTextBoxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_icNumberTextBoxFocusLost

        String ic_number = icNumberTextBox.getText().trim();

        boolean existing_guests = searchGuest(ic_number);

        if (existing_guests == true) {

            int option = JOptionPane.showConfirmDialog(
                    homeDashboardPanel,
                    "Existing guest found. Would you like to autofill ?",
                    "Autofill guests",
                    JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                fillGuestInformation(ic_number);
            }
        }
    }//GEN-LAST:event_icNumberTextBoxFocusLost

    /**
     * @param args the command line arguments
     */
    public void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPaymentButton;
    private javax.swing.JLabel amountPaidLabel_Payment;
    private javax.swing.JList<String> availableRoomList;
    private javax.swing.JLabel bookedRoomLabel;
    private javax.swing.JLabel bookingIDLabel;
    private javax.swing.JLabel bookingIDLabel_Payment;
    private javax.swing.JTable bookingTable;
    private javax.swing.JLabel changeAmountLabel;
    private javax.swing.JPanel checkAvailabilityPanel;
    private javax.swing.JComboBox<String> checkInCombobox;
    private javax.swing.JComboBox<String> checkOutCombobox;
    private javax.swing.JTextField contactTextBox;
    private javax.swing.JLabel customerICLabel;
    private javax.swing.JPanel customerInfoPanel;
    private javax.swing.JLabel customerNameLabel;
    private javax.swing.JLabel durationOfStayLabel;
    private javax.swing.JTextField emailTextBox;
    private javax.swing.JButton guestButton;
    private javax.swing.JTable guestTable;
    private javax.swing.JPanel guestsPanel;
    private javax.swing.JPanel homeDashboardPanel;
    private javax.swing.JTextField icNumberTextBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lengthOfStayLabel;
    private javax.swing.JLabel lengthOfStaylabel;
    private javax.swing.JTextField nameTextBox;
    private javax.swing.JTextField passwordLabel1;
    private javax.swing.JTextField paymentAmountTextField;
    private javax.swing.JButton paymentButton;
    private javax.swing.JPanel paymentDetailsPanel;
    private javax.swing.JPanel paymentPanel;
    private javax.swing.JTable paymentTable;
    private javax.swing.JPanel paymentreceiptPanel;
    private javax.swing.JTextField queryTextField;
    private javax.swing.JButton reservationsButton;
    private javax.swing.JPanel reservationsPanel;
    private javax.swing.JButton resetButton;
    private javax.swing.JLabel roomChargesLabel;
    private javax.swing.JLabel roomNumberLabel;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JTextField searchTextField1;
    private javax.swing.JButton settingsButton;
    private javax.swing.JPanel settingsPanel;
    private javax.swing.JPanel sideNavigationPanel;
    private javax.swing.JLabel totalChargesLabel;
    private javax.swing.JTextField usernameLabel1;
    // End of variables declaration//GEN-END:variables
}
