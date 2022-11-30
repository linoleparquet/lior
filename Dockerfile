# Dockerfile representant le userdata de l'EC2

FROM amazonlinux

RUN amazon-linux-extras install -y nginx1 java-openjdk11
RUN yum install -y vim tar

# Frontend
RUN rm -rf /usr/share/nginx/html/*
RUN curl -L https://github.com/linoleparquet/lior-frontend/releases/download/latest/dist.tar.gz -o dist.tar.gz
RUN tar xf dist.tar.gz  
RUN mv dist/* /usr/share/nginx/html/

# Backend
RUN curl -L https://github.com/linoleparquet/lior-backend/releases/download/latest/lior-0.0.1-SNAPSHOT.jar --output app.jar

# launch frontend and backend servie
RUN nginx
RUN java -jar -Dspring.profiles.active=h2 app.jar