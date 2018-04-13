class Patron {

    String firstName;
    String lastName;
    int myComicTendency;
    int myDramaticTendency;
    int myEducationalTendency;
    int enjoymentThreshold;
    int numOfBooksBorrowed; /*I have decided to count the number of books borrowed inside the patrons
    and not in an array in the library because i figured it will be easier to handle with a specific function
    (and not search inside an array each time) and will consume the same amount of memory*/

    Patron(String patronFirstName, String patronLastName, int comicTendency, int dramaticTendency,
           int educationalTendency, int patronEnjoymentThreshold) {
        /*Patron's constructor; takes Two strings as first and last name, and three ints as his tendency to
         * comic, dramatic and educational books, as well as his\her threshold for enjoying a book.*/
        firstName = patronFirstName;
        lastName = patronLastName;
        myComicTendency = comicTendency;
        myDramaticTendency = dramaticTendency;
        myEducationalTendency = educationalTendency;
        enjoymentThreshold = patronEnjoymentThreshold;
        numOfBooksBorrowed = 0;
    }

    int getBookScore(Book book) {
        //Calculates the amount of pleasure a Patron will get from a book by multiplying his/her tendencies
        //by the book parameters fro these fields.
        int score = myComicTendency*book.getComicValue() +
                    myEducationalTendency*book.getEducationalValue() +
                    myDramaticTendency*book.getDramaticValue();
        return score;
    }

    String stringRepresentation(){
        //Returns the name of the Patron in the form of a String
        return firstName+' '+lastName;
    }

    boolean willEnjoyBook(Book book){
        //For an input in the form of a Book object, returns true if it's score is above the patron's
        // threshold, false otherwise
        int bookScore = getBookScore(book);
        if (bookScore > enjoymentThreshold)
            return true;
        else
            return false;
    }


    void addToBooksBorrowed(int addedNumber){
        //Adds int given as parameter to the variable representing the number of books a patron is borrowing
        numOfBooksBorrowed += addedNumber;
    }

    int getNumOfBooksBorrowed(){
        //Returns the number of books which a patron is currently borrowing
        return numOfBooksBorrowed;
    }
}
