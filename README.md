# Spring Cloud Eureka, Hystrix Example and Monitor

## Components
- `eureka-service` - The Eureka service which is the Service Registry
- `hystrix-server` - The Service which is going to give data to the Client.
- `hystrix-client` - The Service which is going to get data from Server via the Discovery Service from the Service Registry (`eureka-service`).
- `hystrix-monitor` - The Service which is going to get data stream from the Turbine Monitor and Hystrix Dashboard.

## Starter
1. Start `eureka-service`
2. Start `hystrix-client` and `hystrix-server`
3. Start `hystrix-monitor`
4. Eureka: http://localhost:8787
5. Hystrix Stream: http://localhost:8989/hystrix
6. Example Dashboard: http://localhost:8989/hystrix/monitor?stream=http://localhost:8072/hystrix.stream

## Configurations
1. Time which circuit stay OPEN in milliseconds:<br>
`hystrix.command.hello.circuitBreaker.sleepWindowInMilliseconds=10000`

2. Strategy Execution:<br>
`hystrix.command.hello.execution.execution.isolation.strategy=THREAD`
   
3. Timeout of Method:<br>
`hystrix.command.hello.execution.isolation.thread.timeoutInMilliseconds=1000`
   
4. For more methods, add news config properties for this new method, example:<br>
`hystrix.command.<NEW-METHOD-NAME>.execution.isolation.thread.timeoutInMilliseconds`

## Test with Docker
1. After building all projects, execute docker-compose.yml with docker-compose service installed.