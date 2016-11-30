public abstract class Character{
  private WeaponBehavior weapon;
  private String name;
  private int health = 100;
  public Character(String name){
    this.name = name;
  }
  public Character(String name, WeaponBehavior weapon){
    this(name);
    this.weapon = weapon;
  }
  public String name(){ return name; }
  public void changeWeapon(WeaponBehavior weapon){
    this.weapon = weapon;
  }
  public WeaponBehavior weapon(){ return weapon; }

  public void takeDamage(int damage){
    // unsafe for now
    health -= damage;
  }
  public abstract void fight(Character opponent);
  public int health(){ return health; }
  public String toString(){ return name 
      + " with health: " + health 
      + ((weapon!=null)?" carrying " + weapon :""); }
}
