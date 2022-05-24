package entitymapping;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

//@Entity
public class MemberV2 {

    @Id
    private Long id;

    @Column(name = "name", nullable = false)
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;


    @Lob
    private String description;

    // java 8 이후에는 LocalDate, LocalDateTime 사용
    private LocalDate testLocalDate;
    private LocalDateTime testLocalDateTime;

    public MemberV2() {}
}
