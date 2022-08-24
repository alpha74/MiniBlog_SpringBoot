# Notes

#### Udemy Course link: [Click](https://groww.udemy.com/course/microservices-with-spring-boot-and-spring-cloud/learn/lecture/8005680#overview)

## Enable Spring Debug mode

- In `application.properties`, add this:

```
logging.level.org.springframework = debug
``` 

## Making DateUtil date to not return timestamp

- This value is `false` now by default.
- In `application.properties`, add this:

```
spring.jackson.serialization.write-dates-as-timestamps=false
```


## Versioning the APIs

#### Media Type Versioning

- a.k.a `Content Negotiation` or `Accept` header. 
- Used by `Github`.

#### Custom Headers versioning. 

- Used by `Microsoft`.

#### URI Versioning

- Used by `Twitter`.

#### Request Parameter Versioning

- Used by `Amazon`.


### Factors affecting versioning:

- URI Pollution
- Misuse of HTTP Headers
- Caching
- Can request be executed on browser?
- API Documentation






