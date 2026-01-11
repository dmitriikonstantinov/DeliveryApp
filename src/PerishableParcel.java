public class PerishableParcel extends Parcel {
    private int timeToLive;
    private final static int BASE_COST = 3;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    @Override
    public int getBaseCost() {
        return BASE_COST;
    }

    @Override
    public void packageItem() {
        super.packageItem();
    }

    public boolean isExpired(int currentDay) {
        int result = timeToLive + sendDay;
        if (result >= currentDay) {
            return false;
        }
        return true;
    }

    public int getTimeToLive() {
        return timeToLive;
    }
}
