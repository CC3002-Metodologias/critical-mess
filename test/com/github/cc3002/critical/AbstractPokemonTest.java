package com.github.cc3002.critical;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author <a href="mailto:ignacio.slater@ug.uchile.cl">Ignacio Slater Muñoz</a>
 * @version 1.0-rc.1
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

  protected void checkEquals(IPokemon expectedPokemon) {
    assertEquals(testPokemon, testPokemon);
    assertNotSame(expectedPokemon, testPokemon);
    assertEquals(expectedPokemon, testPokemon);
  }

  protected void checkNotEquals(IPokemon actualPokemon) {
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

  @Test
  public abstract void damageTest();

  @Test
  public abstract void attackTest();

  public void checkNormalAttack(IPokemon opponent) {
    checkAttack(opponent, 1);
  }

  protected void checkWeaknessAttack(final IPokemon opponent) {
    checkAttack(opponent, 2);
  }

  protected void checkResistantAttack(final IPokemon opponent) {
    checkAttack(opponent, 0.5);
  }

  private void checkAttack(final @NotNull IPokemon opponent, final double dmgModifier) {
    opponent.setSeed(testSeed);
    int r = new Random(testSeed).nextInt(256);
    int threshold = testPokemon.getSpeed() / 2;
    int expectedHP = opponent.getHP() - (int) (testPokemon.getDamage() * (r < threshold ? 2 : 1)
                                               * dmgModifier);
    testPokemon.attack(opponent);
    assertEquals(expectedHP, opponent.getHP(), "Test failed with seed: " + testSeed);
  }

  private IPokemon getPokemonWith(PokemonBreed breed, int hp, int damage, int speed) {
    return switch (breed) {
      case MUDKIP -> new WaterPokemon("Mudkip", hp, damage, speed);
      case MILTANK -> new NormalPokemon("Miltank", hp, damage, speed);
      case CHARMANDER -> new FirePokemon("Charmander", hp, damage, speed);
    };
  }

  protected IPokemon getPokemon(PokemonBreed breed) {
    return getPokemonWith(breed, 10, 5, 3);
  }

  protected IPokemon getPokemonWithHP(PokemonBreed breed, int hp) {
    return getPokemonWith(breed, hp, 5, 3);
  }

  protected IPokemon getPokemonWithSpeed(PokemonBreed breed, int speed) {
    return getPokemonWith(breed, 10, 5, speed);
  }

  public IPokemon getPokemonWithDamage(PokemonBreed breed, int damage) {
    return getPokemonWith(breed, 10, damage, 3);
  }

  protected enum PokemonBreed {
    MUDKIP, CHARMANDER, MILTANK
  }
}