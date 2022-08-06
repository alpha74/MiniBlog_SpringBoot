# Users and Posts APIs

## Sping Boot and REST


### APIs

#### GET /healthStatus

- Health Check API
- Returns String response: `status:OK`


#### GET /healthStatusBean
- Health Check API
- Return JSON response

```
{"status":"OK"}
```


----

## Tips

#### Enable Spring Debug mode

- In `application.properties`, add this:

```
logging.level.org.springframework = debug
``` 

#### Making DateUtil date to not return timestamp

- This value is `false` now by default.
- In `application;properties`, add this:

```
spring.jackson.serialization.write-dates-as-timestamps=false
```




