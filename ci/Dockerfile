FROM jenkins/jenkins:lts

USER root

# Instala Docker dentro del contenedor
RUN apt-get update && \
    apt-get install -y docker.io

# Instala plugins
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN jenkins-plugin-cli --plugin-file /usr/share/jenkins/ref/plugins.txt

USER jenkins
