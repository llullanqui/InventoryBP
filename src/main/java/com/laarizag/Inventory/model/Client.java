package com.laarizag.Inventory.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String identification;

//    @Lob
//    @Column(name = "picture", columnDefinition = "BLOB")
//    @Basic(fetch = FetchType.LAZY)
//    private byte[] picture;

    @OneToMany(mappedBy = "client")
    @JsonIgnoreProperties(value = {"orders", "hibernateLazyInitializer", "handler"})
    private Set<Order> orders;
}
