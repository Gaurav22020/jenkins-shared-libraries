def call(String projectname, String tagname,String dockerusername){
   withCredentials([
                    usernamePassword(
                        credentialsId: 'docker-hub-cred',
                        usernameVariable: 'dockerhubusername',
                        passwordVariable: 'dockerhubpassword'
                    )
                ]) {
                    sh "docker login -u ${dockerhubusername} -p ${dockerhubpassword}"
                    sh "docker image tag ${projectname}:${taganme} ${dockerusername}/
                    ${projectname}:${taganme}"
                    sh "docker push ${dockerusername}/
    ${projectname}:${taganme}"
                }
}