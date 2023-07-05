def call(ip,creds,warfile){
     // install ssh agent plugin
sshagent([creds]) { 
         // copy war file to tomcat-dev server
             sh "scp -o StrictHostKeyChecking=no target/${warfile} ec2-user@${ip}:/opt/tomcat/webapps"
             // restart tomcat
             sh "ssh ec2-user@${ip} /opt/tomcat/bin/shutdown.sh"
             sh "ssh ec2-user@${ip} /opt/tomcat/bin/startup.sh"
 }
}
