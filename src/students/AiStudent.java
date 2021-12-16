package students;
import building.Building;
import bugs.Bug;
import java.lang.Math;

public class AiStudent implements AiInterface{
  int currentDelay;
  int level;
  Building building;
  public AiStudent(int level){
    this.level = level;
    currentDelay = 6;
    building = null;
  }
  public int specialAttack(Building building) {
    int points = 0;
    Bug[] bugs = building.getAllBugs();
    int damage = getDamage();
    for(int i=0; i<3; i++){
      Bug bug = bugs[i];
      bug.takeDamage(damage);
      if(bug.getCurrentHp() == 0){
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
