package com.turing.api.user;
import lombok.*;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})
@Setter

public class User {
    private String password;
    private Long id;
    private String username;
    private String name;
    private String phoneNumber;
    private Long address;
    private String job;
    private double height;
    private double weight;

    @Builder(builderMethodName = "builder")
    public User(Long id, String username, String password,
                String name, String phoneNumber,
                String job,
                double height, double weight) {
        this.id=id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.job = job;
        this.height = height;
        this.weight = weight;
    }

}
