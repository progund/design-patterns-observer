public class GameStats implements Observer{
  public GameStats(Observable o){
    o.add(this);
  }
  public void update(Observable o){
    if(o instanceof FragList){
      printStats((FragList)o);
    }
  }

  public void printStats(FragList fl){
    System.out.println("====Current frag list====");
    System.out.println(fl);
    System.out.println("=========================");
  }
}
