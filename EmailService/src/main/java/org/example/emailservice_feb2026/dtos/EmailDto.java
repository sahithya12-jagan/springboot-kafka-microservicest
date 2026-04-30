package org.example.emailservice_feb2026.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class EmailDto {
    String to;
    String from;
    String subject;
    String body;
}
