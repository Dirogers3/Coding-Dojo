from ..models.email import Email
from flask_app import app
from flask import render_template,redirect,request,session,flash
from flask_app.config.mysqlconnection import connectToMySQL

@app.route("/")
def index():
    print("IS THIS EVEN RUNNING?")
    return render_template("index.html")

@app.route("/register/", methods=["POST"])
def register():
    if not Email.check_email(request.form):
        return redirect('/')
    return redirect('/success.html')