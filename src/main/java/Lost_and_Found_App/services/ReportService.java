package Lost_and_Found_App.services;

import Lost_and_Found_App.enums.*;
import Lost_and_Found_App.exceptions.ReportException;
import Lost_and_Found_App.models.Item;
import Lost_and_Found_App.models.Report;
import Lost_and_Found_App.repositories.ReportRepository;
import Lost_and_Found_App.validation.ReportValidationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportService {

    private ReportRepository reportRepository;
    private ReportValidationService reportValidationService;

    public ReportService()
    {
        this.reportRepository=new ReportRepository();
        this.reportValidationService=new ReportValidationService();
    }


    public Report createReport(Item item)

    {

        Report report = new Report(ReportType.LOST,item, ReportStatus.OPEN);
        if(!reportValidationService.validateReportDate(report))
        {
            throw new ReportException(ReportExceptionType.REPORT_DATE_INCORRECT);
        }

        return report;

    }


    public void addReport(Report report)
    {
        report.setReportId();
        if(!reportValidationService.validateReportDate(report))
        {
            throw new ReportException(ReportExceptionType.REPORT_DATE_INCORRECT);
        }
        reportRepository.registerReport(report);
    }


    public Report findReportById(Long id)
    {
        return reportRepository.getReportById(id);
    }
    public List<Report> getReportList()
    {
        List<Report> reportList = new ArrayList<>();
        for(Map.Entry<Long,Report> entry: this.reportRepository.getReportMap().entrySet())
        {
            reportList.add(entry.getValue());
        }
        return reportList;
    }
    /// ////////////////////////////////
/// search by Filters section
    public List<Report> filterByItemName(String itemName)
    {
        return getReportList().stream().filter(t -> t.getItem().getItemName().equals(itemName)).collect(Collectors.toList());
    }

    public List<Report> filterByCategory(ItemCategory category)
    {
        return getReportList().stream().filter(r->r.getItem().getItemCategory().name().equals(category.name())).collect(Collectors.toList());
    }

    public List<Report> filterByCaseLocation(String location)
    {

        return getReportList().stream().filter(l->l.getCaseLocation().equals(location)).collect(Collectors.toList());
    }

    public List<Report> filterByReportType(ReportType type)
    {
        return getReportList().stream().filter(c->c.getReportType().equals(type)).collect(Collectors.toList());
    }


    public List<Report> filterByCaseStatus(ReportStatus status)
    {

        return getReportList().stream().filter(s->s.getReportStatus().equals(status)).collect(Collectors.toList());
    }

    /// end of search by filters section
/// //////////////////////////////////////

    public void updateReportDetails(Long id)
    {

        Report sourceReport = reportRepository.getReportById(id);
        /// then will be modification
        sourceReport.getItem().setItemName("Updated Name");
        sourceReport.getItem().setItemDescription("Updated Description");
        sourceReport.getItem().setItemCategory(ItemCategory.ACCESSORIES);
        sourceReport.setCaseLocation("Updated location");

        reportRepository.updateReport(id,sourceReport);
        System.out.println("Report has been updated");

    }

    public void claimReportStatus(Long id)
    {
        Report report = reportRepository.getReportById(id);
        if(!reportValidationService.validateForClaimT(report))
        {
            throw new ReportException(ReportExceptionType.REPORT_NOT_CLAIMABLE);
        }
        report.setReportStatus(ReportStatus.CLAIMED);
        reportRepository.updateReport(id,report);


    }

    public void closeReportStatus(Long id)
    {
        Report r = reportRepository.getReportById(id);
        if(reportValidationService.validatePreCloseF(r))
        {
            throw new ReportException(ReportExceptionType.REPORT_IS_CLOSED);
        }
        r.setReportStatus(ReportStatus.CLOSED);
            reportRepository.updateReport(id,r);
        System.out.println("DETAILS: " + r);
    }


    public Long deleteReport(Long id)
    {


        Report r = reportRepository.getReportById(id);
        Long itemId = r.getItem().getId();
        if(!reportValidationService.validatePreDeletionT(r))
        {
            throw new ReportException(ReportExceptionType.REPORT_IS_NOT_CLOSED);
        }

        reportRepository.deleteReport(id);
        System.out.println("Report has been deleted.");
        return itemId;
    }
}
