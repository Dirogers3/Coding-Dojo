from flask import render_template, redirect, request, session, flash
from flask_app import app
from ..models.author import Author



# This will display the Authors into the INDEX
@app.route("/")
def index():
    all_authors = Author.all_authors()
    return render_template("index.html", authors=all_authors)
# This will add author to the list on the INDEX
@app.route("/add_author/", methods=['POST'])
def add_author():
    Author.create_author(request.form)
    return redirect("/")
# This will display the author page and pass in author info
@app.route("/authors/<int:author_id>")
def show_author_page(author_id):
    author = Author.get_books_of_author({'id':author_id})
    books = Author.get_not_books_of_author({'id':author_id})
    return render_template("/authors_show.html", author=author, books = books)

@app.route("/add/book/", methods=['POST'])
def add_book_to_author():
    author_id = request.form['author_id']
    return redirect(f"/authors/{author_id}")


