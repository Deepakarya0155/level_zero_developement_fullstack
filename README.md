# level_zero_developement_fullstack

# level_zero_development

config server repo : https://github.com/Deepakarya0155/MicrosServices/tree/main/ConfigCloud/ConfigServer

task to do next
eurka server :


0. uncomment admin username & password if commented in docker compose file.
1. login to keyclock and create releam <Name>.
2. create client under that releam which you created in step 2
3. create user
4. update releam in spring boot application properties
5. update releam and client id in angular



setup task ::
    keyclock ::  relem ceration , setting proper grant type, create test user
    sprintg :: change in authresouce url releam
    angular :: keyclock function change






-------------------------------------------------
Angular 
    

keyclockserver 

http://localhost:8090/auth/realms/levelzerofullstack/protocol/openid-connect/auth?client_id=levelzero&redirect_uri=http://localhost:4200/&response_type=code&scope=openid