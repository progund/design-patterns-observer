public class Orch extends Character{
  public Orch(String name){ super(name); }
  public Orch(String name, WeaponBehavior weapon){ super(name, weapon); }

  public void fight(Character opponent){
    if(weapon()==null){
      System.out.println("*Orch scream*");
      opponent.takeDamage(30);
    }else{
      System.out.println("*Orch uses weapon*");
      System.out.println(name() + " uses " + weapon() + " against " + opponent.name());
      opponent.takeDamage(weapon().useWeapon());
    }
    System.out.println(" Score after attack: " + this + " - " + opponent);
  }
}
