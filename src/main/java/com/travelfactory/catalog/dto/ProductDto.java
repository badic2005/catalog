package com.travelfactory.catalog.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.travelfactory.catalog.model.Vendor;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class ProductDto {
    @JsonProperty(value = "Id")
    private String id;

    @JsonProperty(value = "Name")
    private String name;

    @JsonProperty(value = "RoomNumber")
    private String roomNumber;
}
