package students;

import bugs.Bug;
import building.Building;

import java.util.Random;

public class CyberStudent implements CyberInterface{
  int currentDelay;
  int level;
  Building building;
  public CyberStudent(int level){
    this.level = level;
    currentDelay = 7;
    building = null;
  }

  public int specialAttack(Building building) {
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
      int damage = getDamage();
      damage = damage * 2;
      bug.takeDamage(damage);
      if(bug.getCurrentHp() == 0) {
        points = points + (bug.getLevel() * 20);
      }
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
