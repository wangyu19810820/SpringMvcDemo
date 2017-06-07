package webflow;

import org.apache.commons.lang.WordUtils;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 2017/6/5.
 */
public enum Topping implements Serializable {

    PEPPERONI,
    SAUSAGE,
    HAMBURGER,
    MUSHROOM,
    CANADIAN_BACON,
    PINEAPPLE,
    GREEN_PEPPER,
    JALAPENO,
    TOMATO,
    ONION,
    EXTRA_CHEESE;

    public static List<Topping> asList() {
        Topping[] all = Topping.values();
        return Arrays.asList(all);
    }

    @Override
    public String toString() {
        return WordUtils.capitalizeFully(name().replace('_', ' '));
    }

}
