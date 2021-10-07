WebApp
=========
Python/Flask/Docker test

Software Requirements
---------------
1. install [Docker](https://www.docker.com/get-started)
2. install [VSCode](https://code.visualstudio.com/)

Installation
------------

### For Mac/Linux
1. Run docker on the background
1. Open terminal
1. clone repository from Hiekata-lab:
    ```
    git clone https://github.com/hiekata-lab/webapp.git
    ```
2. Build the docker container with the `Dockerfile` (don't forget to run docker on the background)
    ```
    cd ~/your_localFile/webapp/python
    docker build -t webapp:1.0 .
    ```
2. Run the container previously created
    ```
    docker container run --name webserver -d -p 8000:8000 webapp:1.0
    ```
2. go to http://localhost:8000/app on your browser, if you see a message is working

### For Windows
Run "docker run --publish 8000:8000 --name webserver webapp:latest"
then, access http://localhost:8000/app/hello.
VS Code のリモートコンテナで開発しているときは、Dockerfileの以下の行は
実行されない。
CMD ["python", "/app/hello.py"]
開発中のウェブアプリのテストでは、Dockerのターミナルを起動して、
python /app/hello.py と入力してアプリケーションを起動すること。
起動した後は以下のアドレスでウェブアプリにアクセスできる。
http://localhost:8000/app/hello

Run "docker run --publish 8000:8000 --name webserver webapp:latest"
then, access http://localhost:8000/app/hello.
When you are developing in a VS Code remote container, the following line in the Dockerfile will not be executed.
in the Dockerfile will not be executed.
CMD ["python", "/app/hello.py"].
To test the web app you are developing, start a Docker terminal and run
Type python /app/hello.py to launch the application.
After launching, you can access the web app at the following address.
http://localhost:8000/app/hello

### Follow Up
開発が終了して、実行環境のためのイメージ作成は、Dockerfileを
右クリックしてBuild Image から行う。イメージ作成時のタグは
例えばwebapp:latestとする。このタグ名のイメージを実行するには
イメージ作成後にWindowsやMac側で以下のコマンドを実行する。
"docker run --publish 8000:8000 --name webserver webapp:latest"
Dockerイメージを起動できた後、以下のアドレスでウェブアプリにアクセスできる。
http://localhost:8000/
このイメージをAzure等にコピーしていれば、ウェブ上で動く
アプリケーションとして動かすことができる。

When you have finished development, you can create an image for the execution environment by right-clicking on the Dockerfile
Right click on the Dockerfile and select Build Image. The tag for creating the image is
For example, webapp:latest. To run an image with this tag name
After creating the image, run the following command on Windows or Mac
"docker run --publish 8000:8000 --name webserver webapp:latest"
After you are able to run the Docker image, you can access the web app at the following address:
http://localhost:8000/
If you have copied this image to Azure, you can run it as a web application.

### Dockerfile
CMD ["python", "/app/hello.py"] line of Dockerfile
will automatically run the server when you deploy
this docker image into the container for operational use, not for development.

### Notes
Type following commands to start Flask server 
in Running Docker Container with Docker Image.

(Container):/workspaces/webapp# cd /app
(Container):/app# ls
hello.py          requirements.txt
(Container):/app# python hello.py
 * Serving Flask app 'hello' (lazy loading)
 * Environment: production
   WARNING: This is a development server. Do not use it in a production deployment.
   Use a production WSGI server instead.
 * Debug mode: on
 * Running on all addresses.
   WARNING: This is a development server. Do not use it in a production deployment.
 * Running on http://172.17.0.2:8000/ (Press CTRL+C to quit)
 * Restarting with stat
 * Debugger is active!
 * Debugger PIN: 832-376-861
-------------------------------------------
Do followings to start forwarding 8000 port of your computer to 8000 port of running docker container.
-------------------------------------------
1. visual studio code and docker may configure the forwarding automatically.
Access http://localhost:8000/app from your computer(not from the docker)
to check if you could access to hello.py.

2. Edit "port" of visual studio code. port=8000 and local address=localhost:8000,
to configure the forwarding manually.
Then check http://localhost:8000/app .

3. Restart everything and try these if the instructions don't work well.

* Workaround
You can start your docker image by typing following command in your computer.
"webapp:latest" is the name specified when the docker image is build.
(You need to understand more about docker and visual studio code.)
"docker run --publish 8000:8000 --name webserver webapp:latest"
-------------------------------------------

### Advanced Samples
-------------------------------------------
1. Run "python /app/application.py"
2. Connect http://localhost:5000/ from your computer(not from the docker)
* Note that 5000 port is forwarded.
-------------------------------------------

開発が終了して、実行環境のためのイメージ作成は、Dockerfileを
右クリックしてBuild Image から行う。イメージ作成時のタグは
例えばwebapp:latestとする。このタグ名のイメージを実行するには
イメージ作成後にWindowsやMac側で以下のコマンドを実行する。
"docker run --publish 8000:8000 --name webserver webapp:latest"
Dockerイメージを起動できた後、以下のアドレスでウェブアプリにアクセスできる。
http://localhost:8000/app
このイメージをAzure等にコピーしていれば、ウェブ上で動く
アプリケーションとして動かすことができる。

### TODO

I should have included a simple graph by dash. 
https://dash.plotly.com/dash-core-components/graph
