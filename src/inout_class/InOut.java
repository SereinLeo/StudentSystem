package inout_class;

public class InOut {
    private int id;
    private String haverName;
    private String name;
    private int nameId;
    private String type;  //出库 、入库
    private String number; //变动数量
    private String time;


    public int getNameId() {
        return nameId;
    }
    public void setNameId(int nameId) {
        this.nameId = nameId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHaverName() {
        return haverName;
    }

    public void setHaverName(String haverName) {
        this.haverName = haverName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
