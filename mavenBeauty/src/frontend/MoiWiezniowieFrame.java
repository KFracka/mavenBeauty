package frontend;

import backend.HistoriaTerapii;
import backend.Psycholog;
import backend.Wiezien;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

public class MoiWiezniowieFrame extends javax.swing.JFrame {
    
    private EkranGlownyFrame glowny;
    Psycholog psycholog;

    public MoiWiezniowieFrame(EkranGlownyFrame glowny, Psycholog psycholog) {
        initComponents();
        this.glowny = glowny;
        this.psycholog = psycholog;
        
        historiaTerapiiiaTable.getColumnModel().getColumn(0).setPreferredWidth(5);
        
        DefaultListModel listModel = new DefaultListModel();
        
        List<HistoriaTerapii> wszystkieHistoriePsychologa =  wylistujHistorie(psycholog);
        List<Long> peselePowtorzone = new ArrayList<>();
        
        for (int i=0; i < wszystkieHistoriePsychologa.size(); i++) {
            peselePowtorzone.add(wszystkieHistoriePsychologa.get(i).getPesel().getPesel());
        }
        
        List<Long> pesele = new ArrayList<>(new HashSet<>(peselePowtorzone));
        
        for (int i=0; i < pesele.size(); i++) {
            listModel.addElement(pesele.get(i));
        }
        
        jListaWiezinow.setModel(listModel);
        
        jListaWiezinow.addListSelectionListener(e -> {
            wypelnijFormularz(String.valueOf(jListaWiezinow.getSelectedValue()));
        });
    }
    
    public void wypelnijFormularz(String pesel) {
        Long peselLong = Long.valueOf(pesel);
        
        //Informacje o pacjencie
        List<Wiezien> wiezienEntity = wyszukajWieziena(peselLong);
        wiezienImieLabel.setText("IMIĘ: " + String.valueOf(wiezienEntity.get(0).getImie()));
        wiezienNazwiskoLabel.setText("NAZWISKO: " + String.valueOf(wiezienEntity.get(0).getNazwisko()));
        wiezienPeselLabel.setText("PESEL: " + String.valueOf(wiezienEntity.get(0).getPesel()));
        wiezienDataUrodzeniaLabel.setText("D. URO.: " + String.valueOf(wiezienEntity.get(0).getDataUrodzenia().getDate()) + "/" +
                    String.valueOf(wiezienEntity.get(0).getDataUrodzenia().getMonth() + 1) + "/" +
                    String.valueOf(wiezienEntity.get(0).getDataUrodzenia().getYear() + 1900));
        
        if (wiezienEntity.get(0).getPlec()) {
            wiezienPlecLabel.setText("PŁEĆ: M");
        } else {
            wiezienPlecLabel.setText("PŁEĆ: K");
        }
        
        List<HistoriaTerapii> historiaWiezienaEntity = historieWieziena(wiezienEntity.get(0));
        DefaultTableModel tableModel = (DefaultTableModel) historiaTerapiiiaTable.getModel();
        
        if (tableModel.getRowCount() > 0) {
            tableModel.setRowCount(0);
        }
        
        Object rowData[] = new Object[4];
        for(int i=0; i < historiaWiezienaEntity.size(); i++) {
            rowData[0] = historiaWiezienaEntity.get(i).getId();
            rowData[1] = historiaWiezienaEntity.get(i).getChoroba();
            rowData[2] = 
                    String.valueOf(historiaWiezienaEntity.get(i).getDataPrzyjecia().getDate()) + "/" +
                    String.valueOf(historiaWiezienaEntity.get(i).getDataPrzyjecia().getMonth() + 1) + "/" +
                    String.valueOf(historiaWiezienaEntity.get(i).getDataPrzyjecia().getYear() + 1900);
            rowData[3] = 
                    String.valueOf(historiaWiezienaEntity.get(i).getDataWypisu().getDate()) + "/" +
                    String.valueOf(historiaWiezienaEntity.get(i).getDataWypisu().getMonth() + 1) + "/" +
                    String.valueOf(historiaWiezienaEntity.get(i).getDataWypisu().getYear() + 1900);
            
            tableModel.addRow(rowData);
        }
        
    }
    
