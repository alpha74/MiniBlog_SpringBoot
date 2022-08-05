# Users and Posts App

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

- In `application.properties`, add this code

```
logging.level.org.springframework = debug
``` 


----

## Theory

### Dispatcher Servlet

