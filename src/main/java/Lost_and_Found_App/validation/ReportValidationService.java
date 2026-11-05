package Lost_and_Found_App.validation;

import Lost_and_Found_App.enums.ReportStatus;
import Lost_and_Found_App.enums.ReportType;
import Lost_and_Found_App.models.Report;

import java.time.ZonedDateTime;

public class ReportValidationService {




    public boolean validateReportDate(Report report)
    {
        return report.getReportDateTime().isBefore(ZonedDateTime.now());
    }


    public boolean validateForClaimT(Report report)
    {
        return report.getReportType().equals(ReportType.FOUND)
                &&(report.getReportStatus().equals(ReportStatus.OPEN));
    }
    public boolean validatePreDeletionT(Report report)
    {
        return report.getReportStatus().equals(ReportStatus.CLOSED);
    }

    public boolean validatePreCloseF(Report report)
    {
        return report.getReportStatus().equals(ReportStatus.CLOSED);
    }
}
