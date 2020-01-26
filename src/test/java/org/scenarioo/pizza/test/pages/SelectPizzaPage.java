package org.scenarioo.pizza.test.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SelectPizzaPage {

    private SelenideElement step = $("#step-selectPizza");
    private SelenideElement pizzaMargharita = step.$("input#m");
    private SelenideElement pizzaVerdura = step.$("input#v");
    private SelenideElement pizzaPiccante = step.$("input#p");
    private SelenideElement pizzaAlCapone = step.$("input#pizzaFuture");
    private SelenideElement pizzaFuture = step.$("input#a");
    private SelenideElement nextButton = step.$("button.next");

    public static SelectPizzaPage shouldDisplay() {
        SelectPizzaPage page = new SelectPizzaPage();
        page.shouldDisplayPizzaSelection();
        return page;
    }

    private void shouldDisplayPizzaSelection() {
        step.shouldBe(visible);
        pizzaMargharita.shouldBe(visible);
        pizzaVerdura.shouldBe(visible);
        pizzaPiccante.shouldBe(visible);
        pizzaAlCapone.shouldBe(visible);
        pizzaFuture.shouldBe(visible);
    }

    public SelectDrinkPage withPizzaMargharita() {
        return selectPizzaAndNext(pizzaMargharita);
    }

    public SelectDrinkPage withPizzaVerdura() {
        return selectPizzaAndNext(pizzaVerdura);
    }

    public SelectDrinkPage withPizzaBackToTheFuture() {
        return selectPizzaAndNext(pizzaFuture);
    }

    private SelectDrinkPage selectPizzaAndNext(SelenideElement pizzaElem) {
        pizzaElem.click();
        pizzaElem.shouldBe(selected);
        nextButton.click();
        return SelectDrinkPage.shouldDisplay();
    }

}
