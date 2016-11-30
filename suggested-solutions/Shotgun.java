public class Shotgun implements WeaponBehavior{
  public int useWeapon(){
    System.out.println("Schklikt, klikt Ka-POW goes the shotgun");
    return 45;
  }
  public String toString(){ return "Shotgun"; }
}
