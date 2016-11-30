import java.util.List;
import java.util.ArrayList;
public class HardEntitiesFactory implements GameEntitiesFactory{
  // Only knights and a few trolls and an orch in hard level
  private static CharacterFactory knightFac = new KnightFactory();
  private static CharacterFactory trollFac  = new TrollFactory();
  private static CharacterFactory orchFac  = new OrchFactory();
  // The weapons for the hard level
  private static WeaponFactory weaponFac     = new SimpleWeaponFactory();

  // Two knights, one troll and one orch in hard level
  public List<Character>createBadGuys(){
    List<Character> badGuys = new ArrayList<>();
    badGuys.add(knightFac
                .createCharacter(WeaponType.SWORD, "Sir Humpty"));
    badGuys.add(knightFac
                .createCharacter(WeaponType.SWORD, "Sir Dumpty"));
    badGuys.add(orchFac
                .createCharacter(WeaponType.CLUB, "Sir James"));
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
