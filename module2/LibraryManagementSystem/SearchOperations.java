class SearchOperations {

    // Linear Search
    static void linearSearch(Book[] books, String key) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].title.equalsIgnoreCase(key)) {
                System.out.println("Book Found (Linear Search):");
                books[i].display();
                return;
            }
        }
        System.out.println("Book Not Found (Linear Search)");
    }

    // Binary Search (Sorted Array)
    static void binarySearch(Book[] books, String key) {
        int left = 0;
        int right = books.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            int result = books[mid].title.compareToIgnoreCase(key);

            if (result == 0) {
                System.out.println("Book Found (Binary Search):");
                books[mid].display();
                return;
            } else if (result < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println("Book Not Found (Binary Search)");
    }
}