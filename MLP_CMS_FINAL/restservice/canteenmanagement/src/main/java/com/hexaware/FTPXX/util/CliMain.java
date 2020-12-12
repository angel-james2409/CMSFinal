package com.hexaware.MLPXX.util;


import java.util.Scanner;
import com.hexaware.MLPXX.factory.AcceptRejectFactory;
import com.hexaware.MLPXX.factory.MenuFactory;
import com.hexaware.MLPXX.factory.OrderFactory;
import com.hexaware.MLPXX.model.AcceptReject;
import com.hexaware.MLPXX.model.Menu;
import com.hexaware.MLPXX.model.Order;




/**
 * CliMain used as Client interface for java coading.
 * @author hexware
 */
class CliMain {
  private final Scanner option = new Scanner(System.in, "UTF-8");

  /**
   * mainMenu method used to display the option we had in the application.
   */
  private void mainMenu() {
    System.out.println("Canteen Management System");
    System.out.println("-----------------------");
    System.out.println("1. Show Menu");
    System.out.println("2.AcceptReject");
    System.out.println("3.place orders");
    System.out.println("4.show orders");
    System.out.println("5. Exit");
    mainMenuDetails();
  }

  /**
   * mainMenuDetails method process the option selected from main menu.
   */
  private void mainMenuDetails() {
    try {
      System.out.println("Enter your choice:");
      final int menuOption = option.nextInt();
      switch (menuOption) {
        case 1:
          showFullMenu();
          break;
        case 2:
          acceptRejectResponse();
          break;
          case 3:
          placeOrder();
          break;
        case 4:
        showFullOrder();
          break;
        case 5:
          Runtime.getRuntime().halt(0);
        default:
          System.out.println("Choose either 1 or 2");
      }
    } catch (final Exception e) {
      e.printStackTrace();
      System.out.println("enter a valid value");
    }
    option.nextLine();
    mainMenu();
  }

  /**
   * showFullMenu method display the menu item stored in database.
   */
  private void showFullMenu() {
    final Menu[] menu = MenuFactory.showMenu();
    System.out.println("Food_Id" + "\t" + "Food_Name" + "\t" + "Price" + "\t" + "Prepration_Time");
    for (final Menu m : menu) {
      System.out.println(m.getFoodId() + "\t" + m.getFoodName() + "\t" + m.getPrice() + "\t" + m.getPreprationTime());
    }
  }

  private void showOrders() {
    final AcceptReject[] acre = AcceptRejectFactory.showOrders();
    System.out.println("ORDER_ID" + "\t" + "CUSTOMER_ID" + "\t" + "ORDER_STATUS");
    for (final AcceptReject ar : acre) {
      System.out.println(ar.getOrderId() + "\t" + ar.getCustomerId() + "\t" + ar.getOrderStatus());
    }
  }

  private void acceptRejectResponse() {
    showOrders();
    int ordId;
    int cusId;
    System.out.println("enter Order Id");
    ordId = option.nextInt();
    System.out.println("enter customer Id");
    cusId = option.nextInt();
    final String y = "Accepted";
    final String n = "Rejected";
    System.out.println("do you want to accept");
    final String response = option.next().toUpperCase();
    if (response.equals("Y")) {
      System.out.println("order accepted");
      AcceptRejectFactory.acceptOrder(ordId, cusId, y);
    } else {
      System.out.println("order denied");
      AcceptRejectFactory.acceptOrder(ordId, cusId, n);
    }
  }
  
  private void showFullOrder() {
    Order[] order = OrderFactory.showOrder();
    System.out.println(" Order Id" + "\t" + "STATUS" + "\t" + "Customer Id" + "\t" +  "Quanity" + "\t" +  "Total");
    
    for (Order o : order) {
      System.out.println( o.getId()+ "\t" + o.getOrderStatus() + "\t" + o.getCustomerId() + "\t" + o.getQuantity() + "\t" + o.getTotalAmount());
    }
    
  }

  /**.
 * placeOrder method
 */

  private void placeOrder() {
    //Order order= new Order();
    System.out.println("Enter food_Id: ");
    int fid = option.nextInt();
    //order.setMenuId(option.nextInt());
    System.out.println("Enter Quantity: ");
    int quantity = option.nextInt();
    System.out.println("enter customer id");
    int cid=option.nextInt();
    //System.out.println("enter order date");
    //String oda = option.next();

    //double total=order.getTotalAmount(TotalAmount());

   /**  SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
    Scanner sc = new Scanner(System.in);
    System.out.println("enter the date");
    String orderId = sc.next();
    Date d1 = sdformat.parse("2020-04-01");
    Date d2 = sdformat.parse("2020-08-30");
    Date date1 = sdformat.parse(orderId);
    // Date d3 = LocalDate.parse(orderId);
    System.out.println("The date 1 is: " + sdformat.format(d1));
    System.out.println("The date 2 is: " + sdformat.format(d2));
    if ((date1.after(d1)) && (date1.before(d1))) {
        System.out.println("offer is available");

    } else {
        System.out.println("the offer is not apllicable");
    }
}*/
//int i=OrderFactory.insertOrder(fid,quantity,cid);
//System.out.println(i);
OrderFactory.insertOrder(fid, quantity,cid);

//Order order=new Order();
//System.out.println(order.getTotalAmount());


    //OrderFactory.insertOrder(fid, quantity,cid);

    
  }
  

  
  


/**
 * main method  is the basic entry point for the application.
 * @param args used to get the user input.
 */
  public static void main(final String[] args) {
    final CliMain mainObj = new CliMain();
  

    mainObj.mainMenu();
  }
}




