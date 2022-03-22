package good_class;

public class Good {
    private int id;
    private String name; //商品名
    private int price;
    private int number;
    private String type;
    private String haverId;
    private String haverName;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getHaverId() {
        return haverId;
    }
    public void setHaverId(String haverId) {
        this.haverId = haverId;
    }

    public String getHaverName() {
        return haverName;
    }
    public void setHaverName(String haverName) {
        this.haverName = haverName;
    }
}
