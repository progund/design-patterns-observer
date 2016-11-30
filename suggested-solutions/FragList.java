import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;
public class FragList implements Observable{
  private Map<String, Integer> fragStats;
  private List<Observer> observers;
  private Map<String, List<String>> kills;

  private boolean isOver;
  public FragList(){
    fragStats = new TreeMap<>();
    observers = new ArrayList<>();
    kills  = new TreeMap<>();
  }

  @Override
  public void add(Observer o){
    if(!observers.contains(o)){
      observers.add(o);
    }
  }

  @Override
  public void delete(Observer o){
      observers.remove(o);
  }

  @Override
  public void notifyObservers(){
    for(Observer o : observers){
      o.update(this);
    }
  }
  public void addKill(Character killer, Character frag){
    System.out.println(frag.name() + " was killed by " + killer.name());
    List<String> frags = new ArrayList<>();
    if(kills.get(killer.name()) == null){
      frags.add(frag.name());
      kills.put(killer.name(), frags);
    }else{
      frags = kills.get(killer.name());
      frags.add(frag.name());
      kills.put(killer.name(),frags); 
    }
  }
  public List<String>allFrags(){
    List<String> frags = new ArrayList<String>();
    for(List<String>list : kills.values()){
      frags.addAll(list);
    }
    return frags;
  }
  public String killsAsString(){
    return kills.toString();
  }
  public boolean isOver(){ return isOver; }
  public void gameOver(){
    isOver = true;
    notifyObservers();
  }
  public void incFrags(String name){
    if(fragStats.get(name)==null){
      fragStats.put(name, new Integer(1));
    }else{
      int frags = fragStats.get(name);
      fragStats.put(name, new Integer(++frags));
    }
    notifyObservers();
  }
  @Override
  public String toString(){
    if(fragStats.isEmpty()){
      return "No frags yet";
    }
    StringBuilder result = new StringBuilder();
    for(String name : fragStats.keySet()){
      result.append(name)
        .append(": ")
        .append(fragStats.get(name).toString())
        .append(" frag(s)\n");
    }
    if(result.length()>0){
      result.deleteCharAt(result.length()-1);
    }
    return result.toString();
  }
}
