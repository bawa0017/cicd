def string(string url, string branch){
 git( 
            branch: "${branch}",
            url: "${url}"
            )
        }