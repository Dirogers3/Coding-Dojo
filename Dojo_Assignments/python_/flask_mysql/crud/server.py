from flask import Flask, render_template, redirect
from mysqlconn import connectToMySQL# import the function that will return an instance of a connection
app = Flask(__name__)
@app.route("/")
def index():
    mysql = connectToMySQL('users_schema')# call the function, passing in the name of our db
    users = mysql.query_db('SELECT * FROM users;')  # call the query_db function, pass in the query as a string
    return render_template("/index.html")
            
@app.route("/new/")
def new():
    return render_template("/new.html")
if __name__ == "__main__":
    app.run(debug=True)
