package Lost_and_Found_App.models;

import Lost_and_Found_App.Util.LocalUtil;
import Lost_and_Found_App.enums.ReportStatus;
import Lost_and_Found_App.enums.ReportType;

import java.time.ZonedDateTime;

public class Report {

    private Long reportId;
    private ReportType reportType;
    private String caseLocation;
    private ZonedDateTime reportDateTime;
    private Item item;
    private ReportStatus reportStatus;



    public Report(ReportType reportType, Item item, ReportStatus reportStatus) {
        this.reportStatus = reportStatus;
        this.reportType = reportType;
        this.reportDateTime = ZonedDateTime.now();
        this.item = item;
    }

    public Long getReportId() {
        return reportId;
    }
    public void setReportId()
    {
        this.reportId=LocalUtil.assignReportId();


    }


    public Item getItem() {
        return item;
    }

    public ReportStatus getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(ReportStatus reportStatus) {
        this.reportStatus = reportStatus;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public ReportType getReportType() {
        return reportType;
    }

    public void setReportType(ReportType reportType) {
        this.reportType = reportType;
    }

    public String getCaseLocation() {
        return caseLocation;
    }

    public void setCaseLocation(String caseLocation) {
        this.caseLocation = caseLocation;
    }

    public ZonedDateTime getReportDateTime() {
        return reportDateTime;
    }

    public void setReportDateTime(ZonedDateTime reportDateTime) {
        this.reportDateTime = reportDateTime;
    }

    @Override
    public String toString() {
        return "-REPORT{" +
                "reportId=" + reportId +
                ", reportType=" + reportType +
                ", caseLocation='" + caseLocation + '\'' +
                ", reportDateTime=" + reportDateTime +
                ",caseStatus=" + reportStatus.name()+
                "\n--" + item.toString() +
                '}';
    }
}
