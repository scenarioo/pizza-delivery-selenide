package org.scenarioo.pizza.test;

import org.junit.Test;
import org.scenarioo.pizza.test.model.Drink;
import org.scenarioo.pizza.test.pages.PizzaShop;

import static org.scenarioo.pizza.test.model.Drink.*;

public class OrderPizzaWebTest {

    @Test
    public void newCustomer_canOrderPizzaWithNoDrinks() {
        PizzaShop.start()
                .orderPizzaForNewCustomerPhoneNumber()
                .withAddress("Bahnhofstrasse 1", "8006 Zürich")
                .withPizzaMargharita()
                .withDrinks()
                .confirmSummary("Pizza Margherita", "none")
                .shouldDisplayConfirmation("Pizza Margherita", "none");
    }

    @Test
    public void newCustomer_canOrderPizzaWithOneDrink() {
        PizzaShop.start()
                .orderPizzaForNewCustomerPhoneNumber()
                .withAddress("Bahnhofstrasse 1", "8006 Zürich")
                .withPizzaVerdura()
                .withDrinks(VINO)
                .confirmSummary("Pizza Verdura", "Vino Rosso")
                .shouldDisplayConfirmation("Pizza Verdura", "Vino Rosso");
    }

    @Test
    public void newCustomer_canOrderPizzaWithMultipleDrinks() {
        PizzaShop.start()
                .orderPizzaForNewCustomerPhoneNumber()
                .withAddress("Bahnhofstrasse 1", "8006 Zürich")
                .withPizzaBackToTheFuture()
                .withDrinks(MINERAL, VINO, GRAPPA)
                .confirmSummary("Pizza Back To The Future", "Aqua Minerale, Vino Rosso, Grappa")
                .shouldDisplayConfirmation("Pizza Back To The Future", "Aqua Minerale, Vino Rosso, Grappa");
    }


    @Test
    public void existingCustomer_canOrderPizzaOnRegisteredAddress() {
        PizzaShop.start()
                .orderPizzaForExistingCustomerPhoneNumber()
                .withExistingRegisteredAddress()
                .withPizzaVerdura()
                .withDrinks(VINO)
                .confirmSummary("Pizza Verdura", "Vino Rosso")
                .shouldDisplayConfirmation("Pizza Verdura", "Vino Rosso");
    }

    @Test
    public void existingCustomer_canOrderPizzaOnDifferentAddress() {
        PizzaShop.start()
                .orderPizzaForExistingCustomerPhoneNumber()
                .withDifferentAddress()
                .withAddress("Bahnhofstrasse 1", "8006 Zürich")
                .withPizzaVerdura()
                .withDrinks(VINO)
                .confirmSummary("Pizza Verdura", "Vino Rosso")
                .shouldDisplayConfirmation("Pizza Verdura", "Vino Rosso");
    }

}
