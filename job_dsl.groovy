folder('Tools') {
    displayName('Tools')
    description('Folder for miscellaneous tools.')
}

job('Tools/clone-repository') {
     wrappers {
        preBuildCleanup {
            includePattern('**/target/**')
            deleteDirectories()
            cleanupParameter('CLEANUP')
        }
    }
    
    parameters {
        stringParam('GIT_REPOSITORY_URL', null, 'Git URL of the repository to clone')
    }
    
    steps {
        shell('git clone $GIT_REPOSITORY_URL')
    }
}

job('Tools/SEED') {
    parameters {
        stringParam('GITHUB_NAME', null, 'GitHub repiository owner/repo_name (e.g.: "EpitechIT31000/chocolatine")')
        stringParam('DISPLAY_NAME', null, 'Display name for job')
    }
    
    steps {
        dsl({
            text('''
            job("$DISPLAY_NAME") {
                wrappers {
                   preBuildCleanup {
                        includePattern('**/target/**')
                        deleteDirectories()
                        cleanupParameter('CLEANUP')
                    }
                }
                
                properties {
                    githubProjectUrl("$GITHUB_NAME")
                }

                 triggers {
                    scm('* * * * *')
                }

                steps {
                    shell("make fclean")
                    shell("make")
                    shell("make tests_run")
                    shell("make clean")
                }
            }
            ''')
        })
    }
}