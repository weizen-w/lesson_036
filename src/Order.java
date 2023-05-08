import java.util.Scanner;

public class Order {

  private static final double PRICE = 2.0;

  private enum PaymentMethod {
    CARD,
    CASH,
  }

  private final String name;
  private final double quantity;
  private final PaymentMethod paymentMethod;

  public Order(String name, double quantity, PaymentMethod paymentMethod) {
    this.name = name;
    this.quantity = quantity;
    this.paymentMethod = paymentMethod;
  }

  public static Order readOrder(String name, Scanner scanner) {
    double quantity = readFuelQuantity(scanner);
    PaymentMethod paymentMethod = readPaymentMethod(scanner);
    return new Order(name, quantity, paymentMethod);
  }

  private static double readFuelQuantity(Scanner scanner) {
    System.out.println("Сколько литров топлива вам нужно?");
    while (!scanner.hasNextDouble()) {
      String wrongLine = scanner.nextLine(); // пропустить строку
      System.out.println("Неправильный формат дробного числа: " + wrongLine);
      System.out.println("Введите количество топлива (в литрах):");
    }
    double quantity = scanner.nextDouble();
    scanner.nextLine();
    return quantity;
  }

  private static PaymentMethod readPaymentMethod(Scanner scanner) {
    System.out.println("Как будете оплачивать, картой или наличными?");
    String paymentMethod = scanner.nextLine();
    if (paymentMethod.toLowerCase().contains("карт")) {
      return PaymentMethod.CARD;
    }
    return PaymentMethod.CASH;
  }

  public void print() {
    System.out.println("=== Ваш заказ ===");
    System.out.println("Заказчик: " + name);
    System.out.println("Количество топлива: " + quantity + " л");
    double total = quantity * PRICE;
    System.out.println("Стоимость заказа: " + total + " EUR");
    switch (paymentMethod) {
      case CARD -> System.out.println("Заказ должен быть оплачен картой");
      case CASH -> System.out.println("Заказ должен быть оплачен наличными");
    }
  }
}
