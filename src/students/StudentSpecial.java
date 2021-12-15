package students;

public abstract class StudentSpecial {
  int level;
  public StudentSpecial(int level){
    this.level = level;
  }
  static int specialAttack(){
    return 0;
  }
}
