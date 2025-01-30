package com.sigma.Service;

import com.sigma.DTO.BookingRequest;
import com.sigma.DTO.SaloonDTO;
import com.sigma.DTO.ServiceDTO;
import com.sigma.DTO.userDTO;
import com.sigma.Domain.BookingStatus;
import com.sigma.Model.Booking;
import com.sigma.Model.SaloonRepo;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;



public interface BookingService {

    Booking createBooking(BookingRequest bookingRequest,
                          userDTO user,
                          SaloonDTO saloon,
                          Set<ServiceDTO> serviceDTOSet

                          ) throws Exception;

    List<Booking> getBookinfByCuster(Long customerId);
    List<Booking> getBookinfBySaloon(Long saloonId);
    Booking getBookingById(Long id) throws Exception;
    Booking updateBooking(Long bookingId, BookingStatus bookingStatus);
    List<Booking> getBookingsByDate(LocalDate date,Long saloonId);

    SaloonRepo getSaloonReport(Long saloonId);


}
