import org.junit.Test;
import static org.junit.Assert.*;

public class PerishableParcelTests {

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
}
