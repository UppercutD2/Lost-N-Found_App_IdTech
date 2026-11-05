package Lost_and_Found_App.exceptions;

import Lost_and_Found_App.enums.ItemExceptionType;

public class ItemExpection extends RuntimeException {

    public ItemExpection(ItemExceptionType type ) {
        super(type.name());
    }
}
