#!/bin/bash
sm --stop PERTAX_FRONTEND
sleep 3
sm --start PERTAX_FRONTEND -f --appendArgs '{"PERTAX_FRONTEND":["-Dfeature.tax-credits.enabled=false"]}'
sleep 5