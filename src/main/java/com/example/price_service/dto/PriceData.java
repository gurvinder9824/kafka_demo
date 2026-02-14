package com.example.price_service.dto;

import java.time.LocalDateTime;

public record PriceData(String id, LocalDateTime dateTime, Object payload){}
