from flask import Flask, render_template, request, redirect
app = Flask(__name__)

@app.route('/survey')
def survey():
    return render_template('index.html')


@app.route('/result', methods=['POST'])
def results():
    form_name = request.form['name']
    form_location = request.form['location']
    form_language = request.form['language']
    form_comment = request.form['comment']
    return render_template('/result.html', name_on_template = form_name, location_on_template = form_location, language_on_template = form_language, comment_on_template = form_comment )


if __name__=="__main__":
    app.run(debug=True)