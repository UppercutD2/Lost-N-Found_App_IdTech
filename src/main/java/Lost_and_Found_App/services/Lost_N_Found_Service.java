package Lost_and_Found_App.services;

import Lost_and_Found_App.models.Item;
import Lost_and_Found_App.models.Report;

public class Lost_N_Found_Service {

    private ItemService itemService;
    private ReportService reportService;

    public Lost_N_Found_Service()
    {
        this.itemService=new ItemService();
        this.reportService=new ReportService();
    }




    public void createNewEntry()
    {
        Item item = itemService.createItem();
        item.setId();
        Report report = reportService.createReport(item);

        reportService.addReport(report);
    }


    public void displayAllReports()
    {

        reportService.getReportList()
                .forEach(r-> System.out.println("Report ID: " + r.getReportId()
                +"Report Status: "+ r.getReportType().name()
                +"Case status: "+ r.getReportStatus().name()));
    }

    public void findReportById(Long id)
    {
        System.out.println(reportService.findReportById(id));;
    }

    public void deleteEntryByReportId(Long id)
    {
        Long itemId= reportService.deleteReport(id);///deletes Report from report Repository
        itemService.deleteItemById(itemId);///deletes item from item repository


    }


    public void exit()
    {
        System.exit(1);
    }


}
