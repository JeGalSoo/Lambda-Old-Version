package user;
import lombok.*;

@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"username"})
public class User {
    private Long id;
    private String password;
    private String username;
    private String name;
    private String ssn;
    private String phoneNumber;
    private String address;
    private String job;
    private double height;
    private double weight;
    @Builder(builderClassName = "builder")//빌더의 이름을 내가 지정한 것
    public User(Long id, String password, String username, String name, String ssn, String phoneNumber,
                String address, String job, double height, double weight) {
        this.id=id;
        this.password = password;
        this.username = username;
        this.name = name;
        this.ssn = ssn;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.job = job;
        this.height = height;
        this.weight = weight;
    }
}