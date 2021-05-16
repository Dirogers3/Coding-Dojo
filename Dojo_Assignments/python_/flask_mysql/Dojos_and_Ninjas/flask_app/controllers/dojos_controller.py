from flask import render_template, redirect, request, session, flash
from flask_app import app
from ..models.dojo import Dojo

@app.route("/")
def index():
    dojos = Dojo.get_all_dojos()
    return render_template("index.html", all_dojos = dojos)

@app.route("/dojos/<int:dojos_id>")
def display_dojo(dojos_id):
    this_dojo = Dojo.get_dojo_with_ninjas({"id": dojos_id})
    print(this_dojo)
    return render_template("dojoshow.html", dojos = this_dojo)

