public interface Observable{
  public void add(Observer o);
  public void delete(Observer o);
  public void notifyObservers();
}
