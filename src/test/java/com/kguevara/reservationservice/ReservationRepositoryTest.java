package com.kguevara.reservationservice;

import com.kguevara.reservationservice.data.ReservationRepository;
import com.kguevara.reservationservice.service.models.Reservation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
@DataMongoTest
public class ReservationRepositoryTest {

    @Autowired
    ReservationRepository reservationRepository;

    @Test
    public void testRepositoryShouldSaveFind(){
        Mono<Reservation> reservationMono = reservationRepository.save(new Reservation(null, "MARIO"));
        Publisher<Reservation> composed = reservationMono.thenMany(reservationRepository.findByName("MARIO"));

        StepVerifier.create(composed)
                .expectNextMatches(reservation -> reservation.getName().equals("MARIO"))
                .verifyComplete();
    }
}
