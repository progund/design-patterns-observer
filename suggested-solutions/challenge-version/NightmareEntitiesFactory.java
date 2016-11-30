import java.util.List;
import java.util.ArrayList;
public class NightmareEntitiesFactory implements GameEntitiesFactory{
  // All kinds of bad guys in nightmare
  private static CharacterFactory knightFac = new KnightFactory();
  private static CharacterFactory trollFac  = new TrollFactory();
  private static CharacterFactory orchFac  = new OrchFactory();
  // The weapons for the nightmare level
  private static WeaponFactory weaponFac     = new SimpleWeaponFactory();

  // One night, two trolls and two orchs
  public List<Character>createBadGuys(){
    List<Character> badGuys = new ArrayList<>();
    badGuys.add(knightFac
                .createCharacter(WeaponType.SWORD, "Sir Humpty"));
    badGuys.add(trollFac
                .createCharacter(WeaponType.CLUB, "Trolly"));
    badGuys.add(trollFac
                .createCharacter(WeaponType.CLUB, "Dolly"));
    badGuys.add(orchFac
                .createCharacter(WeaponType.CLUB, "Steve"));
    badGuys.add(orchFac
                .createCharacter(WeaponType.CLUB, "Bill"));
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
