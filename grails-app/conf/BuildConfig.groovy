grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"

grails.project.dependency.resolution = {
    inherits("global") {}
    log "warn"
    
    repositories {
        grailsCentral()
    }
    
    dependencies {}

    plugins {
        compile ":resources:1.1.6"
        build(":release:2.0.3") {
            export = false
        }
    }
}
