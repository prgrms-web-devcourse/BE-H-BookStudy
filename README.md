# CH2: 입출금 내역 분석기 문제 요약
## 1. 도전과제

- 여러 군데에서 많은 돈을 소비하는데, 소비내역을 자동으로 요약하는 app
- 은행의 매달 입출금 내역을 모두 살펴볼 수 없어서 입출금 내역을 자동으로 분석하고 재정상태를 더 잘 보여주는 SW를 개발해달라고 부탁받았다.



## 2. 목표

1. 한개의 클래스로 문제를 구현해보고, 프로젝트를 진행하면서 바뀌는 요구사항이나 유지보수에 대응하며 기존 구조의 한계가 무엇인지 확인한다.
2. 쉽게 유지보수하고 이해할 수 있으며 버그가 발생하는 범위를 줄이는데 도움을 주는 **SRP**를 배운다.
3. **응집도 & 결합도 특징도 소개**



## 3. 입출금 내역 분석기 요구사항

1. 자신의 입출금 목록이 담긴 텍스트 파일을 읽어 분석할 것을 요구했다.
2. 온라인 인터넷 뱅킹 사이트에서 자신의 거래내역 파일을 받았고, 이 텍스트 파일은 콤마로 분리된 값인 CSV형식으로 구성되어있다.

```
30-01-2017,-100,Deliveroo
30-01-2017,-50,Tesco
01-02-2017,6000,Salary
02-02-2017,2000,Royalties
02-02-2017,-4000,Rent
03-02-2017,3000,Tesco
05-02-2017,-30,Cinema
```

아래 문제에 대한 답을 내려주세요.

- 은행 입출금 내역의 총 수입과 총 지출은 각각 얼마인가? 결과는 양수인가 음수인가?
- 특정 달엔 몇건의 입출금 내역이 발생했나?
- 지출이 가장 높은 상위 10건은 무엇?
- 돈을 가장 많이 소비하는 항목은 무엇?



## 4. 환경설정

1. java version은 8이상을 사용하라 했는데 현재 기업에서 가장 많이 쓰일 것 같은 java8로 진행해볼까 합니다.
2. 빌드툴로 gradle을 사용 했습니다. 프로젝트 시작시 설정을 조금 수월하게 하기 위해 사용하겠습니다.

3. Csv 파일 데이터가 적어서 복붙한담에 03, 04월데이터로 조금 수정했습니다.(돈과 거래한 곳 이름은 안바꿈)



## 5. 참조자료

- [날짜](https://www.notion.so/0815-update-88995193d9714dbf8f44c1457129094d#70f9c9d93c874638a1cbbf8fa6b8699a)
- [LocalDate, LocalTime, ..](https://www.notion.so/0815-update-88995193d9714dbf8f44c1457129094d#2d6a97eb7362411880b7283fe23cb9f8)

* [파일 읽기](https://kingname.tistory.com/42)



## 6. 중점적으로 봐주셨으면 하는 것

1. Account 객체가 조금 무거운거 같은데 더 잘게 쪼개야할지
2. 요구사항을 최대한 반영하려 했지만 반영을 더 해야할게 있는건지 
   (책에 제시하지 않은 것도 혼자 더 찾아서 해야하는건감...ㅎㅎ잘모르겠음..!)
3. 요구사항 3번 내가 이해한게 가장 자주 사는 물품들로 구했는데 다들 어떻게 구현했는지..?



## 7. 느낀점

1. 생각보다 책을 안보고 하니까 시간이 엄청 많이 갔다.

2. 요구사항을 받자마자 1번 해결 -> 2번 해결 -> 3번해결.. 이런식으로 진행했는데, 다음 챕터는 밑그림을 한번 그리고 만드는 연습을 해야할 것 같다. 처음 방식대로 하니까 계속 고쳐야할게 나오고 나중엔 엎어버리고 다시 새로 플젝파고 만들었기 때문이다. (구조를 먼저 짤수있게 해야겠다.)

   

