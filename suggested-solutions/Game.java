import java.util.List;
public class Game{
  public static void main(String[] args){
    // Observable list:
    FragList fragList = new FragList();
    //Observers: 
    GameStats gameStats = new GameStats(fragList);
    FinalScore finalScore = new FinalScore(fragList);
    Characters characters = new Characters(fragList);

    CharacterFactory cFactory = new KnightFactory();
    Character player =
      cFactory.createUnarmedCharacter("Sir Playsalot");
    GameEntitiesFactory gef = new NightmareEntitiesFactory();
    List<Character>    opponents = gef.createBadGuys();
    List<WeaponBehavior> weapons = gef.createWeapons();

    characters.addCharacters(opponents);
    characters.addCharacter(player);
    System.out.println("============ players in this game ===============");
    System.out.println(characters);
    System.out.println("=================================================");
    sleep(1000);
    int weaponIndex=0;
    System.out.print(player);
    System.out.println(" enters the woods");
    sleep(1000);
    for(Character c : opponents){
      System.out.println("<<<Oh no, not another one!");
      System.out.println(player + " meets " + c + " who attacks!");     
      sleep(1000);
      while(c.health()>0){        
        c.fight(player);
        sleep(200);
        player.fight(c);
        sleep(200);
        player.fight(c);
        sleep(200);
        player.fight(c);
        sleep(500);
        if(c.health()<1){
          fragList.incFrags(player.name());
          fragList.addKill(player, c);
        }
      }
      System.out.println("==============================");
      System.out.println(player + " finds a magic potion and drinks it");
      player.takeDamage(-100);
      if(weaponIndex < weapons.size()){
        System.out.println(player + " finds " +
                           weapons.get(weaponIndex)
                           + " and upgrades his weapon!");
        player.changeWeapon(weapons.get(weaponIndex));
        weaponIndex++;
      }
    }
    sleep(1000);
    System.out.println("===========GAME OVER=============");
    fragList.gameOver();
    System.out.println("Final score: ");
    System.out.println(characters);
  }
  static void sleep(int millis){
    try{
      Thread.currentThread().sleep(millis);
    }catch(InterruptedException e){}
  }
}
