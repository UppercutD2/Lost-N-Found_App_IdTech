import Lost_and_Found_App.enums.ItemCategory;
import Lost_and_Found_App.enums.ReportStatus;
import Lost_and_Found_App.enums.ReportType;
import Lost_and_Found_App.models.Item;
import Lost_and_Found_App.models.Report;
import Lost_and_Found_App.services.ItemService;
import Lost_and_Found_App.validation.ReportValidationService;
import org.junit.Assert;
import org.junit.Test;

public class ItemTest {

    private ItemService service = new ItemService();


    @Test
    public void newItemIdShouldMatch( )
    {
        Item refItem = new Item("Пачка чая", "Зеленый с чебрецом,можно и курить.", ItemCategory.OTHER);
                refItem.orderId(1L);


        Item serviceItem = service.createItem();
        serviceItem.setId();

        Assert.assertEquals(refItem,serviceItem);


    }


}
