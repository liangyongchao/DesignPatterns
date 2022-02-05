package Builder;

import java.util.HashMap;
import java.util.*;

public interface Build {
    public void createDrink(String name);

    public void createSnack(String name);

    public void createHamburger(String name);

    public ComboOrder composite(Map<Integer, String> pack);

    public Map<Integer, String> genPackage(String packageId);

    public Map<Integer, String> genNonComboOrder(List<Integer> orderList);

    public void printNonComboOrder(NonComboOrder nonComboOrder);
}

