package neostudy.entity;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "not blank")
    @NotNull
    @Column(name = "fullname")
    private String fullname;

    @Email(message = "incorrect email")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "not blank")
    @Column(name = "phone")
    private String phone;

    @NotBlank(message = "not blank")
    @Column(name = "address")
    private String address;

    @NotBlank(message = "not blank")
    @Column(name = "date_of_birth")
    private String dateOfBirth;

}
