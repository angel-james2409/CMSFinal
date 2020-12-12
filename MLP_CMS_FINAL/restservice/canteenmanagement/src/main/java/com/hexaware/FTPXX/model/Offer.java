package com.hexaware.MLPXX.model;
import java.sql.Date;

import java.util.Objects;

/**
 * Menu class used to display menu information.
 * @author hexware
 */
public class Offer {
/**
 * foodId to store foodId.
 */
  private int customerId;
  private int orderId;
  private Date orderDate;
  
  
  /**
   * Default Constructor.
   */
  public Offer() {

  }
  /**
   * Default Constructor.
   * @param argCustomerId for foodName
   * @param argOrderId for foodid
   */

  public Offer(final int argCustomerId, final int argOrderId,final Date argOrderDate) {
    this.customerId = argCustomerId;
    this.orderId = argOrderId;
    this.orderDate=argOrderDate;
      }
  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Offer offer = (Offer) obj;
    if (Objects.equals(customerId, offer.customerId) || Objects.equals(orderId, offer.orderId) ||  Objects.equals(orderDate, offer.orderDate)) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(customerId, orderId,orderDate);
  }
    /**
     * @return this customer ID.
     */
    public final int getCustomerId() {
        return customerId;
      }
       /**
         * @param argCustomerId gets the customer id.
         */
      public final void setCustomerId(final int argCustomerId) {
        this.customerId = argCustomerId;
      }
      /**
     * @return this order ID.
     */
  public final int getorderId() {
    return orderId;
  }
  /**
     * @param argOrderId gets the order id.
     */
  public final void setOrderId(final int argOrderId) {
    this.orderId = argOrderId;
  }

    
/**
     * @return this order date.
     */
    public final Date getOrderDate() {
        return orderDate;
      }
      /**
         * @param argOrderDate gets the order date.
         */
      public final void setOrderDate(final Date argOrderDate) {
        this.orderDate = argOrderDate;
      }    

    
}
