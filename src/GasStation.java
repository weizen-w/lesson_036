import java.util.ArrayList;
import java.util.Scanner;

public class GasStation {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("=== Заправочная станция ===");
    System.out.println("Добро пожаловать! Как вас зовут?");
    String name = scanner.nextLine();
    ArrayList<Order> orderArrayList = createOrderList(name, scanner);
    for (Order order : orderArrayList) {
      order.print();
    }
  }

  private static int readOrdersAmount(Scanner scanner) {
    System.out.print("Введите количество заказов: ");
    while (!scanner.hasNextInt()) {
      String wrongLine = scanner.nextLine();
      System.out.println("Неправильный формат целого числа: " + wrongLine);
      System.out.print("Введите количество заказов: ");
    }
    int orders = scanner.nextInt();
    scanner.nextLine();
    return orders;
  }

  private static ArrayList<Order> createOrderList(String name, Scanner scanner) {
    ArrayList<Order> orderList = new ArrayList<>();
    int orders = readOrdersAmount(scanner);
    for (int counter = 0; counter < orders; ++counter) {
      orderList.add(Order.readOrder(name, scanner));
    }
    return orderList;
  }
}
