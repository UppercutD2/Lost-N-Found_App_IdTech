package Lost_and_Found_App.repositories;

import Lost_and_Found_App.enums.ReportExceptionType;
import Lost_and_Found_App.enums.ReportStatus;
import Lost_and_Found_App.exceptions.ReportException;
import Lost_and_Found_App.models.Report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportRepository {


     private HashMap<Long,Report> reportMap;


    public ReportRepository()
    {
        this.reportMap =new HashMap<>();
    }

    public HashMap<Long,Report>   getReportMap()
    {
        return this.reportMap;
    }

    public void registerReport(Report report)
    {
        if(!checkCaseStatusOpen(report))
        {
            throw new ReportException(ReportExceptionType.REPORT_INIT_STATUS_ERROR);
        }
        reportMap.put(report.getReportId(),report);

    }

    public void updateReport(Long id,Report report)
    {
        reportMap.put(id, report);
        System.out.println("DETAILS: " +report);
    }

    public void deleteReport(Long id)
    {
        String details = reportMap.get(id).toString();
        reportMap.remove(id);
        System.out.println("Report has been deleted." +
                "\nDETAILS: "+ details);
    }


    public Report getReportById(Long id)
    {
        if(!checkIfReportExistById(id))
        {
            throw new ReportException(ReportExceptionType.REPORT_ID_ERROR);
        }

        return reportMap.get(id);
    }



    public List<Report> getActiveReportList()/// Return only OPEN, CLAIMED reports.
    {
        List<Report> activeReportList = new ArrayList<>();

        for(Map.Entry<Long,Report> entry: reportMap.entrySet())
        {
            Report r = entry.getValue();
            if(!r.getReportStatus().equals(ReportStatus.CLOSED))
            {
                activeReportList.add(r);
            }
        }
        return activeReportList;
    }

    private boolean checkCaseStatusOpen(Report report)
    {
        return report.getReportStatus().equals(ReportStatus.OPEN);
    }

    private boolean checkIfReportExistById(Long id)
    {
        return this.reportMap.containsKey(id);
    }




}
