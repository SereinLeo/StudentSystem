package menus_class;

public class MenusStatus {
    //菜单栏页面的显示状态
    public boolean indexShow;
    public boolean userTableShow;           //用户表格
    public boolean goodsTableShow;
    public boolean userInfoShow;            //用户信息
    public boolean addUserShow;             //添加用户
    public boolean addGoodShow;             //添加商品
    public boolean inoutTableShow;          //出入库记录表格
    public boolean addInOutShow;            //添加记录

    public void SetAllHide(){
        this.indexShow      = false;
        this.goodsTableShow = false;
        this.userTableShow  = false;
        this.userInfoShow   = false;
        this.addUserShow    = false;
        this.addGoodShow    = false;
        this.inoutTableShow = false;
        this.addInOutShow   = false;
    }
}
