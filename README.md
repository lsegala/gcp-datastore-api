# Run mongodb

## Se for a primeira vez que for executar o container:
```
$ docker pull mongo
$ docker run -d -p 27017-27019:27017-27019 -e MONGODB_DATABASE=test --name mongodb mongo
```

## Se o container já existir

```
$ docker start <CONTAINER_ID>
```