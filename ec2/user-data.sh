echo ' --- Install nginx and java ---'
sudo amazon-linux-extras install -y nginx1 java-openjdk11;

echo ' --- Download frontend application ---'
curl -L https://github.com/linoleparquet/lior-frontend/releases/download/latest/dist.tar.gz -o dist.tar.gz;
sudo tar xf dist.tar.gz;
sudo mv dist/* /usr/share/nginx/html/;

echo ' --- Deploying nginx configuration ---'
sudo bash -c 'cat <<EOF > /etc/nginx/conf.d/default.conf
server {
    listen 80;
    root /usr/share/nginx/html;

    location /api {
        proxy_pass http://localhost:8080/;
    }
}
EOF'
sudo chown nginx:nginx /etc/nginx/conf.d/default.conf

echo ' --- Download backend application ---'
sudo mkdir /home/ec2-user/lior/
sudo chown ec2-user:ec2-user /home/ec2-user/lior/
sudo curl -L https://github.com/linoleparquet/lior-backend/releases/download/latest/lior-0.0.1-SNAPSHOT.jar --output /home/ec2-user/lior/lior.jar
sudo chown ec2-user:ec2-user /home/ec2-user/lior/lior.jar

# Define service
sudo bash -c 'cat <<EOF > /etc/systemd/system/lior.service
[Unit]
Description=Lior backend service
After=syslog.target network.target

[Service]
User=ec2-user   

WorkingDirectory=/home/ec2-user/lior/

ExecStart=/usr/bin/java -jar -Dspring.profiles.active=h2 /home/ec2-user/lior/lior.jar
ExecStop=/bin/kill -15 $MAINPID

SuccessExitStatus=143
TimeoutStopSec=10

Restart=on-failure
RestartSec=5

[Install]
WantedBy=multi-user.target
EOF
'

echo ' --- Enable nginx and java service ---'
sudo systemctl daemon-reload
sudo systemctl start lior.service
sudo systemctl enable lior.service 
sudo systemctl start nginx; 
sudo systemctl enable nginx;

echo ' --- All done !!! ---'