package Lost_and_Found_App.repositories;

import Lost_and_Found_App.Util.LocalUtil;
import Lost_and_Found_App.enums.ItemExceptionType;
import Lost_and_Found_App.exceptions.ItemExpection;
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

    public void updateItem(Item item)
    {
        itemHashMap.put(item.getId(),item);
        System.out.println("DETAILS: " + item);
    }

    public void deleteItem(Item item)
    {
        String details = item.toString();
        itemHashMap.remove(item.getId());

    }
    public Item getItem(Long id)
    {
        if(!checkIfItemExistsbyId(id))
        {
            throw new ItemExpection(ItemExceptionType.ITEM_ID_NOT_FOUND);
        }
        return itemHashMap.get(id);
    }

    private boolean checkIfItemExistsbyId(Long id)
    {
        return itemHashMap.containsKey(id);
    }


}
