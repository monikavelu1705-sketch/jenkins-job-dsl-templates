def projects = ['frontend-app', 'backend-service', 'documentation']

projects.each { project ->
    job("${project}-build-job") {
        steps {
            // Windows batch commands instead of shell
            batchFile("echo Starting standardized build for project: ${project}")
            batchFile("echo Running standard tests...")
        }
        triggers {
            cron('H/20 * * * *') // This is okay on Windows too
        }
        logRotator(5, 5) // Keep 5 builds for 5 days
    }
}
