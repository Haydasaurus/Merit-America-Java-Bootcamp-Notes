# This script validates that the students completed the steps as
# specified in the README correctly.

EXERCISE_FOLDER=$(pwd)
COMMANDS_FOLDER=$EXERCISE_FOLDER/commands/
BASE=~/.temp/m1d1
PRJS=$BASE/projects
NOTES=$BASE/notes
TEST_FILE=testfile.txt
FOO_FILE=foo.txt
BAR_FILE=bar.txt
STEP=0
PREVSTEP=0

echo ""
echo "---- VERIFYING PART 2 ---- "
echo ""

FILES=(     "01_create_directory.txt"
            "02_create_directory_home.txt"
            "03_change_directory.txt"
            "04_change_directory_up.txt"
            "05_change_directory_root.txt"
            "06_remove_directory.txt"
            "07_list_directory_contents.txt"
            "08_list_subdirectory_contents.txt"
            "09_copy_file.txt"
            "10_move_file.txt"
            "11_rename_file.txt"
        )
RESULTS=(   "notes" #1
            "" #2
            $PRJS #3
            $BASE #4
            "/usr" #5
            $FOO_FILE$TEST_FILE #6
            $BAR_FILE$FOO_FILE$TEST_FILE #7
            $BAR_FILE$FOO_FILE #8
            "baz.txt$FOO_FILE" #9
            "dolor.sitlorem.txt" #10
            "buzz.txtlorem.txt" #11
        )
STEPTEXT=(  "Create a new directory called \"notes\" in your current directory" #1
            "Create a new directory called \"work\" in your home directory" #2
            "Change your current working directory to a subfolder named \"projects\"" #3
            "Change your current working directory to the parent directory" #4
            "Change your current working directory to a directory at the root of the file system named \"usr\"" #5
            "Remove a directory called \"temp\" in your current directory" #6
            "List the contents of the current directory" #7
            "List the contents of a subfolder named \"notes\"" #8
            "Create a copy of \"foo.txt\" named \"baz.txt\"" #9
            "Move a file named \"lorem.txt\" into a subfolder named \"ipsum\"" #10
            "Rename the file \"fizz.txt\" to \"buzz.txt\"" #11
        )
PASSED_EXERCISES=()

