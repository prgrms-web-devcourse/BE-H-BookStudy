### [몰랐다가 알게 된 것]

1. 금액(돈)을 Integer (x) -> Double로 파싱한다. (돈관리는 소수점까지..메모..)
2. 입력 및 파싱 로직의 중복 (csv, json, 파일형식이 바뀌는 경우 어떻게 할것?)내용을 빼내야한다.
3. 매개변수로도 final을 붙여서 받는게 신기했다;; 일단 이런 방법이 있다고는 생각못했었음

4. Month Enum의 존재를 알게되었다...java는 정말 가진게 많구낭..ㅎㅎ

5. List에 나는 Output, Input 객체를 만들고 인터페이스로 관리를 했는데
   뭔가 적절하지 않게 쪼갰었던 것 같다. Transaction만으로 amount를 관리 해도 됬을 것 같다.
   amount가 음수라는 이유로 쪼갰던게 오히려 관리에 더 안좋을 것 같다는 (코드가 많아짐) 생각을 하게 되었다.
6. 변수명, 메서드명 수정에 대해서 용진님이 많이 알려주셔서 변경할 수 있었는데
   다음에도 또 실수하지 않도록 신경을 더 기울여보고싶다..ㅎㅎ 그래도 실수하겠지만..꼭 짚어주시면 감사하겠습니다!!ㅠㅠ
   다음에 만들때에는 객체 안에 사용되는 메서드들이 연관이 있는것으로만 넣고,
   이름을 지을때에도 되도록 유사한 이름을 사용하려고 합니다..!
7. 응집도 개념이 클래스 단위보다 더 세밀하게 메서드 단위로도 생각해 볼수 있다는 점이 새롭다.
8. 응집도에 대한 생각도 고려를 해봐야한다는 점..!ㅠㅠㅎㅎ

---

### [알게 된 몇가지 용어]

* DRY: Don't repeat yourself
* KISS: Keep it Short and Simple (남용하지 말자)
* anti-pattern : 효과적이지 않은 해결방법

---

### [실무에서 일반적으로 6가지로 그룹화한다.]

* 기능
* 정보
* 순차
* 논리
* 유틸리티
* 시간

---

### [테스트]

* 확신
* 변화에 튼튼함 유지
* 프로그램 이해도

[test file 만드는 단축키: ctrl + shit + t]

* Grade  + jUnit5 + IntelliJ 에서는 빌드테스트 환경을 IntelliJ로 바꿔주는게 좋겠다.
    * [참조](https://stackoverflow.com/questions/55405441/intelij-2019-1-update-breaks-junit-tests)

* Float, double을 비교할때 delta값을 넣는다고하는데 jUnit5부터는 어 안되나보다
    * https://stackoverflow.com/questions/53458934/precision-of-junit-5s-assertequals-with-double



### Given-When-Then 공식
[다음 챕터 공부하면서 공부해볼 키워드!]


---

