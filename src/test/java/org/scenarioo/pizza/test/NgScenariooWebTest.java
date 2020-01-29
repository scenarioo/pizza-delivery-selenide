package org.scenarioo.pizza.test;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import org.junit.Test;
import org.scenarioo.pizza.test.pages.PizzaShop;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

/**
 * A simple web test to demonstrate that
 * Selenide/Selenium can also test angular apps (scenarioo here) without problems.
 *
 * This is thanks to the cool selenide element and collection wrappers
 * including a lazy loading with implicit waiting technique.
 */
public class NgScenariooWebTest {

    @Test
    public void canBrowseUseCasesAndScenarios() {

        open("http://demo.scenarioo.org/scenarioo-master");

        // Filter use cases
        $(".tableSearch").setValue("page");

        // Browse use cases
        ElementsCollection usecaseRows = $(".usecase-table").$$("tr");
        usecaseRows.shouldHave(size(3));
        usecaseRows.get(1).shouldHave(text("Find Page")).click();

        // Browse scenarios
        ElementsCollection scenariosRows = $(".scenario-table").$$("tr");
        scenariosRows.shouldHave(size(5));
        scenariosRows.get(2).$(byText("Find no results")).click();

    }

}
