import building.Building;
import bugs.ConcurrentModificationBug;
import students.SeStudent;
import students.Team;

import java.io.File;
import java.io.FileWriter;

public class Main {
  public static void main(String args[]){
    Building building1 = new Building(4,20);
    Team team = new Team(100);
    Battle battle = new Battle(team, building1);
    battle.game();
  }
}
