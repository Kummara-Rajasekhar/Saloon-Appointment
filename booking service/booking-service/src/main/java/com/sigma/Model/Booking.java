package com.sigma.Model;


import com.sigma.Domain.BookingStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long saloonId;

    private Long customerId;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @ElementCollection
    private Set<Long> serviceIds;

    private BookingStatus status=BookingStatus.PENDING;

    private int totalServices;
}
