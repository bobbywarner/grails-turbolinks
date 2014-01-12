grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"

grails.project.dependency.resolution = {
    inherits("global") {}
    log "warn"

    repositories {
        grailsCentral()
        mavenLocal()
        mavenCentral()
    }

    dependencies {}

    plugins {
        compile(":asset-pipeline:1.2.4",":coffee-asset-pipeline:1.2.0") {
            export = false
        }

        build(":release:2.2.1", ":rest-client-builder:1.0.3") {
            export = false
        }
    }
}
