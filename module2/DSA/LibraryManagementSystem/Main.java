import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Book[] books = {
            new Book(1, "Java", "James Gosling"),
            new Book(2, "Python", "Guido van Rossum"),
            new Book(3, "C++", "Bjarne Stroustrup")
        };

        System.out.println("Linear Search:");
        SearchOperations.linearSearch(books, "Python");

        // Sort books by title for binary search
        Arrays.sort(books, Comparator.comparing(b -> b.title));

        System.out.println("\nBinary Search:");
        SearchOperations.binarySearch(books, "Python");
    }
}