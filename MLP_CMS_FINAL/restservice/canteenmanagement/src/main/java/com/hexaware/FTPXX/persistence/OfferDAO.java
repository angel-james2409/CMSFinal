package com.hexaware.MLPXX.persistence;

import org.skife.jdbi.v2.sqlobject.Bind;


//import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
//import org.skife.jdbi.v2.sqlobject.customizers.Mapper;


import java.util.Date;


//import java.util.List;

/**.
 * OrderDAO class used to fetch data from data base.
 * @author hexware
 */
public interface OfferDAO {
    /**.
     * @return the all the Menu record.
     */

     
  @SqlUpdate("INSERT INTO offers(CUSTOMER_ID, ORDER_ID, ORDER_DATE )"
  + "VALUES ( :cusId, :ordId, :ordDate)")
int insert(@Bind("cusId") int cusId, @Bind("ordId") int ordId, @Bind("ordDate") Date ordDate);

}
