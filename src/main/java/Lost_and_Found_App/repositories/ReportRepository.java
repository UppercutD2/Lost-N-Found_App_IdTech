package Lost_and_Found_App.repositories;

import Lost_and_Found_App.enums.ReportExceptionType;
import Lost_and_Found_App.exceptions.ReportException;
import Lost_and_Found_App.models.Report;

import java.util.HashMap;

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

        reportMap.put(report.getReportId(),report);
        System.out.println("DETAILS: " +report);
    }

    public Report getReportById(Long id)
    {
        if(!checkIfReportExist(id))
        {
            throw new ReportException(ReportExceptionType.REPORT_ID_ERROR);
        }

        return reportMap.get(id);
    }




    private boolean checkIfReportExist(Long id)
    {
        return this.reportMap.containsKey(id);
    }




}
