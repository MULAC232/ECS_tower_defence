package students;


import static java.lang.Math.round;

public interface SeInterface extends Student{
  int delay = 6;
  int baseAtk = 5;
  default int getDamage(){
    int level = getLevel();
    int damage = (int) round(baseAtk * (Math.pow(level,1.2)));
    return damage;
  }
}
