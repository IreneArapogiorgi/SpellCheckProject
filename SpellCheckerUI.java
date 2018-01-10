package my.spellchecker;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
* SpellCheckerUI class is the leading class of our project.<br>
* It is used for the Graphical User Interface (GUI) of the spell checker project.
* 
* @author Javengers team
* @see Word,DataInput
*/

public class SpellCheckerUI extends javax.swing.JFrame {

   /** SpellCheckUI creates new form SpellCheckerUI
    *
    * Method used to initialize the JDialogs, the JPanels,<br>
    * the JScrollPanes, the JLists, the JButtons, the JTextFields,<br>
    * the JTextAreas,the JPasswordFields and the JLabels that <br>
    * are used in the program.
    * 
    * JDialogs are dialog windows.<br>
    * 
    * JPanels are generic lightweight containers.<br>
    * 
    * JScrollPanes are scrollable views of lightweight components.<br>
    * 
    * JLists are components that allow the user to select one or <br>
    * more objects from a list.<br>
    * 
    * JButtons are "push" buttons.<br>
    * 
    * JTextFields are lightweight components that allows the editing<br>
    * of a single line of text.<br>
    * 
    * JTextAreas are multi-line areas that display plain text.<br>
    * 
    * JLabels are display areas for a short text string, image or both.<br>
    * 
    * JPasswordFields are components that allow the editing of a <br>
    * single line of text where the view indicates something was <br>
    * typed, but does not show the original characters.
    * <p>
    * This method initializes the names, positions, borders and <br>
    * sizes of the above. The JButtons also are connected with the<br>
    * corresponding "actionPerformed" type methods and the kind of<br>
    *   data shown in the JLists is specified. 
    */
    public SpellCheckerUI() {
        initComponents();
    }
    
    static String username = new String();
    static String password = new String();
    protected static Connection myConn;
    static List<Word> wordsList = new ArrayList<Word>();
    static List<String> str = new LinkedList<>();
    static String[] altWords = new String[3];
          
