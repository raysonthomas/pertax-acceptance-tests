#!/bin/bash
echo "***Dropping database: auth"***
mongo auth --eval "db.dropDatabase()"
echo "***Dropping database: message"***
mongo message --eval "db.dropDatabase()"
