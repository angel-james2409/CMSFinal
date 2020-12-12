package com.hexaware.MLPXX.factory;
import com.hexaware.MLPXX.persistence.MenuDAO;
import com.hexaware.MLPXX.model.Menu;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotNull;



import org.junit.Test;

import org.junit.runner.RunWith;
import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;
import java.util.ArrayList;
/**
 * Test class for Menu.
 */
@RunWith(JMockit.class)
public class MenuFactoryTest {
    /**
   * tests for constructor.
   */
  @Test
  public final void testConstructor() {
    assertNotNull(new MenuFactory());
  }
     /**
   * Tests that a list with MenuHandled is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final MenuDAO dao) {
    new Expectations() {
      {
        dao.show(); result = new ArrayList<Menu>();
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
       MenuDAO dao() {
        return dao;
      }
    };
    Menu[] m = MenuFactory.showMenu();
    assertEquals(0, m.length);
  }

/**
 * tests that empty employee list is handled correctly.
 * @param dao mocking the dao class
 */
  @Test
  public final void testListAllSome(@Mocked final MenuDAO dao) {
    final Menu m2 = new Menu(101, "puri", 100, 5);
    final ArrayList<Menu> mn = new ArrayList<Menu>();
    new Expectations() {
      {
        mn.add(m2);
        dao.show(); result = mn;
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        return dao;
      }
    };
    Menu[] mn1 = MenuFactory.showMenu();
    assertEquals(101, mn1[0].getFoodId());
    assertEquals("puri", mn1[0].getFoodName());
    assertEquals(100, mn1[0].getPrice());
    assertEquals(5, mn1[0].getPreprationTime());
  }
}
