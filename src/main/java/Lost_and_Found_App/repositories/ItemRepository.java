package Lost_and_Found_App.repositories;

import Lost_and_Found_App.Util.LocalUtil;
import Lost_and_Found_App.models.Item;

import java.util.HashMap;

public class ItemRepository {

    private HashMap<Long, Item>  itemHashMap;

    public ItemRepository()
    {
        this.itemHashMap=new HashMap<>();
    }

    public HashMap<Long, Item> getItemHashMap() {
        return itemHashMap;
    }

    public String addItem(Item item)
    {
        itemHashMap.put(item.getId(),item);
        return item.toString();
    }

}
