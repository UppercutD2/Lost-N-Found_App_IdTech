package Lost_and_Found_App.services;

import Lost_and_Found_App.enums.ItemCategory;
import Lost_and_Found_App.models.Item;
import Lost_and_Found_App.repositories.ItemRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ItemService {

    private ItemRepository itemRepository;



    public ItemService()
    {
        this.itemRepository=new ItemRepository();
    }



    public Item createItem()
    {
        return new Item("Пачка чая", "Зеленый с чебрецом)", ItemCategory.OTHER);
    }


    public List<Item> getItemList()
    {

        List<Item> itemList = new ArrayList<>();

        for(Map.Entry<Long,Item> entry : itemRepository.getItemHashMap().entrySet())
        {
         itemList.add(entry.getValue());
        }

        return itemList;
    }

}
