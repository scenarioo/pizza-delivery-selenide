package org.scenarioo.pizza.test.model;

public enum Drink {

    MINERAL("drink_a"),
    VINO("drink_v"),
    BEER("drink_b"),
    GRAPPA("drink_g");

    private String domId;

    Drink(String domId) {
        this.domId= domId;
    }

    public String getDomId() {
        return domId;
    }
}
