package students;
import java.util.ArrayList;
import building.Building;
import java.util.Random;

public class Team {
  int points;
  int cost;
  ArrayList<Student> students = new ArrayList<Student>(0);
  public Team(int points){
    this.points = points;
    cost = 100;
  }
  public int getKnowledgePoints(){
    return points;
  }
  public Student[] getStudents(){
    int length = students.size();
    Student[] students2 = new Student[length];
    for(int i=0; i<length; i++){
      Student item = students.get(i);
      students2[i] = item;
    }
    return students2;
  }
  public void studentsAct(Building building){
    int points = 0;
    int length = students.size();
    for(int i=0; i<length; i++){
      Student student = students.get(i);
      Student.setBuilding(building);
    }
    for(int i=0; i<length; i++){
      Student student = students.get(i);
      points = student.defence();
      this.points = this.points + points;
    }
  }
  public int getNewStudentCost(){
    return cost;
  }
  public void recruitNewStudent() throws Exception{
    if(points < cost){
      throw new Exception("not enough knowledge points");
    }
    else{
      Random rand = new Random();
      int choice = rand.nextInt(4);
      if(choice == 0){
        Student student = new AiStudent(1);
        students.add(student);
      }
      else if(choice == 1){
        Student student = new CsStudent(1);
        students.add(student);
      }
      else if(choice == 2){
        Student student = new CyberStudent(1);
        students.add(student);
      }
      else{
        Student student = new SeStudent(1);
        students.add(student);
      }
      points = points - cost;
    }
  }
  public void upgrade(Student student) throws Exception{
    if(points < Student.upgradeCost()){
      throw new Exception("not enough knowledge points");
    }
    else{
      Student.incrLevel();
      points = points - Student.upgradeCost();
    }
  }
}
