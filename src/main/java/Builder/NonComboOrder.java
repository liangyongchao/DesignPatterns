package Builder;

import java.util.HashMap;
import java.util.Map;

public class NonComboOrder {

    private Map<Integer, String> order = new HashMap<Integer, String>();

    public void setOrder(Map<Integer, String> order) {
        this.order = order;
    }

    public Map<Integer, String> getOrder() {
        return order;
    }

}
