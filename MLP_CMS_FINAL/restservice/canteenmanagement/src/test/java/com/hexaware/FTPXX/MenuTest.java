package com.hexaware.MLPXX.model;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import mockit.integration.junit4.JMockit;

/**
 * Test class for Menu.
 */
@RunWith(JMockit.class)
public class MenuTest {
/**.
 * setup method
 */
  @Before
  public void initInput() {

  }
  /**.
   * Test the equals/hascode methods of menu
   */
  @Test
  public final void testMenu() {
    Menu m = new Menu(200, "idly", 50, 20);
    m.setFoodId(200);
    assertNotEquals(200, null);
    assertEquals(200, m.getFoodId());
    m.setFoodName("idly");
    assertNotEquals("idly", null);
    assertEquals("idly", m.getFoodName());
    m.setPrice(50);
    assertNotEquals(50, null);
    assertEquals(50, m.getPrice());
    m.setPreprationTime(20);
    assertNotEquals(20, null);
    assertEquals(20, m.getPreprationTime());
    assertEquals(m, new Menu(200, "idly", 50, 20));
  }
}
