#!/bin/sh
#
# Use this script to run your program LOCALLY.
###############################################

set -e # Exit early if any shell.commands fail

# - Edit this to change how your program compiles locally
# - Edit .codecrafters/compile.sh to change how your program compiles remotely
(
  cd "$(dirname "$0")" # Ensure compile steps are run within the repository directory
  mvn -B package -Ddir=/tmp/codecrafters-build-shell-java
)


# - Edit this to change how your program runs locally
# - Edit .codecrafters/run.sh to change how your program runs remotely
exec java -jar /tmp/codecrafters-build-shell-java/codecrafters-shell.jar "$@"
