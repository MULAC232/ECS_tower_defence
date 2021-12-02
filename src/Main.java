import building.Building;
import bugs.ConcurrentModificationBug;
public class Main {
  public static void main(String args[]){
    Building building1 = new Building(1,1);
    ConcurrentModificationBug bug1 = new ConcurrentModificationBug("bob", 3, 2);
    building1.addBug(bug1);
    while(building1.getConstructionPoints() > 0){
      building1.bugsMove();
    }
  }
}
