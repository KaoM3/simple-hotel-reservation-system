package view.main;

public class WelcomePanel extends javax.swing.JPanel {

    public WelcomePanel() {
        initComponents();
    }

    private void initComponents() {
        pageHeading = new javax.swing.JLabel();
        viewInfo = new javax.swing.JLabel();
        manageInfo3 = new javax.swing.JLabel();
        noteInfo2 = new javax.swing.JLabel();
        manageInfo2 = new javax.swing.JLabel();
        noteLabel = new javax.swing.JLabel();
        createInfo = new javax.swing.JLabel();
        createLabel = new javax.swing.JLabel();
        viewLabel = new javax.swing.JLabel();
        manageLabel = new javax.swing.JLabel();
        manageInfo1 = new javax.swing.JLabel();
        bookLabel = new javax.swing.JLabel();
        bookInfo = new javax.swing.JLabel();
        noteInfo1 = new javax.swing.JLabel();

        setLayout(null);

        pageHeading.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        pageHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pageHeading.setText("Hotel Reservation System: Getting Started");
        add(pageHeading);
        pageHeading.setBounds(10, 30, 550, 60);

        viewInfo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        viewInfo.setText("is where you can view high-level and low-level details of a hotel.");
        add(viewInfo);
        viewInfo.setBounds(100, 150, 440, 30);

        manageInfo3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        manageInfo3.setText("rooms, and removing reservations.");
        add(manageInfo3);
        manageInfo3.setBounds(100, 250, 440, 30);

        noteInfo2.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        noteInfo2.setText("or trailing whitespaces. Hotel and room names should be unique.");
        add(noteInfo2);
        noteInfo2.setBounds(100, 400, 440, 30);

        manageInfo2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        manageInfo2.setText("updating its base rate and date price modifiers, modifying its list of");
        add(manageInfo2);
        manageInfo2.setBounds(100, 220, 440, 30);

        noteLabel.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        noteLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        noteLabel.setText("Note:");
        add(noteLabel);
        noteLabel.setBounds(20, 380, 60, 30);

        createInfo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        createInfo.setText("is where you can create a new hotel with a unique name.");
        add(createInfo);
        createInfo.setBounds(100, 110, 440, 30);

        createLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        createLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        createLabel.setText("Create:");
        add(createLabel);
        createLabel.setBounds(30, 110, 60, 30);

        viewLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        viewLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        viewLabel.setText("View:");
        add(viewLabel);
        viewLabel.setBounds(30, 150, 60, 30);

        manageLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        manageLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        manageLabel.setText("Manage:");
        add(manageLabel);
        manageLabel.setBounds(30, 190, 60, 30);

        manageInfo1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        manageInfo1.setText("is where you can manage a hotel's details such as renaming a hotel,");
        add(manageInfo1);
        manageInfo1.setBounds(100, 190, 440, 30);

        bookLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bookLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        bookLabel.setText("Book:");
        add(bookLabel);
        bookLabel.setBounds(30, 290, 60, 30);

        bookInfo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bookInfo.setText("is where you can create a new reservation for a selected hotel.");
        add(bookInfo);
        bookInfo.setBounds(100, 290, 440, 30);

        noteInfo1.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        noteInfo1.setText("all name fields require a 3 to 20 character long input, with no leading");
        add(noteInfo1);
        noteInfo1.setBounds(90, 380, 440, 30);
    }    

            
    private javax.swing.JLabel bookInfo;
    private javax.swing.JLabel bookLabel;
    private javax.swing.JLabel createInfo;
    private javax.swing.JLabel createLabel;
    private javax.swing.JLabel manageInfo1;
    private javax.swing.JLabel manageInfo2;
    private javax.swing.JLabel manageInfo3;
    private javax.swing.JLabel manageLabel;
    private javax.swing.JLabel noteInfo1;
    private javax.swing.JLabel noteInfo2;
    private javax.swing.JLabel noteLabel;
    private javax.swing.JLabel pageHeading;
    private javax.swing.JLabel viewInfo;
    private javax.swing.JLabel viewLabel;
}
