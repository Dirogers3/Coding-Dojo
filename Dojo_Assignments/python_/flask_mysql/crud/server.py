from flask import Flask, render_template, redirect, request
from mysqlconn import connectToMySQL# import the function that will return an instance of a connection


app = Flask(__name__)
app.secret_key = "keep it secret, keep it safe"


@app.route("/")
def index():
    mysql = connectToMySQL('users_schema')# call the function, passing in the name of our db
    users = mysql.query_db('SELECT * FROM users;')  # call the query_db function, pass in the query as a string
    print(users)
    return render_template("/index.html", users = users)
            

@app.route("/new")
def new_user_form():
    return render_template("new.html")

@app.route("/create", methods=["POST"])
def new():
    mysql = connectToMySQL('users_schema')
    query = "INSERT INTO users (`first_name`, `last_name`, `email`, `created_at`, `updated_at`) VALUES (%(first_name)s, %(last_name)s, %(email)s, NOW(), NOW())"
    data = {
        'first_name' : request.form['firstname'],
        'last_name' : request.form['lastname'],
        'email' : request.form['email']
    }
    user_id = mysql.query_db(query, data)
    return redirect("/")
if __name__ == "__main__":
    app.run(debug=True)
