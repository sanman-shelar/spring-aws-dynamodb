# Spring Boot REST using Amazon DynamoDB [![License: MIT](https://img.shields.io/badge/License-MIT-green.svg)]()

Demo project to showcase capabilites of Amazon DynamoDB.

# Requirements
  - Java 11
  - Docker 19.03.xx
  - AWS CLI

### Setup

Setup AWS region and credentials
```sh
$ aws configure
```
\
Create a new docker volumne for DynamoDB
```sh
$ docker volume create --name=dynamodata
```
\
Spin up a new local instance of DynamoDB
```sh
$ docker-compose -f docker-compose-local.yml up -d
```
\
Create a table in DynamoDB
```sh
$ aws dynamodb --endpoint-url http://localhost:8000 create-table --table-name person-info --attribute-definitions AttributeName=id,AttributeType=S --key-schema AttributeName=id,KeyType=HASH --provisioned-throughput ReadCapacityUnits=5,WriteCapacityUnits=5
```
\
List available tables under DynamoDB
```sh
$ aws dynamodb list-tables --endpoint http://localhost:8000
```
\
View data for a table
```sh
$ aws dynamodb scan --table-name person-info --endpoint-url http://localhost:8000
```
\
Stop DynamoDB instance
```sh
$ docker-compose -f docker-compose-local.yml down
```
