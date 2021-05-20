from ..config.mysqlconnection import connectToMySQL


class Book:
    def __init__(self, data):
        self.id = data['id']
        self.title = data['title']
        self.num_of_pages = data['num_of_pages']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        self.authors = []

#RELATIONSHIPS

    @classmethod 
    def get_books_authors(cls, data):
        from ..models.author import Author
        query = "SELECT * FROM books JOIN favorites ON books.id = favorites.books_id JOIN authors ON favorites.authors_id = authors.id WHERE books.id = %(id)s;"
        results = connectToMySQL("books_schema").query_db(query, data)
        book = cls(results[0])
        for row in results:
            data = {
                'id': row['authors.id'],
                'name':row['name'],
                'created_at':row['authors.created_at'],
                'updated_at':row['authors.updated_at']
            }
            book.authors.append(Author(data))
        return book

    @classmethod
    def get_not_book_authors(cls, data):
        query = "SELECT * FROM authors WHERE id NOT IN (SELECT authors_id FROM favorites WHERE books_id = %(id)s);"
        results = connectToMySQL("books_schema").query_db(query,data)
        return results

    @classmethod
    def add_author_to_favorites(cls, data):
        query = "INSERT INTO favorites (authors_id, books_id, created_at, updated_at) VALUES (%(authors_id)s, %(book_id)s, NOW(), NOW());"
        favorites_id = connectToMySQL("books_schema").query_db(query, data)
        return favorites_id


#CRUD

    #CREATE
    @classmethod
    def insert_book(cls, data):
        query = "INSERT INTO books (title, num_of_pages, updated_at, created_at) VALUES (%(title)s, %(num_of_pages)s, NOW(), NOW());"
        book_id = connectToMySQL("books_schema").query_db(query, data)
        return book_id
    #READ
        #READ ONE
    @classmethod
    def read_one_book(cls, data):
        query = "SELECT * FROM books WHERE id = %(id)s;"
        results = connectToMySQL("books_schema").query_db(query, data)
        book_obj = cls(results[0])
        return book_obj
        #READ ALL
    @classmethod
    def all_books(cls):
        query = "SELECT * FROM books;"
        all_books = connectToMySQL("books_schema").query_db(query)
        books = []
        for book in all_books:
            books.append(cls(book))
        return books
