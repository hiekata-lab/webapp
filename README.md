# webapp
Python/Flask/Docker test

in Windows
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
