from flask import Flask, render_template, request, jsonify, json
app = Flask(__name__)

@app.route("/")
def hello():
    return "Hello World!<br><a href='ui'>Calc and JSON</a><br><br><a href='json'>JSON return</a><br><a href='hello'>Hello</a><br><br>"

@app.route("/json")
def jsonreturn():
    # read JSON file and send them to the web client
    # See templates/calc.html to know how you call this
    with open("./data/input.json", 'r') as f:
        json_data = json.load(f)
    json_str = json.dumps(json_data)
    return json_str

@app.route('/hello')
@app.route('/hello/<name>')
def hello2(name=None):
    # /hello will reply basic html
    # /hello/<name> will reply with username specified in <name>
    return render_template('hello.html', name=name)

@app.route('/ui')
def ui():
    # /ui will reply basic html
    # /ui/<name> will reply with username specified in <name>
    return render_template('calc.html')

@app.route('/simulate')
def simulate():
    # This function read two parameters from web request
    # Returns the sum of two parameters.
    # See templates/calc.html to know how you call this
    param1 = request.args.get('input1')
    param2 = request.args.get('input2')
    # replace the next line with your simulator
    output1 = int(param1) + int(param2)
    json_str = '{"input1":' + str(param1) + ',"input2":' + str(param2) +', "output":' + str(output1) + '}'
    json_data = json.loads(json_str)
    # write your output to a file
    with open('./data/output.json', 'w') as f:
        json.dump(json_data, f, indent=4)
    return  json_str

if __name__ == "__main__":
    app.run(host='0.0.0.0', port=5000, debug=True)
    
