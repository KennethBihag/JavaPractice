#! /bin/bash

deps=web
projName=MySpringMVC


options=\
-a\ ${projName@L}\ \
-d\ $deps\ \
--type\ maven-project\ \
-g\ com.kenneth\ \
-j\ 11

location="$projName"

spring init $options --description "Basic MVC Project. Just testing concepts." "$location"

# echo $options $location
