package com.github.cc3002.critical;

import org.jetbrains.annotations.NotNull;

import java.util.Random;

/**
 * @author <a href="mailto:ignacio.slater@ug.uchile.cl">Ignacio Slater Muñoz</a>
 * @version 1.0-b.1
 * @since 1.0
 */
public class Pokemon {
  private final String name;
  private int hp;
  private final int damage;
  private final int speed;
  private long seed;
  private Random rng;

  public Pokemon(final String name, final int hp, final int damage, final int speed) {
    this.name = name;
    this.hp = hp;
    this.damage = damage;
    this.speed = speed;
  }

  public boolean isOutOfCombat() {
    return hp == 0;
  }

  public void setHP(final int hp) {
    this.hp = hp;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final Pokemon pokemon = (Pokemon) o;
    return hp == pokemon.hp &&
           damage == pokemon.damage &&
           speed == pokemon.speed &&
           name.equals(pokemon.name);
  }

  public int getSpeed() {
    return speed;
  }

  public int getHP() {
    return hp;
  }

  public void attack(final @NotNull Pokemon opponent) {
    int threshold = speed / 2;
    opponent.hp -= damage * (rng.nextInt(256) < threshold ? 2 : 1);
  }

  public void setSeed(final long seed) {
    this.rng = new Random(seed);
  }
}
