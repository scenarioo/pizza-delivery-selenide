package org.scenarioo.pizza.test.pages;

import com.codeborne.selenide.SelenideElement;
import org.scenarioo.pizza.test.model.Drink;

import java.util.Arrays;

import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SelectDrinkPage {

    private SelenideElement step = $("#step-selectDrinks");
    private SelenideElement nextButton = step.$("button.next");

    public static SelectDrinkPage shouldDisplay() {
        SelectDrinkPage page = new SelectDrinkPage();
        page.shouldDisplayDrinkSelection();
        return page;
    }

    private void shouldDisplayDrinkSelection() {
        step.shouldBe(visible);
        Arrays.stream(Drink.values())
                .map(this::getDrinkCheckbox)
                .forEach(drinkChk -> drinkChk.shouldBe(visible));
    }

    public SummaryPage withDrinks(Drink... drinks) {
        Arrays.stream(drinks)
                .map(this::getDrinkCheckbox)
                .forEach(drinkCheckbox -> {
                    drinkCheckbox.click();
                    drinkCheckbox.shouldBe(selected);
                });
        nextButton.click();
        return SummaryPage.shouldDisplay();
    }

    private SelenideElement getDrinkCheckbox(Drink drink) {
        return step.$("input[name='" + drink.getDomId() + "']");
    }

}
