def call(String url , String branch){
    echo 'Coding Stage'
    git url: "${url}", branch: "${branch}"
    echo 'Code is cloned'

}