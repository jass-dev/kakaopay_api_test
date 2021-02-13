# 카카오페이 뿌리기 API 개발 과제

---
## 프로젝트 설정
####
 - JAVA 11
 - Spring boot
 - H2 DB(In Memory)
 - Mybatis
---

## 주요기능

### 공통 요청값
- request Header
  - X-USER-ID : 사용자 ID (숫자)
  - X-ROOM-ID : 방 ID (문자)
### ▶ 뿌리기 ```POST```
```
localhost:8081/doFlex
```

- Request Body  
  - totalAmount : 뿌릴 금액
  - shareCounts : 뿌리기를 받을 인원
- 인원과 금액을 요청하면 뿌리기를 실행하고 TOKEN 발행
    - TOKEN 자리수가 3자리로 짧으므로, 중복을 피할 수 있도록 (2^6)^3 경우의수로 발행(URI SAFE BASE64문자 차용)
    - 뿌리기 기능이 방별 종속되는 개념으로 판단, room_id 컬럼을 DB 복합키로 지정, 방별로 총 26만건 뿌리기 커버 가능
    - 랜덤으로 뿌리기 할당 금액 생성 (O(N)시간) 하여 BULK INSERT
    - 0명에게 뿌리는 케이스는 에러로 규정
- Sample Response
    ```JSON
    {
    "code": "OK",
    "message": "SUCCESS",
    "data": {
        "token": "N-Q"
        }
    }
    ```
### ▶ 받기 ```POST```
```
localhost:8081/claimFlex
``` 
- Request Body  
  - token : 토큰
- TOKEN을 요청하면 뿌리기 share중 아직 받지 않은 값을 응답하고 받은 것으로 처리
  - 세부 제한사항 및 중복 처리 등은 DB 쿼리 1회로 처리, 백엔드에서의 DB 접근 및 transaction 문제 최소화
- Sample Response
    ```JSON
    {
    "code": "OK",
    "message": "SUCCESS",
    "data": {
        "amount": 29
        }
    }
    ```
### ▶ 조회 ```GET```
```
localhost:8081/searchFlex
```
- Request Param
  - token : 토큰
- TOKEN을 요청하면 TOKEN에 해당하는 뿌리기 상태를 조회함
  - 조회할 수 없는 사유별로 에러코드 세분화(7일 날짜 제한, 뿌리기 요청자 제한, TOKEN 조회 불가 제한)
  - 뿌리기 기능이 방별로 귀속되는 개념으로 판단, room_id도 조건으로 사용

- Sample Response 
  ```JSON
    {
        "code": "OK",
        "message": "SUCCESS",
        "data": {
            "flex": {
                "createDate": "2021-02-13 14:14:45.669906",
                "totalClaimedAmount": 68,
                "totalAmount": 100
            },
            "flexDetail": [
                {
                    "claimUserId": 4,
                    "claimAmount": 29
                },
                {
                    "claimUserId": 6,
                    "claimAmount": 17
                },
                {
                    "claimUserId": 3,
                    "claimAmount": 22
                }
            ]
        }
    }
  ```
---
