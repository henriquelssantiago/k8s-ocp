#!/bin/sh

imageName=hlssmobit/k8s-ocp-spring

cd .. || exit

mvn clean package -DskipTests=true || exit

docker build -t $imageName . || exit

docker push $imageName