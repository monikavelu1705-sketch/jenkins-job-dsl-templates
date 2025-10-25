// File: jobs.groovy
def projects = ['frontend-app', 'backend-service', 'documentation']

// Loop through each project to create similar build jobs
projects.each { project ->
    job("${project}-build-job") {
        
        // (Optional) Git repo configuration
        // scm { git('git@github.com/myorg/' + project + '.git') }

        // Define build steps
        steps {
            shell("echo 'Starting standardized build for project: ${project}'")
            shell("echo 'Running standard tests...'")
        }

        // Define build trigger (every 20 minutes)
        triggers {
            cron('H/20 * * * *')
        }

        // Log rotation (keep 5 builds for 5 days)
        logRotator(5, 5)
    }
}
