package com.github.cc3002.critical;

/**
 * @author <a href="mailto:ignacio.slater@ug.uchile.cl">Ignacio Slater M.</a>.
 * @version 1.0-rc.1
 * @since 1.0
 */
public interface IPokemon {
  int getSpeed();

  long getSeed();

  void setSeed(long seed);

  boolean isOutOfCombat();

  int getHP();

  void setHP(int hp);

  int getDamage();

  void attack(IPokemon opponent);

  void receiveWaterAttack(WaterPokemon attacker);
}
