package building;
import bugs.Bug;
import java.util.ArrayList;
import java.util.Collections;

public class Building {
  int constructionPoints;
  int topFloor;
  ArrayList<Bug> bugs = new ArrayList<Bug>(0);
  public Building(int topFloor, int constructionPoints){
    this.topFloor = topFloor;
    this.constructionPoints = constructionPoints;
  }
  public int getTopFloor(){
    return topFloor;
  }
  public int getConstructionPoints(){
    return constructionPoints;
  }
  public Bug[] getAllBugs(){
    ArrayList<Bug> bugs2 = new ArrayList<Bug>(0);
    bugs2.addAll(bugs);
    ArrayList<Bug> toRemove = new ArrayList<Bug>(0);
    for(Bug i: bugs2){
      if(i.getCurrentFloor() == -1 || i.getCurrentHp() == 0){
        toRemove.add(i);
      }
    }
    for(Bug i: toRemove){
      bugs2.remove(i);
    }
    Collections.sort(bugs2);
    int length = bugs2.size();
    Bug[] bugs3 = new Bug[length];
    for(int i=0; i<length; i++){
      Bug item = bugs2.get(i);
      bugs3[i] = item;
    }
    return bugs3; 
  }
  public int addBug(Bug bug){
    if(bugs.contains(bug)){
      return -1;
    }
    else{
      bugs.add(bug);
      return bugs.size();
    }
  }
  public void removeBug(Bug bug){
    bugs.remove(bug);
  }
  public void bugsMove(){
    ArrayList<Bug> toRemove = new ArrayList<Bug>(0);
    for(Bug bug: bugs){
      bug.move();
      if(bug.getCurrentFloor() == topFloor){
        int damage = bug.getDamage();
        constructionPoints = constructionPoints - damage;
        toRemove.add(bug);
      }
      if(constructionPoints <= 0){
        break;
      }
    }
    for(Bug bug: toRemove){
      bugs.remove(bug);
    }
  }
}
