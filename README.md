# Lior

Lior is a [CRM](https://www.salesforce.com/crm/what-is-crm/) tool tailored for medical representative. It help them manage their times and theirs planning.

![Lior's interface](images/lior-interface.gif)

## Main features 

- List every doctor you planned to see, depending on the schedule you set (every one month, every 6 months, etc) and the last time you visited them. 
- Find the optimal path to visit most of them within a day.  

## Technical aspects

The [backend part](https://github.com/linoleparquet/lior-backend) is coded in Java using the Spring framework. It's a Spring Boot application that opens the port 8080 to expose its API. It embeed a H2 database to store user's informations. 
The lone backend container can be pulled from this command: `docker pull ghcr.io/linoleparquet/lior-backend:master`

The [frontend part](https://github.com/linoleparquet/lior-frontend) is coded in HTML/CSS/JavaScipt using the Angular framework.
The lone frontend container can be pulled from this command: `docker pull ghcr.io/linoleparquet/lior-backend:master`

### Installation

### Docker compose
You need to have [docker](https://www.docker.com/) installed on your machine. 

``` docker-compose up -d```

### Kubernetes

You need to have [Kubernetes](https://kubernetes.io/fr/) installed on your cluster, and [Helm](https://helm.sh/) installed on your machine.

https://helm.sh/

``` helm install lior ./lior-helm --namespace=lior-helm --create-namespace ```

Caution: The nameof the chart must be `lior`. The nginx configuration require that.

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.
Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)

