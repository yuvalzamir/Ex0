class LibraryTest {
    public static void main(String[] args) {
        Library myLib = new Library(4, 2, 2);
        Book myBook = new Book("My Life", "Yuval", 2018, 1, 4,0);
        Book nextBook = new Book("His Life", "Uri", 2018, 7, 5,1);
        Book thirdBook= new Book("Our Life", "Daniel", 2018, 3,4,6);
        Patron myPatron = new Patron("Nadav", "Drexler", 2, 4, 5, 23);
        Patron nextPatron = new Patron("Shira", "Telem", 2, 1, 5, 6);

        //Book Tests
        System.out.println(myBook.stringRepresentation());
        System.out.println("Should Be: [My Life, Yuval, 2018, 11]");
        System.out.println(myBook.getLiteraryValue());
        System.out.println("Should Be: "+11);
        System.out.println(myBook.getCurrentBorrowerId());
        System.out.println("Should Be: "+-1);
        myBook.setBorrowerId(54);
        System.out.println(myBook.getCurrentBorrowerId());
        System.out.println("Should be 54");
        myBook.returnBook();
        System.out.println(myBook.getCurrentBorrowerId());
        System.out.println("Should Be -1");

        //Patron Tests
        System.out.println(myPatron.getBookScore(myBook)+"; Should Be 48");
        System.out.println(myPatron.stringRepresentation()+"; Should be Nadav Drexler");
        System.out.println(myPatron.willEnjoyBook(myBook));
        System.out.println(myPatron.willEnjoyBook(nextBook));
        System.out.println("Should be True and False");


        //Library Tests
        myLib.addBookToLibrary(myBook);
        System.out.println(myLib.getNumberOfBooksInLibrary());
        System.out.println(myLib.getBooksInLibrary()[0].stringRepresentation());
        myLib.addBookToLibrary(nextBook);
        System.out.println(myLib.getBooksInLibrary()[1].stringRepresentation());
        System.out.println(myLib.getNumberOfBooksInLibrary()+" Should be 2"); //will not work anywhere
        myLib.addBookToLibrary(nextBook);
        System.out.println(myLib.getNumberOfBooksInLibrary()+" Should be 2"); // will not work anywhere
        System.out.println(myLib.isBookValid(1)+" Should be true");
        System.out.println(myLib.isBookValid(3)+" Should be false");
        System.out.println(nextBook.getCurrentBorrowerID()+" Should be -1"); //will not work anywhere
        System.out.println(myLib.getBookId(myBook)+ " Should be 0");
        System.out.println(myLib.getBookId(thirdBook)+" should be -1");
        myBook.setBorrowerId(1);
        System.out.println(myLib.isBookAvailable(0)+" Should be false");
        System.out.println(myLib.isBookAvailable(1)+" Should be true");
        myLib.registerPatronToLibrary(myPatron);
        System.out.println(myLib.getNumberOfPatronsInLibrary()+ " Should be 1"); //wil not work anywhere
        System.out.println(myLib.isPatronValid(0)+" Should be true");
        System.out.println(myLib.isPatronValid(-1)+" Should be false");
        System.out.println(myLib.isPatronValid(1)+" Should be false");
        System.out.println(myLib.getPatronId(myPatron)+" Should be 0");
        System.out.println(myLib.getPatronId(nextPatron)+" Should be -1");
        myBook.returnBook();
        System.out.println(myLib.borrowBook(1,0)+" Should by true");
        System.out.println(myLib.borrowBook(0,0)+" Should by false");
        System.out.println(myLib.borrowBook(0,0)+ " Should be false");
        System.out.println(myLib.borrowBook(1,1)+" Should be false");
        myLib.borrowBook(1,0);
        System.out.println(myLib.borrowBook(2,0)+" Should be false");
        myLib.returnBook(0);
        myLib.returnBook(1);
        myLib.returnBook(2);
        System.out.println(myBook.getCurrentBorrowerID()+" Should be -1");
        System.out.println(thirdBook.getCurrentBorrowerID()+" Should be -1");
        Book pickedBook = myLib.suggestBookToPatron(0);
        System.out.println(pickedBook.stringRepresentation()+" Should suggest myBook");
        myLib.addBookToLibrary(thirdBook);
        myLib.registerPatronToLibrary(nextPatron);
        System.out.println(myLib.isPatronValid(1)+" Should be true");
        pickedBook = myLib.suggestBookToPatron(1);
        System.out.println(pickedBook.stringRepresentation()+" Should suggest third book");










    }
}