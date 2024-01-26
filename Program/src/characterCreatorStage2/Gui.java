package characterCreatorStage2;

// Imports 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.io.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class Gui extends JFrame implements ActionListener {

  // ArrayList Declarations

  ArrayList<Character> characters;
  ArrayList<Place> places;

  // Characters Tab

  JButton btnCAdd, btnCList, btnCSave, btnCSearch, btnCClear;
  JTextArea jtaC;
  JLabel lblCAdd, lblCList, lblCSave, lblCSearch, lblCClear, lblCName, lblCType, lblCHealth, lblCMana, lblCAttack,
      lblCSpeed,
      lblCEvil;
  JTextField txtCSearch, txtCName, txtCType, txtCHealth, txtCMana, txtCAttack, txtCSpeed, txtCEvil;
  Character cfound, cfoundb = null;

  // Places Tab

  JButton btnPAdd, btnPList, btnPSave, btnPSearch, btnPClear;
  JTextArea jtaP;
  JLabel lblPAdd, lblPList, lblPSave, lblPSearch, lblPClear, lblPLocation, lblPSize, lblPBiome;
  JTextField txtPSearch, txtPLocation, txtPSize, txtPBiome;
  Place pfound = null;

  // Constructor

  public Gui() {
    characters = new ArrayList<Character>();
    places = new ArrayList<Place>();

    // Components for Tabbed Panel

    JTabbedPane tabs = new JTabbedPane();
    JPanel charactersTab = new JPanel();
    JPanel placesTab = new JPanel();

    // Components for Character Tab

    JPanel inputCPanel = new JPanel();
    JPanel displayCPanel = new JPanel();
    JPanel buttonCPanel = new JPanel();

    inputCPanel.setLayout(new GridLayout(2, 1));
    inputCPanel.setBorder(new EmptyBorder(30, 30, 30, 30));

    lblCName = new JLabel("Name: ");
    txtCName = new JTextField(10);
    lblCType = new JLabel("Type: ");
    txtCType = new JTextField(10);
    lblCHealth = new JLabel("Health: ");
    txtCHealth = new JTextField(10);
    lblCMana = new JLabel("Mana: ");
    txtCMana = new JTextField(10);
    lblCAttack = new JLabel("Attack: ");
    txtCAttack = new JTextField(10);
    lblCSpeed = new JLabel("Speed: ");
    txtCSpeed = new JTextField(10);
    lblCEvil = new JLabel("Evil: ");
    txtCEvil = new JTextField(10);

    btnCAdd = new JButton("Add Character");
    btnCList = new JButton("List Characters");
    btnCSearch = new JButton("Search ");
    btnCSave = new JButton("Test Database");
    btnCClear = new JButton("Clear");

    jtaC = new JTextArea(30, 50);
    jtaC.setBorder(new TitledBorder("List of Characters"));

    // Components for Place Tab

    JPanel inputPPanel = new JPanel();
    JPanel displayPPanel = new JPanel();
    JPanel buttonPPanel = new JPanel();

    inputCPanel.setLayout(new GridLayout(2, 1));
    inputCPanel.setBorder(new EmptyBorder(30, 30, 30, 30));

    lblPLocation = new JLabel("Name: ");
    txtPLocation = new JTextField(10);
    lblPSize = new JLabel("Size: ");
    txtPSize = new JTextField(10);
    lblPBiome = new JLabel("Biome: ");
    txtPBiome = new JTextField(10);

    btnPAdd = new JButton("Add Place");
    btnPList = new JButton("List Places");
    btnPSearch = new JButton("Search ");
    btnPSave = new JButton("Test Database");
    btnPClear = new JButton("Clear");

    jtaP = new JTextArea(30, 50);
    jtaP.setBorder(new TitledBorder("List of Places"));

    // Tabbed Pane in the Center

    add(tabs, BorderLayout.CENTER);

    // Build Dual Tabs

    tabs.addTab("Characters", charactersTab);
    tabs.addTab("Places", placesTab);

    // Build Characters Tab

    charactersTab.setLayout(new BorderLayout());
    charactersTab.add(inputCPanel, BorderLayout.NORTH);
    charactersTab.add(displayCPanel, BorderLayout.CENTER);
    charactersTab.add(buttonCPanel, BorderLayout.SOUTH);

    jtaC.setBorder(new TitledBorder("List of Characters"));

    inputCPanel.setLayout(new GridLayout(1, 2));
    inputCPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
    inputCPanel.add(lblCName);
    inputCPanel.add(txtCName);
    inputCPanel.add(lblCType);
    inputCPanel.add(txtCType);
    inputCPanel.add(lblCHealth);
    inputCPanel.add(txtCHealth);
    inputCPanel.add(lblCMana);
    inputCPanel.add(txtCMana);
    inputCPanel.add(lblCAttack);
    inputCPanel.add(txtCAttack);
    inputCPanel.add(lblCSpeed);
    inputCPanel.add(txtCSpeed);
    inputCPanel.add(lblCEvil);
    inputCPanel.add(txtCEvil);

    btnCAdd.addActionListener(this);
    btnCList.addActionListener(this);
    btnCSave.addActionListener(this);
    btnCClear.addActionListener(this);

    buttonCPanel.add(btnCAdd);
    buttonCPanel.add(btnCList);
    buttonCPanel.add(btnCSave);
    buttonCPanel.add(btnCClear);

    displayCPanel.add(jtaC);

    // Build Places Tab

    placesTab.setLayout(new BorderLayout());
    placesTab.add(inputPPanel, BorderLayout.NORTH);
    placesTab.add(displayPPanel, BorderLayout.CENTER);
    placesTab.add(buttonPPanel, BorderLayout.SOUTH);

    jtaP.setBorder(new TitledBorder("List of Places"));

    inputPPanel.setLayout(new GridLayout(1, 2));
    inputPPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
    inputPPanel.add(lblPLocation);
    inputPPanel.add(txtPLocation);
    inputPPanel.add(lblPSize);
    inputPPanel.add(txtPSize);
    inputPPanel.add(lblPBiome);
    inputPPanel.add(txtPBiome);

    btnPAdd.addActionListener(this);
    btnPList.addActionListener(this);
    btnPSave.addActionListener(this);
    btnPClear.addActionListener(this);

    buttonPPanel.add(btnPAdd);
    buttonPPanel.add(btnPList);
    buttonPPanel.add(btnPSave);
    buttonPPanel.add(btnPClear);

    displayPPanel.add(jtaP);

  }

  // Methods and GUI Parameters
  
  public static void main(String[] args) {
    Gui jp = new Gui();

    // Setting Up Frame

    jp.setSize(800, 600);
    jp.setLocationRelativeTo(null);
    jp.setVisible(true);
    jp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }
  
  public void addCharacter() {
    String Name = txtCName.getText();
    String Type = txtCType.getText();
    Integer Health = Integer.parseInt(txtCHealth.getText());
    Integer Mana = Integer.parseInt(txtCMana.getText());
    Integer Attack = Integer.parseInt(txtCAttack.getText());
    Integer Speed = Integer.parseInt(txtCSpeed.getText());
    Boolean Evil = Boolean.parseBoolean(txtCEvil.getText());
    Character c = new Character(Name, Type, Health, Mana, Attack, Speed, Evil);
    characters.add(c);
  }

  public void addPlace() {
    String Location = txtPLocation.getText();
    String Size = txtPSize.getText();
    String Biome = txtPBiome.getText();
    Place p = new Place(Location, Size, Biome);
    places.add(p);
  }

  public void listCharacters() {
    jtaC.setText("");
    for (Character c : characters) {
      jtaC.append("\n" + c.toString() + "\n");
    }
  }

  public void listPlaces() {
    jtaP.setText("");
    for (Place p : places) {
      jtaP.append("\n" + p.toString() + "\n");
    }
  }

  public void saveCharacters() {
	  Database classObj = new Database();
	  classObj.charactersDatabase();
  }
  
  public void savePlaces() {
	  Database classObj = new Database();
	  classObj.placesDatabase();
  }
  
  public Character searchCharacterById(int id) {

    for (Character c : characters) {
      if (c.getcharacterId() == id)
        return c;
    }
    return null;
  }

  public Place searchPlaceById(int id) {

    for (Place p : places) {
      if (p.getplaceId() == id)
        return p;
    }
    return null;
  }

  // Button Functionality
  
  public void actionPerformed(ActionEvent e) {

    if (e.getSource() == btnCAdd) {
      addCharacter();
    }

    if (e.getSource() == btnPAdd) {
      addPlace();
    }

    if (e.getSource() == btnCList) {
      listCharacters();
    }

    if (e.getSource() == btnPList) {
      listPlaces();
    }

    if (e.getSource() == btnCClear) {
      jtaC.setText("");
    }

    if (e.getSource() == btnPClear) {
      jtaP.setText("");
    }
    
    if (e.getSource() == btnCSave) {
    	saveCharacters();
    }
    
    if (e.getSource() == btnPSave) {
    	savePlaces();
    }

  }
  
}