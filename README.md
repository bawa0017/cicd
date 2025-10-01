# Jenkins Shared Library: Git Clone, Build, and Push
  This is a Jenkins shared library containing reusable Groovy scripts for common CI/CD tasks like cloning a Git repository, building a project, and pushing artifacts or Docker images. It is designed to be used in Jenkins pipelines to simplify and standardize these operations.

## Library Structure
├── clone.groovy # Script to clone a Git repository
├── build.groovy # Script to build the project
├── push.groovy # Script to push Docker images 


Each `.groovy` file contains reusable pipeline steps that can be called directly from a Jenkinsfile.

---

##  Setup in Jenkins

1. Go to **Jenkins Dashboard** → **Manage Jenkins** → **Configure System**.  
2. Scroll down to **Global Pipeline Libraries**.  
3. Add a new library:
   - **Name:** `groovy-scripts` (or any name you prefer)  
   - **Default version:** `main` (or a specific branch/tag)  
   - **Retrieval method:** Modern SCM → Git  
   - **Project Repository:** `https://github.com/bawa0017/shared-library-for-jenkins.git'
---


## Usage in Jenkins Pipeline
In your `Jenkinsfile`, load the library and call the scripts as steps:--'

Example:-->
    @Library('share') _
pipeline{
    
    agent any
    
    environment{
        CUST_DIR="/var/lib/jenkins/custom_projects/grovy/"
    }
    
    stages{
        stage("clone repo"){
            steps{
                dir("${CUST_DIR}"){
                script{
                    clone("https://github.com/bawa0017/test01.git" , "main")
                }
                }
                }
            }
     stage("build"){
         steps{
             dir("${CUST_DIR}"){
                 script{
                     build("app21", "bawa0017", "test01","v4")
                 }
             }
         }
     }
Requirements:---.
      Jenkins with Pipeline plugin installed
      Git installed on Jenkins agent
      Groovy runtime (bundled with Jenkins Pipeline)

