import java.util.Map;
import java.util.TreeMap;
import java.util.List;

public class Characters implements Observer {
  private Map<String,Character> characters;
  
  public Characters(Observable o) {
    characters = new TreeMap<>();
    o.add(this);
  }
  
  public void addCharacters(List<Character> list) {
    for(Character c : list) {
      characters.put(c.name(), c);
    }
  }
  
  public void addCharacter(Character c) {
    characters.put(c.name(), c);
  }
  
  public Map<String,Character> getCharacters() {
    return characters;
  }
  
  public void update(Observable o) {
    if(o instanceof FragList) {
      for(String s : ((FragList)o).allFrags()) {
        characters.remove(s);
      }
    }
  }
  
  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    for(Character c : characters.values()) {
      result.append(c.toString());
      result.append("\n");
    }
    return result.toString();
  }
}

