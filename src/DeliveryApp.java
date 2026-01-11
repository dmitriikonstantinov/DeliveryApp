import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static ParcelBox<StandardParcel> standardBox = new ParcelBox<>(50);
    private static ParcelBox<FragileParcel> fragileBox = new ParcelBox<>(30);
    private static ParcelBox<PerishableParcel> perishableBox = new ParcelBox<>(40);
    private static List<Trackable> trackableItems = new ArrayList<>();

    public static void main(String[] args) {


        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        System.out.println("Выберите тип посылки:");
        System.out.println("1 — Стандартная");
        System.out.println("2 — Хрупкая");
        System.out.println("3 — Скоропортящаяся");
        int type = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Описание посылки: ");
        String description = scanner.nextLine();

        System.out.print("Вес (кг): ");
        int weight = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Адрес доставки: ");
        String address = scanner.nextLine();

        System.out.print("День отправки (число месяца): ");
        int sendDay = scanner.nextInt();
        scanner.nextLine();

        Parcel parcel = null;
        switch (type) {
            case 1:
                parcel = new StandardParcel(description, weight, address, sendDay);
                standardBox.addParcel((StandardParcel) parcel);
                break;
            case 2:
                parcel = new FragileParcel(description, weight, address, sendDay);
                fragileBox.addParcel((FragileParcel) parcel);
                trackableItems.add((Trackable) parcel);
                break;
            case 3:
                System.out.print("Срок годности (дней): ");
                int timeToLive = scanner.nextInt();
                scanner.nextLine();
                parcel = new PerishableParcel(description, weight, address, sendDay, timeToLive);
                perishableBox.addParcel((PerishableParcel) parcel);
                break;
            default:
                System.out.println("Неверный тип посылки.");
                return;
        }
        if (parcel != null) {
            allParcels.add(parcel);
            System.out.println("Посылка успешно добавлена!");
        }

    }

    private static void sendParcels() {
        if (allParcels.isEmpty()) {
            System.out.println("Нет посылок для отправки.");
            return;
        }

        for (Parcel parcel : allParcels) {
            System.out.println("Обработка посылки: " + parcel.getDescription());
            parcel.packageItem();
            parcel.deliver();
        }
        System.out.println("Все посылки отправлены!");
    }

    private static void calculateCosts() {
        int totalCost = 0;
        for (Parcel parcel : allParcels) {
            int cost = parcel.calculateDeliveryCost();
            System.out.println("Посылка '" + parcel.getDescription() + "': " + cost + " руб.");
            totalCost += cost;
        }
        System.out.println("Общая стоимость доставки: " + totalCost + " руб.");
    }
}



