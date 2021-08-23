import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ExportText implements Export{

    private StatisticalSummary statisticalSummary;
    private static final String PATH = "src/main/resources/";

    ExportText(StatisticalSummary statisticalSummary){
        this.statisticalSummary = statisticalSummary;
    };

    String getStringSummary(){
        StringBuilder sb = new StringBuilder();

        sb.append("min : ").append(statisticalSummary.getMin()).append("\n");
        sb.append("max : ").append(statisticalSummary.getMax()).append("\n");
        sb.append("sum : ").append(statisticalSummary.getSum()).append("\n");
        sb.append("avg : ").append(statisticalSummary.getAverage()).append("\n");

        return sb.toString();
    }

    @Override
    public void export(){
        File file = new File(PATH + "text.txt");
        String str =  getStringSummary();

        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(file));
            br.append(str);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
