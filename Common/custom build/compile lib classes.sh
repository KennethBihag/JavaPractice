#! /bin/bash

willBuild=1

srcDir=./src/
srcFiles="Trial.java"
outDir="./custom build/production/"

outFiles="${srcFiles//.java/.class}"
for class in $outFiles
do
    echo -n "$outDir$class "
    if [ -a "$outDir$class" ]
    then
        echo "is already built."
    else
        echo "is missing"
        willBuild=0
        break
    fi
done

if (($willBuild != 0))
then
    echo "Library classes already compiled."
    exit 1
fi

javac --source-path "$srcDir" -d "$outDir" \
    --release 11 "$srcDir$srcFiles"

exit 0
