#!/bin/bash

echo "Construyendo imágenes Docker..."
docker-compose build

echo "Iniciando contenedores..."
docker-compose up

