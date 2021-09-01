public class Patient {
    final int patientId;
    final String patientName;
    final int securityNum;
    final int phoneNumber;
    final String location;
    final int height;
    final int weight;

    public Patient(int patientId, String patientName, int securityNum, int phoneNumber, String location, int height, int weight) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.securityNum = securityNum;
        this.phoneNumber = phoneNumber;
        this.location = location;
        this.height = height;
        this.weight = weight;
    }
}
