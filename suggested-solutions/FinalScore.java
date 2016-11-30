public class FinalScore implements Observer{
  public FinalScore(Observable o){
    o.add(this);
  }
  public void update(Observable o){
    if(o instanceof FragList){
      if(((FragList)o).isOver()){
        printStats((FragList)o);
      }
    }
  }

  public void printStats(FragList fl){
    System.out.println("====Kills in the game===");
    System.out.println(fl.killsAsString());
    System.out.println("========================");
  }
}
