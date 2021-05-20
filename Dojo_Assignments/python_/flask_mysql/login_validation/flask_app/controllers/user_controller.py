from flask import render_template, redirect, request, session, flash
from flask_bcrypt import Bcrypt
from flask_app import app
from ..models.user import User
bcrypt = Bcrypt(app)

@app.route("/")
def index():
    if "user_id" in session:
        return redirect("/success")
    return render_template("index.html")

@app.route("/register", methods = ['POST'])
def register():
    if not User.register_validator(request.form):
        return redirect("/")
    hashed = bcrypt.generate_password_hash(request.form['password'])
    data = {
        "first_name": request.form["first_name"],
        "last_name": request.form["last_name"],
        "email": request.form["email"],
        "password": hashed
    }
    user_id = User.create(data)
    session['user_id']= user_id
    return redirect("/success")


@app.route("/login", methods = ['POST'])
def login():
    if not User.login_validator(request.form):
        return redirect("/")
    
    user = User.get_by_email({"email": request.form['email']})

    session['user_id'] = user.id

    return redirect("/success")
    
@app.route("/logout")
def logout():
    session.clear()
    return redirect("/")

@app.route("/success")
def success():
    if "user_id" not in session: #Check to see if the user is logged in via sessions
        return redirect("/")

    logged_user = User.get_by_id({"id":session['user_id']})

    return render_template("success.html", user = logged_user)

