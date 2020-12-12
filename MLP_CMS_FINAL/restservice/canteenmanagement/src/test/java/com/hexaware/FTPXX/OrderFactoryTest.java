package com.hexaware.MLPXX.factory;

import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.hexaware.MLPXX.factory.OrderFactory;
import com.hexaware.MLPXX.model.Menu;
import com.hexaware.MLPXX.model.Order;
import com.hexaware.MLPXX.persistence.OrderDAO;
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
@Test
public final void testConstructor() {
}
/**
 * tests that empty order list is handled correctly.
 * @param dao mocking the dao class
 */
@Test
 public final void testListAllEmpty(@Mocked final OrderDAO dao) {
  new Expectations() {
    {
      dao.show(); result = new ArrayList<Order>();
    }
};
new MockUp<OrderFactory>() {
  @Mock
  OrderDAO dao() {
    return dao;
  }
};
Order[] o = OrderFactory.showOrder();
assertEquals(0, o.length);
}
/**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   * @throws ParseException for date format validation.
   */
/**
  * @param dao for mocking PlaceOrder Mock Test.
  * @throws ParseException for converting date to string.
   */
  @Test
  public final void testplaceOrder(@Mocked final OrderDAO dao) throws ParseException {
    final Menu m2 = new Menu(101, "puri", 100, 5);

    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final String ord1 = new String("2020-04-28");
    final Date orDate1 = sdf.parse(ord1);
    final String ord2 = new String("2020-01-18");
    final Date orDate2 = sdf.parse(ord2);
    final Order order1 = new Order();
    order1.setFoodId(101);
    order1.setQuantity(1);
    order1.setCustomerId(1);
    new Expectations() {
        {
                 //  dao.insert();
        //   dao.placeOrder(order2);
        //   dao.placeOrder(order3);
        }
      };
    new MockUp<OrderFactory>() {
        @Mock
        OrderDAO dao() {
          return dao;
        }
      };
       //int result1 = OrderFactory.insertOrder(101,2,1);
    //assertEquals(result1, 0);
 }
}
      
