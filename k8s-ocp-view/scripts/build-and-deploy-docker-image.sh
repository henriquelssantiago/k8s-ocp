#!/bin/sh

imageName=hlssmobit/k8s-ocp-view:latest

echo "Iniciando build da imagem $imageName"

cd .. || exit

#npm install
#
#ng build -c production

docker build -t $imageName . || exit

docker push $imageName
