package etc.ali.q4;

import java.util.Date;

public class Info1 extends Info {
    private Date buyTime;
    private Double cost;

    public Date getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
