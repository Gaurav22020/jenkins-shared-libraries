def call(String projectname,String version)
{  
  echo 'Building Code'
  sh 'whoami'
  sh "docker build -t ${projectname}:${version} ."
  echo "Docker image is Build"
}