package com.hexaware.MLPXX.factory;

import com.hexaware.MLPXX.persistence.OrderDAO;
import com.hexaware.MLPXX.persistence.DbConnection;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
//import java.util.List;
import java.util.List;
import java.util.Scanner;

import com.hexaware.MLPXX.model.Menu;
import com.hexaware.MLPXX.model.Order;
/**
 * OrderFactory class used to fetch order data from database.
 * @author hexware
 */
public class OrderFactory {
  /**
   *  Protected constructor.
   */
  protected OrderFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static OrderDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(OrderDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of menu object.
   * @throws ParseException
   */
  public static Order[] showOrder() {
    List<Order> order = dao().show();
    return order.toArray(new Order[order.size()]);
  }
  /**.
   * Place order for customer
   * @param mid for customer id.
   * @param quantity for quantity
   */
  public static void insertOrder(final int fid, final  int quantity,final int cid) {
    try {
      Order order = new Order();
      order.setFoodId(fid);
      order.setQuantity(quantity);
      order.setCustomerId(cid);
      //order.setOrderDate(oda);final String oda
      Menu menu = MenuFactory.findMenu(order.getFoodId());
      order.setAmount(menu.getPrice());
      order.setOrderDate(Calendar.getInstance());
      order.setOrderTime(Calendar.getInstance());
      order.setOrderStatus("PENDING");
      int id = (int) (Math.random() * 10);
      order.setCustomerId(id);
      SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
     Scanner sc=new Scanner(System.in);
    
    System.out.println("enter the date");
    String orderDate=sc.next();
    System.out.println("if this is 1st order:1.yes or 2.n");
    int ord=sc.nextInt();
    Date d1 = sdformat.parse("2020-03-31");
    Date d2 = sdformat.parse("2020-05-01");
    Date date1 = sdformat.parse(orderDate);
    if (date1.after(d1) && date1.before(d2) && ord==1 ){
      System.out.println("offer is available");


     computeTotal1(order.getAmount(), order.getQuantity(), order);
    } else {
      computeTotal(order.getAmount(), order.getQuantity(), order);
      System.out.println("offer is not available");

   }
      computeEstimatedTime(order);
      Time t1 = dateToTimeConvert(order.getEstimatedDeliveryTime());
      Time t2 = dateToTimeConvert(order.getOrderTime());
      dao().insert(order, order.getOrderDate().getTime(), t2, t1, order.getOrderStatus().toString());
      System.out.println("----ORDER PLACED SUCCESSFULLY----");
      System.out.println("Order Amount: Rs." + order.getTotalAmount());
    } catch (Throwable e) {
      e.printStackTrace();
      System.out.println("---TECHNICAL ERROR---");
    }
  }
  /**.
   * Date to Time
   * @param date for date
   */
  private static Time dateToTimeConvert(final Calendar date) {
    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
    String str = sdf.format(date.getTime());
    Date d1;
    Time time = null;
    try {
      d1 = sdf.parse(str);
      //System.out.println(d1);
      time = new Time(d1.getTime());
      //System.out.println(time);
      return time;
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return time;
  }
  /**.
   * total
   * @param amount for amount
   * @param quantity for quantity
   * @param order for order
   * @return totalAmount
   */
  public static void computeTotal(final double amount, final int quantity, final Order order) {
    double totalAmount = amount * quantity;
    order.setTotalAmount(totalAmount);
  
  }
    /**.
   * total
   * @param amount for amount
   * @param quantity for quantity
   * @param order for order
   * @return totalAmount
   */
  public static void computeTotal1(final double amount, final int quantity, final Order order) {
    double dis=amount*0.2*quantity;
    double totalAmount=amount*quantity-dis;
    //double totalAmount = amount * quantity*0.2;

    order.setTotalAmount(totalAmount);
  
  }
  /**.
   * estimated time
   * @param order for order
   */
  public static void computeEstimatedTime(final Order order) {
    int estimatedTime = 20;
    // for(OrderItem orderItem: orderItems){
    //     if(orderItem.getFoodItem().getPreparationTime() > estimatedTime){
    //         estimatedTime= orderItem.getFoodItem().getPreparationTime();
    //     }
    //}
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.MINUTE, estimatedTime);
    order.setEstimatedDeliveryTime(calendar);
  }
}
