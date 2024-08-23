## 인디음악 커뮤니티 녹색소금  

![메인페이지](https://github.com/user-attachments/assets/6af207dc-411e-4174-b308-098587b8d834)
![메인 히스토리](https://github.com/user-attachments/assets/aa58e739-4fcc-48f7-97db-e867d57d9b82)
![로그인](https://github.com/user-attachments/assets/ce7eb3de-3e0a-4fd9-b08a-17da5f6009ec)
![회원가입](https://github.com/user-attachments/assets/2cfd2468-e035-4756-a89a-414e4c3005f7)
![마이페이지](https://github.com/user-attachments/assets/579f217b-b834-4996-ae9f-a467df35e780)
![개인정보 수정](https://github.com/user-attachments/assets/cbe2c221-86a4-4181-b301-2e5d0b9ae516)
![비밀번호 변경](https://github.com/user-attachments/assets/d426b105-c725-44f4-94fe-752fceff1a6e)
![게시판 목록](https://github.com/user-attachments/assets/a66cc888-e6ad-464b-a47d-0d56b70c8a3d)
![게시판 검색](https://github.com/user-attachments/assets/2b4e14d1-5c63-492c-8eeb-b5bd6ef69a12)
![게시글 및 댓글](https://github.com/user-attachments/assets/2283f7d9-0212-4bdc-8190-9c31be65f6a4)

## 개발기능(~ing)

#### 인덱스
   + 앨범 History
     + 클릭한 앨범을 로컬 스토리지에 저장하고 최신순으로 표시 (24시간 뒤 삭제)

#### 회원가입
   + 587포트와 Ajax를 활용하여 이메일 인증
     + Ajax를 활용한 이메일 중복 체크 후, 인증번호 전송 버튼 활성화
     + 중복 클릭 방지를 위해 버튼 클릭시 비활성화 되며 응답 후 재활성화
   + 2중 유효성 검사
     + 클라이언트 측 검사로 서버 부하 감소 및 사용자 경험 개선
     + Validator를 사용하여 서버 유효성 검사 
   + 카카오 API를 활용하여 주소 찾기
   + Security를 활용하여 비밀번호 해시화

#### 로그인
   + Interceptor를 활용하여 접근 제어 강화
   + Cookie를 활용한 이메일 저장 체크박스

#### 마이페이지
   + 개인정보 수정
   + 비밀번호 변경
     + 비밀번호 변경시 보안 강화를 위해 자동으로 로그아웃 

#### 게시판
   + 게시글, 댓글 CRUD 구현
   + SearchCondition를 사용한 검색 필터
   + PageHandler를 사용한 페이징 네비게이션
   + RestController를 활용한 RESTful 방식으로 댓글 관리
   
   

