package Lost_and_Found_App.validation;

import Lost_and_Found_App.models.Report;

import java.time.ZonedDateTime;

public class ReportValidationService {




    public boolean validateReportDate(Report report)
    {
        return report.getReportDateTime().isBefore(ZonedDateTime.now());
    }

}
