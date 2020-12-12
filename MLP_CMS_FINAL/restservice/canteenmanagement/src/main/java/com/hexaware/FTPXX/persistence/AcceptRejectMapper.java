package com.hexaware.MLPXX.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.MLPXX.model.AcceptReject;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
/**
 * AcceptRejectMapper class used to fetch menu data from database.
 * @author hexware
 */


public class AcceptRejectMapper implements ResultSetMapper<AcceptReject> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final AcceptReject map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
    return new AcceptReject(rs.getInt("ORDER_ID"), rs.getInt("CUSTOMER_ID"), rs.getString("ORDER_STATUS"));
  }
}
