package com.github.cc3002.critical;

import org.jetbrains.annotations.NotNull;

import java.util.Random;

/**
 * @author <a href="mailto:ignacio.slater@ug.uchile.cl">Ignacio Slater Muñoz</a>
 * @version 1.0-b.2
 * @since 1.0
 */
public abstract class AbstractPokemon implements IPokemon {
  private final String name;
  private final int damage;
  private final int speed;
  private int hp;
  private Random rng;
  private long seed;

  public AbstractPokemon(final String name, final int hp, final int damage, final int speed) {
    this.name = name;
    this.hp = hp;
    this.damage = damage;
    this.speed = speed;
    rng = new Random();
  }

  public boolean isOutOfCombat() {
    return hp == 0;
  }

  public int getSpeed() {
    return speed;
  }

  public int getHP() {
    return hp;
  }

  public void setHP(final int hp) {
    this.hp = hp;
  }

  public void attack(final @NotNull AbstractPokemon opponent) {
    int threshold = speed / 2;
    opponent.hp -= damage * (rng.nextInt(256) < threshold ? 2 : 1);
  }

  @Override
  public long getSeed() {
    return seed;
  }

  @Override
  public void setSeed(final long seed) {
    this.seed = seed;
    this.rng.setSeed(seed);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final AbstractPokemon pokemon = (AbstractPokemon) o;
    return hp == pokemon.hp &&
           damage == pokemon.damage &&
           speed == pokemon.speed &&
           name.equals(pokemon.name);
  }
}
