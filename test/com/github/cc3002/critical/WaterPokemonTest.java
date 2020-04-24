package com.github.cc3002.critical;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author <a href="mailto:ignacio.slater@ug.uchile.cl">Ignacio Slater M.</a>.
 * @version 1.0-b.2
 * @since 1.0
 */
public class WaterPokemonTest extends AbstractPokemonTest {
protected IPokemon getCharmander() {
    return new FirePokemon("Charmander", 8, 7, 4);
  }
  @BeforeEach
  public void setUp() {
    super.setUp();
    testPokemon = getMudkip();
  }

  @Override
  @Test
  public void equalsTest() {
    checkEquals(getMudkip());
    checkNotEquals(getCharmander());
  }

  @Override
  @Test
  public void testHP() {
    IPokemon expectedPokemon = getMudkipWithHP(5);
    checkHP(expectedPokemon, getMudkip());
  }

  @Override
  @RepeatedTest(10)
  public void testSpeed() {
    int expectedSpeed = new Random(testSeed).nextInt(100);
    IPokemon actualMudkip = getMudkipWithSpeed(expectedSpeed);
    assertEquals(expectedSpeed, actualMudkip.getSpeed(), "Test failed with seed: " + testSeed);
  }
}
