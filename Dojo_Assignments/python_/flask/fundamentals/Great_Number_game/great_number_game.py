from flask import Flask, render_template, request, redirect, session
import random
app = Flask(__name__)
app.secret_key ='This is a secret'

@app.route('/')
def game():
    if 'random-number' in session:
        session.pop('random-number')
        session['random-number'] = random.randint(1,100)
    else: 
        session['random-number'] = random.randint(1,100)

    if 'tries' in session:
        session.pop('tries')
        session['tries'] = 0
    else:
        session['tries'] = 0
    return render_template("index.html")

@app.route('/guess/', methods=['POST'])
def guess():
    random_number = session['random-number']
    form_guess = request.form["guess"]
    print(session)
    session['tries'] += 1
    form_tries = session['tries']
    if form_guess == random_number:
        name = request.form["name"]
        session['name'] = name
    else:
        pass
    return render_template("results.html", randomNum = int(random_number), guessNumber = int(form_guess), template_tries = int(form_tries))

@app.route('/leader/', methods=['POST'])
def leaderboard():
    if 'leaderboard' not in session:
        session['leaderboard'] = []
    print(session['name'])
    session['name'] = request.form["name"]
    session['leaderboard'].append([session['name'],session['tries']])
    print(session)
    return render_template("/")
    session['name'] = request.form["name"]
    session['leaderboard'].append([session['name'],session['tries']])
    return render_template("leaderboard.html")

if __name__ == "__main__":
    app.run(debug=True)