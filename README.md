# OmokGame

혼자서 0부터 시작해보는 자바 프로젝트!
오목게임 만들기

기본 기능들
1. 모드기능 - AI모드, 2인용모드
  1) AI모드 - 1. 플레이어가 돌 색깔 고를 수 있음(기본은 플레이어가 흑돌시작) 
              2. AI모드 알고리즘 적용!(MINIMAX 알고리즘은 사용하지 않았음)
  2) 2인용 모드 - 차례대로 둠
  
2. 한수 무르기 기능
  AI모드에서는 컴퓨터와 플레이어 것 동시에 무르기!
  2인용모드에서는 하나씩 무르기!
  (만약 무를것이 없다면 에러 메시지 뜨게하기!)
3. 타이머 기능
  플레이어 차례는 30초씩 정해둠
  (만약 시간이 다되면 그냥 패스)
  
  
중요한 기능!
1. 금수 판별... 이거는 3*3, 4*4 6장목금지 기본으로 만들었지만 인터넷에 있는 모든 테스트 케이스 통과하지 못함.. 인터넷에 잘 정리되어있는 테스트 케이스가 없음 그렇다고 남이 만들어놓은것 따라하기 싫음!ㅜㅜ
2. AI모드...이것도 인터넷에 올라온 알고리즘 말고 내 생각대로 구현해봄!
  1) 4에서 공격 우선 다음 수비
  2) 3에서 공격 우선 다음 수비
  3) 나머지는 가중치 설정하여 둠! (같은 가중치에서는 첫번째 나온 것 기준으로 둠)
  
  
느낀점 : AI모드를 제대로 만들어보고 싶다는 생각 (이후에 MINIMAX 알고리즘 공부 예정!)
         진짜 구닥다리 자바로 GUI구현하는 것보다는 REACT로 하는것이 나을 것 같다! 
