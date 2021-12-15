package students;
import building.Building;
import bugs.Bug;

import static java.lang.Math.round;

public interface Student {
  public static int getLevel(){
    return level;
  }
  public static int upgradeCost(){
    int cost = 100 * (2^level);
    return cost;
  }
  public default int defence(){
    int points;
    if(currentDelay == 0){
      points = StudentSpecial.specialAttack();
      resetDelay();
    }
    else{
      points = normalAttack();
    }
    return points;
  }
  public static int normalAttack(){
    int points = 0;
    int damage = getDamage();
    Bug[] bugs = building.getAllBugs();
    Bug bug = bugs[0];
    bug.takeDamage(damage);
    if(bug.getCurrentHp() == 0){
      points = bug.getLevel() * 20;
    }
    return points;
  }
  public static int getDamage(){
    int damage = (int) round(baseAtk * (Math.pow(level,1.2)));
    return damage;
  }

  public static void resetDelay(){
    int num = delay - 1;
    currentDelay = num;
  }

  public static void setBuilding(Building building2){
    building = building2;
  }
  public static void incrLevel(){
    level++;
  }
}
