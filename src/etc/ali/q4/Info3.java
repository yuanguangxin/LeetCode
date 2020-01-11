package etc.ali.q4;

public class Info3 extends Info1 {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Info3() {
    }

    public Info3(Info1 info1, Info2 info2) {
        this.setUserId(info1.getUserId());
        this.setGoodsId(info1.getGoodsId());
        this.setBuyTime(info1.getBuyTime());
        this.setCost(info1.getCost());
        this.setAddress(info2.getAddress());
    }
}
