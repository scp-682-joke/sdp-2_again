package logistics;

public class Truck implements Transport {
    @Override
    public void deliver(String cargo, String destination) {
        System.out.printf("Truck delivers %s to %s warehouse via road.%n", cargo, destination);
    }
}