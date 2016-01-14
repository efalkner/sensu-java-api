package com.commercehub.sensu.api

/**
 * Assumes checks/events created by included Vagrant image and Chef recipes. Please see README for instructions.
 */
class ClientApiSpec extends ApiSpec {
    def "listing clients"() {
        when:
        def clients = api.clients

        then:
        clients.size() == 1
        def client = clients[0]
        client.name == "sensu-client-server"
        client.address == "127.0.0.1"
        client.subscriptions == ["all"]
        client.timestamp > 0
    }

    def "listing clients with paging"() {
        expect:
        api.getClients(1, 0).collect { it.name } == ["sensu-client-server"]
        api.getClients(1, 1).empty
    }

    def "getting client by path"() {
        when: "requesting an existing client"
        def client = api.getClient("sensu-client-server")

        then:
        client.name == "sensu-client-server"
        client.address == "127.0.0.1"
        client.subscriptions == ["all"]
        client.timestamp > 0

        when: "requesting a non-existing client"
        api.getClient("non-client")

        then:
        thrown(SensuNotFoundException)
    }

    def "getting client history"() {
        when:
        def clientHistory = api.getClientHistory("sensu-client-server").sort { it.check }

        then:
        clientHistory.collect { it.check } == ["check-cpu", "check-disk", "check-ram", "keepalive"]
        // history isn't particularly reliable for testing; most fields don't have assertions
    }

    // no coverage of deleting clients due to inability to re-create
}