FILECOUNT=${#FILES[@]}

function testStudentCommand() {
    CMD=$1
    STEP=$2
    if [[ "$CMD" == "rm -rf /"* ]]; then
        CMD=""
    fi
    if [[ $STEP == 1 ]]; then
        mkdir -p $BASE
        cd $BASE
        $CMD
        RESULT=$(ls)
        # echo ${RESULT//[$'\r\n']}
        if [[ ${RESULT//[$'\r\n']} == ${RESULTS[$STEP-1]} ]]; then
            PASSED_EXERCISES+=($STEP)
        fi
        ## clean up
        rmdir notes 2> /dev/null
        cd $EXERCISE_FOLDER
        rm -rf $BASE
    fi
    if [[ $STEP == 2 ]]; then
        cd $EXERCISE_FOLDER
        if [[ "$CMD" == *"~"* ]]; then
            CMD=${CMD//[$'~']/$HOME} # Tilde expansion only happens when the tilde is unquoted, replace with $HOME (https://stackoverflow.com/a/8409034/1034308)
        fi
        $CMD
        if [[ -d ~/work ]]; then
            PASSED_EXERCISES+=($STEP)
            ## clean up
            rmdir ~/work
        fi
    fi
    if [[ $STEP == 3 ]]; then
        mkdir -p $PRJS
        cd $BASE
        $CMD
        RESULT=$(pwd)
        # echo ${RESULT//[$'\r\n']}
        if [[ ${RESULT//[$'\r\n']} == *${RESULTS[$STEP-1]} ]]; then
            PASSED_EXERCISES+=($STEP)
        fi
        ## clean up
        cd $EXERCISE_FOLDER
        rm -rf $BASE
    fi
    if [[ $STEP == 4 ]]; then
        mkdir -p $PRJS
        cd $PRJS
        if [[ $CMD != *".."* ]]; then # must use `..`
            continue
        fi
        $CMD
        RESULT=$(pwd)
        # echo ${RESULT//[$'\r\n']}
        if [[ ${RESULT//[$'\r\n']} == *${RESULTS[$STEP-1]} ]]; then
            PASSED_EXERCISES+=($STEP)
        fi
        ## clean up
        cd $EXERCISE_FOLDER
        rm -rf $BASE
    fi
    if [[ $STEP == 5 ]]; then
        $CMD
        RESULT=$(pwd)
        # echo ${RESULT//[$'\r\n']}
        if [[ ${RESULT//[$'\r\n']} == *${RESULTS[$STEP-1]} ]]; then
            PASSED_EXERCISES+=($STEP)
        fi
    fi
    if [[ $STEP == 6 ]]; then
        mkdir -p $BASE/temp
        cd $BASE
        touch $TEST_FILE
        touch $FOO_FILE
        $CMD
        RESULT=$(ls)
        # echo ${RESULT//[$'\r\n']}
        if [[ ${RESULT//[$'\r\n']} == *${RESULTS[$STEP-1]} ]]; then
            PASSED_EXERCISES+=($STEP)
        fi
        ## clean up
        cd $EXERCISE_FOLDER
        rm -rf $BASE
    fi
    if [[ $STEP == 7 ]]; then
        mkdir -p $BASE
        cd $BASE
        touch $TEST_FILE
        touch $FOO_FILE
        touch $BAR_FILE
        RESULT=$($CMD)
        # echo ${RESULT//[$'\r\n']}
        if [[ ${RESULT//[$'\r\n']} == *${RESULTS[$STEP-1]} ]]; then
            PASSED_EXERCISES+=($STEP)
        fi
        ## clean up
        cd $EXERCISE_FOLDER
        rm -rf $BASE
    fi
    if [[ $STEP == 8 ]]; then
        mkdir -p $NOTES
        cd $NOTES
        touch $FOO_FILE
        touch $BAR_FILE
        cd ..
        RESULT=$($CMD)
        # echo ${RESULT//[$'\r\n']}
        if [[ ${RESULT//[$'\r\n']} == *${RESULTS[$STEP-1]} ]]; then
            PASSED_EXERCISES+=($STEP)
        fi
        ## clean up
        cd $EXERCISE_FOLDER
        rm -rf $BASE
    fi
    if [[ $STEP == 9 ]]; then
        mkdir -p $BASE
        cd $BASE
        touch $FOO_FILE
        $CMD
        RESULT=$(ls)
        # echo ${RESULT//[$'\r\n']}
        if [[ ${RESULT//[$'\r\n']} == *${RESULTS[$STEP-1]} ]]; then
            PASSED_EXERCISES+=($STEP)
        fi
        ## clean up
        cd $EXERCISE_FOLDER
        rm -rf $BASE
    fi
    if [[ $STEP == 10 ]]; then
        mkdir -p $BASE/ipsum
        cd $BASE
        touch lorem.txt
        touch ipsum/dolor.sit
        $CMD
        RESULT=$(ls ipsum)
        # echo ${RESULT//[$'\r\n']}
        if [[ ${RESULT//[$'\r\n']} == *${RESULTS[$STEP-1]} ]]; then
            PASSED_EXERCISES+=($STEP)
        fi
        ## clean up
        cd $EXERCISE_FOLDER
        rm -rf $BASE
    fi
    if [[ $STEP == 11 ]]; then
        mkdir -p $BASE
        cd $BASE
        touch lorem.txt
        touch fizz.txt
        $CMD
        RESULT=$(ls)
        # echo ${RESULT//[$'\r\n']}
        if [[ ${RESULT//[$'\r\n']} == *${RESULTS[$STEP-1]} ]]; then
            PASSED_EXERCISES+=($STEP)
        fi
        ## clean up
        cd $EXERCISE_FOLDER
        rm -rf $BASE
    fi
}

# loop through files
for (( i = 1; i <= $FILECOUNT; i++ ))
do

    # file needs to end in newline so command is read properly
    if [[ $(tail -1c $COMMANDS_FOLDER${FILES[$i-1]} | wc -l | awk '{$1=$1};1') == 0 ]]; then
        echo >> $COMMANDS_FOLDER${FILES[$i-1]}
    fi

    while IFS= read -r line
    do
        if [[ -n ${line//[$'\r\n ']} && "$line" != "#"* ]]; then
            testStudentCommand "${line//[$'\r\n']}" $i
        fi
    done < $COMMANDS_FOLDER${FILES[$i-1]}

done

PASSED_COUNT="${#PASSED_EXERCISES[@]}"
EXERCISE_COUNT="${#RESULTS[@]}"

for (( i = 1; i <= $EXERCISE_COUNT; i++ ))
do
    if ([[ " ${PASSED_EXERCISES[@]} " =~ " ${i} " ]]); then
        echo "✅ $i. ${STEPTEXT[$i-1]}"
    else
        echo "❗️$i. ${STEPTEXT[$i-1]}"
    fi
done

echo ""
echo "Total tests: $EXERCISE_COUNT"
echo "Tests passed: $PASSED_COUNT"
echo ""

if ((PASSED_COUNT==EXERCISE_COUNT)); then
    echo "Congratulations! All tests in Part 2 are passing."
    #echo "Continue on to the next step in the README to submit your exercise."
    echo ""
fi

if ((PASSED_COUNT<EXERCISE_COUNT)); then
    echo " Review the commands you wrote in the command files."
    echo " If you're having difficulty troubleshooting, try the following:"
    echo " - Create the same folders or files, then try running your commands manually."
    echo " - If there are any error messages above, use them to try to diagnose why a test is failing."
    echo " - Check for typos in the names of folders or file paths."
    echo " - Make sure to save before running the tests."
    echo ""
fi
