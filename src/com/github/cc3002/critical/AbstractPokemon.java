package com.github.cc3002.critical;

import org.jetbrains.annotations.NotNull;

import java.util.Random;

/**
 * @author <a href="mailto:ignacio.slater@ug.uchile.cl">Ignacio Slater Muñoz</a>
 * @version 1.0-rc.1
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

  @Override
  public abstract void attack(final IPokemon opponent);

  @Override
  public void receiveWaterAttack(final WaterPokemon attacker) {
    receiveDamage(attacker);
  }

  private void calculateReceivedDamage(double attackerDamage, int attackerSpeed) {
    int threshold = attackerSpeed / 2;
    int r = rng.nextInt(256);
    setHP(hp - (int) (attackerDamage * (r < threshold ? 2 : 1)));
  }

  protected void receiveDamage(final @NotNull IPokemon attacker) {
    calculateReceivedDamage(attacker.getDamage(), attacker.getSpeed());
  }

  protected void receiveResistantDamage(final @NotNull IPokemon attacker) {
    calculateReceivedDamage(attacker.getDamage() * 0.5, attacker.getSpeed());
  }

  protected void receiveWeaknessDamage(final @NotNull IPokemon attacker) {
    calculateReceivedDamage(attacker.getDamage() * 2, attacker.getSpeed());
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

  @Override
  public int getDamage() {
    return damage;
  }

  @Override
  public long getSeed() {
    return seed;
  }

  @Override
  public void setSeed(final long seed) {
    this.seed = seed;
    this.rng = new Random(seed);
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
