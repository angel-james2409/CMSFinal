package com.hexaware.MLPXX.factory;
import com.hexaware.MLPXX.persistence.AcceptRejectDAO;
import com.hexaware.MLPXX.persistence.DbConnection;
import java.util.List;

import com.hexaware.MLPXX.model.AcceptReject;
/**
 * AcceptRejectFactory class used to fetch menu data from database.
 * @author hexware
 */


public class AcceptRejectFactory {
    /**
   *  Protected constructor.
   */


  protected AcceptRejectFactory() {

  }
    /**
     * Call the data base connection.
     * @return the connection object.
     */
  private static AcceptRejectDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(AcceptRejectDAO.class);
  }
    /**
     * Call the data base connection.
     * @return the array of AcceptReject object.
     */
  public static AcceptReject[] showOrders() {
    List<AcceptReject> acre = dao().show();
    return acre.toArray(new AcceptReject[acre.size()]);
  }
    /**
   * @param orderId order id
   * @param customerId customer id
   * @param orderStatus order status
   * @return returns
   */
  public static int acceptOrder(final int orderId, final int customerId, final String orderStatus) {
    int check = dao().acceptedRejected(orderId, customerId, orderStatus);
    return check;
  }
}
