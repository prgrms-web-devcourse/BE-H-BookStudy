package answer;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//Query -> clauses (문장 -> 절)
//예: Amount:1000 로 되어있는 문장을 쪼개어서 map 으로 변경해준다.
public class Query implements Predicate<Document> {

    private final Map<String, String> clauses;

    public Query(final Map<String, String> clauses) {
        this.clauses = clauses;
    }

    //static method 로 만들어 instance 생성하지 않고 사용.
    //array -> stream -> toMap 할 때 Collectors.toMap() 처음 사용해보는데 좋은 방법인듯
    static Query parse(final String query){
        return new Query(
                Arrays.stream(query.split(","))
                .map(str -> str.split(":"))
                .collect(Collectors.toMap(x -> x[0], x-> x[1])));
    }


    //filter 로 검색요청을 했을 때, document 에 있는 value 들을 요청했는지 유무를 체킹할 수 있다.
    //궁금증1: 왜 contains 로 포함유무로 체크하는건가 고민을 좀 했음;; equals 가 아닌..?
    //짐작하기로는 아무래도 검색이다보니 포함유무로 좀더 넓게 검색하려한게 안닐까 싶다
    @Override
    public boolean test(Document document) {
        return clauses
                .entrySet()
                .stream()
                .allMatch(
                        entry -> {
                            final var documentValue = document.getAttributes(entry.getKey());
                            final var queryValue = entry.getValue();
                            return documentValue != null && documentValue.contains(queryValue);
                        }
                );
    }
}
