package students;
import static java.lang.Math.round;
public interface CyberInterface extends Student{
  int delay = 8;
  int baseAtk = 7;
  default int getDamage(){
    int level = getLevel();
    int damage = (int) round(baseAtk * (Math.pow(level,1.2)));
    return damage;
  }
}
