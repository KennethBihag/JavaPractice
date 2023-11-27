@echo off
set "libFile=.\custom build\artifacts\CommonLib.jar"
set "prodDir=.\custom build\production"
set "thirdPartyLibs=C:\Users\kenneth.bihag\IdeaProjects\downloaded_libs"
set hikari=HikariCP
set jdbc=msql_jdbc

set "x1=%thirdPartyLibs%\%hikari%\HikariCP-5.0.1.jar"
set "x2=%thirdPartyLibs%\%hikari%\slf4j-api-2.0.0-alpha1.jar"
set "x3=%thirdPartyLibs%\%jdbc%\mysql-connector-java-8.0.30.jar"
set "x4=%thirdPartyLibs%\%jdbc%\protobuf-java-3.19.4.jar"

java -cp "%x1%;%x2%;%x3%;%x4%;%libFile%;%prodDir%" Main
