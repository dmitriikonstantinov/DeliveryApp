import org.junit.Test;
import static org.junit.Assert.*;

public class ParcelBoxTests {

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
