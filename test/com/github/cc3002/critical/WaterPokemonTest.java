package com.github.cc3002.critical;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author <a href="mailto:ignacio.slater@ug.uchile.cl">Ignacio Slater M.</a>.
 * @version 1.0-rc.1
 * @since 1.0
 */
public class WaterPokemonTest extends AbstractPokemonTest {
  @BeforeEach
  public void setUp() {
    super.setUp();
    testPokemon = getPokemon(PokemonBreed.MUDKIP);
  }

  @Override
  @Test
  public void equalsTest() {
    checkEquals(getPokemon(PokemonBreed.MUDKIP));
    checkNotEquals(getPokemon(PokemonBreed.CHARMANDER));
  }

  @Override
  @Test
  public void testHP() {
    IPokemon expectedPokemon = getPokemonWithHP(PokemonBreed.MUDKIP, 5);
    checkHP(expectedPokemon, getPokemon(PokemonBreed.MUDKIP));
  }

  @Override
  @Test
  public void testSpeed() {
    int expectedSpeed = 11;
    IPokemon actualMudkip = getPokemonWithSpeed(PokemonBreed.MUDKIP, 11);
    assertEquals(expectedSpeed, actualMudkip.getSpeed(), "Test failed with seed: " + testSeed);
  }

  @Override
  @Test
  public void damageTest() {
    int expectedDamage = 11;
    IPokemon actualMudkip = getPokemonWithDamage(PokemonBreed.MUDKIP, 11);
    assertEquals(expectedDamage, actualMudkip.getDamage(), "Test failed with seed: " + testSeed);
  }

  @Override
  @RepeatedTest(500)
  public void attackTest() {
    assertEquals(testPokemon, getPokemon(PokemonBreed.MUDKIP));
    checkNormalAttack(getPokemon(PokemonBreed.MILTANK));
    checkResistantAttack(getPokemon(PokemonBreed.MUDKIP));
    checkWeaknessAttack(getPokemon(PokemonBreed.CHARMANDER));
  }
}
