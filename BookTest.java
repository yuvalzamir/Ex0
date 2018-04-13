class BookTest {

    public static void main(String[] args){
        Book myBook = new Book("My Life", "Yuval", 2018, 1, 4,6);


        System.out.println(myBook.stringRepresentation());
        System.out.println("Should Be: [My Life, Yuval, 2018, 11]");
        System.out.println(myBook.getLitteraryValue());
        System.out.println("Should Be: "+11);
        System.out.println(myBook.getCurrentBorrowerID());
        System.out.println("Should Be: "+-1);
        myBook.setBorrowerId(54);
        System.out.println(myBook.getCurrentBorrowerID());
        System.out.println("Should be 54");
        myBook.returnBook();
        System.out.println(myBook.getCurrentBorrowerID());
        System.out.println("Should Be -1");


    }
}
