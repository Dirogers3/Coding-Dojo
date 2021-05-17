from ..config.mysqlconnection import connectToMySQL

class Book:
    def __init__(self, data):
        self.id = data['id']
        self.title = data['title']
        self.num_of_pages = data['num_of_pages']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']

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
        