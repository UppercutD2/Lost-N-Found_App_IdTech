package Lost_and_Found_App.models;

import Lost_and_Found_App.Util.LocalUtil;
import Lost_and_Found_App.enums.ItemCategory;

import java.util.Objects;

public class Item {

    private Long id;
    private String itemName;
    private String itemDescription;
    private ItemCategory itemCategory;


    public Item(String itemName, String itemDescription, ItemCategory itemCategory) {
        this.itemCategory = itemCategory;
        this.itemName = itemName;
        this.itemDescription = itemDescription;

    }


    public Long getId() {
        return id;
    }

    public void setId() {
        this.id = LocalUtil.assignItemId();
    }

    public void orderId(Long id)
    {
        this.id=id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public ItemCategory getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(ItemCategory itemCategory) {
        this.itemCategory = itemCategory;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id) && Objects.equals(itemName, item.itemName) && Objects.equals(itemDescription, item.itemDescription) && itemCategory == item.itemCategory;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, itemName, itemDescription, itemCategory);
    }

    @Override
    public String toString() {
        return "ITEM{" +
                "id=" + id +
                ",itemName=" + itemName +
                ", itemDescription='" + itemDescription +
                ", itemCategory=" + itemCategory +
                '}';
    }
}
