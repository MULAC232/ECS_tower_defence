import building.Building;
import bugs.ConcurrentModificationBug;
import students.SeStudent;

public class Main {
  public static void main(String args[]){
    Building building1 = new Building(1,1);
    ConcurrentModificationBug bug1 = new ConcurrentModificationBug("bob", 3, 2);
    building1.addBug(bug1);
      building1.bugsMove();
    SeStudent student = new SeStudent(1);
    System.out.println(student.upgradeCost());
    student.defence(building1);
  }
}
