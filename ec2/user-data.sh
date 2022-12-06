sudo amazon-linux-extras install -y nginx1 java-openjdk11;
sudo rm -rf /usr/share/nginx/html/*;
sudo curl -L https://github.com/linoleparquet/lior-frontend/releases/download/latest/dist.tar.gz -o dist.tar.gz;
sudo tar xf dist.tar.gz;
sudo mv dist/* /usr/share/nginx/html/;
sudo nginx; #sudo systemctl enable nginx;


curl -L https://github.com/linoleparquet/lior-backend/releases/download/latest/lior-0.0.1-SNAPSHOT.jar --output app.jar
java -jar -Dspring.profiles.active=h2 app.jar
