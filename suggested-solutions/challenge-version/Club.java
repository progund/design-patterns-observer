public class Club implements WeaponBehavior{
  public int useWeapon(){
    System.out.println("The club makes a swooshing sound");
    return 20;
  }
  public String toString(){ return "Ugly wooden club"; }
}
