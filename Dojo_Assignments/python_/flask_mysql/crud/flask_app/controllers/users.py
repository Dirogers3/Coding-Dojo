from flask_app import app
from flask import render_template, redirect, request
from flask_app.config.mysqlconn import connectToMySQL
from flask_app.models.user import User


@app.route("/")
def index():
    return render_template("/index.html", users = User.get_all())
            

@app.route("/new")
def new_user_form():
    return render_template("new.html")

@app.route("/create", methods=["POST"])
def new():
    data = {
        'first_name' : request.form['first_name'],
        'last_name' : request.form['last_name'],
        'email' : request.form['email'],
    }
    
    user_id = User.save(data)
    return redirect(f"user/{user_id}")

@app.route("/user/<int:id>")
def read(id):
    data = {
        "id":id
    }
    return render_template("user.html", user=User.get_by_id(data))
    

@app.route("/user/<int:id>/edit")
def edit_user(id):
    data = {
        "id":id
    }
   
    return render_template("edit.html", user = User.get_by_id(data))

@app.route('/user/<int:id>/update', methods=["POST"])
def update_user(id):
    data = {
        'first_name' : request.form['first_name'],
        'last_name' : request.form['last_name'],
        'email' : request.form['email'],
        "id": id
    }
    User.update(data)
    return redirect(f"/user/{id}")

@app.route("/user/<int:id>/delete")
def delete(id):
    data = {
        "id":id
    }
    User.destroy(data)
    return redirect("/")