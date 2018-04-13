class PatronTest {

    public static void main(String[] args){
        Patron myPatron = new Patron("Nadav", "Drexler", 2, 4, 5, 23);
        Book myBook = new Book("My Life", "Yuval", 2018, 1, 4,6);
        Book nextBook = new Book("His Life", "Uri", 2018, 1, 2,1);


        System.out.println(myPatron.getBookScore(myBook)+"; Should Be 48");
        System.out.println(myPatron.stringRepresentation()+"; Should be Nadav Drexler");
        System.out.println(myPatron.willEnjoyBook(myBook));
        System.out.println(myPatron.willEnjoyBook(nextBook));
        System.out.println("Should be True and False");

    }
}
