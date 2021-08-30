import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ExportHtml implements Export{
    private SummaryStatistics summaryStatistics;
    private static final String PATH = "src/main/resources/";

    ExportHtml(){}

    String getStringSummary(SummaryStatistics summaryStatistics){
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "  <ul>");

        sb.append("<li>min: </li>").append(summaryStatistics.getMin()).append("\n");
        sb.append("<li>max: </li>").append(summaryStatistics.getMax()).append("\n");
        sb.append("<li>sum: </li> ").append(summaryStatistics.getSum()).append("\n");
        sb.append("<li>avg: </li> ").append(summaryStatistics.getAverage()).append("\n");
        sb.append("  </ul>\n" +
                "</body>\n" +
                "</html>");

        return sb.toString();
    }
    @Override
    public void export(SummaryStatistics summaryStatistics) {
        File file = new File(PATH + "index.txt");
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
