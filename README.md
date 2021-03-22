# kesko-factory
Sample factory service. This service be default tuns on port `8080`.

The API receives the number of chocolate bars needed by the user, the prices of bars, packs and boxes,
and the number of bars included in a pack and box. The API then returns the cheapest combination of boxes, packs and individual bars to satisfy the
requirement, as well as the total price.

Once you start the service use tthe heath check service to test the service.
`http://localhost:8080/health`

This service consumes and produces `application/json`. Model input looks as below:

```
{
    "count": 895,
    "barPrice": 2.5,
    "packPrice": 80,
    "boxPrice": 400,
    "packSize": 40,
    "boxSize": 200
}
```
Result looks as below:

```
{
    "boxCount": 4,
    "packCount": 2,
    "barCount": 15,
    "totalPrice": 1797.5
}
```

# Running this service
To run the service use the below command

`mvn spring-boot:run`

# Testing the service
To test the service use the below command

`mvn clean test`