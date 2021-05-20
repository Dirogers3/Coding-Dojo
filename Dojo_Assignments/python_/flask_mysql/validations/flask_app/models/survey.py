from flask_app.config.mysqlconnection import connectToMySQL
from flask import flash

class Survey:
    def __init__(self,data):
        self.id = data['id']
        self.name = data['name']
        self.location = data['location']
        self.language = data['language']
        self.comment = data['comment']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
    
    @staticmethod
    def validate_survey(survey):
        is_valid = True
        if len(survey['name']) < 2:
            flash("Must enter Name longer than 2 characters")
            is_valid = False
        return is_valid
    
    @classmethod
    def create(cls,data):
        query = "INSERT INTO survey (name,location,language,comment,created_at,updated_at) VALUES (%(name)s,%(location)s,%(language)s,%(comment)s,NOW(),NOW());"
        return connectToMySQL("survey_schema").query_db(query,data)
    
    @classmethod
    def show(cls,data):
        query = "SELECT * FROM survey WHERE id = %(id)s;"
        results = connectToMySQL("survey_schema").query_db(query,data)
        return cls(results[0])