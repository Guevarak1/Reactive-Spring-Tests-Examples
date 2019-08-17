package com.kguevara.reservationservice;

import com.kguevara.reservationservice.data.ReservationRepository;
import com.kguevara.reservationservice.service.models.Reservation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@SpringBootApplication
public class ReservationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservationServiceApplication.class, args);
	}

    @Configuration
    public static class ProducerRestConfiguration {

        private final ReservationRepository reservationRepository;

        ProducerRestConfiguration(ReservationRepository reservationRepository) {
            this.reservationRepository = reservationRepository;
        }

        @Bean
        RouterFunction<ServerResponse> routes(){
            return route(GET("/reservations"), serverRequest -> ok().body(reservationRepository.findAll(), Reservation.class));
        }
    }
}
