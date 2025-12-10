def call(String projectname, String tagname, String dockerusername) {

    echo 'Push Code'

    withCredentials([
        usernamePassword(
            credentialsId: 'docker-hub-cred',
            usernameVariable: 'dockerhubusername',
            passwordVariable: 'dockerhubpassword'
        )
    ]) {

        sh "docker login -u ${dockerhubusername} -p ${dockerhubpassword}"

        sh "docker image tag ${projectname}:${tagname} ${dockerusername}/${projectname}:${tagname}"

        sh "docker push ${dockerusername}/${projectname}:${tagname}"
    }

    echo "Pushed code"
}
