FROM jenkins/jenkins:lts

ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false

COPY --chown=jenkins:jenkins plugins.txt /usr/share/jenkins/ref/plugins.txt
COPY --chown=jenkins:jenkins job_dsl.groovy /var/jenkins_home/job_dsl.groovy

RUN jenkins-plugin-cli -f /usr/share/jenkins/ref/plugins.txt