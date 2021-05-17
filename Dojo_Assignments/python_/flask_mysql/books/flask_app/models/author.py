from ..config.mysqlconnection import connectToMySQL
#from ..models.book import Book

class Author:
    def __init__(self, data):
        self.id = data['id']
        self.name = data['name']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']

    @classmethod
    def get_all_authors(cls):
        query = 'SELECT * FROM authors;'#this will be the query to get all authors
        authors_from_db = connectToMySQL("books_schema").query_db(query)#this passes the query into the config to get actually work with sql
        authors = [] #created a place for the list of authors
        for author in authors_from_db: #taking a dictionary of authors
            authors.append(cls(author)) #adding it to the authors list for better readability
        return authors #returns the list of authors.

    @classmethod
    def add_author(cls, data):
        query = "INSERT INTO authors (name, created_at, updated_at) VALUES (%(name)s, NOW(), NOW());"
        author_id = connectToMySQL('books_schema').query_db(query, data)
        return author_id
