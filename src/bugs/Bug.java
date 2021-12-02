package bugs;
import java.lang.Comparable;

public abstract class Bug implements Comparable<Bug>{
  String name;
  int baseHp;
  int baseSteps;
  int level;
  int currentHp;
  int currentSteps;
  int currentFloor;
  public Bug(String name, int baseHp, int baseSteps, int level){
    this.name = name;
    this.baseHp = baseHp;
    this.baseSteps = baseSteps;
    this.level = level;
    currentHp = (int) Math.round(baseHp * (Math.pow(level, 1.5)));
    currentFloor = -1;
  }
  public Bug(String name, int baseHp, int baseSteps, int level, int initialSteps){
    this.name = name;
    this.baseHp = baseHp;
    this.baseSteps = baseSteps;
    this.level = level;
    currentSteps = initialSteps;
    currentHp = (int) Math.round(baseHp * (Math.pow(level,1.5)));
    currentFloor = -1;
  }
  public int getBaseSteps(){
    return baseSteps;
  }
  public int getLevel(){
    return level;
  }
  public int getCurrentHp(){
    return currentHp;
  }
  public int getCurrentSteps(){
    return currentSteps;
  }
  public int getCurrentFloor(){
    return currentFloor;
  }
  public int move(){
    if(currentSteps > 0){
      currentSteps -= 1;
    }
    else{
      currentFloor += 1;
      currentSteps = baseSteps - 1;
    }
    return currentSteps;
  }
  public void damage(int amount){
    currentHp  = currentHp - amount;
    if(currentHp < 0){
      this.currentHp = 0;
    }
  }
  public void slowDown(int steps){
    currentSteps = currentSteps + steps;
  }
  @Override
  public int compareTo(Bug bug) {
    if (this.getCurrentFloor() > bug.getCurrentFloor()) {
      return -1;
    }
    else if(this.getCurrentFloor() < bug.getCurrentFloor()){
      return 1;
    }
    else{
      if(this.getCurrentSteps() < bug.getCurrentSteps()){
        return -1;
      }
      else if(this.getCurrentSteps() > bug.getCurrentSteps()){
        return 1;
      }
      return 0;
    }
  }
  public abstract int getDamage();
}
