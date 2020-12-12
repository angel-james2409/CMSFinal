package com.hexaware.MLPXX.factory;

import static org.junit.Assert.assertEquals;




import java.text.ParseException;

import java.util.ArrayList;


import com.hexaware.MLPXX.model.AcceptReject;
import com.hexaware.MLPXX.persistence.AcceptRejectDAO;



import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;
/**
 * Test class for order.
 */
@RunWith(JMockit.class)
public class AcceptRejectFactoryTest {
  /**
   * tests for constructor.
   */
  @Test
  public final void testConstructor() {
  }
  /**
   * tests that empty order list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
   public final void testListAllEmpty(@Mocked final AcceptRejectDAO dao) {
    new Expectations() {
      {
        dao.show(); result = new ArrayList<AcceptReject>();
      }
    };
    new MockUp<AcceptRejectFactory>() {
      @Mock
      AcceptRejectDAO dao() {
        return dao;
      }
    };
    AcceptReject[] ar = AcceptRejectFactory.showOrders();
    assertEquals(0, ar.length);
  }
   /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   * @throws ParseException for date format validation.
   */
  @Test
  public final void testListAllSome(@Mocked final AcceptRejectDAO dao) {
    final AcceptReject mn = new AcceptReject(101, 1, "Accepted");
    final ArrayList<AcceptReject> m2 = new ArrayList<AcceptReject>();
    new Expectations() {
      {
        m2.add(mn);
        dao.show(); result = mn;
      }
    };
    new MockUp<AcceptRejectFactory>() {
      @Mock
      AcceptRejectDAO dao() {
        return dao;
      }
    };
    AcceptReject[] mn1 = AcceptRejectFactory.showOrders();
    assertEquals(101, mn1[0].getOrderId());
    assertEquals(1, mn1[0].getCustomerId());
    
    assertEquals("Accepted", mn1[0].getOrderStatus());
  }
  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   * @throws ParseException for date format validation.
   */
  @Test
  public final void testAcceptOrReject(@Mocked final AcceptRejectDAO dao) throws ParseException {
    final AcceptReject ac = new AcceptReject(101, 1, "Accepted");
    new Expectations() {
        {
          dao.acceptedRejected(101, 1, "Accepted");
        }
      };
    new MockUp<AcceptRejectFactory>() {
        @Mock
        AcceptRejectDAO dao() {
          return dao;
        }
      };
    int result1 = AcceptRejectFactory.acceptOrder(101, 1, "Accepted");
    assertEquals(result1, 0);
  }
}

