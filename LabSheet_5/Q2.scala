case class Book(title: String, author: String, ISBN: String)

object LibraryManagement {
    var library: Set[Book] = Set(
        Book("The Catcher in the Rye", "J.D. Salinger", "9780316769488"),
        Book("To Kill a Mockingbird", "Harper Lee", "9780061120084"),
        Book("1984", "George Orwell", "9780451524935"),
        Book("Pride and Prejudice", "Jane Austen", "9780141439518"),
        Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565"),
        Book("The Hobbit", "J.R.R. Tolkien", "9780345534835"),
        Book("The Lord of the Rings", "J.R.R. Tolkien", "9780544003415"),
        Book("Animal Farm", "George Orwell", "9780451526342"),
        Book("Brave New World", "Aldous Huxley", "9780060850524")
    )

    def addBook(book: Book): Unit = {
        library += book
    }

    def removeBookByISBN(ISBN: String): Unit = {
        library = library.filterNot(_.ISBN == ISBN)
    }

    def isBookInLibrary(ISBN: String): Boolean = {
        library.exists(_.ISBN == ISBN)
    }

    def displayLibrary(): Unit = {
        println("Current library collection:")
        library.foreach(book => println(s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.ISBN}"))
    }

    def searchBookByTitle(title: String): Unit = {
        library.find(_.title.equalsIgnoreCase(title)) match {
            case Some(book) => println(s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.ISBN}")
            case None => println("Book not found")
        }
    }

    def displayBookByAuthor(author: String): Unit = {
        val booksByAuthor = library.filter(_.author.equalsIgnoreCase(author))
        if (booksByAuthor.nonEmpty) {
            println(s"Books by $author:")
            booksByAuthor.foreach(book => println(s"Title: ${book.title}, ISBN: ${book.ISBN}"))
        } else {
            println(s"No books found by author $author.")
        }
    }

    def main(args: Array[String]): Unit = {
        displayLibrary()
        println("\nAdding a new book to the library:")
        addBook(Book("The Picture of Dorian Gray", "Oscar Wilde", "9780141439570"))
        displayLibrary()

        println("\nRemoving a book from the library:")
        removeBookByISBN("9780061120084")
        displayLibrary()

        println("\nChecking if a book is in the library by ISBN:")
        println(isBookInLibrary("9780451524935"))
        println(isBookInLibrary("9780061120084"))

        println("\nSearching for a book by title:")
        searchBookByTitle("The Great Gatsby")

        println("\nDisplaying books by author:")
        displayBookByAuthor("George Orwell")
    }
}