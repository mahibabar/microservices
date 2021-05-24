# microservices
This app contains three services
1. movie-info-service(deployed on 8081 port)
2. ratings-data-service(deployed on 8082 port)
3. movie-catalog-service(deployed on 8083 port)
4. discover-server(deployed on 8085 port)

Movie-catalog-service calls other two services to get hard coded data of movies with ratings given by user and retuns a list of movies with ratings provided by user

To test you need to call:
http://localhost:8083/catalog/1

**Basic microservices with service discovery enabled**
git checkout e7a2fe594cdee6403845063672258471c0d4575d
