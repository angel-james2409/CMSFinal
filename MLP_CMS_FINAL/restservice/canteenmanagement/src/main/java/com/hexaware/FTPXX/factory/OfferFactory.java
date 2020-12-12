package com.hexaware.MLPXX.factory;
import com.hexaware.MLPXX.persistence.OfferDAO;
import com.hexaware.MLPXX.persistence.DbConnection;

import java.sql.Date;



/**
 * AcceptRejectFactory class used to fetch menu data from database.
 * @author hexware
 */


public class OfferFactory {
    /**
   *  Protected constructor.
   */


  protected OfferFactory() {

  }
    /**
     * Call the data base connection.
     * @return the connection object.
     */
  private static OfferDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(OfferDAO.class);
  }

  public static int insertOffer(final int customerId, final int orderId,final Date orderDate ) {
    int offer = dao().insert(customerId, orderId,orderDate);
     return offer;
   }

}
