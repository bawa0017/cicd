def call(String app12, String username , String reponame , String version){ 
sh "docker build -t ${app12} ."
sh " docker tag ${app12} ${username}/${reponame}:${version}"


}
