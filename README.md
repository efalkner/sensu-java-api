# Overview
`sensu-java-api` is a Java API for the [Sensu monitoring framework](http://sensuapp.org/).  Specifically, it provides Java bindings for the [Sensu API](http://sensuapp.org/docs/0.12/api) provided by Sensu itself.  It currently uses [Feign](https://github.com/Netflix/feign) as the HTTP client.

# What does it do?

It provides bindings for the following functionality:

* Reading information about checks
* Reading information about clients
* Reading information about events
* Reading information about stashes
* Issuing check requests
* Deleting clients
* Resolving events
* Creating/updating/deleting stashes

It does not yet have bindings for:
* Dealing with [aggregates](http://sensuapp.org/docs/0.16/api_aggregates)
* Checking Sensu's [health](http://sensuapp.org/docs/0.16/api_health)
* Inspecting Sensu's [info](http://sensuapp.org/docs/0.16/api_info)

The following functionality is not provided by the Sensu API, and thus cannot be included (unless it's first added to Sensu):

* Creating checks
* Creating clients
* Creating events

# Where do I get it?

[ ![Download](https://api.bintray.com/packages/commercehub-oss/main/sensu-java-api/images/download.svg) ](https://bintray.com/commercehub-oss/main/sensu-java-api/_latestVersion)

Binaries are published to JCenter.  To use the library from [Gradle](https://www.gradle.org/), use something like this (substitute latest version):

```groovy
repositories {
    jcenter()
}
dependencies {
    compile "com.commercehub.sensu:sensu-java-api:VERSION"
}
```

# How do I use it?

Examples below are in [Groovy](http://groovy-lang.org/).  First, build an instance of `SensuApi` using `SensuApiBuilder`:

```groovy
def api = SensuApiBuilder.builder()
    .authentication(username, password)
    .build(apiUrl)
// Check
println "Current checks: ${api.checks.sort { it.name } }"
println "Check by name: ${api.getCheck('sensu-api')}"
api.requestCheck('sensu-api', 'client1')
// Client
println "Current clients: ${api.clients}"
```

Then, use its methods to interact with the Sensu API:

```groovy
println "Current checks: ${api.checks}"
println "Current clients: ${api.clients}"
println "Current events: ${api.events}"
println "Current stashes: ${api.stashes}"
```
