# post-test

# Run server
Build jar file into target folder
- get into postwall project
- run "mvn clean install -Dmaven.test.skip"
- get into target folder
- run the jar file postwall-0.0.1-SNAPSHOT.jar

Kill the server from windows.
- netstat -ano | findstr :80
- taskkill /PID Pid_number /F

Kill the server from linux.
- In linux, the process is running in the console, ctrl-c will terminate the process.


# Run web
- get into post-web folder
- run yarn install
- run yarn start

# Failed running web
- Please check if has node.js, npm and yarn installed in your machine.
- install on windows 
-- node.js and npm, download installer from https://nodejs.org/en/download/
-- yarn, run "npm install --global yarn" to install yarn.

- install on ubuntu
-- node.js and npm, run commands "sudo apt install nodejs", "sudo apt install npm"
-- yarn, run "npm install --global yarn" to install yarn.

# Codes analysis
- Please check out zip file processEntitlmentOnRole.zip 
