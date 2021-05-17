from flask import render_template, redirect, request, session, flash
from flask_app import app
from ..models.book import Book

@app.route("/books/")
def get_book():
    books = Book.get_all_books()
    return render_template("books.html", all_books = books)

@app.route("/add_book/", methods=['POST'])
def add_book():
    Book.add_book(request.form)
    return redirect("/books/")

@app.route("/book/<int:book_id>")
def show_book(book_id):
    print("THIS IS THE BOOK ID FROM THE SHOW",book_id)
    books_authors = Book.get_book_authors({"id": book_id})
    return render_template("/books_show.html", authors = books_authors)

