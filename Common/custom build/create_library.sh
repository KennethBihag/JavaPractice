#! /bin/bash

srcDir="./custom build/production/"
srcFiles=Trial.class
outputDir="./custom build/artifacts/"
jarName=CommonLib.jar

./custom\ build/compile\ lib\ classes.sh

jar -cfv "$outputDir$jarName" -C "$srcDir" "$srcFiles"
