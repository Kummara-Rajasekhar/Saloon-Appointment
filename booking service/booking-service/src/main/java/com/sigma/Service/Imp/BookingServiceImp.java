package com.sigma.Service.Imp;

import com.sigma.DTO.BookingRequest;
import com.sigma.DTO.SaloonDTO;
import com.sigma.DTO.ServiceDTO;
import com.sigma.DTO.userDTO;
import com.sigma.Domain.BookingStatus;
import com.sigma.Model.Booking;
import com.sigma.Model.SaloonRepo;
import com.sigma.Service.BookingService;
import com.sigma.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class BookingServiceImp implements BookingService {
    private final BookingRepository bookingRepository;

    @Override
    public Booking createBooking(BookingRequest bookingRequest, userDTO user, SaloonDTO saloon, Set<ServiceDTO> serviceDTOSet) throws Exception {

        int totalDuration=serviceDTOSet.stream().mapToInt(ServiceDTO::getDuration).sum();
        LocalDateTime bookingStartTime= bookingRequest.getStartTime();
        LocalDateTime bookingEndTime= bookingStartTime.plusMinutes(totalDuration);
        Boolean isSlotAvailable=isTimeSlotAvailable(saloon,bookingStartTime,bookingEndTime);
        int totalPrice=serviceDTOSet.stream().mapToInt(ServiceDTO::getPrice).sum();
        Set<Long> idList=serviceDTOSet.stream()
                .map(ServiceDTO::getId)
                .collect(Collectors.toSet());
        Booking newBooking=new Booking();
        newBooking.setCustomerId(user.getId());
        newBooking.setSaloonId(saloon.getId());
        newBooking.setStatus(BookingStatus.PENDING);
        newBooking.setStartTime(bookingStartTime);
        newBooking.setEndTime(bookingEndTime);
        newBooking.setTotalPrice(totalPrice);
        return newBooking;
    }


    public Boolean isTimeSlotAvailable(SaloonDTO saloonDTO,LocalDateTime bookingStartTime, LocalDateTime bookingEndTime) throws Exception {
        List<Booking> existingBookings=getBookinfBySaloon(saloonDTO.getId());
        LocalDateTime saloonOpenTime=saloonDTO.getOpenTime().atDate(bookingStartTime.toLocalDate());
        LocalDateTime saloonCloseTime=saloonDTO.getCloseTime().atDate(bookingEndTime.toLocalDate());
        if(bookingStartTime.isBefore(saloonOpenTime) || bookingEndTime.isAfter(saloonCloseTime)){
            throw new Exception("Booking time must be within saloon's working hours");
        }


        for(Booking bookings:existingBookings){
            LocalDateTime existingBookingStartTime=bookings.getStartTime();
            LocalDateTime existingBookingEndTime=bookings.getEndTime();
            if(bookingStartTime.isBefore(existingBookingStartTime) && bookingEndTime.isAfter(existingBookingEndTime)){
                throw new Exception("Slot not available, choose different time");
            }

            if(bookingStartTime.isEqual(existingBookingStartTime) && bookingEndTime.isEqual(existingBookingEndTime)){
                throw new Exception("Slot not available, choose different time");
            }
        }
        return true;
    }

    @Override
    public List<Booking> getBookinfByCuster(Long customerId) {
        return List.of();
    }

    @Override
    public List<Booking> getBookinfBySaloon(Long saloonId) {
        return bookingRepository.findByCustomerId(saloonId);
    }

    @Override
    public Booking getBookingById(Long id) throws Exception {
         Booking booking=bookingRepository.findById(id).orElse(null);
         if(booking==null){
             throw new Exception("Booking not found");
         }
         return booking;
    }

    @Override
    public Booking updateBooking(Long bookingId, BookingStatus bookingStatus) {
        Booking booking=bookingRepository.findById(bookingId).orElse(null);
        booking.setStatus(bookingStatus);

        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getBookingsByDate(LocalDate date, Long saloonId) {

        List<Booking> all=getBookinfBySaloon(saloonId);
        if(date==null){
            return all;
        }
        all.stream().filter(booking -> isSameDate(booking.getStartTime(),date) || isSameDate(booking.getEndTime(),date)).collect(Collectors.toList());

        return all;
    }

    public boolean isSameDate(LocalDateTime dateTime,LocalDate date){

        return dateTime.toLocalDate().equals(date);
    }

    @Override
    public SaloonRepo getSaloonReport(Long saloonId) {

        List<Booking> bookings=getBookinfBySaloon(saloonId);
        Double totalEarnings=bookings.stream().mapToInt(Booking::getTotalPrice).sum();
        Integer totalBookings=bookings.size();
        List<Booking> cancelledBookings=bookings.stream().filter(booking -> booking.getStatus().equals(BookingStatus.CANCELLED));
        Double totalRefund=cancelledBookings.stream().mapToDouble(Booking::getTotalPrice).sum();
        SaloonRepo saloonRepo=new SaloonRepo();
        saloonRepo.setSaloonId(saloonId);
        saloonRepo.setCancelledBookings(cancelledBookings.size());
        saloonRepo.setTotalBookings(totalBookings);
        saloonRepo.setTotalEarnings(totalEarnings);
        saloonRepo.setTotalRefund(totalRefund);

        return saloonRepo;
    }
}
