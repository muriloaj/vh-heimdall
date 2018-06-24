# vh-heimdall
Login validation API validating user + password and also managing REDIS

## To compile and execute:
./gradlew clean run

## endpoints
- port application - 8881
  - POST "/token/issue/{userid}" : return token validated by redis 
  - POST "/token/validate" : validate if token is valid. input, json returned by issue endpoint
  - POST "/token/revogate" : revogate token if it is valid. input, same input as validate endpoint
  
 ## redis
 to start redis, in development environment, you can use docker;
 
 $ docker run -p 6379:6379 --name myredis redis
