#!/bin/sh

imageName=hlssmobit/k8s-ocp-view

echo "Iniciando build da imagem $imageName"

cd .. || exit

docker build -f Dockerfile-with-build -t $imageName . || exit

docker push $imageName
