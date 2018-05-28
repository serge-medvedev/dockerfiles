[Riemann](http://riemann.io/) monitors distributed systems.

### Usage

```
docker run -d -p 5555:5555 -p 5555:5555/udp -p 5556:5556 thismoment/riemann
```

With customized configuration file:

```
docker run -d \
    -p 5555:5555 \
    -p 5555:5555/udp \
    -p 5556:5556 \
    -v ./riemann.config:/etc/riemann.config
    thismoment/riemann
```

_Note_: to use a version with **healthcheck** functionality built in, specify respective image tag:

```
docker run -d -p 5555:5555 -p 5555:5555/udp -p 5556:5556 thismoment/riemann:healthcheck
```

