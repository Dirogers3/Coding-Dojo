from ..config.mysqlconnection import connectToMySQL
from flash import flash
import re
EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')

class Email:
    def __init__(self, data):
        self.id:data['id']
        self.email:data['data']
        self.created_at:data['created_at']
        self.updated_at:data['updated_at']

    @classmethod
    def create_email(cls, data):
        query = "INSERT INTO emails (email, created_at, updated_at) VALUES (%(email)s, NOW(), NOW());"
        email_id = connectToMySQL("validation_schema").query_db(query,data)
        return email_id

    @classmethod
    def get_all_email(cls):
        query = "SELECT * FROM emails"
        results = connectToMySQL("validation_schema").query_db(query)
        return results
    
    @staticmethod 
    def check_email(emails):
        is_valid = True
        if not EMAIL_REGEX.match(emails['email']):
            flash("Invalid email address!")
            is_valid = False
            return is_valid