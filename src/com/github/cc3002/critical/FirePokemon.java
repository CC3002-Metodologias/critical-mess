package com.github.cc3002.critical;

/**
 * @author <a href="mailto:ignacio.slater@ug.uchile.cl">Ignacio Slater M.</a>.
 * @version 1.0-rc.1
 * @since 1.0
 */
public class FirePokemon extends AbstractPokemon {
  public FirePokemon(final String name, final int hp, final int damage, final int speed) {
    super(name, hp, damage, speed);
  }

  @Override
  public void attack(final IPokemon opponent) {

  }

  @Override
  public void receiveWaterAttack(final WaterPokemon attacker) {
    receiveWeaknessDamage(attacker);
  }
}
