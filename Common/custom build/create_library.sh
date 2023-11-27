#! /bin/bash

jarDir=./custom\ build/artifacts/
jarName=CommonLib.jar

./custom\ build/compile\ lib\ classes.sh

jar -cfv "$jarDir$jarName" -C "$prodDir" .
