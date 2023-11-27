#! /bin/bash

willBuild=1
pkgDirs=(\
    Practice/annotations\
    Practice/Geometry\
    Practice/jdbc\
)

pkgDir1="${pkgDirs[0]}"
pkgDir2="${pkgDirs[1]}"
pkgDir3="${pkgDirs[2]}"
srcPaths=(\
    "$srcDir/$pkgDir1/MyAnnotations.java"\
    "$srcDir/$pkgDir2/Faces.java"\
    "$srcDir/$pkgDir2/Geometry.java"\
    "$srcDir/$pkgDir2/Vertices.java"\
    "$srcDir/$pkgDir3/MyException.java"\
    "$srcDir/$pkgDir3/MyPooler.java"\
    "$srcDir/$pkgDir3/MySqlConn.java"\
)

# check if classes already built
for sp in $srcPaths
do
    classPath="$prodDir/${sp//$srcDir/}"
    classPath="${classPath//.java/.class}"
    if [ -a "$classPath" ]
    then
        echo "$classPath is already built."
    else
        echo "$classPath is missing"
        willBuild=0
        break
    fi
done

if (($willBuild != 0))
then
    echo "Library classes already compiled."
    exit 1
fi

javac -cp "$thirdPartyPaths" --source-path "$srcDir" -d "$prodDir" \
    --release 11 "${srcPaths[@]}"

exit 0
