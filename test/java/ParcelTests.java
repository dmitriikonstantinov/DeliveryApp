import org.junit.Test;

import static org.junit.Assert.*;

public class ParcelTests {

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
    public void testIsExpired_NotExpired() {
        PerishableParcel parcel = new PerishableParcel("Йогурт", 1, "Москва", 10, 5);
        assertFalse(parcel.isExpired(12));
    }

    @Test
    public void testIsExpired_Expired() {
        PerishableParcel parcel = new PerishableParcel("Йогурт", 1, "Москва", 10, 5);
        assertTrue(parcel.isExpired(20));
    }

    @Test
    public void testIsExpired_LastDay() {
        PerishableParcel parcel = new PerishableParcel("Йогурт", 1, "Москва", 10, 5);
        assertFalse(parcel.isExpired(15));
    }


    @Test
    public void testAddParcel_HasSpace() {
        ParcelBox<StandardParcel> box = new ParcelBox<>(10);
        StandardParcel parcel = new StandardParcel("Книга", 3, "Москва", 1);

        assertTrue(box.addParcel(parcel));
        assertEquals(3, box.getCurrentWeight());
    }

    @Test
    public void testAddParcel_NoSpace() {
        ParcelBox<StandardParcel> box = new ParcelBox<>(5);
        StandardParcel parcel1 = new StandardParcel("Книга", 3, "Москва", 1);
        StandardParcel parcel2 = new StandardParcel("Одежда", 3, "Москва", 1);

        box.addParcel(parcel1);
        assertFalse(box.addParcel(parcel2));
        assertEquals(3, box.getCurrentWeight());
    }

    @Test
    public void testAddParcel_ExactFit() {
        ParcelBox<StandardParcel> box = new ParcelBox<>(7);
        StandardParcel parcel = new StandardParcel("Гантеля", 7, "Москва", 1);

        assertTrue(box.addParcel(parcel));
        assertEquals(7, box.getCurrentWeight());
    }
}