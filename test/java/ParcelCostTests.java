import org.junit.Test;
import static org.junit.Assert.*;

public class ParcelCostTests {

    @Test
    public void testStandardParcelCost() {
        StandardParcel parcel = new StandardParcel("Книги", 5, "Москва", 1);
        assertEquals(10, parcel.calculateDeliveryCost());
    }

    @Test
    public void testFragileParcelCost() {
        FragileParcel parcel = new FragileParcel("Ваза", 3, "СПб", 1);
        assertEquals(12, parcel.calculateDeliveryCost());
    }

    @Test
    public void testPerishableParcelCost() {
        PerishableParcel parcel = new PerishableParcel("Молоко", 2, "Казань", 1, 5);
        assertEquals(6, parcel.calculateDeliveryCost());
    }

    @Test
    public void testZeroWeightParcelCost() {
        // Твой новый тест - посылка с нулевым весом
        StandardParcel standard = new StandardParcel("Письмо", 0, "Москва", 1);
        FragileParcel fragile = new FragileParcel("Пустая коробка", 0, "СПб", 1);
        PerishableParcel perishable = new PerishableParcel("Воздух", 0, "Казань", 1, 1);

        assertEquals(0, standard.calculateDeliveryCost());
        assertEquals(0, fragile.calculateDeliveryCost());
        assertEquals(0, perishable.calculateDeliveryCost());
    }
}