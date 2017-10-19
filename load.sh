#!/usr/bin/env bash
curl -X POST http://localhost:8080/api/user -i -H 'content-type: application/json' -d '{ "name":"foo" }'
curl -X POST http://localhost:8080/api/user -i -H 'content-type: application/json' -d '{ "name":"bar" }'
curl http://localhost:8080/api/all