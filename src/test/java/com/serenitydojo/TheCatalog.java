package com.serenitydojo;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static com.serenitydojo.Fruit.*;
import static org.assertj.core.api.Assertions.*;

public class TheCatalog {

    Catalog catalog;
    @Before
    public void setUp(){
        catalog = new Catalog();
        catalog.setPriceOf(Apple).to(4.00)
                .setPriceOf(Orange).to(5.50)
                .setPriceOf(Banana).to(4.50)
                .setPriceOf(Pear).to(4.50);
    }
    @Test
    public void shouldBeableToUpdateTheCurrentPriceOfFruit(){

        assertThat(catalog.getPriceOf(Apple)).isEqualTo(4.00);
    }
    @Test
    public void shouldListTheNamesOfFruitInAlphabeticOrder(){
        assertThat(catalog.getFruitNames()).containsExactly("Apple", "Banana", "Orange", "Pear");
    }
    @Test(expected = FruitUnavailableException.class)
    public void shouldReportUnavailableFruit(){
        assertThat(catalog.getPriceOf(Strawberries));
    }
}
