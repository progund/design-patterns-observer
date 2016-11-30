import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;
public class FragList implements Observable, Observer{
  private Map<String, Integer> fragStats;
  private List<Observer> observers;
  private Map<String, List<String>> kills;
  private boolean isOver;
  private static final FragList instance = new FragList();
  public final static FragList fragList(){ return instance; }

  private Character lastKill;
  
  private FragList(){
    fragStats = new TreeMap<>();
    observers = new ArrayList<>();
    kills  = new TreeMap<>();
  }
  @Override
  public int hashCode(){
    return 17;
  }
  @Override
  public boolean equals(Object o){
    return o == this;
  }

  @Override
  public void update(Observable o){
    System.out.println("Notified by: " + o);
    if(o instanceof Character){
      if( ((Character)o).health()<1){
        System.out.println(o + " is dead. Adding kill by: " + ((Character)o).slayer());
        addKill( ( (Character)o ).slayer(), (Character)o);
      }
    }
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
  public Character lastKill(){
    return lastKill;
  }
  public void addKill(Character killer, Character frag){
    System.out.println(frag.name() + " was killed by " + killer.name());
    lastKill = frag;
    List<String> frags = new ArrayList<>();
    if(kills.get(killer.name()) == null){
      frags.add(frag.name());
      kills.put(killer.name(), frags);
    }else{
      frags = kills.get(killer.name());
      frags.add(frag.name());
      kills.put(killer.name(),frags); 
    }
    incFrags(killer.name());
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
