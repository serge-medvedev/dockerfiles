FROM alpine as builder

RUN apk update && apk upgrade && apk add \
    build-base \
    g++ \
    git

RUN git clone https://github.com/MarkoPaul0/DatagramTunneler.git /usr/src/app

WORKDIR /usr/src/app

RUN make

FROM alpine

RUN apk update && apk upgrade && apk add \
    libstdc++

COPY --from=builder /usr/src/app/bin /usr/local/bin

ENTRYPOINT ["datagramtunneler"]
