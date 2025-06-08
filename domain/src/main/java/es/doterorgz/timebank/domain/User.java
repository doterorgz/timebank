package es.doterorgz.timebank.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String password;

    private double hoursCredit;
}
