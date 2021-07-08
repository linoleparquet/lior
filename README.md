# Lior

Lior is a [CRM](https://www.salesforce.com/crm/what-is-crm/) tool tailored for medical representative.

The backend part is in Java using the Spring framework, and the frontend part is in JS using the Angular framework.

## Main features 
- Find a route
- Remind which docter you need to see 

xxx Add a photo xxx

## Installation

### The easy way

Use the docker image available at `xxxxx`
`docker run -p 8080:8080 linoleparquet/lior`

### The hard way

Build and run the jar:
```bash
jar cf lior-backend.jar lior-backend/src (or something like that lol)
java -jar lior-backend.jar
```

Build and run the angular application
```
npm i 
npm start
```

Java v1.8
Node v10

## Usage

To document

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)