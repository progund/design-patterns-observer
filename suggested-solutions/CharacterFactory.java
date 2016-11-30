public interface CharacterFactory{
  public Character createCharacter(WeaponType    weapon,
                                   String        name);
  public Character createUnarmedCharacter(String name);
}
