package app;

import logistics.Logistics;
import ui.Button;
import ui.Checkbox;
import ui.GUIFactory;

public class DeliveryApplication {
    private final Button button;
    private final Checkbox checkbox;
    private final Logistics logistics;

    //Constructor injection ensures client depends only on abstractions.

    public DeliveryApplication(GUIFactory guiFactory, Logistics logistics) {
        this.button = guiFactory.createButton();
        this.checkbox = guiFactory.createCheckbox();
        this.logistics = logistics;
    }

    public void run(String cargo, String destination) {
        // Render UI elements
        button.paint();
        checkbox.paint();

        // Perform delivery workflow
        logistics.planDelivery(cargo, destination);
    }
}