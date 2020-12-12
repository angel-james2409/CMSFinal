package com.hexaware.MLPXX.persistence;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import com.hexaware.MLPXX.model.AcceptReject;
/**
 * AcceptRejectDAO class used to fetch data from data base.
 * @author hexware
 */
public interface AcceptRejectDAO {
    /**
     * @return the all the Menu record.
     */
  @SqlQuery("Select * from orders ")
    @Mapper(AcceptRejectMapper.class)
    List<AcceptReject> show();
    /**
     * @param oid order id
     * @param cid  customer id
     * @param ostatus order status
     * @return returs
     */


  @SqlUpdate("Update orders set ORDER_STATUS =(:ostatus) where ORDER_ID=(:oid) and CUSTOMER_ID=(:cid)")
    @Mapper(AcceptRejectMapper.class)
    int acceptedRejected(@Bind("oid")int oid, @Bind ("cid") int cid, @Bind ("ostatus") String ostatus);
}
