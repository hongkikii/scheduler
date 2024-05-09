# 🗓️ 프로젝트
###  캘린더, 메모, 24시간 시간표로 구성된 스케줄러(Scheduler)

<br>

# 🌷 목적

- 24시간 계획 작성(혹은 상상)을 루틴처럼 하는데, 캘린더에서 날짜를 클릭했을 때 24시간 시간표를 볼 수 있었으면 좋겠다 싶지만 실상 이런 형태로 제공되는 어플을 찾기 어려움
- 특히 24시간 시간표와 더불어 간단히 메모를 할 수 있는 공간이 있으면 좋겠는데, [캘린더, 메모, 24시간 시간표] 기능을 전부 갖춘 어플은 더욱 찾기 어려움
- 이런 불편함을 해소하고자 모바일 프로그래밍 과목 과제로 해당 기능들을 포함한 애플리케이션을 구현하고자 했음
- 평소에도 kotlin을 배워보고 싶었기에, 프로젝트 기회가 닿을 때 CRUD 기능을 구현해보고 싶었음
- 결국 위 과목에서는 안드로이드 프로그래밍을 배우는 것이 궁극적인 목표이기에, 간단히 UI까지 완성해 하나의 완성된 애플리케이션 형태로 만들어보고자 함

<br>

# 🌷 개발 환경
`Kotlin`, `Android SDK`, `Android Studio`, `XML`, `Gradle`

<br>

# 🌷 주요 기능 설명

## ✔️ 할 일

### 등록
- 다이얼로그뷰에서 날짜 구간(시작 날짜, 종료 날짜), 시간 구간(시작 시간, 종료 시간)을 선택하고 할 일 텍스트를 작성해 저장할 수 있음
<img width="1156" alt="스크린샷 2024-05-09 오후 4 01 12" src="https://github.com/hongkikii/scheduler/assets/110226866/7a30001d-430f-4d9f-86cd-88509d6c8285">
<img width="1156" alt="스크린샷 2024-05-09 오후 4 01 14" src="https://github.com/hongkikii/scheduler/assets/110226866/68d93aa6-d49c-4aff-8d75-1908c92d67fd">
<img width="1156" alt="스크린샷 2024-05-09 오후 4 01 16" src="https://github.com/hongkikii/scheduler/assets/110226866/559b05e7-9bb0-48a2-b0d7-820c120e7802">

### 조회
- 캘린더뷰의 특정 날짜를 선택해 내가 등록한 할 일을 확인할 수 있음
<img width="1156" alt="스크린샷 2024-05-09 오후 4 01 21" src="https://github.com/hongkikii/scheduler/assets/110226866/59ca489c-7977-45ce-8669-c6de6cee7421">

### 수정
- 작성되어 있는 할 일을 선택해 날짜, 시간, 할 일 텍스트를 수정할 수 있음
<img width="1156" alt="스크린샷 2024-05-09 오후 4 01 24" src="https://github.com/hongkikii/scheduler/assets/110226866/cf5a85e9-2359-45d6-bfa6-034bb5bf5da1">
<img width="1156" alt="스크린샷 2024-05-09 오후 4 01 27" src="https://github.com/hongkikii/scheduler/assets/110226866/d9987aac-9086-4494-ac3e-21022a95545e">
<img width="1156" alt="스크린샷 2024-05-09 오후 4 01 30" src="https://github.com/hongkikii/scheduler/assets/110226866/feb272a2-02fd-456a-a1fe-8af8c8746f46">

### 삭제
- 작성되어 있는 할 일을 선택해 삭제할 수 있음
<img width="1156" alt="스크린샷 2024-05-09 오후 4 01 32" src="https://github.com/hongkikii/scheduler/assets/110226866/2dde8d34-dada-46a4-8e00-a1500f55619e">

## 📝 메모

### 등록
- 다이얼로그뷰에서 날짜를 선택하고 메모 텍스트를 작성해 저장할 수 있음
<img width="1156" alt="스크린샷 2024-05-09 오후 4 00 57" src="https://github.com/hongkikii/scheduler/assets/110226866/36cfc770-0491-4e9d-a002-6d35a4ef9576">

### 조회
- 캘린더뷰의 특정 날짜를 선택해 내가 등록한 메모를 확인할 수 있음
<img width="1156" alt="스크린샷 2024-05-09 오후 4 01 01" src="https://github.com/hongkikii/scheduler/assets/110226866/06f54c0d-3108-4a1c-b3dc-02e7da80668c">

### 수정
- 작성되어 있는 메모를 선택해 날짜, 메모 텍스트를 수정할 수 있음
<img width="1156" alt="스크린샷 2024-05-09 오후 4 01 03" src="https://github.com/hongkikii/scheduler/assets/110226866/2117737d-8fcc-480f-8c96-7791d2164100">
<img width="1156" alt="스크린샷 2024-05-09 오후 4 01 06" src="https://github.com/hongkikii/scheduler/assets/110226866/49cff364-96b7-4a9f-bab7-e84c33890b11">
<img width="1156" alt="스크린샷 2024-05-09 오후 4 01 16" src="https://github.com/hongkikii/scheduler/assets/110226866/fd142be0-6faa-4b7a-8f5e-5b81f7fe3f48">

### 삭제
- 메뉴에서 메모 삭제를 클릭해 해당 날짜의 메모를 삭제할 수 있음
<img width="1156" alt="스크린샷 2024-05-09 오후 4 01 08" src="https://github.com/hongkikii/scheduler/assets/110226866/dc11f364-dbf4-4ac2-805f-2b5680174266">

<br>


# 🌷 시뮬레이션 영상 링크

https://drive.google.com/file/d/1jGfJcT8KxNpwZvYEYY5LU9tqPqqhGDfM/view?usp=sharing

<br>

# 🌷 개선점

- 24시간 시간표의 경우, recyclerView를 이용할 시 중복 코드를 줄일 수 있으리라 예상됨. 다만, 특정 TextView를 지정해 불러오는 현재 구조에서 변경이 어려움. 또한 recylcerView를 이용한다면 별도의 Adapter 클래스가 필요할 것이기에, 현재와 같이 기능이 복잡하지 않은 단계에서는 어느 정도 중복 코드를 감수하는게 합리적인 trade-off라고 여겨짐

- kotlin을 처음 사용하다보니 기능 구현을 완성하는 걸 가장 큰 목표로 두었고, 클래스, 메소드, 변수 선언에 있어 객체 지향적이지 않고, 좋은 코드를 작성하지 못 함

- (버그) 24시간 시간표 작성 시 날짜 구간을 3일 이상으로 설정할 때 시작 날짜, 종료 날짜를 제외하고 할 일을 인식하지 못 함
