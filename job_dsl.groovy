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
        stringParam('GITHUB_NAME', null, 'GitHub repository owner/repo_name (e.g.: "EpitechIT31000/chocolatine")')
        stringParam('DISPLAY_NAME', null, 'Display name for job')
    }
    
    steps {
        shell('git clone $GIT_REPOSITORY_URL')
    }
}

// job('Disk usage') {
//     steps {
//         shell('df')
//     }
// }

// job('Polite DDoS') {
//     parameters {
//         stringParam('NAME', 'Hogu', 'name of user')
//     }
//     steps {
//         shell('echo "Hello dear "$NAME"!"')
//         shell('date')
//         shell('echo "This is your DDoS number "$BUILD_NUMBER"."')
//     }
// }