public class Sword implements WeaponBehavior{
  public int useWeapon(){
    System.out.println("The sword shines and cuts through the air before it hits its target");
    return 15;
  }
  public String toString(){ return "Excalibur"; } // excalibur should be a singleton!
}
