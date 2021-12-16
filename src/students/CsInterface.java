package students;
import static java.lang.Math.round;
public interface CsInterface extends Student{
  int delay = 6;
  static int baseAtk = 6;
  default int getDamage(){
    int level = getLevel();
    int damage = (int) round(baseAtk * (Math.pow(level,1.2)));
    return damage;
  }
}
