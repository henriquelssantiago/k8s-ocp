#!/bin/sh

build=true;

while getopts b: flag
do
    case "${flag}" in
        b) build=${OPTARG};;
    esac
done

echo $build

imageName=hlssmobit/k8s-ocp-view

echo "Iniciando build da imagem $imageName"

cd .. || exit


# Buildar aplicação
if [ $build = true ]
then
  npm install
  ng build -c production
pwd
fi

docker build -t $imageName . || exit

docker push $imageName
