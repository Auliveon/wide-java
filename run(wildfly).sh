export JAVA_HOME=/usr/lib/jvm/jdk1.8.0_301
mvn clean install;
cp -f /home/savitsky/Java/projects/wide-java/wide-java-rest/wide-java-rest-web/target/wide-java-0.1-dev.war /home/savitsky/Java/projects/wildfly-20.0.0.Final/standalone/deployments/wide-java-0.1-dev.war
sh /home/savitsky/Java/projects/wildfly-20.0.0.Final/bin/standalone.sh -b 0.0.0.0