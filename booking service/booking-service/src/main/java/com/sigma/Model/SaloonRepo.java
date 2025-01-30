package com.sigma.Model;


import lombok.Data;

@Data
public class SaloonRepo {

    private Long saloonId;
    private String saloonName;
    private Double totalEarnings;
    private Integer totalBookings;
    private Integer cancelledBookings;
    private Double totalRefund;
}
