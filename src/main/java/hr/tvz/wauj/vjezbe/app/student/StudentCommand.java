package hr.tvz.wauj.vjezbe.app.student;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class StudentCommand {

    @NotBlank(message = "First name must not be empty")
    private String firstName;

    @NotBlank(message = "Last name must not be empty")
    private String lastName;
    
    @NotBlank(message = "JMBAG must not be empty")
    @Pattern(message = "JMBAG must have 10 digits", regexp="[\\d]{10}")
    private String jmbag;
    
//    @JsonFormat(pattern = "dd.MM.yyyy.")
    @NotNull(message = "Date of birth must be entered")
    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;
    
    @NotNull(message = "Number of ECTS points must be entered")
    @PositiveOrZero(message = "Number of ECTS must be entered as a positive integer")
    @Max(message = "Number of ECTS can not be higher than 480", value = 480)
    private Integer numberOfECTS;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getJmbag() {
        return jmbag;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Integer getNumberOfECTS() {
        return numberOfECTS;
    }
}
