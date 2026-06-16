def buildApp()
{
    echo "building the application version ${parameter.VERSION}"
}

def testApp()
{
    echo 'testing the application...'
}

def deployApp()
{
    echo 'deploying the application...'
    echo "deploying version ${params.VERSION}"
}
return this
