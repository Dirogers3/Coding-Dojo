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

