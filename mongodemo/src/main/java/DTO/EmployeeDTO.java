package DTO;

import com.example.mongodemo.entity.Address;
import com.example.mongodemo.entity.Dependant;
import lombok.Data;
import lombok.ToString;
import nonapi.io.github.classgraph.json.Id;

import java.util.Date;
import java.util.List;

@Data
@ToString
public class EmployeeDTO {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Date dateOfJoining;
    private Date dateOfBirth;
    private Boolean isActive;
    private Address address;
}
