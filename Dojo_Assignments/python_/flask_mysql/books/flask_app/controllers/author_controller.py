from flask import render_template, redirect, request, session, flash
from flask_app import app
from ..models.author import Author

@app.route("/")
def index():
    authors = Author.get_all_authors()
    return render_template("index.html", all_authors = authors)

@app.route("/add_author/", methods=['POST'])
def add_author():
    Author.add_author(request.form)
    return redirect("/")
