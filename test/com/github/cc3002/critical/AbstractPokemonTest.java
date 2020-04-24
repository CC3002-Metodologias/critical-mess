package com.github.cc3002.critical;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author <a href="mailto:ignacio.slater@ug.uchile.cl">Ignacio Slater Muñoz</a>
 * @version 1.0-b.3
 * @since 1.0
 */
public abstract class AbstractPokemonTest {
  protected IPokemon testPokemon;
  protected long testSeed;

  @BeforeEach
  public void setUp() {
    testSeed = new Random().nextLong();
  }

  @Test
  public abstract void equalsTest();

  protected void checkEquals(final IPokemon expectedPokemon) {
    assertEquals(testPokemon, testPokemon);
    assertNotSame(expectedPokemon, testPokemon);
    assertEquals(expectedPokemon, testPokemon);
  }

  protected void checkNotEquals(final IPokemon actualPokemon) {
    assertNotEquals(testPokemon, null);
    assertNotEquals(testPokemon, new Object());
    assertNotEquals(testPokemon, actualPokemon);
  }

  @Test
  public abstract void testHP();

  public void checkHP(IPokemon expectedResult, IPokemon expectedInit) {
    assertEquals(expectedInit, testPokemon);
    int expectedHP = 5;
    testPokemon.setHP(expectedHP);
    assertEquals(expectedResult, testPokemon);
  }

  @Test
  public abstract void testSpeed();

  @Test
  public void testSeed() {
    long expectedSeed = 11;
    testPokemon.setSeed(expectedSeed);
    assertEquals(expectedSeed, testPokemon.getSeed());
  }

  @Test
  public void outOfCombatTest() {
    assertFalse(testPokemon.isOutOfCombat());
    testPokemon.setHP(0);
    assertTrue(testPokemon.isOutOfCombat());
  }

  protected IPokemon getMudkip() {
    return getMudkipWithHP(10);
  }

  protected IPokemon getMudkipWithHP(int hp) {
    return new WaterPokemon("Mudkip", hp, 5, 3);
  }

  protected IPokemon getMudkipWithSpeed(int speed) {
    return new WaterPokemon("Mudkip", 10, 5, speed);
  }

  protected IPokemon getCharmander() {
    return new FirePokemon("Charmander", 8, 7, 4);
  }

//
//  @RepeatedTest(2 * 512 / MUDKIP_SPEED)
//  public void resistantAttackTest() {
//    long seed = new Random().nextLong();
//    mudkip.setSeed(seed);
//    int r = new Random(seed).nextInt(256);
//    int threshold = MUDKIP_SPEED / 2;
//    int expectedHP = MUDKIP_HP - (MUDKIP_DAMAGE * (r < threshold ? 2 : 1) / 2);
//    mudkip.attack(otherMudkip);
//    assertEquals(expectedHP, otherMudkip.getHP());
//  }
}
