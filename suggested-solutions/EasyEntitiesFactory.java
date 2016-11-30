import java.util.List;
import java.util.ArrayList;
public class EasyEntitiesFactory implements GameEntitiesFactory{
  // Only knights and a few trolls in easy level
  private static CharacterFactory knightFac = new KnightFactory();
  private static CharacterFactory trollFac  = new TrollFactory();
  // The weapons for the easy level
  private static WeaponFactory weaponFac     = new SimpleWeaponFactory();

  // Three knights and one troll
  public List<Character>createBadGuys(){
    List<Character> badGuys = new ArrayList<>();
    badGuys.add(knightFac
                .createCharacter(WeaponType.SWORD, "Sir Humpty"));
    badGuys.add(knightFac
                .createCharacter(WeaponType.SWORD, "Sir Dumpty"));
    badGuys.add(knightFac
                .createCharacter(WeaponType.SWORD, "Sir James"));
    badGuys.add(trollFac
                .createCharacter(WeaponType.CLUB, "Trolly"));
    return badGuys;
  }
  // A club, a sword and a shotgun
  public List<WeaponBehavior>createWeapons(){
    List<WeaponBehavior>weapons = new ArrayList<>();
    weapons.add(weaponFac.createWeapon(WeaponType.CLUB));
    weapons.add(weaponFac.createWeapon(WeaponType.SWORD));
    weapons.add(weaponFac.createWeapon(WeaponType.SHOTGUN));
    return weapons;
  }
}
