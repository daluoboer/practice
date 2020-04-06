package com.radish.thinking.unit5;

public class Book {
    boolean checkedOut = false;
    Book(boolean checkOut){
        checkedOut = checkOut;
    }
    void checkIn(){
        checkedOut = false;
    }
    protected void finalize () throws Throwable{
        if(checkedOut){
            System.out.println("Error:checked out");
//            super.finalize();
        }
    }
}
