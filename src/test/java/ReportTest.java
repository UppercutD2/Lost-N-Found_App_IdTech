import Lost_and_Found_App.enums.ItemCategory;
import Lost_and_Found_App.enums.ReportStatus;
import Lost_and_Found_App.enums.ReportType;
import Lost_and_Found_App.exceptions.ReportException;
import Lost_and_Found_App.models.Item;
import Lost_and_Found_App.models.Report;
import Lost_and_Found_App.services.ReportService;
import Lost_and_Found_App.validation.ReportValidationService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class ReportTest {

    private Item refItem ;
    private Report reportFoundOpen;
    private Report reportLostOpen;

    private ReportValidationService validationService = new ReportValidationService();
    private ReportService reportService = new ReportService();


    @Before
    public void createOtherItem()
    {
        refItem=new Item("Пачка чая", "Зеленый с чебрецом,можно и курить.", ItemCategory.OTHER);
    }

    @Before
    public void createFoundOpenReport()
    {
        reportFoundOpen = new Report(ReportType.FOUND,refItem, ReportStatus.OPEN);
    }

    @Before
    public void createLostOpenReport()
    {
        System.out.println("Before annotation is initiated");
        reportLostOpen=new Report(ReportType.LOST,refItem, ReportStatus.OPEN);
    }



    @Test
    public void reportTypeShouldBeOpenForClaim()
    {

        refItem.orderId(1L);

        Assert.assertFalse(validationService.validateForClaimT(reportLostOpen));
        Assert.assertTrue(validationService.validateForClaimT(reportFoundOpen));

    }

    @Test(expected = ReportException.class) /// test for exception throwing
    public void futureDateShouldTriggerException()
    {
        Report report = new Report(ReportType.LOST,refItem, ReportStatus.OPEN);

     report.setReportDateTime(ZonedDateTime.now().plusDays(4));

        reportService.addReport(report);
    }

    @After
    public void printAfter()
    {
        System.out.println("After annotation is initiated.");
    }

    /// @BeforeClass - @AfterClass - used for STATIC variable
}
