public class SimpleWeaponFactory implements WeaponFactory{
  public WeaponBehavior createWeapon(WeaponType type){
    switch(type){
    case CLUB:
      return new Club();
    case SWORD:
      return new Sword();
    case SHOTGUN:
      return new Shotgun();
    case UNARMED:
      return null; // could use a class for this
    default:
      return null;
    }
  }
}
