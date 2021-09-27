FROM python:alpine
# FROM python:3.6

# Set Working Directory (application runs here.)
WORKDIR /app
# Copy files in current directory
ADD hello.py /app
ADD application.py /app
ADD requirements.txt /app

# install 
RUN pip install -r requirements.txt

# open port 8000 and 5000
EXPOSE 8000
EXPOSE 5000
# start flask server.
CMD ["python", "/app/hello.py"]
# CMD ["python", "/app/application.py"]