    /**
     * initComponents is called from within the constructor to initialize the form
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        spellCheckDialog = new javax.swing.JDialog();
        wrongSpelledTextPanel = new javax.swing.JPanel();
        wrongWordsScrollPane = new javax.swing.JScrollPane();
        wrongWordsList = new javax.swing.JList();
        altWordButton = new javax.swing.JButton();
        cancelButton1 = new javax.swing.JButton();
        finalTextButton = new javax.swing.JButton();
        alternativeWordDialog = new javax.swing.JDialog();
        altWordPanel = new javax.swing.JPanel();
        altWordScrollPane = new javax.swing.JScrollPane();
        altWordList = new javax.swing.JList();
        cancelButton2 = new javax.swing.JButton();
        replaceAltWordButton = new javax.swing.JButton();
        exceptionInOpenFileUsingPathDialog = new javax.swing.JDialog();
        exceptionLabel = new javax.swing.JLabel();
        closeExceptionWindowButton = new javax.swing.JButton();
        textDialog = new javax.swing.JDialog();
        textPanel = new javax.swing.JPanel();
        textScrollPane = new javax.swing.JScrollPane();
        textTextArea = new javax.swing.JTextArea();
        spellCheckButton = new javax.swing.JButton();
        cancelTextPanelButton = new javax.swing.JButton();
        fileDialog = new javax.swing.JDialog();
        openFilePanel = new javax.swing.JPanel();
        pathTextField = new javax.swing.JTextField();
        pathButton = new javax.swing.JButton();
        encodingTypeTextField = new javax.swing.JTextField();
        cancelFileDialogButton = new javax.swing.JButton();
        chooseDialog = new javax.swing.JDialog();
        choosePanel = new javax.swing.JPanel();
        chooseInsertTextButton = new javax.swing.JButton();
        chooseOpenFileButton = new javax.swing.JButton();
        browseHtmlButton = new javax.swing.JButton();
        exitButton1 = new javax.swing.JButton();
        htmlDialog = new javax.swing.JDialog();
        openHtmlPanel = new javax.swing.JPanel();
        urlTextField = new javax.swing.JTextField();
        urlButton = new javax.swing.JButton();
        cancelHtmlDialogButton = new javax.swing.JButton();
        databaseDialog = new javax.swing.JDialog();
        databasePanel = new javax.swing.JPanel();
        usernameLabel1 = new javax.swing.JLabel();
        usernameLabel2 = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        passwordLabel1 = new javax.swing.JLabel();
        passwordLabel2 = new javax.swing.JLabel();
        passwordPasswordField = new javax.swing.JPasswordField();
        exitButton2 = new javax.swing.JButton();
        nextButton2 = new javax.swing.JButton();
        finalTextDialog = new javax.swing.JDialog();
        finalTextPanel = new javax.swing.JPanel();
        finalTextScrollPane = new javax.swing.JScrollPane();
        finalTextTextArea = new javax.swing.JTextArea();
        welcomePanel = new javax.swing.JPanel();
        welcomeLabel = new javax.swing.JLabel();
        nextButton1 = new javax.swing.JButton();

        spellCheckDialog.setMinimumSize(new java.awt.Dimension(340, 400));

        wrongSpelledTextPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Wrong Spelled Words", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        wrongWordsList.setModel(new javax.swing.AbstractListModel() {
            public int getSize() { return str.size(); }
            public Object getElementAt(int i) { return str.get(i); }
        });
        wrongWordsList.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        wrongWordsScrollPane.setViewportView(wrongWordsList);

        altWordButton.setText("Find Alternative");
        altWordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                altWordButtonActionPerformed(evt);
            }
        });

        cancelButton1.setText("Cancel");
        cancelButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButton1ActionPerformed(evt);
            }
        });

        finalTextButton.setText("Show Final Text");
        finalTextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalTextButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout wrongSpelledTextPanelLayout = new javax.swing.GroupLayout(wrongSpelledTextPanel);
        wrongSpelledTextPanel.setLayout(wrongSpelledTextPanelLayout);
        wrongSpelledTextPanelLayout.setHorizontalGroup(
            wrongSpelledTextPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wrongSpelledTextPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(wrongWordsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(wrongSpelledTextPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(wrongSpelledTextPanelLayout.createSequentialGroup()
                        .addComponent(altWordButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(wrongSpelledTextPanelLayout.createSequentialGroup()
                        .addGroup(wrongSpelledTextPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cancelButton1)
                            .addComponent(finalTextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        wrongSpelledTextPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {altWordButton, cancelButton1, finalTextButton});

        wrongSpelledTextPanelLayout.setVerticalGroup(
            wrongSpelledTextPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wrongSpelledTextPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(wrongSpelledTextPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(wrongSpelledTextPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(altWordButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(finalTextButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton1))
                    .addComponent(wrongWordsScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout spellCheckDialogLayout = new javax.swing.GroupLayout(spellCheckDialog.getContentPane());
        spellCheckDialog.getContentPane().setLayout(spellCheckDialogLayout);
        spellCheckDialogLayout.setHorizontalGroup(
            spellCheckDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(wrongSpelledTextPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        spellCheckDialogLayout.setVerticalGroup(
            spellCheckDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(wrongSpelledTextPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        alternativeWordDialog.setMinimumSize(new java.awt.Dimension(350, 300));

        altWordPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Alternative Words", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        altWordList.setModel(new javax.swing.AbstractListModel() {
            public int getSize() { return altWords.length; }
            public Object getElementAt(int i) { return altWords[i]; }
        });
        altWordScrollPane.setViewportView(altWordList);

        cancelButton2.setText("Cancel");
        cancelButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButton2ActionPerformed(evt);
            }
        });

        replaceAltWordButton.setText("Replace Word");
        replaceAltWordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                replaceAltWordButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout altWordPanelLayout = new javax.swing.GroupLayout(altWordPanel);
        altWordPanel.setLayout(altWordPanelLayout);
        altWordPanelLayout.setHorizontalGroup(
            altWordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(altWordPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(altWordScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(altWordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cancelButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(replaceAltWordButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        altWordPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelButton2, replaceAltWordButton});

        altWordPanelLayout.setVerticalGroup(
            altWordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, altWordPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(altWordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(altWordPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(replaceAltWordButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton2))
                    .addComponent(altWordScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout alternativeWordDialogLayout = new javax.swing.GroupLayout(alternativeWordDialog.getContentPane());
        alternativeWordDialog.getContentPane().setLayout(alternativeWordDialogLayout);
        alternativeWordDialogLayout.setHorizontalGroup(
            alternativeWordDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(altWordPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        alternativeWordDialogLayout.setVerticalGroup(
            alternativeWordDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(altWordPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        exceptionInOpenFileUsingPathDialog.setMinimumSize(new java.awt.Dimension(400, 215));

        exceptionLabel.setFont(new java.awt.Font("Buxton Sketch", 0, 24)); // NOI18N
        exceptionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exceptionLabel.setText("Problem Accessing File");

        closeExceptionWindowButton.setText("Cancel");
        closeExceptionWindowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeExceptionWindowButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout exceptionInOpenFileUsingPathDialogLayout = new javax.swing.GroupLayout(exceptionInOpenFileUsingPathDialog.getContentPane());
        exceptionInOpenFileUsingPathDialog.getContentPane().setLayout(exceptionInOpenFileUsingPathDialogLayout);
        exceptionInOpenFileUsingPathDialogLayout.setHorizontalGroup(
            exceptionInOpenFileUsingPathDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exceptionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exceptionInOpenFileUsingPathDialogLayout.createSequentialGroup()
                .addContainerGap(301, Short.MAX_VALUE)
                .addComponent(closeExceptionWindowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        exceptionInOpenFileUsingPathDialogLayout.setVerticalGroup(
            exceptionInOpenFileUsingPathDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exceptionInOpenFileUsingPathDialogLayout.createSequentialGroup()
                .addComponent(exceptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(closeExceptionWindowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        textDialog.setMinimumSize(new java.awt.Dimension(400, 350));

        textPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Text", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        textPanel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        textTextArea.setColumns(20);
        textTextArea.setRows(5);
        textTextArea.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textScrollPane.setViewportView(textTextArea);

        spellCheckButton.setText("Spell Check");
        spellCheckButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        spellCheckButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spellCheckButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout textPanelLayout = new javax.swing.GroupLayout(textPanel);
        textPanel.setLayout(textPanelLayout);
        textPanelLayout.setHorizontalGroup(
            textPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(textPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(textPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                    .addGroup(textPanelLayout.createSequentialGroup()
                        .addComponent(spellCheckButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        textPanelLayout.setVerticalGroup(
            textPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(textPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spellCheckButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        cancelTextPanelButton.setText("Cancel");
        cancelTextPanelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelTextPanelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout textDialogLayout = new javax.swing.GroupLayout(textDialog.getContentPane());
        textDialog.getContentPane().setLayout(textDialogLayout);
        textDialogLayout.setHorizontalGroup(
            textDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 468, Short.MAX_VALUE)
            .addGroup(textDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, textDialogLayout.createSequentialGroup()
                    .addGroup(textDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(textPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(textDialogLayout.createSequentialGroup()
                            .addContainerGap(393, Short.MAX_VALUE)
                            .addComponent(cancelTextPanelButton)))
                    .addContainerGap()))
        );
        textDialogLayout.setVerticalGroup(
            textDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 287, Short.MAX_VALUE)
            .addGroup(textDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(textDialogLayout.createSequentialGroup()
                    .addComponent(textPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(cancelTextPanelButton)
                    .addGap(0, 10, Short.MAX_VALUE)))
        );

        fileDialog.setMinimumSize(new java.awt.Dimension(550, 170));

        openFilePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Open File"));
        openFilePanel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        pathTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pathTextField.setText("Write Path");
        pathTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        pathTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pathTextFieldFocusGained(evt);
            }
        });
        pathTextField.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                pathTextFieldComponentHidden(evt);
            }
        });
        pathTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pathTextFieldActionPerformed(evt);
            }
        });

        pathButton.setText("Open");
        pathButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pathButtonActionPerformed(evt);
            }
        });

        encodingTypeTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        encodingTypeTextField.setText("Write Encoding Type");
        encodingTypeTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                encodingTypeTextFieldFocusGained(evt);
            }
        });

        javax.swing.GroupLayout openFilePanelLayout = new javax.swing.GroupLayout(openFilePanel);
        openFilePanel.setLayout(openFilePanelLayout);
        openFilePanelLayout.setHorizontalGroup(
            openFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(openFilePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(encodingTypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pathButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        openFilePanelLayout.setVerticalGroup(
            openFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(openFilePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(openFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(encodingTypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pathButton))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        cancelFileDialogButton.setText("Cancel");
        cancelFileDialogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelFileDialogButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout fileDialogLayout = new javax.swing.GroupLayout(fileDialog.getContentPane());
        fileDialog.getContentPane().setLayout(fileDialogLayout);
        fileDialogLayout.setHorizontalGroup(
            fileDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fileDialogLayout.createSequentialGroup()
                .addContainerGap(403, Short.MAX_VALUE)
                .addComponent(cancelFileDialogButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(fileDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fileDialogLayout.createSequentialGroup()
                    .addComponent(openFilePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        fileDialogLayout.setVerticalGroup(
            fileDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fileDialogLayout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addComponent(cancelFileDialogButton)
                .addContainerGap())
            .addGroup(fileDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(fileDialogLayout.createSequentialGroup()
                    .addComponent(openFilePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(40, 40, 40)))
        );

        chooseDialog.setMinimumSize(new java.awt.Dimension(370, 160));

        choosePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Choose Spell Checking Method:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        choosePanel.setMinimumSize(new java.awt.Dimension(300, 300));

        chooseInsertTextButton.setText("Insert Text");
        chooseInsertTextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseInsertTextButtonActionPerformed(evt);
            }
        });

        chooseOpenFileButton.setText("Open File");
        chooseOpenFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseOpenFileButtonActionPerformed(evt);
            }
        });

        browseHtmlButton.setText("Open URL");
        browseHtmlButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseHtmlButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout choosePanelLayout = new javax.swing.GroupLayout(choosePanel);
        choosePanel.setLayout(choosePanelLayout);
        choosePanelLayout.setHorizontalGroup(
            choosePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(choosePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chooseInsertTextButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chooseOpenFileButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(browseHtmlButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        choosePanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {browseHtmlButton, chooseInsertTextButton, chooseOpenFileButton});

        choosePanelLayout.setVerticalGroup(
            choosePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(choosePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(choosePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chooseInsertTextButton)
                    .addComponent(chooseOpenFileButton)
                    .addComponent(browseHtmlButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        exitButton1.setText("Exit");
        exitButton1.setMinimumSize(new java.awt.Dimension(77, 23));
        exitButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout chooseDialogLayout = new javax.swing.GroupLayout(chooseDialog.getContentPane());
        chooseDialog.getContentPane().setLayout(chooseDialogLayout);
        chooseDialogLayout.setHorizontalGroup(
            chooseDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(choosePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chooseDialogLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exitButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        chooseDialogLayout.setVerticalGroup(
            chooseDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chooseDialogLayout.createSequentialGroup()
                .addComponent(choosePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exitButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        htmlDialog.setMinimumSize(new java.awt.Dimension(500, 170));

        openHtmlPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Open URL", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        urlTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        urlTextField.setText("Write Url");
        urlTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                urlTextFieldFocusGained(evt);
            }
        });
        urlTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urlTextFieldActionPerformed(evt);
            }
        });

        urlButton.setText("Open");
        urlButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urlButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout openHtmlPanelLayout = new javax.swing.GroupLayout(openHtmlPanel);
        openHtmlPanel.setLayout(openHtmlPanelLayout);
        openHtmlPanelLayout.setHorizontalGroup(
            openHtmlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(openHtmlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(urlTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(urlButton, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                .addContainerGap())
        );
        openHtmlPanelLayout.setVerticalGroup(
            openHtmlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(openHtmlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(openHtmlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(urlTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(urlButton))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        cancelHtmlDialogButton.setText("Cancel");
        cancelHtmlDialogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelHtmlDialogButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout htmlDialogLayout = new javax.swing.GroupLayout(htmlDialog.getContentPane());
        htmlDialog.getContentPane().setLayout(htmlDialogLayout);
        htmlDialogLayout.setHorizontalGroup(
            htmlDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(openHtmlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, htmlDialogLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancelHtmlDialogButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        htmlDialogLayout.setVerticalGroup(
            htmlDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(htmlDialogLayout.createSequentialGroup()
                .addComponent(openHtmlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancelHtmlDialogButton)
                .addContainerGap())
        );

        databaseDialog.setMinimumSize(new java.awt.Dimension(530, 300));

        databasePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Database Connection", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        databasePanel.setMinimumSize(new java.awt.Dimension(500, 200));
        databasePanel.setPreferredSize(new java.awt.Dimension(500, 300));

        usernameLabel1.setText("Insert the username used to access your MySQL database.");

        usernameLabel2.setText("If you have not change it during or after the MySQL installation process, please type: root");

        usernameTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usernameTextField.setText("username");
        usernameTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                usernameTextFieldFocusGained(evt);
            }
        });
        usernameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTextFieldActionPerformed(evt);
            }
        });

        passwordLabel1.setText("Insert the password used to access your MySQL database.");

        passwordLabel2.setText("Your password may have been first created during the MySQL installation process");

        passwordPasswordField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passwordPasswordField.setText("jPasswordField");
        passwordPasswordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordPasswordFieldFocusGained(evt);
            }
        });
        passwordPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordPasswordFieldActionPerformed(evt);
            }
        });

        exitButton2.setText("Exit");
        exitButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButton2ActionPerformed(evt);
            }
        });

        nextButton2.setText("Next");
        nextButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout databasePanelLayout = new javax.swing.GroupLayout(databasePanel);
        databasePanel.setLayout(databasePanelLayout);
        databasePanelLayout.setHorizontalGroup(
            databasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(databasePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(databasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameLabel2)
                    .addComponent(passwordLabel2)
                    .addComponent(passwordPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameLabel1)
                    .addComponent(passwordLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, databasePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nextButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exitButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        databasePanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {exitButton2, nextButton2});

        databasePanelLayout.setVerticalGroup(
            databasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(databasePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(usernameLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(passwordLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(databasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exitButton2)
                    .addComponent(nextButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        databasePanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {exitButton2, nextButton2});

        javax.swing.GroupLayout databaseDialogLayout = new javax.swing.GroupLayout(databaseDialog.getContentPane());
        databaseDialog.getContentPane().setLayout(databaseDialogLayout);
        databaseDialogLayout.setHorizontalGroup(
            databaseDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(databasePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 491, Short.MAX_VALUE)
        );
        databaseDialogLayout.setVerticalGroup(
            databaseDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(databasePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
        );

        finalTextDialog.setMinimumSize(new java.awt.Dimension(500, 300));
        finalTextDialog.setPreferredSize(new java.awt.Dimension(500, 300));

        finalTextPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Final Text", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        finalTextPanel.setMinimumSize(new java.awt.Dimension(512, 324));

        finalTextTextArea.setEditable(false);
        finalTextTextArea.setBackground(new java.awt.Color(240, 240, 240));
        finalTextTextArea.setColumns(20);
        finalTextTextArea.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        finalTextTextArea.setRows(1000000);
        finalTextTextArea.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        finalTextTextArea.setMinimumSize(new java.awt.Dimension(500, 300));
        finalTextScrollPane.setViewportView(finalTextTextArea);

        javax.swing.GroupLayout finalTextPanelLayout = new javax.swing.GroupLayout(finalTextPanel);
        finalTextPanel.setLayout(finalTextPanelLayout);
        finalTextPanelLayout.setHorizontalGroup(
            finalTextPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(finalTextPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(finalTextScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                .addContainerGap())
        );
        finalTextPanelLayout.setVerticalGroup(
            finalTextPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(finalTextPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(finalTextScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout finalTextDialogLayout = new javax.swing.GroupLayout(finalTextDialog.getContentPane());
        finalTextDialog.getContentPane().setLayout(finalTextDialogLayout);
        finalTextDialogLayout.setHorizontalGroup(
            finalTextDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(finalTextDialogLayout.createSequentialGroup()
                .addComponent(finalTextPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        finalTextDialogLayout.setVerticalGroup(
            finalTextDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(finalTextPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        welcomePanel.setBackground(new java.awt.Color(226, 226, 230));
        welcomePanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(56, 76, 97), new java.awt.Color(56, 76, 97), new java.awt.Color(56, 76, 97), new java.awt.Color(56, 76, 97)));

        welcomeLabel.setFont(new java.awt.Font("Segoe Print", 1, 16)); // NOI18N
        welcomeLabel.setForeground(new java.awt.Color(6, 27, 49));
        welcomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcomeLabel.setText("Welcome To Our Spell Checker!");

        nextButton1.setText("Next");
        nextButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout welcomePanelLayout = new javax.swing.GroupLayout(welcomePanel);
        welcomePanel.setLayout(welcomePanelLayout);
        welcomePanelLayout.setHorizontalGroup(
            welcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(welcomePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(welcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(welcomeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, welcomePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(nextButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        welcomePanelLayout.setVerticalGroup(
            welcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(welcomePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nextButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        welcomeLabel.getAccessibleContext().setAccessibleName("welcomeLabel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(welcomePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(welcomePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void altWordButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        String wrongWord = (String) wrongWordsList.getSelectedValue();
        for (Word w : wordsList) {
            if (w.getWord().equals(wrongWord)){
                altWords = w.getBestPossibleSolutions();
                break;
            }
        }
        alternativeWordDialog.setVisible(true);
        wrongWordsList.clearSelection();
    }                                             

    private void cancelButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        spellCheckDialog.setVisible(false);
    }                                             

    private void nextButton11ActionPerformed(java.awt.event.ActionEvent evt) {                                             
        databaseDialog.setVisible(true);
        this.setVisible(false);
    }                                            

    private void closeExceptionWindowButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                           
        exceptionInOpenFileUsingPathDialog.setVisible(false);
    }                                                          

    private void spellCheckButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        try {
            String text;
            text = textTextArea.getText();
            wordsList = DataInput.splitStringToWords(text);
            listHandling();
            
            Word word = null;
            for (int j = 0; j < wordsList.size(); j++) {
                word = wordsList.get(j);
                if (!word.getIsSpelledCorrectly()) {
                    str.add(word.getWord());
                }
            }
            spellCheckDialog.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(SpellCheckerUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                                

    private void cancelTextPanelButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        textDialog.setVisible(false);
        textTextArea.setText(null);
    }                                                     

    private void pathTextFieldFocusGained(java.awt.event.FocusEvent evt) {                                          
        pathTextField.setText("");
    }                                         

    private void pathTextFieldComponentHidden(java.awt.event.ComponentEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void pathTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void pathButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        try {
            wordsList = DataInput.readInputFromTxt(pathTextField.getText(), encodingTypeTextField.getText());
            listHandling();
            
            Word word = null;
            for (int j = 0; j < wordsList.size(); j++) {
                word = wordsList.get(j);
                if (!word.getIsSpelledCorrectly()) {
                    str.add(word.getWord());
                }
            }
            spellCheckDialog.setVisible(true);
        } catch (Exception e) {
            exceptionInOpenFileUsingPathDialog.setVisible(true);
        }
    }                                          

    private void encodingTypeTextFieldFocusGained(java.awt.event.FocusEvent evt) {                                                  
        encodingTypeTextField.setText("");
    }                                                 

    private void cancelFileDialogButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                       
        fileDialog.setVisible(false);
    }                                                      

    private void chooseInsertTextButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                       
        textDialog.setVisible(true);
    }                                                      

    private void chooseOpenFileButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        fileDialog.setVisible(true);
    }                                                    

    private void exitButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        System.exit(0);
    }                                           

    private void browseHtmlButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        htmlDialog.setVisible(true);
    }                                                

    private void urlTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void urlTextFieldFocusGained(java.awt.event.FocusEvent evt) {                                         
        urlTextField.setText("");
    }                                        

    private void urlButtonActionPerformed(java.awt.event.ActionEvent evt) {                                          
        try {
            wordsList = DataInput.readInputFromHtml(urlTextField.getText());
            listHandling();
            
            Word word = null;
            for (int j = 0; j < wordsList.size(); j++) {
                word = wordsList.get(j);
                if (!word.getIsSpelledCorrectly()) {
                    str.add(word.getWord());
                }
            }
            spellCheckDialog.setVisible(true);
        } catch (Exception e) {
            exceptionInOpenFileUsingPathDialog.setVisible(true);
        }
    }                                         

    private void cancelHtmlDialogButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                       
        htmlDialog.setVisible(false);
    }                                                      

    private void usernameTextFieldFocusGained(java.awt.event.FocusEvent evt) {                                              
        usernameTextField.setText("");
    }                                             

    private void exitButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        System.exit(0);
    }                                           

    /** Java DataBase Connectivity
    * <p>
    * nextButton2ActionPerformed establishes a connection with the MySQL database that the other methods like existsInDictionary and findSuggestions use.
    * nextButton2ActionPerformed needs the username and password of the administrator of MySQL, and therefore the user is asked to insert them.
    * 
    * @param evt
    */
    private void nextButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        boolean w;
        try {
            w = true;
            username = usernameTextField.getText();
            password = passwordPasswordField.getText();
            String url = "jdbc:mysql://127.0.0.1:3306/dictionary?useSSL=false";
            myConn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            w = false;
            databaseDialog.setVisible(false);
            usernameTextField.setText("");
            passwordPasswordField.setText("");
            databaseDialog.setVisible(true);
            Logger.getLogger(SpellCheckerUI.class.getName()).log(Level.SEVERE, null, e);
        }
        if (w) {
           chooseDialog.setVisible(true);
           databaseDialog.setVisible(false);
        }
    }                                           

    private void usernameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                  

    }                                                 

    private void passwordPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                      

    }                                                     

    private void passwordPasswordFieldFocusGained(java.awt.event.FocusEvent evt) {                                                  
        passwordPasswordField.setText("");
    }                                                 

    private void finalTextButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                
        String string = new String();
        for (Word w : wordsList){
           string = string.concat(w.toString());
        }
        finalTextTextArea.setText(string);
        finalTextDialog.setVisible(true);
        spellCheckDialog.setVisible(false);
    }                                               

    private void replaceAltWordButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        String alternativeWord = (String) altWordList.getSelectedValue();
        for (Word w : wordsList) {
            if (Arrays.asList(w.getBestPossibleSolutions()).contains(alternativeWord)){
                w.setWord(alternativeWord);
                w.setSpelledCorrectly(true);
                break;
            }
        }
        altWordList.clearSelection();
        alternativeWordDialog.setVisible(false);
    }                                                    

    private void cancelButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        alternativeWordDialog.setVisible(false);
    }                                             
    
    /** Handles a list of words 
     * 
     * listHandling processes the words from the text that the user wrote/imported 
     * in order to check if each word is spelled correctly, and if not, to find suggestions
     * 
     * @throws SQLException
     */
    public static void listHandling() throws SQLException {
        Iterator<Word> iterator = wordsList.iterator();
        while (iterator.hasNext()) {
            iterator.next().wordProcessing();
        }
        iterator = null;
    }
    
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
            java.util.logging.Logger.getLogger(SpellCheckerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SpellCheckerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SpellCheckerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SpellCheckerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            /* run method is used to execute SpellCheckerUI */
            public void run() {
                new SpellCheckerUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton altWordButton;
    private javax.swing.JList altWordList;
    private javax.swing.JPanel altWordPanel;
    private javax.swing.JScrollPane altWordScrollPane;
    private javax.swing.JDialog alternativeWordDialog;
    private javax.swing.JButton browseHtmlButton;
    private javax.swing.JButton cancelButton1;
    private javax.swing.JButton cancelButton2;
    private javax.swing.JButton cancelFileDialogButton;
    private javax.swing.JButton cancelHtmlDialogButton;
    private javax.swing.JButton cancelTextPanelButton;
    private javax.swing.JDialog chooseDialog;
    private javax.swing.JButton chooseInsertTextButton;
    private javax.swing.JButton chooseOpenFileButton;
    private javax.swing.JPanel choosePanel;
    private javax.swing.JButton closeExceptionWindowButton;
    private javax.swing.JDialog databaseDialog;
    private javax.swing.JPanel databasePanel;
    private javax.swing.JTextField encodingTypeTextField;
    private javax.swing.JDialog exceptionInOpenFileUsingPathDialog;
    private javax.swing.JLabel exceptionLabel;
    private javax.swing.JButton exitButton1;
    private javax.swing.JButton exitButton2;
    private javax.swing.JDialog fileDialog;
    private javax.swing.JButton finalTextButton;
    private javax.swing.JDialog finalTextDialog;
    private javax.swing.JPanel finalTextPanel;
    private javax.swing.JScrollPane finalTextScrollPane;
    private javax.swing.JTextArea finalTextTextArea;
    private javax.swing.JDialog htmlDialog;
    private javax.swing.JButton nextButton1;
    private javax.swing.JButton nextButton2;
    private javax.swing.JPanel openFilePanel;
    private javax.swing.JPanel openHtmlPanel;
    private javax.swing.JLabel passwordLabel1;
    private javax.swing.JLabel passwordLabel2;
    private javax.swing.JPasswordField passwordPasswordField;
    private javax.swing.JButton pathButton;
    private javax.swing.JTextField pathTextField;
    private javax.swing.JButton replaceAltWordButton;
    private javax.swing.JButton spellCheckButton;
    private javax.swing.JDialog spellCheckDialog;
    private javax.swing.JDialog textDialog;
    private javax.swing.JPanel textPanel;
    private javax.swing.JScrollPane textScrollPane;
    private javax.swing.JTextArea textTextArea;
    private javax.swing.JButton urlButton;
    private javax.swing.JTextField urlTextField;
    private javax.swing.JLabel usernameLabel1;
    private javax.swing.JLabel usernameLabel2;
    private javax.swing.JTextField usernameTextField;
    private javax.swing.JLabel welcomeLabel;
    private javax.swing.JPanel welcomePanel;
    private javax.swing.JPanel wrongSpelledTextPanel;
    private javax.swing.JList wrongWordsList;
    private javax.swing.JScrollPane wrongWordsScrollPane;
    // End of variables declaration                   

}
