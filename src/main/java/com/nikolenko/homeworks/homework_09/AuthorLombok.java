package com.nikolenko.homeworks.homework_09;

import lombok.Value;
import java.util.Date;

@Value
class AuthorLombok {

    private final String firstName;
    private final String lastName;
    private final Date dateOfBirth;

    public Date getDateOfBirth() {
        return new Date(dateOfBirth.getTime());
    }
}
