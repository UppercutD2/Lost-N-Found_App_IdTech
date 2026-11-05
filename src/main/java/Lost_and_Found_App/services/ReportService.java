package Lost_and_Found_App.services;

import Lost_and_Found_App.enums.ItemCategory;
import Lost_and_Found_App.enums.ItemStatus;
import Lost_and_Found_App.enums.ReportExceptionType;
import Lost_and_Found_App.enums.ReportType;
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

        Report report = new Report(ReportType.LOST,item, ItemStatus.OPEN);
        if(!reportValidationService.validateReportDate(report))
        {
            throw new ReportException(ReportExceptionType.REPORT_DATE_INCORRECT);
        }

        return report;

    }


    public void addReport(Report report)
    {
        report.setReportId();
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

    public List<Report> filterByItemName(String itemName)
    {
        return getReportList().stream().filter(t -> t.getItem().getItemName().equals(itemName)).collect(Collectors.toList());
    }

    public List<Report> filterByCategory(ItemCategory category)
    {
        return getReportList().stream().filter(r->r.getItem().getItemCategory().name().equals(category.name())).collect(Collectors.toList());
    }

    /// i tak dalee po oceredi




}
