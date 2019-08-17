package com.kguevara.reservationservice;

import com.kguevara.reservationservice.service.models.Reservation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
@DataMongoTest
public class ReservationDocumentTest {

    @Autowired
    ReactiveMongoTemplate reactiveMongoTemplate;

    @Test
    public void testShouldStoreAndRetrieve(){
        Publisher<Reservation> reservationPublisher = reactiveMongoTemplate.save(new Reservation(null, "JOSH"));

        StepVerifier.create(reservationPublisher)
        .expectNextMatches(reservation -> reservation.getName().equals("JOSH"))
        .verifyComplete();
    }
}
