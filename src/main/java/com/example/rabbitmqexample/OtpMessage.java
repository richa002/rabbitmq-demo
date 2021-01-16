package com.example.rabbitmqexample;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OtpMessage {
private String recieverEmail;
private String text;
private String subject;

}
