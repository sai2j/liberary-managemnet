
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean available;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.available = true;
    }

    public Book() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter book title: ");
        this.title = scanner.nextLine();

        System.out.print("Enter author name: ");
        this.author = scanner.nextLine();

        System.out.print("Enter ISBN: ");
        this.isbn = scanner.nextLine();

        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn + ", Available: " + available;
    }
}

class Library {
    private List<Book> comicBooks;
    private List<Book> horrorStoryBooks;

    public Library() {
        this.comicBooks = new ArrayList<>();
        this.horrorStoryBooks = new ArrayList<>();
    }

    public void addBook(Book book, boolean isComic) {
        if (isComic) {
            comicBooks.add(book);
        } else {
            horrorStoryBooks.add(book);
        }
    }

    public void displayAvailableBooks() {
        System.out.println("Available Books:");

        System.out.println("\nComic Books:");
        displayBooksByCategory(comicBooks);

        System.out.println("\nHorror Story Books:");
        displayBooksByCategory(horrorStoryBooks);
    }

    private void displayBooksByCategory(List<Book> bookList) {
        for (Book book : bookList) {
            if (book.isAvailable()) {
                System.out.println(book);
            }
        }
    }

    public Book borrowBook(String title, boolean isComic) {
        List<Book> bookList = isComic ? comicBooks : horrorStoryBooks;

        for (Book book : bookList) {
            if (book.getTitle().equals(title) && book.isAvailable()) {
                book.setAvailable(false);
                return book;
            }
        }
        return null;
    }

    public void returnBook(Book book) {
        book.setAvailable(true);
    }
}

class User {
    private static int userCount = 0;
    private int userId;
    private List<Book> borrowedBooks;

    public User() {
        this.userId = ++userCount;
        this.borrowedBooks = new ArrayList<>();
    }

    public int getUserId() {
        return userId;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }
}

public class liberary{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        // Display in Wel come screen
        System.out.println("                    __COLOMBO MUNICIPLE PUBLIC LIBRARY__    \n    \n    *-*- Reading makes a full man--Win the world with the power of knowledge!!! \n *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n\t*-*-Tuch and select favourite one-*-*" );
        
        //List of Comic Books
        Book comicBook1 = new Book("The Dark Knight Returns", "Frank Miller", "CB001");
        Book comicBook2 = new Book("Watchmen", "Alan Moore and Dave Gibbons", "CB015");
        Book comicBook3 = new Book("Maus", "Art Spiegelman", "CB025");
        Book comicBook4 = new Book("X-Men: Days of Future Past", "Chris Claremont", "CB037");
        Book comicBook5 = new Book("Spider-Man: The Night Stacy Died", "Gerry Conway", "CB049");
        Book comicBook6 = new Book("The Lord of the Rings", "J. R. R. Tolkien", "CB065");
        Book comicBook7 = new Book("One Hundred Year of Solitude", "Jane Austen", "CB138");
        
        //List of Horror Story books
        Book horrorStoryBook1 = new Book("Psycho", "Robert Bloch", "HB012");
        Book horrorStoryBook2 = new Book("The Exorcist", "William Peter Blatty", "HB021");
        Book horrorStoryBook3 = new Book("The Haunting of Hill House", "Shirly Jackson", "HB035");
        Book horrorStoryBook4 = new Book("It", "Stephen King","HB065");
        Book horrorStoryBook5 = new Book("Bird Box", "Josh Malerman", "HB073");
        Book horrorStoryBook6 = new Book("Mexican Gothic", "Silivia Moreno-Garcia", "HB085");
        Book horrorStoryBook7 = new Book("The Silence of the Lambs", "Thomas Harris", "HB124");

        library.addBook(horrorStoryBook7, false);
        library.addBook(comicBook1,true);
        library.addBook(comicBook2,true);
        library.addBook(comicBook3,true);
        library.addBook(comicBook4,true);
        library.addBook(comicBook5,true);
        library.addBook(comicBook6,true);
        library.addBook(comicBook7,true);
        library.addBook(horrorStoryBook1,false);
        library.addBook(horrorStoryBook2,false);
        library.addBook(horrorStoryBook3,false);
        library.addBook(horrorStoryBook4,false);
        library.addBook(horrorStoryBook5,false);
        library.addBook(horrorStoryBook6,false);
        library.addBook(horrorStoryBook7,false);

        User user = new User();

        while (true) {
            System.out.println("\n1. Display Available Books");
            System.out.println("2. Borrow a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Add a New Book");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                
                //To display available books
                case 1:
                    library.displayAvailableBooks();
                    break;

                //To Borrow a book from system
                
                case 2:
                    System.out.print("Enter the book title to borrow: ");
                    String titleToBorrow = scanner.nextLine();
                    System.out.print("Is the book comic? (true/false): ");
                    boolean isComicToBorrow = scanner.nextBoolean();
                    Book borrowedBook = library.borrowBook(titleToBorrow, isComicToBorrow);

                    if (borrowedBook != null) {
                        user.borrowBook(borrowedBook);
                        System.out.println("Book borrowed successfully.");
                    } else {
                        System.out.println("Book not available or not found.");
                    }
                    break;

                //To Return already burrowd Book
                case 3:
                    System.out.print("Enter Title of the book to return: ");
                    String titleToReturn = scanner.nextLine();
                    Book bookToReturn = null;

                    for (Book borrowed : user.getBorrowedBooks()) {
                        if (borrowed.getTitle().equals(titleToReturn)) {
                            bookToReturn = borrowed;
                            break;
                        }
                    }

                    if (bookToReturn != null) {
                        library.returnBook(bookToReturn);
                        user.returnBook(bookToReturn);
                        System.out.println("Book returned successfully.");
                    } else {
                        System.out.println("Book not found in your borrowed list.");
                    }
                    break;

                //To add New books
                case 4:
                    System.out.print("Is the book comic? (true/false): ");
                    boolean isComicToAdd = scanner.nextBoolean();
                    Book newBook = new Book();
                    library.addBook(newBook, isComicToAdd);
                    System.out.println("New book added to the library.");
                    break;

                //To exit the system
                case 5:
                    System.out.println("Thank you!, We are here to assist you. \n\t Have a nice day");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
