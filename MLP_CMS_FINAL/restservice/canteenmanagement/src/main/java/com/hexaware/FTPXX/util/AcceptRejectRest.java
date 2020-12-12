package com.hexaware.MLPXX.util;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.hexaware.MLPXX.model.AcceptReject;
import com.hexaware.MLPXX.factory.AcceptRejectFactory;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/acceptReject")
public class AcceptRejectRest {
  /**
   * Returns AcceptReject details.
   * @return the AcceptReject details
   */
  @GET
  @Path("/showOrders")

  @Produces(MediaType.APPLICATION_JSON)
  public final AcceptReject[] listAcceptReject() {
    final AcceptReject[] acceptReject = AcceptRejectFactory.showOrders();
    return acceptReject;
  }
  /**
   * @param orderId is for newMenu
   * @param customerId is for newMenu
   * @param orderStatus is for newMenu
   *  @return returns
   */
  @POST
  @Path(("/updateStatus/{orderId}/{customerId}/{orderStatus}"))
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public final String acceptRejectOrder(@PathParam("orderId") final int orderId, @PathParam("customerId") final int customerId,
      @PathParam("orderStatus") final String orderStatus) {
    String comment = "";
    final int  orderUpdate = AcceptRejectFactory.acceptOrder(orderId, customerId, orderStatus);
    if (orderUpdate > 0) {
      comment = "{\" order accepted\"}";
    } else {
      comment = "{\" order rejected\"}";
    }
    return comment;
  }
}

