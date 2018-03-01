package com.library.model.request;

public class BookFamousFilterRequest {

    private String bookFamous;

    private String period;

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }
    //
//    private int resultList;

    public String getBookFamous() {
        return bookFamous;
    }

    public void setBookFamous(String bookFamous) {
        this.bookFamous = bookFamous;
    }
}
