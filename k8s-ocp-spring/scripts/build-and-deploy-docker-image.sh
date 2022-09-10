#!/bin/sh

tagVersion=latest
imageName=hlssmobit/k8s-ocp-spring:$tagVersion


cd .. || exit

mvn clean package -DskipTests=true || exit

docker build -t $imageName . || exit

docker push $imageName