package com.github.cc3002.critical;

/**
 * @author <a href="mailto:ignacio.slater@ug.uchile.cl">Ignacio Slater M.</a>.
 * @version 1.0-b.3
 * @since 1.0
 */
public interface IPokemon {
  void setHP(int hp);

  int getSpeed();

  void setSeed(long seed);

  long getSeed();

  boolean isOutOfCombat();
}
