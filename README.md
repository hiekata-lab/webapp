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
    cd ~/your_localFile/webapp
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

開発が終了して、実行環境のためのイメージ作成は、Dockerfileを
右クリックしてBuild Image から行う。イメージ作成時のタグは
例えばwebapp:latestとする。このタグ名のイメージを実行するには
イメージ作成後にWindowsやMac側で以下のコマンドを実行する。
"docker run --publish 8000:8000 --name webserver webapp:latest"
Dockerイメージを起動できた後、以下のアドレスでウェブアプリにアクセスできる。
http://localhost:8000/app/hello
このイメージをAzure等にコピーしていれば、ウェブ上で動く
アプリケーションとして動かすことができる。

