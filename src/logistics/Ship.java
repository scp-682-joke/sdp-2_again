package logistics;

public class Ship implements Transport {
    @Override
    public void deliver(String cargo, String destination) {
        System.out.printf("Ship delivers %s to %s port via sea.%n", cargo, destination);
    }
}