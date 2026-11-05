package Lost_and_Found_App.exceptions;

import Lost_and_Found_App.enums.ReportExceptionType;
import Lost_and_Found_App.enums.ReportType;

public class ReportException extends RuntimeException{

    public ReportException (ReportExceptionType type){
        super(type.name());
    }

}