    EntityManagerFactory emf;
    public EntityManager getEntityManager() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("WiezieniePU");
        }
        return emf.createEntityManager();
    }
    //pobierz historie terapii wiezienów zalogowanego psychologa
    public List<HistoriaTerapii> wylistujHistorie(Psycholog idPsychologa){
        EntityManager em = this.getEntityManager();
        TypedQuery<HistoriaTerapii> q = em.createNamedQuery("HistoriaTerapii.findByIdPsychologa", HistoriaTerapii.class);
        q.setParameter("idPsychologa", idPsychologa.getIdPsychologa());

        return q.getResultList();
    }
    
    //z pobranej historii terapii wyciągnij pesele
    public List<Wiezien> wylistujWiezinow(List<HistoriaTerapii> historiaTerapii){
        EntityManager em = this.getEntityManager();
        TypedQuery<Wiezien> q = em.createNamedQuery("Wiezien.findByPesel", Wiezien.class);
        for(int i=0; i<historiaTerapii.size(); i++) {
            q.setParameter("pesel", historiaTerapii.get(i).getPesel().getPesel());
        }
        return q.getResultList();
    }
    
    public List<Wiezien> wyszukajWieziena(Long pesel){
        EntityManager em = this.getEntityManager();
        TypedQuery<Wiezien> q = em.createNamedQuery("Wiezien.findByPesel", Wiezien.class);
        q.setParameter("pesel", pesel);
        return q.getResultList();
    }
    
    public List<HistoriaTerapii> historieWieziena(Wiezien wiezien){
        EntityManager em = this.getEntityManager();
        TypedQuery<HistoriaTerapii> q = em.createNamedQuery("HistoriaTerapii.findByPesel", HistoriaTerapii.class);
        q.setParameter("pesel", wiezien.getPesel());
        
        return q.getResultList();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListaWiezinow = new javax.swing.JList<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        historiaTerapiiiaTable = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        wiezienNazwiskoLabel = new javax.swing.JLabel();
        wiezienImieLabel = new javax.swing.JLabel();
        wiezienPeselLabel = new javax.swing.JLabel();
        wiezienDataUrodzeniaLabel = new javax.swing.JLabel();
        wiezienPlecLabel = new javax.swing.JLabel();
        jNazwa = new javax.swing.JLabel();
        jOpis = new javax.swing.JLabel();
        powrotButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(java.awt.SystemColor.desktop);
        background.setFocusable(false);
        background.setFont(new java.awt.Font("SF Pro Display", 0, 12)); // NOI18N
        background.setInheritsPopupMenu(true);
        background.setMinimumSize(new java.awt.Dimension(1000, 670));
        background.setPreferredSize(new java.awt.Dimension(1000, 670));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jListaWiezinow.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jListaWiezinow);

        background.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 240, 440));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        historiaTerapiiiaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Choroba", "Data Przyjęcia", "Data Wypisu"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(historiaTerapiiiaTable);
        if (historiaTerapiiiaTable.getColumnModel().getColumnCount() > 0) {
            historiaTerapiiiaTable.getColumnModel().getColumn(0).setResizable(false);
            historiaTerapiiiaTable.getColumnModel().getColumn(2).setResizable(false);
            historiaTerapiiiaTable.getColumnModel().getColumn(3).setResizable(false);
        }

        wiezienNazwiskoLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        wiezienNazwiskoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wiezienNazwiskoLabel.setText("NAZWISKO: ");

        wiezienImieLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        wiezienImieLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wiezienImieLabel.setText("IMIĘ: ");

        wiezienPeselLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        wiezienPeselLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wiezienPeselLabel.setText("PESEL: ");

        wiezienDataUrodzeniaLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        wiezienDataUrodzeniaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wiezienDataUrodzeniaLabel.setText("D. URO.:");

        wiezienPlecLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        wiezienPlecLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wiezienPlecLabel.setText("PŁEĆ: ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(wiezienImieLabel)
                            .addComponent(wiezienNazwiskoLabel))
                        .addGap(70, 70, 70)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(wiezienDataUrodzeniaLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                                .addComponent(wiezienPlecLabel))
                            .addComponent(wiezienPeselLabel))
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wiezienImieLabel)
                    .addComponent(wiezienDataUrodzeniaLabel)
                    .addComponent(wiezienPlecLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wiezienNazwiskoLabel)
                    .addComponent(wiezienPeselLabel))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        background.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, 480, 440));

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

        powrotButton.setBackground(new java.awt.Color(255, 0, 204));
        powrotButton.setFont(new java.awt.Font("SF Pro Display", 1, 14)); // NOI18N
        powrotButton.setForeground(new java.awt.Color(255, 255, 255));
        powrotButton.setText("POWRÓT DO PANELU GŁÓWNEGO");
        powrotButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                powrotButtonActionPerformed(evt);
            }
        });
        background.add(powrotButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 630, -1, -1));

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
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void powrotButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_powrotButtonActionPerformed
        glowny.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_powrotButtonActionPerformed

    public static void main(String args[]) {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    public javax.swing.JTable historiaTerapiiiaTable;
    public javax.swing.JList<String> jListaWiezinow;
    private javax.swing.JLabel jNazwa;
    private javax.swing.JLabel jOpis;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton powrotButton;
    private javax.swing.JLabel wiezienDataUrodzeniaLabel;
    private javax.swing.JLabel wiezienImieLabel;
    private javax.swing.JLabel wiezienNazwiskoLabel;
    private javax.swing.JLabel wiezienPeselLabel;
    private javax.swing.JLabel wiezienPlecLabel;
    // End of variables declaration//GEN-END:variables

}
