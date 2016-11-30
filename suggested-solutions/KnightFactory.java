public class KnightFactory implements CharacterFactory{
  private static WeaponFactory weaponFactory 
    = new SimpleWeaponFactory();

  public Character createCharacter(WeaponType weapon,
                                   String name){    
    return new Knight(name, weaponFactory.createWeapon(weapon));
  }
  public Character createUnarmedCharacter(String name){    
    return createCharacter(WeaponType.UNARMED, name);
  }
}
