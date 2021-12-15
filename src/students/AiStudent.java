package students;
import building.Building;
import bugs.Bug;
import java.lang.Math;

public class AiStudent extends StudentSpecial implements Student{
  public AiStudent(int level){
    super(level);
    delay = 7;
    currentDelay = 6;
    baseAtk = 7;

  }
  public static int specialAttack() {
    int points = 0;
    Bug[] bugs = building.getAllBugs();
    int damage = Student.getDamage();
    for(int i=0; i<3; i++){
      Bug bug = bugs[i];
      bug.takeDamage(damage);
      if(bug.getCurrentHp() == 0){
        points = points + (bug.getLevel() * 20);
      }
    }
    return points;
  }
}
