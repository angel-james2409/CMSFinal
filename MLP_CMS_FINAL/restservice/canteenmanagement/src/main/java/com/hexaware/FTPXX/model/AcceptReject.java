package com.hexaware.MLPXX.model;
import java.util.Objects;

/**
 * AcceptReject class used to display menu information.
 * @author hexware
 */
public class AcceptReject {
  private int orderId;
  private int customerId;
  private String orderStatus;
/**
 * Default Constructor.
 */

  public AcceptReject() {
  }
  /**
   * Default Constructor.
   * @param argOrdId for orderid
   * @param argCusId for customerid
   * @param argOrdStatus for orderstatus
   */

  public AcceptReject(final int argOrdId, final int argCusId, final String argOrdStatus) {
    this.orderId = argOrdId;
    this.customerId = argCusId;
    this.orderStatus = argOrdStatus;
  }
  /**
   * Default Constructor.
   * @param i for interger
   */
  public AcceptReject(final int i) {
    this.orderId = i;
  }
  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    AcceptReject atre = (AcceptReject) obj;
    if (Objects.equals(orderId, atre.orderId) || Objects.equals(customerId, atre.customerId) ||  Objects.equals(orderStatus, atre.orderStatus)) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(orderId, customerId, orderStatus);
  }
    /**
     * @return this Order ID.
     */
  public final int getOrderId() {
    return orderId;
  }
    /**
     * @param argOrdId gets the order id.
     */
  public final void setOrderId(final int argOrdId) {
    this.orderId = argOrdId;
  }
    /**
     * @return this Customer ID.
     */
  public final int getCustomerId() {
    return customerId;
  }
    /**
     * @param argCusId gets the Customer id.
     */
  public final void setCustomerId(final int argCusId) {
    this.customerId = argCusId;
  }
    /**
     * @return this Order Status.
     */
  public final String getOrderStatus() {
    return orderStatus;
  }
    /**
     * @param argOrdStatus gets the Order Status.
     */
  public final void setOrderStatus(final String argOrdStatus) {
    this.orderStatus = argOrdStatus;
  }
}
