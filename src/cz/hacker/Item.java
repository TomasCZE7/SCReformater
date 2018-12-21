package cz.hacker;

public class Item {

    private int price = -1;
    private String materialName = null;

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getMaterialName() {
        return materialName;
    }
}
