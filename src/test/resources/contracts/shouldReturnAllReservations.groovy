package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("should return all Reservations")

    request {
        method(GET())
        url("/reservations")
    }

    response {
        status(200)
        headers { contentType(applicationJsonUtf8())
        }
        body (
            """
            [
                { "id": "1", "name": "Mario"}
            ]
            """
        )
    }
}
