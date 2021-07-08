#!/bin/sh

FULL_PATH_OF_SOAPUI_FOLDER="$( cd "$(dirname "$0")" >/dev/null 2>&1 ; pwd -P )"
SOAPUI_WORKSPACE_FILE=soapui-workspace.xml

cp -f $FULL_PATH_OF_SOAPUI_FOLDER/$SOAPUI_WORKSPACE_FILE.example $FULL_PATH_OF_SOAPUI_FOLDER/$SOAPUI_WORKSPACE_FILE

sed -i -e "s|<con:project name=\"HelloWorldService\">\(.*\)</con:project>|<con:project name=\"HelloWorldService\">$FULL_PATH_OF_SOAPUI_FOLDER/HelloWorldService-soapui-project.xml</con:project>|g" $FULL_PATH_OF_SOAPUI_FOLDER/$SOAPUI_WORKSPACE_FILE

echo "Logs are written to $FULL_PATH_OF_SOAPUI_FOLDER/soapui.log"
SOAPUI="$(which soapui.sh)"

nohup sh -c "\"$SOAPUI\" -w \"$FULL_PATH_OF_SOAPUI_FOLDER\"/$SOAPUI_WORKSPACE_FILE" > $FULL_PATH_OF_SOAPUI_FOLDER/soapui.log &