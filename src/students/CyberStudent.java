package students;

import bugs.Bug;
import building.Building;

import java.util.Random;

public class CyberStudent extends StudentSpecial implements Student{
  public CyberStudent(int level){
    super(level);
    delay = 8;
    currentDelay = 7;
    baseAtk = 7;
  }

  public static int specialAttack() {
    int points = 0;
    Boolean removed = false;
    Bug[] bugs = building.getAllBugs();
    Bug bug = bugs[0];
    int prob = bug.getLevel() + 20;
    if(prob > 50) {
      prob = 50;
    }
    Random rand = new Random();
    int num = rand.nextInt(100);
    if(num < prob) {
      removed = true;
      building.removeBug(bug);
      points = points + (bug.getLevel() * 20);
    }
    if(removed.equals(false)){
      int damage = Student.getDamage();
      damage = damage * 2;
      bug.takeDamage(damage);
      if(bug.getCurrentHp() == 0){
        points = points + (bug.getLevel() * 20);
      }
      return points;
    }
  }
}
