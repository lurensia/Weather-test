package site.metacoding.test.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String MSRDT; // 측정일

    private String MSRRGN_NM; // 권역명

    private String MSRSTE_NM; // 측정소명

    private Integer PM10; // 미세먼지

    private Integer PM25; // 초미세먼지농도

    private Double O3; // 오존

    private Double NO2; // 이산화질소농도

    private Double CO; // 일산화탄소농도

    private Double SO2; // 아황산가스농도

    private String IDEX_NM; // 통합대기환경등급

    private Integer IDEX_MVL; // 통합대기환경지수

    private String ARPLT_MAIN; // 지수결정물질
}
