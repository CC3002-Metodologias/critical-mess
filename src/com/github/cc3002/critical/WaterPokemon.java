package com.github.cc3002.critical;

import org.jetbrains.annotations.NotNull;

/**
 * @author <a href="mailto:ignacio.slater@ug.uchile.cl">Ignacio Slater M.</a>.
 * @version 1.0-rc.1
 * @since 1.0
 */
public class WaterPokemon extends AbstractPokemon {
  public WaterPokemon(final String name, final int hp, final int damage, final int speed) {
    super(name, hp, damage, speed);
  }

  @Override
  public void attack(final @NotNull IPokemon opponent) {
    opponent.receiveWaterAttack(this);
  }

  @Override
  public void receiveWaterAttack(final WaterPokemon attacker) {
    receiveResistantDamage(attacker);
  }
}
