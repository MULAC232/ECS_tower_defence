package students;

import bugs.Bug;
import building.Building;

public final class CsStudent extends StudentSpecial implements Student{
  public CsStudent(int level){
    super(level);
    delay = 6;
    currentDelay = 5;
    baseAtk = 6;
  }
  public static int specialAttack(){
    int points = 0;
    int damage = Student.getDamage();
    damage = damage * 4;
    Bug[] bugs = building.getAllBugs();
    Bug bug = bugs[0];
    bug.takeDamage(damage);
    if(bug.getCurrentHp() == 0){
      points = bug.getLevel() * 20;
    }
    return points;
  }
}
