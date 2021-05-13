from flask import Flask, render_template, redirect, request
from mysqlconn import connectToMySQL# import the function that will return an instance of a connection


app = Flask(__name__)
app.secret_key = "keep it secret, keep it safe"


@app.route("/")
def index():
    mysql = connectToMySQL('users_schema')# call the function, passing in the name of our db
    users = mysql.query_db('SELECT * FROM users;')  # call the query_db function, pass in the query as a string
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
    print(user_id)
    return redirect(f"user/{user_id}")

@app.route("/user/<int:id>")
def read(id):
    mysql = connectToMySQL('users_schema')
    query = "SELECT * FROM users WHERE id = %(id)s;"
    data = {
        "id":id
    }
    user_list = mysql.query_db(query,data)
    return render_template("user.html", user=user_list[0])
    

@app.route("/user/<int:id>/edit")
def edit_user(id):
    mysql = connectToMySQL('users_schema')
    query = "SELECT * FROM users WHERE id = %(id)s;"
    data = {
        "id":id
    }
    user_list = mysql.query_db(query,data)
    return render_template("edit.html", user=user_list[0])

@app.route('/user/<int:id>/update', methods=["POST"])
def update_user(id):
    mysql = connectToMySQL('users_schema')
    query = "UPDATE users SET `first_name`= %(first_name)s, `last_name` = %(last_name)s, `email` = %(email)s, `updated_at` = NOW() WHERE id = %(id)s;"
    data = {
        'first_name' : request.form['firstname'],
        'last_name' : request.form['lastname'],
        'email' : request.form['email'],
        "id": id
    }
    mysql.query_db(query, data)
    user_id = int(id)
    return redirect(f"/user/{user_id}")

@app.route("/user/<int:id>/delete")
def delete(id):
    data = {
        "id":id
    }
    mysql = connectToMySQL('users_schema')
    mysql.query_db("DELETE FROM `users_schema`.`users` WHERE id = %(id)s;", data)
    return redirect("/")


if __name__ == "__main__":
    app.run(debug=True)
