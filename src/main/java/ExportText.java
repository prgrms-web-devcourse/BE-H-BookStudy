import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ExportText implements Export{

    private static final String PATH = "src/main/resources/";

    String getStringSummary(SummaryStatistics summaryStatistics){
        StringBuilder sb = new StringBuilder();

        sb.append("min : ").append(summaryStatistics.getMin()).append("\n");
        sb.append("max : ").append(summaryStatistics.getMax()).append("\n");
        sb.append("sum : ").append(summaryStatistics.getSum()).append("\n");
        sb.append("avg : ").append(summaryStatistics.getAverage()).append("\n");

        return sb.toString();
    }

    @Override
    public void export(SummaryStatistics summaryStatistics){
        File file = new File(PATH + "text.txt");
        String str =  getStringSummary(summaryStatistics);

        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(file));
            br.append(str);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
