from flask import Flask, render_template
app = Flask(__name__)

@app.route('/')
def home():
    return render_template('index.html', x = 8, y = 8,colora = 'red' ,colorb = 'black')

@app.route('/<x>')
def withx(x):
    return render_template('index.html', x = int(x) , y = 8)

@app.route('/<x>/<y>')
def withxy(x,y):
    return render_template('index.html', x =int(x), y = int(y))

@app.route('/<x>/<y>/<color1>/<color2>')
def withxycolors(x,y,color1,color2):
    return render_template('index.html', x=int(x), y=int(y), colora = str(color1) , colorb = str(color2))
if __name__=="__main__":
    app.run(debug=True)
