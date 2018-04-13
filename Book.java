class Book {

    String title;
    String author;
    int yearOfPublication;
    int comicValue;
    int dramaticValue;
    int educationalValue;
    int currentBorrowerId ;

    Book(String bookTitle, String bookAuthor, int bookYearOfPublication, int bookComicValue,
         int bookDramaticValue, int bookEducationalValue) {
        //The Book constructor. Takes the name of the book and the author as Strings and It's year of
        // publication, comic. dramatic and educational value as ints.
        title = bookTitle;
        author = bookAuthor;
        yearOfPublication = bookYearOfPublication;
        comicValue = bookComicValue;
        dramaticValue = bookDramaticValue;
        educationalValue = bookEducationalValue;
        currentBorrowerId = -1;
    }

    int getLiteraryValue(){
        //Returns the sum of all it's values
        return comicValue+dramaticValue+educationalValue;
    }

    String stringRepresentation(){
        //Returns the String representation of the book in the following formart [title,auther,year of
        // publication,sum of values].
        String spaceValue = ",";
        return('['+title+spaceValue+author+spaceValue+yearOfPublication+spaceValue+getLiteraryValue()+']');
    }

    int getCurrentBorrowerId(){
        //Returns the Id of the current borrower of the book. -1 if is not borrowed currently.
       return currentBorrowerId;
    }

    void setBorrowerId(int borrowerId) {
        //Changes the variable which holds the Id or the current borrower
        currentBorrowerId = borrowerId;
    }

    void returnBook() {
        //Marks the book as not-borrowed
        setBorrowerId(-1);
    }

    int getDramaticValue(){
        //Returns the dramatic value of the book (as a number)
        return dramaticValue;
    }

    int getComicValue(){
        //Returns the comic value of the book (as a number)
        return comicValue;
    }

    int getEducationalValue(){
        //Returns the educational value of the book (as a number)
        return educationalValue;
    }

}