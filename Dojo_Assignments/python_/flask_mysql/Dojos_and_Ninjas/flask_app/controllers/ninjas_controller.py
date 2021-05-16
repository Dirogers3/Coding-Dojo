from flask import render_template, redirect, request, session, flash, url_for
from flask_app import app
from ..models.ninja import Ninja
from ..models.dojo import Dojo

@app.route("/ninjas/new/")
def newNinja():
    dojos = Dojo.get_all_dojos()
    return render_template("newninjas.html", all_dojos = dojos)

@app.route("/ninjas/create", methods=['POST'])
def create_ninja():
    # data = {
    #     "dojos_id":request.form['dojo']
    #     "first_name":request.form[first_name]
    # }
    Ninja.create(request.form)
    return redirect(url_for(".display_dojo",dojos_id = request.form.get("dojos_id")))