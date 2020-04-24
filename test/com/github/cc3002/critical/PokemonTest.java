package com.github.cc3002.critical;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author <a href="mailto:ignacio.slater@ug.uchile.cl">Ignacio Slater Muñoz</a>
 * @version 1.0-b.1
 * @since 1.0
 */
public class PokemonTest {
  // region : constants
  // region : Mudkip
  private static final String MUDKIP_NAME = "Mudkip";
  private static final int MUDKIP_HP = 10;
  private static final int MUDKIP_DAMAGE = 5;
  private static final int MUDKIP_SPEED = 3;
  // endregion
  // region : Charmander
  private static final String CHARMANDER_NAME = "Charmander";
  private static final int CHARMANDER_HP = 8;
  private static final int CHARMANDER_DAMAGE = 7;
  private static final int CHARMANDER_SPEED = 4;
  // endregion
  // endregion
  private Pokemon mudkip;
  private Pokemon charmander;
  private Pokemon otherMudkip;

  @BeforeEach
  public void setUp() {
    mudkip = new Pokemon(MUDKIP_NAME, MUDKIP_HP, MUDKIP_DAMAGE, MUDKIP_SPEED);
    otherMudkip = new Pokemon(MUDKIP_NAME, MUDKIP_HP, MUDKIP_DAMAGE, MUDKIP_SPEED);
    charmander = new Pokemon(CHARMANDER_NAME, CHARMANDER_HP, CHARMANDER_DAMAGE, CHARMANDER_SPEED);
  }

  @Test
  public void equalsTest() {
    assertEquals(mudkip, mudkip);
    assertNotEquals(mudkip, null);
    assertNotEquals(mudkip, new Object());
    assertNotSame(otherMudkip, mudkip);
    assertEquals(otherMudkip, mudkip);
    assertNotEquals(mudkip, charmander);
  }

  @Test
  public void hpTest() {
    assertEquals(otherMudkip, mudkip);

    int expectedHP = 5;
    var expectedMudkip = new Pokemon(MUDKIP_NAME, expectedHP, MUDKIP_DAMAGE, MUDKIP_SPEED);
    mudkip.setHP(expectedHP);
    assertEquals(expectedMudkip, mudkip);
  }

  @Test
  public void speedTest() {
    assertEquals(MUDKIP_SPEED, mudkip.getSpeed());
    assertEquals(CHARMANDER_SPEED, charmander.getSpeed());
  }

  @Test
  public void outOfCombatTest() {
    assertFalse(mudkip.isOutOfCombat());
    mudkip.setHP(0);
    assertTrue(mudkip.isOutOfCombat());
  }

  @RepeatedTest(2 * 512 / MUDKIP_SPEED)
  public void attackTest() {
    long seed = new Random().nextLong();
    mudkip.setSeed(seed);
    int r = new Random(seed).nextInt(256);
    int threshold = MUDKIP_SPEED / 2;
    int expectedHP = MUDKIP_HP - MUDKIP_DAMAGE * (r < threshold ? 2 : 1);
    mudkip.attack(otherMudkip);
    assertEquals(expectedHP, otherMudkip.getHP());
  }
}
