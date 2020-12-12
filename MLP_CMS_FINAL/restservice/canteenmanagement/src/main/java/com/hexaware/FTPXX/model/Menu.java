package com.hexaware.MLPXX.model;
import java.util.Objects;

/**
 * Menu class used to display menu information.
 * @author hexware
 */
public class Menu {
/**
 * foodId to store foodId.
 */
  private int foodId;
  private String foodName;
  private int price;
  private int preprationTime;
  /**
   * Default Constructor.
   */
  public Menu() {

  }
  /**
   * Default Constructor.
   * @param argFoodId for foodid
   * @param argFoodName for foodName
   * @param argPrice for price
   * @param argPreprationTime for prepration time
   */

  public Menu(final int argFoodId, final String argFoodName, final int argPrice, final int argPreprationTime) {
    this.foodId = argFoodId;
    this.foodName = argFoodName;
    this.price = argPrice;
    this.preprationTime = argPreprationTime;
  }
  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Menu menu = (Menu) obj;
    if (Objects.equals(foodId, menu.foodId) || Objects.equals(foodName, menu.foodName)
        || Objects.equals(price, menu.price) || Objects.equals(preprationTime, menu.preprationTime)) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(foodId, foodName, price, preprationTime);
  }
    /**
     * @return this food Id.
     */
  public final int getFoodId() {
    return foodId;
  }
    /**
     * @param argFoodId gets the food id.
     */
  public final void setFoodId(final int argFoodId) {
    this.foodId = argFoodId;
  }
    /**
     * @return this food name.
     */

  public final String getFoodName() {
    return foodName;
  }
    /**
     * @param argFoodName gets the food Name.
     */
  public final void setFoodName(final String argFoodName) {
    this.foodName = argFoodName;
  }
    /**
     * @return this price.
     */
  public final int getPrice() {
    return price;
  }
    /**
     * @param argPrice gets price.
     */
  public final void setPrice(final int argPrice) {
    this.price = argPrice;
  }
    /**
     * @return this prepration time.
     */
  public final int getPreprationTime() {
    return preprationTime;
  }
    /**
     * @param argPreprationTime gets the prepration time.
     */
  public final void setPreprationTime(final int argPreprationTime) {
    this.preprationTime = argPreprationTime;
  }
}
