//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SpringLayout;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

class ElGamal extends JFrame implements ActionListener {
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JTextField tfB;
    private JLabel labelB; 
    private JButton buttonComputePrimeB;
    private JButton buttonPublishKeysB;
    private JButton buttonSendMessage;
    private JLabel labelMessage;
    private JTextField textfieldMessage;
    private JTextArea labelprimeB;
    private JCheckBox checkPrime;
    private JTextArea sendTxtArea;
    private JLabel bobLabel;
    private boolean bob = true;
    private JLabel aliceLabel;
    private boolean alice = false;
    private JButton startButton;
    private JLabel label;
    private JLabel infos;
    private JToggleButton aliceORbob;
    private JLabel sender;
    boolean flag = true;
    public String name;
    private JLabel labelInfos;
    private JTextArea textAreaPanel2;
    private JTextArea textAreaPanel3;
    private JTextArea textAreaChat;
    private JScrollPane scrollPanel;
    private JButton clearChat;
    private List<BigInteger> intList = new ArrayList();

    public ElGamal(String var1) {
        this.name = var1;
        this.initGui();
    }

    private void initGui() {
        this.setLayout(new BorderLayout());
        this.jPanel1 = new JPanel();
        this.jPanel2 = new JPanel(new SpringLayout());
        this.jPanel3 = new JPanel();
        this.jPanel3.setPreferredSize(new Dimension(150, 280));
        this.jPanel3.setBorder(BorderFactory.createLineBorder(Color.black));
        this.jPanel3.setBackground(new Color(0, 0, 0));


        this.getContentPane().add(this.jPanel1, "North");
        this.getContentPane().add(this.jPanel2, "Center");
        this.getContentPane().add(this.jPanel3, "South");


        this.jPanel1.setPreferredSize(new Dimension(600, 800));
        this.jPanel1.setBackground(new Color(0, 0, 0));

        //Preferences for start button
        this.startButton = new JButton("START");
        Font var1 = new Font("SansSerif", 1, 30);
        this.startButton.setBounds(150, 100, 300, 50);
        this.startButton.setBackground(new Color(255, 255, 255));
        this.startButton.setFont(var1);
        this.jPanel1.add(this.startButton);

        //Preferences for label in the beginning
        this.infos = new JLabel("El Gamal Algorithm");
        this.infos.setBounds(this.startButton.getX() + 50, 160, 200, 50);
        this.infos.setFont(new Font("SansSerif", 2, 20));
        this.infos.setForeground(new Color(255, 255, 255));
        this.jPanel1.add(this.infos);

        //adding a gif
        ImageIcon var2 = new ImageIcon(this.getClass().getResource("start.gif"));
        this.label = new JLabel(var2);
        this.label.setBounds(this.startButton.getX() - 50, 225, 400, 400);
        this.jPanel1.add(this.label);

        //adding functionalty to a button
        this.startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent var1) {
                ElGamal.this.pressedStartButton();
            }
        });
        this.jPanel2.setPreferredSize(new Dimension(148, 200));
        this.jPanel2.setBorder(BorderFactory.createLineBorder(Color.black));
        this.jPanel2.setBackground(new Color(236, 235, 213));
        this.jPanel2.setVisible(false);
        this.jPanel3.setVisible(false);

        Insets var3 = this.jPanel1.getInsets();
        this.aliceLabel = new JLabel("Alice"); //alice button
        this.aliceLabel.setBounds(25 + var3.left, 65 + var3.top, 50, 25);
        this.jPanel1.add(this.aliceLabel);
        this.aliceLabel.setVisible(false);


        this.bobLabel = new JLabel("Bob"); //bob button
        this.bobLabel.setBounds(475 + var3.left, this.aliceLabel.getY(), 50, 25);
        this.bobLabel.setBorder(BorderFactory.createLineBorder(Color.red));
        this.jPanel1.add(this.bobLabel);
        this.bobLabel.setVisible(false);

        this.labelB = new JLabel("Enter a prime number:"); //label for prime number
        this.labelB.setBounds(50, 100 + var3.top, 150, 25);


        this.tfB = new JTextField();
        this.tfB.setBounds(this.labelB.getX(), this.labelB.getY() + 25, 150, 25);
        this.jPanel1.add(this.labelB);
        this.labelB.setVisible(false);
        this.jPanel1.add(this.tfB);
        this.tfB.setVisible(false);

        //adding functionality for Jtextfield
        this.tfB.addKeyListener(new MyKeyListener_());

        //checkbox for choosing a random prime number
        this.checkPrime = new JCheckBox("", false);
        this.checkPrime.setBounds(this.tfB.getX(), this.tfB.getY() + 30, 20, 20);
        this.checkPrime.setVisible(false);
        this.checkPrime.setOpaque(false);
        this.jPanel1.add(this.checkPrime);

        //label with informations about the checkbox usage
        this.labelprimeB = new JTextArea("Check the box if you want to take \na prime number automatically");
        this.labelprimeB.setBounds(this.checkPrime.getX() + 30, this.checkPrime.getY(), 180, 35);
        this.labelprimeB.setOpaque(false);
        this.labelprimeB.setEditable(false);
        this.labelprimeB.setVisible(false);
        this.jPanel1.add(this.labelprimeB);

        //button for
        this.buttonComputePrimeB = new JButton("Compute");
        this.buttonComputePrimeB.setBounds(this.checkPrime.getX(), this.checkPrime.getY() + 50, 100, 25);
        this.buttonComputePrimeB.setBackground(new Color(255, 255, 255));
        this.buttonComputePrimeB.setBorder(BorderFactory.createLineBorder(Color.black));
        this.jPanel1.add(this.buttonComputePrimeB);
        this.buttonComputePrimeB.setVisible(false);

        //label with infos
        this.sender = new JLabel("Choose the message sender");
        this.sender.setBounds((this.aliceLabel.getX() + this.bobLabel.getX()) / 2 - 50, this.aliceLabel.getY() - 60, 200, 25);
        this.jPanel1.add(this.sender);
        this.sender.setVisible(false);

        //adding toggle button
        this.aliceORbob = new JToggleButton("Bob");
        this.aliceORbob.setBounds(this.sender.getX() + 10, this.sender.getY() + 25, 125, 25);
        this.aliceORbob.setBackground(new Color(255, 255, 255));
        this.jPanel1.add(this.aliceORbob);
        this.aliceORbob.setVisible(false);
        this.aliceORbob.addItemListener(new ItemListener() { //adding functiomality
            public void itemStateChanged(ItemEvent var1) {
                ElGamal.this.itemAliceORBob(var1);
            }
        });

        //button
        this.buttonPublishKeysB = new JButton("Publish Keys");
        this.buttonPublishKeysB.setBounds(this.buttonComputePrimeB.getX(), this.buttonComputePrimeB.getY() + 50, 100, 25);
        this.buttonPublishKeysB.setBackground(new Color(255, 255, 255));
        this.buttonPublishKeysB.setBorder(BorderFactory.createLineBorder(Color.black));
        this.jPanel1.add(this.buttonPublishKeysB); //adding functionality
        this.buttonPublishKeysB.setVisible(false);


        this.labelMessage = new JLabel("Message: ");
        this.textfieldMessage = new JTextField("Type your message here!");
        this.labelMessage.setBounds(this.bobLabel.getX() - 100, this.labelB.getY(), 100, 25);
        this.jPanel1.add(this.labelMessage);
        this.labelMessage.setVisible(false);
        this.jPanel1.add(this.textfieldMessage);

        //field for adding text
        this.textfieldMessage.setBounds(this.labelMessage.getX(), this.tfB.getY(), 150, 25);
        this.textfieldMessage.setVisible(false);
        this.textfieldMessage.addKeyListener(new MyKeyListener_());

        //button for sendin the message
        this.buttonSendMessage = new JButton("Send");
        this.buttonSendMessage.setBounds(this.labelMessage.getX(), this.buttonPublishKeysB.getY(), 100, 25);
        this.buttonSendMessage.setBackground(new Color(255, 255, 255));
        this.buttonSendMessage.setBorder(BorderFactory.createLineBorder(Color.black));
        this.jPanel1.add(this.buttonSendMessage);  //adding functionality
        this.buttonSendMessage.setVisible(false);


        this.sendTxtArea = new JTextArea("The message is too big, \nless or equal to 0. \nIt must be lower than q, \nbut bigger than 0");
        this.sendTxtArea.setBounds(this.textfieldMessage.getX(), this.textfieldMessage.getY() + 30, 180, 70);
        this.sendTxtArea.setOpaque(false);
        this.sendTxtArea.setEditable(false);
        this.sendTxtArea.setVisible(false);
        this.jPanel1.add(this.sendTxtArea);
        this.jPanel1.setLayout((LayoutManager)null);
        SpringLayout var4 = new SpringLayout();
        this.jPanel2.setLayout(var4);


        this.labelInfos = new JLabel("What is happening inside the algorithm?");
        var4.putConstraint("HorizontalCenter", this.labelInfos, 100, "South", this.jPanel2);
        var4.putConstraint("VerticalCenter", this.labelInfos, 8, "North", this.jPanel2);
        this.labelInfos.setVisible(false);
        this.jPanel2.add(this.labelInfos);


        this.textAreaPanel2 = new JTextArea("Waiting for Alice\n         to send cripting details...", 7, 17);
        this.textAreaPanel2.setBorder(BorderFactory.createLineBorder(Color.black));
        this.textAreaPanel2.setVisible(false);

        var4.putConstraint("South", this.textAreaPanel2, 150, "North", this.labelInfos);
        var4.putConstraint("East", this.textAreaPanel2, 200, "South", this.labelInfos);
        this.jPanel2.add(this.textAreaPanel2);
        this.textAreaPanel2.setEditable(false);


        this.textAreaPanel3 = new JTextArea("Waiting for " + this.aliceORbob.getText() + " \n         to send the message...", 7, 17);
        this.textAreaPanel3.setBorder(BorderFactory.createLineBorder(Color.black));
        this.textAreaPanel3.setVisible(false);
        var4.putConstraint("North", this.textAreaPanel3, 35, "North", this.labelInfos);
        var4.putConstraint("West", this.textAreaPanel3, 200, "South", this.textAreaPanel2);
        this.jPanel2.add(this.textAreaPanel3);
        this.textAreaPanel3.setEditable(false);
        this.jPanel3.setBorder(new TitledBorder(new EtchedBorder(), "Chat Area"));
        this.textAreaChat = new JTextArea(10, 45);
        Font var5 = new Font("SansSerif", 1, 12);

        //adding a chat area
        this.textAreaChat.setFont(var5);
        this.textAreaChat.setEditable(false);
        this.scrollPanel = new JScrollPane(this.textAreaChat);
        this.scrollPanel.setVerticalScrollBarPolicy(22);
        this.scrollPanel.setVisible(false);
        this.jPanel3.add(this.scrollPanel);

        //a clear button
        this.clearChat = new JButton("  Clear Chat  ");
        this.clearChat.setVisible(false);
        this.clearChat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent var1) {
                ElGamal.this.textAreaChat.setText("");
            }
        });
        this.clearChat.setBorder(BorderFactory.createLineBorder(Color.black));
        this.clearChat.setBackground(new Color(255, 255, 255));
        this.jPanel3.add(this.clearChat);
        this.buttonComputePrimeB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent var1) {
                ElGamal.this.pressedButtonToCompute(ElGamal.this.tfB, ElGamal.this.buttonPublishKeysB);
            }
        });
        this.checkPrime.addActionListener(new ActionListener() {  //adding functionality to the checkbox
            public void actionPerformed(ActionEvent var1) {
                if (ElGamal.this.checkPrime.isSelected()) {
                    ElGamal.this.tfB.setEditable(false);
                    ElGamal.this.tfB.setText(ElGamal.this.checkPr());
                    ElGamal.this.buttonComputePrimeB.setVisible(false);
                    ElGamal.this.buttonPublishKeysB.setVisible(true);
                } else if (!ElGamal.this.checkPrime.isSelected()) {
                    ElGamal.this.tfB.setEditable(true);
                    ElGamal.this.buttonPublishKeysB.setVisible(false);
                    ElGamal.this.buttonComputePrimeB.setVisible(true);
                }

            }
        });

        this.buttonPublishKeysB.addActionListener(new ActionListener() { //adding functionality to the button
            public void actionPerformed(ActionEvent var1) {
                ElGamal.this.intList = ElGamal.this.pressedButtonPublish(ElGamal.this.tfB);
                ElGamal.this.buttonSendMessage.setVisible(true);
                JTextArea var10000;
                String var10001;
                if (ElGamal.this.alice) {
                    var10000 = ElGamal.this.textAreaPanel2;
                    var10001 = ElGamal.this.bobLabel.getText();
                    var10000.setText(var10001 + " is sending cripting details...\n\n" + ElGamal.this.bobLabel.getText() + "'s private key: " + ElGamal.this.intList.get(2) + "\nPrime number q : " + ElGamal.this.intList.get(0) + "\nGenerator alpha : " + ElGamal.this.intList.get(1) + "\nh : " + ElGamal.this.intList.get(3));
                } else if (ElGamal.this.bob) {
                    var10000 = ElGamal.this.textAreaPanel2;
                    var10001 = ElGamal.this.aliceLabel.getText();
                    var10000.setText(var10001 + " is sending cripting details...\n\n" + ElGamal.this.aliceLabel.getText() + "'s private key: " + ElGamal.this.intList.get(2) + "\nPrime number q : " + ElGamal.this.intList.get(0) + "\nGenerator alpha : " + ElGamal.this.intList.get(1) + "\nh : " + ElGamal.this.intList.get(3));
                }

            }
        });
        this.buttonSendMessage.addActionListener(new ActionListener() {   //adding functionality to the button
            public void actionPerformed(ActionEvent var1) {
                try {
                    BigInteger var3 = BigInteger.valueOf(Long.parseLong(ElGamal.this.textfieldMessage.getText()));
                    int var4 = var3.compareTo((BigInteger)ElGamal.this.intList.get(0));
                    int var5 = var3.compareTo(BigInteger.valueOf(0L));


                    if (var5 != 0 && var5 != -1 && var4 != 0 && var4 != 1) {
                        ElGamal.this.sendTxtArea.setVisible(false);
                        List var2 = ElGamal.this.cripting(ElGamal.this.textfieldMessage, ElGamal.this.intList);
                        JTextArea var10000;
                        String var10001;
                        if (ElGamal.this.alice) {
                            var10000 = ElGamal.this.textAreaPanel3;
                            var10001 = ElGamal.this.aliceORbob.getText();
                            var10000.setText(var10001 + " is sending the cripted message...\n\n" + ElGamal.this.aliceORbob.getText() + "'s cripted message: \nC = (C1,C2): (" + var2.get(0) + "," + var2.get(1) + ")\nk : " + var2.get(2));
                        } else if (ElGamal.this.bob) {
                            var10000 = ElGamal.this.textAreaPanel3;
                            var10001 = ElGamal.this.aliceORbob.getText();
                            var10000.setText(var10001 + " is sending the cripted message...\n\n" + ElGamal.this.aliceORbob.getText() + "'s cripted message: \nC = (C1,C2): (" + var2.get(0) + "," + var2.get(1) + ")\nk : " + var2.get(2));
                        }

                        BigInteger var6 = ElGamal.this.decript(var2, ElGamal.this.intList);
                        if (ElGamal.this.alice) {
                            var10000 = ElGamal.this.textAreaChat;
                            var10001 = ElGamal.this.textAreaChat.getText();
                            var10000.setText(var10001 + "\n" + ElGamal.this.aliceORbob.getText() + ":" + var6);
                        } else if (ElGamal.this.bob) {
                            var10000 = ElGamal.this.textAreaChat;
                            var10001 = ElGamal.this.textAreaChat.getText();
                            var10000.setText(var10001 + "\n" + ElGamal.this.aliceORbob.getText() + ":" + var6);
                        }
                    } else {
                        ElGamal.this.textfieldMessage.setText("0");
                        ElGamal.this.sendTxtArea.setVisible(true);
                    }
                } catch (NumberFormatException var7) {
                }

            }
        });
        this.setDefaultCloseOperation(3);
        this.pack();
        this.validate();
        this.setSize(600, 800);
    }

    //function that verifies if a number is prime
    protected boolean primeNr(int var1) {
        if (var1 == 4) {
            this.flag = false;
        }

        if (var1 <= 1) {
            this.flag = false;
        } else {
            for(int var2 = 2; var2 < var1 / 2; ++var2) {
                if (var1 % var2 == 0) {
                    this.flag = false;
                    break;
                }
            }
        }

        return this.flag;
    }

    //
    protected boolean pressedButtonToCompute(JTextField var1, JButton var2) {
        try {
            int var3 = Integer.parseInt(var1.getText());
            this.primeNr(var3);
            if (!this.flag) {
                var1.setText("It is not a prime number!");
                var2.setVisible(false);
                this.flag = true;
            } else {
                var2.setVisible(true);
                this.flag = true;
            }
        } catch (NumberFormatException var4) {
        }

        return this.flag;
    }

    //
    protected void pressedStartButton() {
        this.startButton.setVisible(false);
        this.jPanel1.setPreferredSize(new Dimension(100, 300));
        this.jPanel1.setBorder(BorderFactory.createLineBorder(Color.black));
        this.label.setVisible(false);
        this.infos.setVisible(false);
        this.jPanel1.setBackground(new Color(236, 235, 223));
        this.jPanel2.setVisible(true);
        this.jPanel3.setVisible(true);
        this.tfB.setVisible(true);
        this.buttonComputePrimeB.setVisible(true);
        this.labelB.setVisible(true);
        this.aliceLabel.setVisible(true);
        this.bobLabel.setVisible(true);
        this.aliceORbob.setVisible(true);
        this.sender.setVisible(true);
        this.buttonPublishKeysB.setVisible(false);
        this.labelMessage.setVisible(true);
        this.textfieldMessage.setVisible(true);
        this.checkPrime.setVisible(true);
        this.labelprimeB.setVisible(true);
        this.textAreaPanel3.setVisible(true);
        this.textAreaPanel2.setVisible(true);
        this.labelInfos.setVisible(true);
        this.scrollPanel.setVisible(true);
        this.clearChat.setVisible(true);
    }

    //
    protected void itemAliceORBob(ItemEvent var1) {
        Insets var2 = this.jPanel1.getInsets();
        int var3 = var1.getStateChange();
        if (var3 == 1) {
            this.aliceORbob.setText("Alice");
            this.bobLabel.setBorder(BorderFactory.createEmptyBorder());
            this.aliceLabel.setBorder(BorderFactory.createLineBorder(Color.red));
            this.labelB.setBounds(this.bobLabel.getX() - 100, 100 + var2.top, 150, 25);
            this.tfB.setBounds(this.labelB.getX(), this.labelB.getY() + 25, 150, 25);
            this.checkPrime.setBounds(this.tfB.getX(), this.tfB.getY() + 30, 20, 15);
            this.buttonComputePrimeB.setBounds(this.checkPrime.getX(), this.checkPrime.getY() + 50, 100, 25);
            this.buttonPublishKeysB.setBounds(this.buttonComputePrimeB.getX(), this.buttonComputePrimeB.getY() + 50, 100, 25);
            this.buttonPublishKeysB.setVisible(false);
            this.labelMessage.setBounds(50, 100 + var2.top, 100, 25);
            this.textfieldMessage.setBounds(this.labelMessage.getX(), this.tfB.getY(), 150, 25);
            this.buttonSendMessage.setBounds(this.labelMessage.getX(), this.buttonPublishKeysB.getY(), 100, 25);
            this.labelprimeB.setBounds(this.checkPrime.getX() + 30, this.checkPrime.getY(), 180, 35);
            this.sendTxtArea.setBounds(this.textfieldMessage.getX(), this.textfieldMessage.getY() + 30, 180, 35);
            this.textAreaPanel2.setText("Waiting for Bob\n        to send cripting details...");
            this.textAreaPanel3.setText("Waiting for " + this.aliceORbob.getText() + "\n        to send the message...");
            this.alice = true;
            this.bob = false;
            this.textfieldMessage.setText("");

        } else {
            this.aliceORbob.setText("Bob");
            this.aliceLabel.setBorder(BorderFactory.createEmptyBorder());
            this.bobLabel.setBorder(BorderFactory.createLineBorder(Color.red));
            this.labelB.setBounds(50, 100 + var2.top, 150, 25);
            this.tfB.setBounds(this.labelB.getX(), this.labelB.getY() + 25, 150, 25);
            this.checkPrime.setBounds(this.tfB.getX(), this.tfB.getY() + 30, 20, 15);
            this.labelprimeB.setBounds(this.checkPrime.getX() + 30, this.checkPrime.getY(), 180, 35);
            this.buttonComputePrimeB.setBounds(this.checkPrime.getX(), this.checkPrime.getY() + 50, 100, 25);
            this.buttonPublishKeysB.setBounds(this.buttonComputePrimeB.getX(), this.buttonComputePrimeB.getY() + 50, 100, 25);
            this.buttonPublishKeysB.setVisible(false);
            this.labelMessage.setBounds(this.bobLabel.getX() - 100, this.labelB.getY(), 100, 25);
            this.textfieldMessage.setBounds(this.labelMessage.getX(), this.tfB.getY(), 150, 25);
            this.buttonSendMessage.setBounds(this.labelMessage.getX(), this.buttonPublishKeysB.getY(), 100, 25);
            this.sendTxtArea.setBounds(this.textfieldMessage.getX(), this.textfieldMessage.getY() + 30, 180, 35);
            this.textAreaPanel2.setText("Waiting for Alice\n        to send cripting details...");
            this.textAreaPanel3.setText("Waiting for " + this.aliceORbob.getText() + "\n        to send the message...");
            this.alice = false;
            this.bob = true;
            this.textfieldMessage.setText("");
        }

    }

    //
    protected String checkPr() {
        String var1 = new String();

        try {
            StringBuffer var2 = new StringBuffer();
            Path var3 = Paths.get("primes-to-100k.txt");
            int var4 = (int)(Math.random() * (double)(Files.readAllLines(var3).size() - 2) + 2.0D);
            var1 = (String)Files.readAllLines(var3).get(var4);
            if (var1 != null) {
                var2.append(var1);
                var2.append("\n");
            }
        } catch (IOException var5) {
            var5.printStackTrace();
        }

        return var1;
    }

    public ArrayList<BigInteger> try100(BigInteger var1) {
        int var2 = 1;
        ArrayList var4 = new ArrayList();
        int var5 = 0;

        for(int var6 = 2; (long)var6 < var1.longValue(); ++var6) {
            int var3 = (int)Math.pow((double)var6, (double)var2);

            for(var3 = (int)((long)var3 % var1.longValue()); var3 > 1; var3 = (int)((long)var3 % var1.longValue())) {
                ++var2;
                var3 *= var6;
            }

            if ((long)var2 == var1.longValue() - 1L) {
                var4.add(BigInteger.valueOf((long)var6));
                ++var5;
            }

            var2 = 1;
        }

        return var4;
    }

    protected List<BigInteger> pressedButtonPublish(JTextField var1) {
        ArrayList var2 = new ArrayList();
        byte var3 = 2;

        try {
            BigInteger var8 = BigInteger.valueOf(Long.parseLong(var1.getText()));
            int var10 = var8.intValue() - 1;
            long var4 = (long)(Math.random() * (double)(var10 - var3 + 1) + (double)var3);
            ArrayList var9 = this.try100(var8);
            BigInteger var6 = (BigInteger)var9.get((int)(Math.random() * (double)(var9.size() - var3 - 2) + (double)var3));
            BigInteger var11 = this.power(var6, var4);
            BigInteger var7 = var11.mod(var8);
            var2.add(var8);
            var2.add(BigInteger.valueOf(var4));
            var2.add(var6);
            var2.add(var7);
        } catch (NumberFormatException var12) {
        }

        return var2;
    }

    public List<BigInteger> cripting(JTextField var1, List<BigInteger> var2) {
        ArrayList var7 = new ArrayList();

        try {
            BigInteger var6 = BigInteger.valueOf(Long.parseLong(var1.getText()));
            int var8 = ((BigInteger)var2.get(0)).intValue() - 1;
            BigInteger var5 = BigInteger.valueOf((long)(Math.random() * (double)var8 + 1.0D));
            BigInteger var9 = this.power((BigInteger)var2.get(2), var5.longValue());
            BigInteger var3 = var9.mod((BigInteger)var2.get(0));
            BigInteger var10 = this.power((BigInteger)var2.get(3), var5.longValue());
            BigInteger var11 = var6.multiply(var10);
            BigInteger var4 = var11.mod((BigInteger)var2.get(0));
            var7.add(var3);
            var7.add(var4);
            var7.add(var5);
        } catch (IndexOutOfBoundsException | NumberFormatException var12) {
        }

        return var7;
    }

    public BigInteger decript(List<BigInteger> var1, List<BigInteger> var2) {
        BigInteger var3 = (BigInteger)var1.get(0);
        BigInteger var4 = (BigInteger)var1.get(1);
        BigInteger var5 = (BigInteger)var2.get(0);
        BigInteger var6 = (BigInteger)var2.get(1);
        BigInteger var8 = this.power(var3, var6.longValue());
        BigInteger var9 = var8.mod(var5);
        BigInteger var10 = this.power(var9, var5.longValue() - 2L);
        BigInteger var11 = var4.multiply(var10);
        BigInteger var7 = var11.mod(var5);
        return var7;
    }

    public BigInteger power(BigInteger var1, long var2) {
        BigInteger var4;
        for(var4 = BigInteger.valueOf(1L); var2 != 0L; --var2) {
            var4 = var4.multiply(new BigInteger(String.valueOf(var1)));
        }

        return var4;
    }

    public void actionPerformed(ActionEvent var1) {
    }
}
