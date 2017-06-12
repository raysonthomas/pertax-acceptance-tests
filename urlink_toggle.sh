#!/bin/bash
sm --stop PERTAX_FRONTEND
sleep 1
sm --start PERTAX_FRONTEND -f --appendArgs '{"PERTAX_FRONTEND":["-Dfeature.ur-link.url=https://zwgy80l7.optimalworkshop.com/treejack/navigation-0"]}'
sleep 3