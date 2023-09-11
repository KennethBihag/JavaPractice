#! /bin/bash

binDirs=('custom build/production/' \
    'custom build/artifacts/')

len=${#binDirs[@]}
: '
toRun="
for n in {1..$len}
do
    echo \"Deleting $(($n-1))...\"
done
"
eval "$toRun"
'
for((i=0;i<len;i++))
do
    # echo "Deleting ${binDirs[$i]}..."
    rm -fR "${binDirs[$i]}"
done
