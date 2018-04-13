class Library {

    int myMaxBookCapacity;
    int myMaxBorrowedBooks;
    int myMaxPatronCapacity;
    int numberOfBooksInLibrary = 0;
    int numberOfPatronsInLibrary = 0;
    Book[] booksInLibrary; //Holds all the Book objects which are in the library
    Patron[] patronsInLibrary; //Holds all the Patrons which are registered to the library

    Library(int maxBookCapacity, int maxBorrowedBooks, int maxPatronCapacity){
        myMaxBookCapacity = maxBookCapacity;
        myMaxBorrowedBooks = maxBorrowedBooks;
        myMaxPatronCapacity = maxPatronCapacity;
        booksInLibrary = new Book[maxBookCapacity];
        patronsInLibrary = new Patron[maxBookCapacity];
    }

    int addBookToLibrary(Book book){
        //Adds a Book (given as parameter) to the Library. Note you should not insert null books as input.
        for(int i=0; i< numberOfBooksInLibrary; i++) { //checks if the book is already in the library
            if (booksInLibrary[i] == book) {
                return i; // if so - returns it's Id
            }
        }
        if (numberOfBooksInLibrary < myMaxBookCapacity){ // checks if there is room for the book
            booksInLibrary[numberOfBooksInLibrary] = book; // if so, adds it to the array.
            numberOfBooksInLibrary++;
            return numberOfBooksInLibrary - 1; /*returns it's Id. Note that the Id of a book is simply it's
            place in the array, which means that two books can have the same Id in DIFFERENT libraries, but
            not the same Id in the same library. See more in the README file.*/
        }
        return -1; // if the method fails on one of the conditions, return -1.
    }

    int getNumberOfBooksInLibrary(){
        //Returns the number of books which are registered to the Library
        return numberOfBooksInLibrary;
    }

    Book[] getBooksInLibrary(){
        //Returns the array which holds all the books
        return booksInLibrary;
    }

    boolean isBookIdValid(int bookId) {
        /*Checks if an Id of a book (given as parameter) is registered for some book in the library. Note that
         it can't make sure that the Book with Id you are checking is infect the same book with the same Id
        inside this library - it only checks if the Id given belongs to SOME book in the library*/
        if (bookId < numberOfBooksInLibrary && bookId >= 0)
            return true;
        return false;
    }

    int getBookId(Book book){
        //Checks for a certain book it's Id inside this library.
        if (book != null){
            for(int i = 0; i < numberOfBooksInLibrary; i++) {
                if (booksInLibrary[i] == book)
                    return i;
            }
        }
        return -1;
    }

    boolean isBookAvailable(int bookId){
        //Checks if a book with a given Id is currently unborrowed in the library (given that it is
        // registered to it)
        if (isBookIdValid(bookId) && booksInLibrary[bookId].getCurrentBorrowerId() == -1){
            return true;
        }
        return false;
    }

    int registerPatronToLibrary(Patron patron){
        //Registers patron to the library. Note that you musn't insert null patrons as input.
        for(int i = 0; i <numberOfPatronsInLibrary; i++){ //checks if the patron is already registered
            if (patronsInLibrary[i] == patron)
                return i;
        }
        if (numberOfPatronsInLibrary < myMaxPatronCapacity){ //checks if there is room for the patron
            patronsInLibrary[numberOfPatronsInLibrary] = patron; //insert the object to the patron array
            numberOfPatronsInLibrary++;
            return numberOfPatronsInLibrary-1; /*returns the patron Id, which is, as in the books array, it's
            spot in the array*/
        }
        return -1;
    }

    int getNumberOfPatronsInLibrary(){
        //Returns the number of patrons registered
        return numberOfPatronsInLibrary;
    }

    boolean isPatronIdValid(int patronId){
        //Checks if a patron with a certain Id (given as input as int) is registered to the library
        if (patronId >=0 && patronId < numberOfPatronsInLibrary){
            return true;
        }
        return false;
    }

    int getPatronId(Patron patron){
        //Given a Patron object as input, returns it's Id in this library (-1 if it is not registered)
        for(int i = 0; i < numberOfPatronsInLibrary; i++){
            if (patronsInLibrary[i] == patron)
                return i;
        }
        return -1;
    }

    boolean borrowBook(int bookId, int patronId){
        /*Allows to borrow book from the library given a book and patron id (given as input), if both of them
        belong to the library, the book is not already borrowed, the patron is not maxed out on the amount of
        books he or she can borrow, and the books checks out for the patron's literary standards (above
        his/her enjoyment threshold)*/
        if(isPatronIdValid(patronId) && isBookAvailable(bookId)){ //checks if both the patron and book are
            // registered
            Patron myPatron = patronsInLibrary[patronId];
            Book myBook = booksInLibrary[bookId];
            if(myPatron.getNumOfBooksBorrowed() < myMaxBorrowedBooks && myPatron.willEnjoyBook(myBook)) {
                //checks if the patron will enjoy the book and if he doesn't have to many borrowed books
                myBook.setBorrowerId(patronId);
                myPatron.addToBooksBorrowed(1);
                return true;
            }
        }
        return false;
    }

    void returnBook(int bookId){
        //Returns a book given it's Id (if it is indeed registered and borrowed)
        if(isBookIdValid(bookId) && isBookAvailable(bookId) == false){
            //checks the book is validand and borrowed
            Book currentBook = booksInLibrary[bookId];
            int currentBorrowerId = currentBook.getCurrentBorrowerId();
            Patron currentBorrower = patronsInLibrary[currentBorrowerId];
            currentBorrower.addToBooksBorrowed(-1); //change the number of books the patron holds
            currentBook.returnBook(); //mark the book as returned
        }
    }

    Book suggestBookToPatron(int patronId){
        //Suggest an available book to the patron, which holds the id given, which he will enjoy
        // (if there is one)
        if (numberOfBooksInLibrary > 0 && isPatronIdValid(patronId)){
            //checks if there are books in the library and the patron id is valid
            int maxValue = 0;
            Book maxBook = null;
            Patron curPatron = patronsInLibrary[patronId];
            if(isPatronIdValid(patronId)){
                for(int i = 0; i < numberOfBooksInLibrary; i++){
                    /*for every book the method checks it's score, compares it to the max score so far, and
                    sets the Book with the higher score to be the maxBook*/
                    if (isBookAvailable(i)){
                        Book curBook = booksInLibrary[i];
                        int curValue = curPatron.getBookScore(curBook);
                        if(maxValue < curValue){
                            maxValue = curValue;
                            maxBook = curBook;
                        }
                    }
                }
                if(curPatron.willEnjoyBook(maxBook)) { //checks that the maxBook holds to the threshold
                    return maxBook;
                }
            }
        }
        return null; //otherwise returns null
    }


}
