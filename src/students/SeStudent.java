package students;

import bugs.Bug;
import building.Building;

public class SeStudent extends StudentSpecial implements Student{
  public SeStudent(int level){
    super(level);
    delay = 6;
    currentDelay = 5;
    baseAtk = 5;
  }
  static int specialAttack(){
    Bug[] bugs = building.getAllBugs();
    for(int i=0; i<5; i++){
      Bug bug = bugs[i];
      bug.slowDown(2);
    }
    return 0;
  }
}
