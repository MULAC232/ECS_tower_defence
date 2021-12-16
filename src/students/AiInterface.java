package students;
import static java.lang.Math.round;
public interface AiInterface extends Student{
  int delay = 7;
  int baseAtk = 7;
  default int getDamage(){
    int level = getLevel();
    int damage = (int) round(baseAtk * (Math.pow(level,1.2)));
    return damage;
  }
}
