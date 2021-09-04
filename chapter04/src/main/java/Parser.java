public class Parser {

    static Patient parseLine(String line){
        String[] splitWords = line.split(",");
        int patientId = Integer.parseInt(splitWords[0]);
        String userName = splitWords[1];
        int securityNum = Integer.parseInt(splitWords[2]);
        int phone = Integer.parseInt(splitWords[3]);
        String location = splitWords[4];
        int height = Integer.parseInt(splitWords[5]);
        int weight = Integer.parseInt(splitWords[6]);

        // builder 패턴으로 사용하면 좋을거 같은데..일단 이렇게 생성자로;
        return new Patient(patientId, userName, securityNum, phone, location, height, weight);
    }
}
