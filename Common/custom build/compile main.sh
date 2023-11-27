#! /bin/bash

libFile=./custom\ build/artifacts/CommonLib.jar
srcDir=./src
srcFiles=Main.java
prodDir=./custom\ build/production

thirdPartyLibs=/c/Users/kenneth.bihag/IdeaProjects/downloaded_libs
hikari=HikariCP
jdbc=mysql_jdbc
concatScript=/c/Users/kenneth.bihag/personal\ repository/bash/fileToString.sh
hikariPaths=$("$concatScript" toDelimitedList "$thirdPartyLibs/$hikari" :)
jdbcPaths=$("$concatScript" toDelimitedList "$thirdPartyLibs/$jdbc" :)
thirdPartyPaths="$hikariPaths:$jdbcPaths"

export prodDir
export thirdPartyPaths
export srcDir

./custom\ build/create_library.sh

while IFS= read cpath
do
    if [ -d "$prodDir/$cpath" ]
    then
        rm -fR "$prodDir/$cpath"
    fi
done < <(ls "$prodDir")

javac --release 11 --source-path "$srcDir" -cp "$libFile:$thirdPartyPaths"\
      -d "$prodDir" "$srcDir/$srcFiles"

# jar -c -f MyApplication.jar -e Main -C "$prodDir" "Main.class"
