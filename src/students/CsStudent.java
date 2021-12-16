package students;

import bugs.Bug;
import building.Building;

public final class CsStudent implements CsInterface{
  int currentDelay;
  int level;
  Building building;
  public CsStudent(int level){
    this.level = level;
    currentDelay = 5;
    building = null;
  }
  public int specialAttack(Building building){
    int points = 0;
    int damage = getDamage();
    damage = damage * 4;
    Bug[] bugs = building.getAllBugs();
    Bug bug = bugs[0];
    bug.takeDamage(damage);
    if(bug.getCurrentHp() == 0){
      points = bug.getLevel() * 20;
    }
    return points;
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
