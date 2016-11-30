public class Troll extends Character{
  public Troll(String name){ super(name); }
  public Troll(String name, WeaponBehavior weapon){ super(name, weapon); }

  public void fight(Character opponent){
    if(weapon()==null){
      System.out.println("Jag ska meja ned hela tomtearmén, utan vapen");
      opponent.takeDamage(10);
    }else{
      System.out.println("-Bränn, bränn, bränn!");
      System.out.println(name() + " uses " + weapon() + " against " + opponent.name());
      opponent.takeDamage(weapon().useWeapon());
    }
    System.out.println(" Score after attack: " + this + " - " + opponent);
  }
}
