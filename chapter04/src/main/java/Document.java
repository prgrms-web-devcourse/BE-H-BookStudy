import java.util.List;

public class Document {
    List<Patient> list;

    Document(List<Patient> list){
        this.list = list;
    }

    public List<Patient> getList() {
        return list;
    }

}
