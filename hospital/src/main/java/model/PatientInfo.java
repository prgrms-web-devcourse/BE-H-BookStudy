package model;

import java.util.Objects;
import java.util.UUID;

public class PatientInfo {
    private UUID patientId;
    private String name;
    private String birth;
    private String sex;
    private String phoneNumber;

    public PatientInfo(String name, String birth, String sex, String phoneNumber) {
        this.patientId = UUID.randomUUID();
        this.name = name;
        this.birth = birth;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "PatientInfo{" +
                "patientId=" + patientId +
                "name='" + name + '\'' +
                ", birth='" + birth + '\'' +
                ", sex='" + sex + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientInfo that = (PatientInfo) o;
        return Objects.equals(patientId, that.patientId) && Objects.equals(name, that.name) && Objects.equals(birth, that.birth) && Objects.equals(sex, that.sex) && Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientId, name, birth, sex, phoneNumber);
    }
}
