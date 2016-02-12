#!/bin/bash
clear
echo "-------------------------"
echo "Dropping Mongo Databases"
echo "-------------------------"

mongo <<EOF > databases.txt
show databases
exit
EOF
echo "#!/bin/bash" > tmpScript.sh
cat databases.txt | sed '$d' | awk 'BEGIN{n=2}NR<=n{next}{print "echo \"***Dropping database: " $1 "\"***"}{print "mongo " $1 " --eval " "\"db.dropDatabase()\""}' >> tmpScript.sh
chmod a+x tmpScript.sh
./tmpScript.sh


sbt -Dbrowser=firefox-local -Denvironment=local 'test-only uk.gov.hmrc.integration.cucumber.RunTestSuiteAgent'

exit 0