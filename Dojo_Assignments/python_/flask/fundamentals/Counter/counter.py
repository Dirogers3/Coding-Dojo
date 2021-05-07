from flask import Flask, render_template, request, redirect, session
app = Flask(__name__)
app.secret_key ='keep it secret, keep it safe'

@app.route('/', methods=['GET'])
def counter():
    if 'visits' in session:
        session['visits']=session['visits']+1
    else:
        session['visits']=1
    return render_template('index.html', visit=session['visits'])

@app.route('/plus2/')
def addtwo():
    session['visits'] = session['visits']+1
    return redirect("/")

@app.route('/destroy_session/')
def clear():
    session.pop('visits')
    return redirect("/")
if __name__ =="__main__":
    app.run(debug=True)