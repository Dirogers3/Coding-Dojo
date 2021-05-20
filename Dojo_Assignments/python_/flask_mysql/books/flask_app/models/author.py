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

#UPDATE

#DELETE








































    # @classmethod
    # def get_all_authors(cls):
    #     query = 'SELECT * FROM authors;'#this will be the query to get all authors
    #     authors_from_db = connectToMySQL("books_schema").query_db(query)#this passes the query into the config to get actually work with sql
    #     authors = [] #created a place for the list of authors
    #     for author in authors_from_db: #taking a dictionary of authors
    #         authors.append(cls(author)) #adding it to the authors list for better readability
    #     return authors #returns the list of authors.

    # @classmethod
    # def add_author(cls, data):
    #     query = "INSERT INTO authors (name, created_at, updated_at) VALUES (%(name)s, NOW(), NOW());"
    #     author_id = connectToMySQL('books_schema').query_db(query, data)
    #     return author_id
    
    # @classmethod 
    # def get_all(cls, data):
    #     print("THIS Is THE DATTA", data)
    #     query = "SELECT * FROM authors JOIN favorites ON authors.id = favorites.authors_id JOIN books ON favorites.books_id = books.id WHERE favorites.authors_id = %(id)s;"
    #     results = connectToMySQL("books_schema").query_db(query, data)
    #     print("THIS IS THE RESLUTS OF THE RESUTLS", results)
    #     author_info =[]
    #     for row in results:
    #         data = {
    #             "id":row['authors_id'],
    #             "name":row['name'],
    #             "created_at":row['created_at'],
    #             "updated_at":row['updated_at']
    #         }
    #         author_info.append(data)
    #         print("################################# THIS IS BOOKS",author_info)
    #     return author_info