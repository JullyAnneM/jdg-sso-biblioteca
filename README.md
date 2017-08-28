# Red Hat JBoss Data Grid + Single-Sign On with RESTful API

## Overview
This Maven Project uses JBoss Data Grid to persist information sent through a RESTful API, authenticated with Red Hat Single-Sign On.

## Prerequisites
* Red Hat JBoss Enterprise Application Platform
* Red Hat JBoss Developer Studio
* Red Hat JBoss Data Grid
* Red Hat Single-Sign On
* A browser or Postman API

## Installation and Configuration
### Installation of all 
1. At https://access.redhat.com, download and unzip the following files into the desired folder: 
* Server file for Red Hat JBoss Enterprise Application Platform, Data Grid and Single-Sign On.
* Jar installer for JBoss Developer Studio.
* Maven Repository for Red Hat JBoss Data Grid.
2. For Postman, go to www.getpostman.com and download it.

### Configuration
#### Red Hat JBoss Developer Studio
1. Open the Servers tab.
2. Click on the `No servers are available. Click this link to create a new server..` link.
3. Expand Red Hat JBoss Middleware and choose JBoss Enterprise Application Platform 7.0. Enter a server name then click Next.
2. Create a server adapter to manage starting and stopping the server. Keep the defaults and click Next.
3. Enter a name, for example JBoss EAP 7.0 Runtime. Click `Browse next to Home Directory` and navigate to your JBoss EAP installation directory, then click Finish.

#### Red Hat JBoss Data Grid
1. Go to Maven `${user.home}/.m2` directory.
2. Check if theres a file named `settings.xml`. If not, create one. 
3. Update the `settings.xml` file as follows:
```
<?xml version="1.0" encoding="UTF-8"?>

<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd">

   <profiles>
      <profile>
         <id>jboss-datagrid-repository</id>
         <repositories>
            <repository>
               <id>jboss-datagrid-repository</id>
               <name>JBoss Data Grid Maven Repository</name>
               <url>file:///path/to/jboss-datagrid-7.0.0.GA-maven-repository/maven-repository</url>
               <layout>default</layout>
               <releases>
                  <enabled>true</enabled>
                  <updatePolicy>never</updatePolicy>
               </releases>
               <snapshots>
                  <enabled>false</enabled>
                  <updatePolicy>never</updatePolicy>
               </snapshots>
            </repository>
         <pluginRepositories>
            <pluginRepository>
               <id>jboss-datagrid-repository</id>
               <name>JBoss Data Grid Maven Repository</name>
               <url>file:///path/to/jboss-datagrid-7.0.0.GA-maven-repository/maven-repository</url>
               <layout>default</layout>
               <releases>
                  <enabled>true</enabled>
                  <updatePolicy>never</updatePolicy>
               </releases>
               <snapshots>
                  <enabled>false</enabled>
                  <updatePolicy>never</updatePolicy>
               </snapshots>
            </pluginRepository>
         </pluginRepositories>
      </profile>
   </profiles>
   <activeProfiles>
      <!-- make the profile active by default -->
      <activeProfile>jboss-datagrid-repository</activeProfile>
   </activeProfiles>
</settings>
```
3. Make sure to change the path correctly in the settings.xml file to your Data Grid Server repository.

#### Red Hat Single-Sign On
1. Boot the Server with `./standalone.sh` and open your browser at http://localhost:8080/auth. 
2. Create a username/password and go to http://localhost:8080/auth/admin. 
3. Log in with your new admin user.
4. Go to `Users` and add a new one at `Add User`. This will be the user required to log into your jsp page.
5. Change the password at `Credentials` and make sure the Temporary button is off.
6. Go to `Clients` and click on `Create`.
7. Set the id name as the same name of the application (in this case, data_grid-0.0.1-SNAPSHOT).
8. Make sure that the URLs are all set to `http` instead of `https`. 
9. Go to the `Installation` tab and copy the generated adapter selecting `Keycloak OIDC JBoss Subsystem XML`. It will be similar to: 
```
<secure-deployment name="WAR MODULE NAME.war">
    <realm>demo</realm>
    <auth-server-url>http://localhost:8180/auth</auth-server-url>
    <public-client>true</public-client>
    <ssl-required>EXTERNAL</ssl-required>
    <resource>data_grid-0.0.1-SNAPSHOT</resource>
</secure-deployment>

```
10. Copy and paste it in JBoss Enterprise Application Platform standalone.xml file, at the Keycloak Subsystem tag.
11. Replace the WAR MODULE NAME with the application name, in this case: data_grid-0.0.1-SNAPSHOT. Save it.

## Standalone Deployment 
1. Import the project downloaded here. 
2. Right-click the project in the `Project Explorer` tab and select `Run As → Run on Server`.
3. Boot the Data Grid Server with a different port using the following command: 
```
./standalone.sh -Djboss.socket.binding.port-offset=OFFSET_NUMBER_HERE
```
4. Do the same with the Single-Sign On Server using another different port.
5. Go to `localhost:8080/data_grid-0.0.1-SNAPSHOT/api` and log in using the user created at the admin page of Single-Sign On.
6. Persist the information desired and retrieve it.

## Commands using Postman instead of the JSP page: 
* Persisting Data (make sure to set it to POST):
``` 
http://localhost:8080/data_grid-0.0.1-SNAPSHOT/api/rest/persist?titulo={title}&isbn={isbn_number}&autor={autor}
http://localhost:8080/data_grid-0.0.1-SNAPSHOT/api/rest/persist?titulo=Outlander&isbn=123456&autor=Diana 
```

* Retrieving Data (make sure to set it to GET):
``` 
http://localhost:8080/data_grid-0.0.1-SNAPSHOT/api/rest/get?isbn={isbn_number}
http://localhost:8080/data_grid-0.0.1-SNAPSHOT/api/rest/get?isbn=123456
```

## Useful links
* Any trouble with installation and setup can be solved at https://access.redhat.com with the Documentation or Knowledgebase.
