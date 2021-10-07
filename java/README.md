WebApp
=========
Java/HttpServer/Docker test

Software Requirements
---------------
1. install [Docker](https://www.docker.com/get-started)
2. (Optional) install [Eclipse](https://www.eclipse.org) (If you would like an IDE for the editing and testing the Java code)

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
    cd ~/your_localFile/webapp/java
    docker build -t webapp:1.0 .
    ```
2. Run the container previously created
    ```
    docker container run --name webserver -d -p 8000:8000 webapp:1.0
    ```
2. go to http://localhost:8000/app on your browser, if you see a message is working

### Follow Up (日本語）
開発が終了して、実行環境のためのイメージ作成は、Dockerfileを
右クリックしてBuild Image から行う。イメージ作成時のタグは
例えばwebapp:latestとする。このタグ名のイメージを実行するには
イメージ作成後にWindowsやMac側で以下のコマンドを実行する。
"docker run --publish 8000:8000 --name webserver webapp:latest"
Dockerイメージを起動できた後、以下のアドレスでウェブアプリにアクセスできる。
http://localhost:8000/
このイメージをAzure等にコピーしていれば、ウェブ上で動く
アプリケーションとして動かすことができる。

###Follow Up
When you have finished development, you can create an image for the execution environment by right-clicking on the Dockerfile
Right click on the Dockerfile and select Build Image. The tag for creating the image is
For example, webapp:latest. To run an image with this tag name
After creating the image, run the following command on Windows or Mac
"docker run --publish 8000:8000 --name webserver webapp:latest"
After you are able to run the Docker image, you can access the web app at the following address:
http://localhost:8000/
If you have copied this image to Azure, you can run it as a web application.

Translated with www.DeepL.com/Translator (free version)

### Dockerfile
CMD ["java", "HelloHTTP"] line of Dockerfile
will automatically run the server when you deploy
this docker image into the container for operational use, not for development.
