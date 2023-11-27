#! /bin/bash

binDir=./custom\ build/production/
srcDir=./src/
artDir=./custom\ build/artifacts
jars="CommonLib"

function getClassInfo(){
    javap -s -cp "$artDir/CommonLib.jar" $@
}

function getJarInfo(){
    for j in $jars
    do
    Echo Info on $j:
        while IFS= read line
        do
            echo -e "\t$line"
        done< <(jar -t -f "$artDir/$j.jar")
    done
}

if [ -z $1 ]
then
    echo Usage: \<function_name\> [args]
    exit 1
fi

funcs="getClassInfo getJarInfo"

case "$1" in
    "getClassInfo")
        getClassInfo \
        Practice.annotations.MyAnnotations.AnnotationClient \
        Practice.annotations.MyAnnotations.Trials\
        ;;
    "getJarInfo")
        getJarInfo CommonLib.jar;;
esac
