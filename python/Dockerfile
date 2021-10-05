FROM python:alpine
# FROM python:3.6

# Install Git
RUN apk --no-cache add git

# Set Working Directory (application runs here.)
WORKDIR /app
RUN mkdir /app/data
RUN mkdir /app/templates

# Copy files in current directory
ADD *.py /app
ADD requirements.txt /app
ADD templates/* /app/templates/
ADD data/* /app/data/

# install 
RUN pip install -r requirements.txt

# open port 5000
#EXPOSE 8000
EXPOSE 5000
# start flask server.
#CMD ["python", "/app/hello.py"]
CMD ["python", "/app/application.py"]
