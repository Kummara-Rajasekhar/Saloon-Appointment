package com.sigma.DTO;

import com.sigma.Domain.BookingStatus;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.Set;

public class BookingDTO {
    private Long id;
    private Long saloonId;
    private Long customerId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Set<Long> serviceIds;
    private BookingStatus status=BookingStatus.PENDING;
    private int totalServices;
}
