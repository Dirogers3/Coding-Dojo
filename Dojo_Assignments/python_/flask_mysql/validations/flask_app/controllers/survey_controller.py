from flask_app import app
from flask import render_template,redirect,request,session,flash

from flask_app.config.mysqlconnection import connectToMySQL
from flask_app.models.survey import Survey

@app.route("/")
def show_form():
    return render_template("index.html")

@app.route("/result", methods=['POST'])
def show_result():

    if not Survey.validate_survey(request.form):
        return redirect('/')
    
    survey = Survey.create(request.form)
    print("IS ANYTHING HERE",survey)
    return redirect(f"/results/{survey}")

@app.route('/results/<id>')
def show_survey(id):
    data = {
        'id': id
    }
    return render_template('result.html', survey=Survey.show(data))