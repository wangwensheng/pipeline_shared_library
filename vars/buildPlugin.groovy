def call(Map config) {
    //node {
        git url: "https://github.com/jenkinsci/${config.name}-plugin.git"
        sh 'mvn install -DskipTests'
        //mail to: '...', subject: "${config.name} plugin build", body: '...'
    //}
}
