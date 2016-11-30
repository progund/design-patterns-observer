import java.util.List;
public class Game{
  public static void main(String[] args){


    // Observable list:
    FragList fragList = FragList.fragList();
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
        if(player.health()<50 ){
          player.takeDamage(-50);
        }
        c.fight(player);
        if(c.health()<0){
          break;
        }
        sleep(200);
        player.fight(c);
        if(c.health()<0){
          break;
        }
        sleep(200);
        player.fight(c);
        if(c.health()<0){
          break;
        }
        sleep(200);
        player.fight(c);
        sleep(500);
      }
      System.out.println("==============================");
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
