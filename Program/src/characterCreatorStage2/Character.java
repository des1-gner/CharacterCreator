package characterCreatorStage2;

// Instance Variables

public class Character {

  protected Integer characterId;

  private String Name;

  private String Type;

  private Integer Health;

  private Integer Mana;

  private Integer Attack;

  private Integer Speed;

  private Boolean Evil;

  static Integer nextID = 0;

  // Default Constructor

  public Character() {
  }

  // Constructor and elimination of confusion of objects with same class
  // attributes and parameters names

  public Character(String Name, String Type, Integer Health, Integer Mana, Integer Attack,
      Integer Speed,
      Boolean Evil) {
    this.Name = Name;
    this.Type = Type;
    this.Health = Health;
    this.Mana = Mana;
    this.Attack = Attack;
    this.Speed = Speed;
    this.Evil = Evil;
    characterId = nextID++;
  }

  // Getters

  public Integer getcharacterId() {
    return characterId;
  }

  public String getName() {
    return Name;
  }

  public String getType() {
    return Type;
  }

  public Integer getHealth() {
    return Health;
  }

  public Integer getMana() {
    return Mana;
  }

  public Integer getAttack() {
    return Attack;
  }

  public Integer getSpeed() {
    return Speed;
  }

  public Boolean getEvil() {
    return Evil;
  }

  // Setters

  public Integer setcharacterId(int i) {
    return characterId;
  }

  public String setName() {
    return Name;
  }

  public String setType() {
    return Type;
  }

  public Integer setHealth() {
    return Health;
  }

  public Integer setMana() {
    return Mana;
  }

  public Integer setAttack() {
    return Attack;
  }

  public Integer setSpeed() {
    return Speed;
  }

  public Boolean setEvil() {
    return Evil;
  }

  // toString Character Output

  public String toString() {
    return "\nCharacter Id: " + characterId + "\nI am " + Name + ", the " + Type + ". I have " + Health + " Health, "
        + Mana + " Mana, " + Attack + " Attack, " + Speed + " Speed. Am I Evil?: " + Evil;
  }
}