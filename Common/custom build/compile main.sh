#! /bin/bash

libFile="./custom build/artifacts/CommonLib.jar"
srcDir="./src/"
srcFiles="Main.java"
outDir="./custom build/production/"

./custom\ build/create_library.sh

javac -cp "$libFile" --release 11 --source-path "$srcDir" \
    -d "$outDir" "$srcDir$srcFiles"
