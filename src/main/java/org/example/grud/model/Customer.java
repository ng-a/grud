package org.example.grud.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force = true)

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long id;

    @CreationTimestamp
    @JdbcTypeCode(SqlTypes.BIGINT)
    private final Long created;

    @UpdateTimestamp
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long updated;

    @Column(name = "full_name")
    private String fullName;

    @Column(unique = true)
    private String email;

    private String phone;

    @JdbcTypeCode(SqlTypes.BOOLEAN)
    private boolean is_active;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", created=" + created +
                ", updated=" + updated +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", is_active=" + is_active +
                '}';
    }
}
