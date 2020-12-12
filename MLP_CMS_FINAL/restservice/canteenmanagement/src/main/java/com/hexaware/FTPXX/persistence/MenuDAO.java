package com.hexaware.MLPXX.persistence;
import org.skife.jdbi.v2.sqlobject.Bind;

import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import com.hexaware.MLPXX.model.Menu;
/**
 * MenuDAO class used to fetch data from data base.
 * @author hexware
 */
public interface MenuDAO {
    /**
     * @return the all the Menu record.
     */
  @SqlQuery("Select * from Menu")
    @Mapper(MenuMapper.class)
    List<Menu> show();

    
  @SqlQuery("Select food_id, food_name, price, prepration_time from Menu where food_id= :fid")
  @Mapper(MenuMapper.class)
  Menu find(@Bind("fid") int foodId);
}
