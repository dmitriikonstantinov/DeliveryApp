import java.util.ArrayList;
import java.util.List;

public class ParcelBox<T extends Parcel> {
    private List<T> parcels;
    private int maxWeight;
    private int currentWeight;

    public ParcelBox(int maxWeight) {
        this.parcels = new ArrayList<>();
        this.maxWeight = maxWeight;
        this.currentWeight = 0;
    }

    // Метод добавления посылки в коробку
    public boolean addParcel(T parcel) {
        if (currentWeight + parcel.getWeight() <= maxWeight) {
            parcels.add(parcel);
            currentWeight += parcel.getWeight();
            return true;
        } else {
            System.out.println("Внимание! Превышен максимальный вес коробки. Посылка не добавлена.");
            return false;
        }
    }

    // Метод получения всех посылок из коробки
    public List<T> getAllParcels() {
        return new ArrayList<>(parcels);
    }

    // Геттеры
    public int getCurrentWeight() {
        return currentWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    // Метод для отображения содержимого коробки
    public void displayContents() {
        System.out.println("Содержимое коробки " + currentWeight + " " + maxWeight + " кг:");
        if (parcels.isEmpty()) {
            System.out.println("  Коробка пуста");
        } else {
            for (Parcel parcel : parcels) {
                System.out.println(" " + parcel.getDescription() + " " + parcel.getWeight() + " кг");
            }
        }
    }
}

