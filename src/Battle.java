import bugs.ConcurrentModificationBug;
import bugs.NoneTerminationBug;
import bugs.NullPointerBug;
import building.Building;
import students.Team;
import bugs.Bug;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import students.Student;

public class Battle {
  Building building;
  Team team;
  BufferedReader reader;
  ArrayList<String[]> rounds;
  int roundNum;
  Battle(Team team, Building building){
    this.building = building;
    this.team = team;
    rounds = initiate("gameSave.txt");
    roundNum = 0;
  }
  public ArrayList<String[]> initiate(String fileName){
    try{
      FileReader fr = new FileReader(fileName);
      reader = new BufferedReader(fr);
    }catch(Exception e){
      System.out.println("file could not be found");
    }
    ArrayList<String[]> rounds = new ArrayList<String[]>(0);
    Boolean line = true;
    while(line.equals(true)) {
      String text = this.getLine();
      if (text == null) {
        line = false;
      }
      if (text != null) {
        String[] wave = text.split(";");
        rounds.add(wave);
      }
    }
    return rounds;
  }
  public String getLine(){
    String text = null;
    try{
      text = reader.readLine();
      return text;
    }catch(Exception e){
      System.out.println("error");
    }
    return text;
  }
  public void setup(){
    String[] wave = rounds.get(roundNum);
    int length = wave.length;
    for(int i=0; i<length; i++){
      String text = wave[i];
      String[] txt = text.split("\\(");
      String[] txt2 = txt[1].split(",");
      String name = txt[0];
      int level = Integer.valueOf(txt2[1]);
      int num = txt2[2].length();
      String initial = txt2[2].substring(0, num-1);
      int initialSteps = Integer.valueOf(initial);
      Bug bug = null;
      if(txt2[0].equals("CMB")){
        bug = new ConcurrentModificationBug(name, level, initialSteps);
      }
      else if(txt2[0].equals("NTB")){
        bug = new NoneTerminationBug(name, level, initialSteps);
      }
      else if(txt2[0].equals("NPB")){
        bug = new NullPointerBug(name, level, initialSteps);
      }
      building.addBug(bug);
    }
  }
  public void round(){
    int displayRound = roundNum + 1;
    System.out.println("round " + displayRound);
    this.setup();
    int num = building.getTopFloor();
    num = num ;
    for(int i=0; i<num; i++){
      this.manageTeam();
      building.bugsMove();
      team.studentsAct(building);
      Bug[] bugs = building.getAllBugs();
      for(int n=0; n<bugs.length; n++){
        Bug bug = bugs[n];
        System.out.println(bug.getName() + ": HP:" + bug.getCurrentHp() + " steps:" + bug.getCurrentSteps() + " floor:" + bug.getCurrentFloor());
      }
      System.out.println("construction points: " + building.getConstructionPoints());
    }
    roundNum++;
  }
  public void game(){
    boolean gameOver = false;
    String winner = "students";
    for(int i=0; i<rounds.size(); i++){
      if(!gameOver){
        this.round();
        if(building.getConstructionPoints() <= 0){
          gameOver = true;
          winner = "bugs";
        }
      }
    }
    if(building.getAllBugs().length == 0){
      gameOver = true;
    }
    while(!gameOver){
      this.manageTeam();
      building.bugsMove();
      team.studentsAct(building);
      if(building.getConstructionPoints() <= 0) {
        gameOver = true;
        winner = "bugs";
      }
      else if(building.getAllBugs().length == 0){
        gameOver = true;
      }
    }
    System.out.println("the " + winner + " win!!!!!!!!");
  }
  public void manageTeam(){
    int points = team.getKnowledgePoints();
    int cost1 = team.getNewStudentCost();
    while(points >= cost1){
      try {
        team.recruitNewStudent();
      } catch (Exception e) {
        System.out.println("not enough points to recruit a new student");
      }
      points = team.getKnowledgePoints();
      cost1 = team.getNewStudentCost();
    }
    Student[] teamList = team.getStudents();
    int length = teamList.length;
    int cost2;
    for(int i=0; i<length; i++){
      points = team.getKnowledgePoints();
      Student student = teamList[i];
      cost2 = student.upgradeCost();
      if(points >= cost2){
        try {
          team.upgrade(student);
        } catch (Exception e) {
          System.out.println("not enough points to upgrade this student");
        }
      }
    }
  }
}
