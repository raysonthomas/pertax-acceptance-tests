#!/bin/bash
mongo attorney --eval 'db.dropDatabase()'
mongo auth --eval 'db.dropDatabase()'
mongo email --eval 'db.dropDatabase()'
mongo keystore --eval 'db.dropDatabase()'
mongo user-details --eval 'db.dropDatabase()'
