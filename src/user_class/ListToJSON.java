package user_class;

import good_class.Good;
import inout_class.InOut;

import java.util.List;

public class ListToJSON {
    public static String userTransfor(List<User> userList){
        String res = "{\"code\":0,\"msg\":\"\",\"count\":";

        Integer count = userList.size();
        String countStr = Integer.toString(count);
        res = res + countStr + ",\"data\":[";

        String userStrItem;
        for(User userItem : userList){
            userStrItem = "{\"id\":";
            Integer id = userItem.getId();
            userStrItem = userStrItem + id +
                    ",\"name\":\"" + userItem.getName() +
                    "\",\"nickName\":\""+ userItem.getNickName() +
                    "\",\"tel\":\"" + userItem.getTel() +
                    "\",\"email\":\"" + userItem.getEmail() +
                    "\",\"address\":\"" + userItem.getAddress() +"\"},";

            res = res + userStrItem;
        }
        res = res.substring(0,res.length()-1);
        res = res + "]}";
        return  res;
    }
    public static String goodTransfor(List<Good> goodList){
        StringBuilder res = new StringBuilder("{\"code\":0,\"msg\":\"\",\"count\":");

        Integer count = goodList.size();
        String countStr = Integer.toString(count);
        res.append(countStr).append(",\"data\":[");

        String goodStrItem;
        for(Good goodItem : goodList){
            goodStrItem = "{\"id\":";
            Integer id = goodItem.getId();
            Integer price = goodItem.getPrice();
            Integer number = goodItem.getNumber();
            goodStrItem = goodStrItem + id +
                    ",\"name\":\"" + goodItem.getName() +
                    "\",\"price\":\""+ price +
                    "\",\"number\":\"" + number +
                    "\",\"type\":\"" + goodItem.getType() +
                    "\",\"haverId\":\"" + goodItem.getHaverId() +
                    "\",\"haverName\":\"" + goodItem.getHaverName() +
                    "\"},";

            res.append(goodStrItem);
        }
        res = new StringBuilder(res.substring(0, res.length() - 1));
        res.append("]}");
        return res.toString();
    }
    public static String inoutTransfor(List<InOut> inoutList){
        String res = "{\"code\":0,\"msg\":\"\",\"count\":";

        Integer count = inoutList.size();
        String countStr = Integer.toString(count);
        res = res + countStr + ",\"data\":[";

        String inoutStrItem;
        for(InOut inoutItem : inoutList){
            inoutStrItem = "{\"id\":";
            Integer id = inoutItem.getId();
            inoutStrItem = inoutStrItem + id +
                    ",\"haverName\":\"" + inoutItem.getHaverName() +
                    "\",\"name\":\""+ inoutItem.getName() +
                    "\",\"nameId\":\""+ inoutItem.getNameId() +
                    "\",\"type\":\"" + inoutItem.getType() +
                    "\",\"number\":\"" + inoutItem.getNumber() +
                    "\",\"time\":\"" + inoutItem.getTime() +"\"},";

            res = res + inoutStrItem;
        }
        res = res.substring(0,res.length()-1);
        res = res + "]}";
        return  res;
    }
}
