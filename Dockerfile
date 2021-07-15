FROM python:alpine
# FROM python:3.6
#ルートディレクトリ設定
WORKDIR /app
COPY ./app /app
RUN pip install Flask

#ファイルをappディレクトリに追加
COPY hello.py /app/

#コマンド実行
CMD ["python", "hello.py"]
