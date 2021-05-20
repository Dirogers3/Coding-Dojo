from flask import render_template, redirect, request, session, flash
from flask_app import app
from ..models.book import Book

@app.route("/add_book/", methods=['POST'])
def add_book():
    Book.insert_book(request.form)
    return redirect("/books/")

@app.route("/books/")
def new_book_form():
    books = Book.all_books()
    return render_template("books.html", books = books)

@app.route("/books/<int:book_id>")
def show_book(book_id):
    book = Book.get_books_authors({'id':book_id})
    not_fav_authors = Book.get_not_book_authors({'id':book_id})
    return render_template("/books_show.html", book = book, not_authors= not_fav_authors)

@app.route("/add/book/favorite/", methods=['POST'])
def add_favorite():
    book_id = request.form['book_id']
    Book.add_author_to_favorites(request.form)
    return redirect(f"/books/{book_id}")

