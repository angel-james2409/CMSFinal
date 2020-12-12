package com.hexaware.MLPXX.persistence;


import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.Calendar;

import com.hexaware.MLPXX.model.Offer;



import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;

/**
 * MenuMapper class used to fetch menu data from database.
 * @author hexware
 */
public class OfferMapper implements ResultSetMapper<Offer> {
  /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final Offer map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
        /**
         * @return Orders
         */

    return new Offer(rs.getInt("customer_id"), rs.getInt("order_id"), rs.getDate("order_date"));
  }
}
