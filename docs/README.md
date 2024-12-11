# 🚀 지하철 노선도 경로 조회 미션

# 📝 기능 구현 목록

## 프로그램 시작 시 역, 노선, 구간 정보를 초기 설정하는 기능

- [x] 프로그램 시작 시 역, 노선, 구간 정보를 초기 설정한다.
- 거리와 소요 시간은 양의 정수이며 단위는 km와 분을 의미
- 아래의 사전 등록 정보로 반드시 초기 설정을 한다.

```
 1. 지하철역으로 교대역, 강남역, 역삼역, 남부터미널역, 양재역, 양재시민의숲역, 매봉역이 등록되어 있다.
 2. 지하철 노선으로 2호선, 3호선, 신분당선이 등록되어 있다.
 3. 노선에 역이 아래와 같이 등록되어 있다.(왼쪽 끝이 상행 종점)
   - 2호선: 교대역 - ( 2km / 3분 ) - 강남역 - ( 2km / 3분 ) - 역삼역
   - 3호선: 교대역 - ( 3km / 2분 ) - 남부터미널역 - ( 6km / 5분 ) - 양재역 - ( 1km / 1분 ) - 매봉역
   - 신분당선: 강남역 - ( 2km / 8분 ) - 양재역 - ( 10km / 3분 ) - 양재시민의숲역
```

## 경로를 조회하는 기능

- [ ] 출발역과 도착역을 입력받아 경로를 조회한다.
- [ ] 경로 조회 시 총 거리, 총 소요 시간도 함께 출력한다.
- [ ] 경로 조회 기준은 최단 거리 최소 시간

- [ ] 경로 조회 시 출발역과 도착역이 같으면 예외 처리, 에러 출력
- [ ] 경로 조회 시 출발역과 도착역이 연결되어 있지 않으면 예외 처리, 에러 출력
- [ ] 그 외 정상적으로 프로그램이 수행되지 않은 경우 에러를 출력

## 그 외 요구사항

- [ ] 프로그래밍 실행 결과 예시와 동일하게 입출력을 구현
- [ ] 기대하는 출력 결과는 [INFO]를 붙여서 출력
- [ ] 에러 발생 시 [ERROR]를 붙여서 출력

예시

```
## 메인 화면
1. 경로 조회
Q. 종료

## 원하는 기능을 선택하세요.
1

## 경로 기준
1. 최단 거리
2. 최소 시간
B. 돌아가기

## 원하는 기능을 선택하세요.
1

## 출발역을 입력하세요.
교대역

## 도착역을 입력하세요.
양재역

## 조회 결과
[INFO] ---
[INFO] 총 거리: 4km
[INFO] 총 소요 시간: 11분
[INFO] ---
[INFO] 교대역
[INFO] 강남역
[INFO] 양재역

## 메인 화면
1. 경로 조회
Q. 종료

...
```

프로그래밍 요구사항 - Station, Line

- [ ] Station, Line 클래스를 활용하여 지하철역과 노선을 구현해야 한다.
- [ ] 각 클래스의 기본 생성자를 추가할 수 없다.
- [ ] 필드(인스턴스 변수)인 name의 접근 제어자 private을 변경할 수 없다.
- [ ] 가능하면 setter 메소드(ex. setXXX)를 추가하지 않고 구현한다.

프로그래밍 요구사항 - StationRepository, LineRepository

- [ ] 작성된 메서드는 수정할 수 없다.