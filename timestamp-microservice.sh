#!/bin/bash

function build_microservice(){
	mvn -DskipTests clean package
}

# Check if a command has been provided
if ! [[ -z "$1" ]]; then
	case "$1" in
		update)
			git pull
			build_microservice
			;;
		*)
			echo "Invalid command $1"
			;;
	esac
fi

# Check if the jar exists, build it if not
if [[ ! -f 'target/fcc-timestamp-microservice-thorntail.jar' ]]; then
	echo "timestamp-microservice jar not found. Building..."
	build_microservice
fi

java -Xmx512m -jar target/fcc-timestamp-microservice-thorntail.jar
