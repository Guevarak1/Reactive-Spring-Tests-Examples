package com.kguevara.reservationservice;

import com.kguevara.reservationservice.service.models.Reservation;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReservationPOJOTest {

    @Test
    public void testShouldConstruct() {
        Reservation reservation = new Reservation("1", "Mario");

        assertEquals("1", reservation.getId());
        assertEquals("Mario", reservation.getName());

        Assertions.assertThat(reservation)
                .as("not a null reference")
                .isNotNull();

        Assertions.assertThat(reservation.getName())
                .as("A name is populated")
                .isNotBlank();
    }
}
