package frontend;

import backend.Psycholog;

public class EkranGlownyFrame extends javax.swing.JFrame {

    Psycholog psycholog;
    
    public EkranGlownyFrame(Psycholog psycholog) {
        initComponents();
        this.psycholog = psycholog;
        
        this.jImieNazwisko.setText(String.valueOf(psycholog.getImie()) + ' ' + String.valueOf(psycholog.getNazwisko()));
        this.jId.setText("ID: " + String.valueOf(psycholog.getIdPsychologa()));
        this.jSpecjalizacja.setText("Specjalizacja: " + String.valueOf(psycholog.getSpecjalizacja()));
        this.jOddział.setText("Oddział: " + String.valueOf(psycholog.getNazwaOddzialu().getNazwaOddzialu()));
        
        wyszukiwarka = new WyszukiwarkaFrame(this);
        wyszukiwarka.setTitle("Wyszukiwarka");
        wyszukiwarka.setSize(1000,700);
        
        dodaj = new DodajWiezniaFrame(this);
        dodaj.setTitle("Dodawanie nowego wieznia");
        dodaj.setSize(1000,700);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        bWyszukiwarka = new javax.swing.JButton();
        szczegolyButton = new javax.swing.JButton();
        bWyloguj = new javax.swing.JButton();
        bWiezien = new javax.swing.JButton();
        historiaButton = new javax.swing.JButton();
        jNazwa = new javax.swing.JLabel();
        jOpis = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jSpecjalizacja = new javax.swing.JLabel();
        jId = new javax.swing.JLabel();
        jOddział = new javax.swing.JLabel();
        jAvatar = new javax.swing.JLabel();
        jImieNazwisko = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(new java.awt.Color(0, 0, 0));
        background.setFocusable(false);
        background.setFont(new java.awt.Font("SF Pro Display", 0, 12)); // NOI18N
        background.setInheritsPopupMenu(true);
        background.setMaximumSize(new java.awt.Dimension(1000, 730));
        background.setMinimumSize(new java.awt.Dimension(1000, 700));
        background.setPreferredSize(new java.awt.Dimension(1000, 670));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        bWyszukiwarka.setBackground(new java.awt.Color(255, 0, 204));
        bWyszukiwarka.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bWyszukiwarka.setForeground(new java.awt.Color(255, 255, 255));
        bWyszukiwarka.setText("WYSZUKIWARKA");
        bWyszukiwarka.setAlignmentY(1.0F);
        bWyszukiwarka.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bWyszukiwarka.setMargin(new java.awt.Insets(6, 20, 6, 20));
        bWyszukiwarka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bWyszukiwarkaActionPerformed(evt);
            }
        });

        szczegolyButton.setBackground(new java.awt.Color(255, 0, 204));
        szczegolyButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        szczegolyButton.setForeground(new java.awt.Color(255, 255, 255));
        szczegolyButton.setText("DODAJ PACJENTA");
        szczegolyButton.setAlignmentY(1.0F);
        szczegolyButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        szczegolyButton.setMargin(new java.awt.Insets(6, 20, 6, 20));
        szczegolyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                szczegolyButtonActionPerformed(evt);
            }
        });

        bWyloguj.setBackground(new java.awt.Color(255, 0, 204));
        bWyloguj.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bWyloguj.setForeground(new java.awt.Color(255, 255, 255));
        bWyloguj.setText("WYLOGUJ");
        bWyloguj.setAlignmentY(1.0F);
        bWyloguj.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bWyloguj.setMargin(new java.awt.Insets(6, 20, 6, 20));
        bWyloguj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bWylogujActionPerformed(evt);
            }
        });

        bWiezien.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bWiezien.setForeground(new java.awt.Color(255, 255, 255));
        bWiezien.setText("MOI PACJENCI");
        bWiezien.setAlignmentY(1.0F);
        bWiezien.setBorderPainted(false);
        bWiezien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bWiezien.setMargin(new java.awt.Insets(6, 20, 6, 20));
        bWiezien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bWiezienActionPerformed(evt);
            }
        });

        historiaButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        historiaButton.setForeground(new java.awt.Color(255, 255, 255));
        historiaButton.setText("HISTORIA LECZEŃ");
        historiaButton.setAlignmentY(1.0F);
        historiaButton.setBorderPainted(false);
        historiaButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        historiaButton.setMargin(new java.awt.Insets(6, 20, 6, 20));
        historiaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historiaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(bWyszukiwarka, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(szczegolyButton)
                    .addComponent(bWyloguj, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bWiezien, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(historiaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bWiezien, bWyszukiwarka, szczegolyButton});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(szczegolyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(bWyszukiwarka, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(bWyloguj, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(bWiezien)
                .addGap(29, 29, 29)
                .addComponent(historiaButton)
                .addGap(42, 42, 42))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bWiezien, bWyszukiwarka, szczegolyButton});

        background.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 160, 340, 440));

        jNazwa.setFont(new java.awt.Font("Segoe UI", 3, 54)); // NOI18N
        jNazwa.setForeground(new java.awt.Color(255, 255, 255));
        jNazwa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jNazwa.setText("Wiezienie Maven");
        background.add(jNazwa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1000, -1));

        jOpis.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jOpis.setForeground(new java.awt.Color(255, 0, 204));
        jOpis.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jOpis.setText("centrum zarządzania historią leczeń");
        background.add(jOpis, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jSpecjalizacja.setFont(new java.awt.Font("SF Pro Display", 1, 20)); // NOI18N
        jSpecjalizacja.setText("Specjalizacja:");

        jId.setFont(new java.awt.Font("SF Pro Display", 1, 20)); // NOI18N
        jId.setText("ID: ");

        jOddział.setFont(new java.awt.Font("SF Pro Display", 1, 20)); // NOI18N
        jOddział.setText("Oddział:");

        jAvatar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jAvatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wiezienie/images/avat.png"))); // NOI18N

        jImieNazwisko.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jImieNazwisko.setText("Imie Naziwsko");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jOddział, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jSpecjalizacja, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                                .addComponent(jId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 29, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jImieNazwisko, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(139, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jAvatar))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jImieNazwisko, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(54, 54, 54)
                .addComponent(jId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSpecjalizacja)
                .addGap(18, 18, 18)
                .addComponent(jOddział)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jImieNazwisko.getAccessibleContext().setAccessibleName("Imie Nazwisko");

        background.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 480, 440));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bWiezienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bWiezienActionPerformed
        pacjenci = new MoiWiezniowieFrame(this, psycholog);
        pacjenci.setTitle("Panel psychologa");
        pacjenci.setSize(1000,700);
        pacjenci.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bWiezienActionPerformed

    private void historiaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historiaButtonActionPerformed
    }//GEN-LAST:event_historiaButtonActionPerformed

    private void bWyszukiwarkaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bWyszukiwarkaActionPerformed
        wyszukiwarka.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bWyszukiwarkaActionPerformed

    private void bWylogujActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bWylogujActionPerformed
        System.exit(0);
    }//GEN-LAST:event_bWylogujActionPerformed

    private void szczegolyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_szczegolyButtonActionPerformed
        dodaj.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_szczegolyButtonActionPerformed

    public static void main(String args[]) {

//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new EkranGlownyFrame().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bWiezien;
    private javax.swing.JButton bWyloguj;
    private javax.swing.JButton bWyszukiwarka;
    private javax.swing.JPanel background;
    private javax.swing.JButton historiaButton;
    private javax.swing.JLabel jAvatar;
    public javax.swing.JLabel jId;
    private javax.swing.JLabel jImieNazwisko;
    private javax.swing.JLabel jNazwa;
    public javax.swing.JLabel jOddział;
    private javax.swing.JLabel jOpis;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JLabel jSpecjalizacja;
    private javax.swing.JButton szczegolyButton;
    // End of variables declaration//GEN-END:variables

    private MoiWiezniowieFrame pacjenci;
    private WyszukiwarkaFrame wyszukiwarka;
    private DodajWiezniaFrame dodaj;

}
