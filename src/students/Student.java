package students;
import building.Building;
import bugs.Bug;

import static java.lang.Math.round;

public interface Student {
  default int getLevel(){
    System.out.println("Error. Wrong method called.");
    return 0;
  }
  default int upgradeCost(){
    int level = getLevel();
    int cost = (int) (100 * (Math.pow(2, level)));
    return cost;
  }
  public default int defence(Building building){
    int points;
    int currentDelay = getDelay();
    if(currentDelay == 0){
      points = specialAttack(building);
      resetDelay();
    }
    else{
      points = normalAttack(building);
    }
    return points;
  }
  default int normalAttack(Building building){
    int points = 0;
    try {
      int damage = getDamage();
      Bug[] bugs = building.getAllBugs();
      Bug bug = bugs[0];
      bug.takeDamage(damage);
      if (bug.getCurrentHp() == 0) {
        points = bug.getLevel() * 20;
      }
    }catch(Exception e){
      System.out.println("no bugs left to kill");
    }
    return points;
  }
  int getDamage();
  default void resetDelay(){
    System.out.println("Error. Wrong method called.");
  }
  default void incrLevel(){
    System.out.println("Error. Wrong method called.");
  }
  default int getDelay(){
    System.out.println("Error. Wrong method called.");
    return 0;
  }
  default int specialAttack(Building building){
    System.out.println("Error. Wrong method called.");
    return 0;
  }
}
