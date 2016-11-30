import java.util.*;
public abstract class Character implements Observable{
  private WeaponBehavior weapon;
  private String name;
  private int health = 100;
  static private List<Observer> observers = new ArrayList<>();
  private Character slayer;
  
  public void add(Observer o){
    if(observers.indexOf(o)<0){
      observers.add(o);
    }
  }
  public void delete(Observer o){
    observers.remove(o);
  }
  public void notifyObservers(){
    for(Observer o : observers){
      o.update(this);
    }
  }
  
  public Character(String name){
    // Register the fraglist as interested in our changes
    add(FragList.fragList());
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
  // the frag list object must be able to get information
  // about who killed us
  public Character slayer(){
    return slayer;
  }
  public void takeDamage(int damage, Character adversary){
    // unsafe for now
    health -= damage;
    if(health<1){
      // I died, so notify those interested in this      
      if(slayer==null){
        slayer = adversary;
        notifyObservers();
      }
    }
  }
  public abstract void fight(Character opponent);
  public int health(){ return health; }
  public String toString(){
    return name 
      + " with health: " + health 
      + ((weapon!=null)?" carrying " + weapon :" (unarmed)"); }
}
