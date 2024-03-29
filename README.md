<img src="images/logo.png" style="width:20%;height:20%;" align="right" />

# Lior: A CRM for Medical Sales Representatives

Lior is a [CRM](https://www.salesforce.com/crm/what-is-crm/) tool tailored specifically for use by **medical sales representatives**.  
The tool enables a frictionless smart envrionment in the management and execution for **client scheduling** and **route optimization**.

## Main features

- 👨‍🦱 Client Database
- ⏱ Schedule Optimization
- 🚗 Route Optimization
- 📃 Other custom features such as: Notes, Reminders, Calendar, etc

## Demonstration

![Route Display](images/route-display.gif)

## How to use the application?

![Lior's interface](images/dashboard.png)

### Step 1

The user creates an entry for a medical client with all relevant personal information, as well as the frequency of the desired visit times.

### Step 2

The user documents the last known date of a visit with a client, and the program automatically sets up the following visit per the frequency request in Step 1.

- if the date is within the actual month, the doctor will appear on the "Active Appointments" table
- if the date is already passed, the doctor will appear on the "Missed Appointments" table
- if the doctor haven't been visited yet, he will appear on the "Prospects" table
  The combination of the three tables form a complete list of doctors to visit. It represents the inputs for the calculation of the optimal path for the day.

### Step 3

The user plans their route for the visits by inputting a departure and arrival location, indicated the departure hour, and arrival hour in the settings tab.

### Step 4

The user finalizes all inputs and clicks the button "Find Route". The program will then combine the route inputs with the visit locations and schedule, and produce an optimal route for the user. The route will be displayed through a map and a timetable of visits, to the preference of the user.

## Technical aspects

The [backend part](https://github.com/linoleparquet/lior-backend) is a Java Spring project. It embeed a H2 database to store user's informations.
The lone backend container can be pulled from this command: `docker pull ghcr.io/linoleparquet/lior-backend`

The [frontend part](https://github.com/linoleparquet/lior-frontend) is an Angular project.
The lone frontend container can be pulled from this command: `docker pull ghcr.io/linoleparquet/lior-backend`

## Deployment

The application can be deployed using two ways: Docker Compose or Kubernetes.

### Docker Compose

Requirement:
[Git](git.com), [Docker](https://www.docker.com/) and [Docker-Compose](https://docs.docker.com/compose/) need to be installed on your machine.

Open a terminal, and run the following script:

```
git clone https://github.com/linoleparquet/lior --depth 1
docker-compose -f lior/docker-compose.yaml up
```

The application is available at `http://localhost`

### Kubernetes

Requirements:
[Kubernetes](https://kubernetes.io/fr/) needs to be installed on your cluster. [Git](git.com) and [Helm](https://helm.sh/) needs to be installed on the machine.

```
git clone https://github.com/linoleparquet/lior --depth 1
cd lior
helm install lior chart --namespace=lior --create-namespace
```

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.
Please make sure to update tests as appropriate.

## License

[MIT](https://choosealicense.com/licenses/mit/)
