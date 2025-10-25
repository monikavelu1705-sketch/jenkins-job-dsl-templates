def projects = ['frontend-app', 'backend-service', 'documentation']

projects.each { project ->
    job("${project}-build-job") {
        steps {
            // Use Windows batch commands
            batchFile("echo Starting standardized build for project: ${project}")
            batchFile("echo Running standard tests...")
        }

        // Build trigger (every 20 minutes)
        triggers {
            cron('H/20 * * * *')
        }

        // Log rotation: keep 5 builds for 5 days
        logRotator(5, 5)
    }
}
