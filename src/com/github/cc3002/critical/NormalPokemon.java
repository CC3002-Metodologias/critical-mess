package com.github.cc3002.critical;

/**
 * @author <a href="mailto:ignacio.slater@ug.uchile.cl">Ignacio Slater M.</a>.
 * @version 1.0-rc.1
 * @since 1.0
 */
public class NormalPokemon extends AbstractPokemon {
  public NormalPokemon(final String name, final int hp, final int damage, final int speed) {
    super(name, hp, damage, speed);
  }

  @Override
  public void attack(final IPokemon opponent) {

  }
}
