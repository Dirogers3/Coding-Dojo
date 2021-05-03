from flask import Flask, render_template  # Import Flask to allow us to create our app
app = Flask(__name__)    # Create a new instance of the Flask class called "app"

@app.route('/dojo')
def dojo():
    return "Dojo!"

@app.route('/success')
def success():
    return "success"

@app.route('/say/<name>')
def say(name):
    print(name)
    return ("Hi, " + str(name))

@app.route('/repeat/<number>/<word>')
def repeat(number, word):
    sentence=""
    for i in range(int(number)):
        sentence += (word +"\n")
    return str(sentence)
    
@app.route('/hello/<name>') # for a route '/hello/____' anything after '/hello/' gets passed as a variable 'name'
def hello(name):
    print(name)
    return "Hello, " + name

@app.route('/users/<username>/<id>') # for a route '/users/____/____', two parameters in the url get passed as username and id
def show_user_profile(username, id):
    print(username)
    print(id)
    return "username: " + username + ", id: " + id

@app.route('/')                           
def hello_world():
    # Instead of returning a string, 
    # we'll return the result of the render_template method, passing in the name of our HTML file
    return render_template('index.html')  

@app.route('/<something>')
def function(something):
    return "Sorry! No response. Try again."

if __name__=="__main__":   # Ensure this file is being run directly and not from a different module    
    app.run(debug=True)    # Run the app in debug mode.



