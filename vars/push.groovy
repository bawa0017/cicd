def call(String repo, String image, String version ){ 
     withCredentials([usernamePassword("credentialsId":"dockerhub",
                              usernameVariable:"user",
                              passwordVariable:"pass")])
            sh "docker tag myapp01 ${env.user}/test01:v3"
            sh "echo ${env.pass} | docker login -u ${env.user} --password-stdin"
            sh "docker push ${repo}/${image}:${version}"
            {                        
