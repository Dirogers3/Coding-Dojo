from ..config.mysqlconnection import connectToMySQL
from ..models.author import Author

class Book:
    def __init__(self, data):
        self.id = data['id']
        self.title = data['title']
        self.num_of_pages = data['num_of_pages']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        self.authors = []

    @classmethod
    def get_all_books(cls):
        query = "SELECT * FROM books;"
        books_from_db = connectToMySQL("books_schema").query_db(query)
        books=[]
        for book in books_from_db:
            books.append(cls(book))
        return books

    @classmethod
    def add_book(cls, data):
        query = "INSERT INTO books (title, num_of_pages, created_at, updated_at) VALUES (%(title)s, %(num_of_pages)s, NOW(), NOW());"
        book_id = connectToMySQL("books_schema").query_db(query, data)
        return book_id
        
    @classmethod
    def get_book_authors(cls, data):
        query ="SELECT name FROM authors JOIN favorites ON authors.id = authors_id JOIN books ON favorites.books_id = books.id WHERE books.id = %(book_id)s;"
        results = connectToMySQL("books_schema").query_db(query, data)
        book = cls(results[0])
        for row in results:
            data = {
                "id":row['authors.id'],
                "name":row['authors.name'],
                "created_at":row['authors.created_at'],
                "updated_at":row['authors.updated_at']
            }
            book.authors.append(Author(data))
        return book
