job('Disk usage') {
    steps {
        shell('df')
    }
}

job('Polite DDoS') {
    parameters {
        stringParam('NAME', 'Hogu', 'name of user')
    }
    steps {
        shell('echo "Hello dear "$NAME"!"')
        shell('date')
        shell('echo "This is your DDoS number "$BUILD_NUMBER"."')
    }
}