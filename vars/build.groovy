def call(String app12, String username , String reponame , String version){
docker build -t "${app12}" .
docker tag ${app12} ${username}/${reponame}:${version}


}
