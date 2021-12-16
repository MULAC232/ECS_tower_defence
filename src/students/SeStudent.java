package students;

import bugs.Bug;
import building.Building;

public class SeStudent implements SeInterface{
  int currentDelay;
  int level;
  Building building;
  public SeStudent(int level){
    this.level = level;
    currentDelay = 5;
    building = null;
  }
  public int specialAttack(Building building){
    Bug[] bugs = building.getAllBugs();
    for(int i=0; i<5; i++){
      Bug bug = bugs[i];
      bug.slowDown(2);
    }
    return 0;
  }
  public void resetDelay(){
    currentDelay = delay - 1;
  }
  public int getLevel(){
    return level;
  }
  public int getDelay(){
    return currentDelay;
  }
  public void incrLevel(){
    level++;
  }
}
