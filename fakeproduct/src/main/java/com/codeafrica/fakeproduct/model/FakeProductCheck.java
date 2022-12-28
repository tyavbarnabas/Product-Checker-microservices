package com.codeafrica.fakeproduct.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="Fake_product")
public class FakeProductCheck {
    @Id
    @SequenceGenerator(name = "fake_id_sequence", sequenceName = "fake_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "fake_id_sequence")
    private Integer id;
    private Integer productId;
    private Boolean isFakeProduct;
    private LocalDateTime createdAt;
}
