from ..config.mysqlconnection import connectToMySQL
from ..models.book import Book



class Author:
    def __init__(self, data):
        self.id = data['id']
        self.name = data['name']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        self.books = []


#RELATIONSHIPS
    @classmethod
    def get_books_of_author(cls, data):
        query = "SELECT * FROM authors JOIN favorites ON favorites.authors_id = authors.id JOIN books ON books.id = favorites.books_id WHERE authors.id = %(id)s;"
        results = connectToMySQL("books_schema").query_db(query, data)
        authors = cls(results[0])
        print("THIS IS THE RESULTS",results)
        for row in results:
            data = {
                'id': row['books.id'],
                'title':row['title'],
                'num_of_pages':row['num_of_pages'],
                'created_at':row['books.created_at'],
                'updated_at':row['books.updated_at']
            }
            authors.books.append(Book(data))
        return authors
        
    @classmethod
    def get_not_books_of_author(cls, data):
        query = "SELECT * FROM books WHERE id NOT IN (SELECT books_id FROM favorites WHERE authors_id = %(id)s);"
        results = connectToMySQL("books_schema").query_db(query,data)
        return results

    @classmethod
    def add_books_to_favorites(cls, data):
        query = "INSERT INTO favorites (authors_id, books_id, created_at, updated_at) VALUES (%(authors_id)s, %(books_id)s, NOW(), NOW());"
        favorites_id = connectToMySQL("books_schema").query_db(query, data)
        return favorites_id


#CRUD
#CREATE
    @classmethod
    def create_author(cls, data):
        query = "INSERT INTO authors (name, created_at, updated_at ) VALUES (%(name)s, NOW(), NOW());"
        author_id = connectToMySQL("books_schema").query_db(query, data)

#READ
    #READ all authors
    @classmethod
    def all_authors(cls):
        query = "SELECT * FROM authors;"
        all_authors = connectToMySQL("books_schema").query_db(query)
        return all_authors

    #READ one authors
    @classmethod
    def one_author(cls, data):
        query = "SELECT * FROM authors WHERE id = %(id)s"
        author = connectToMySQL("books_schema").query_db(query, data)
        author_obj = cls(author[0])
        return author_obj
