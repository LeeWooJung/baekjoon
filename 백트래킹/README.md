# 백트래킹 <img src = "https://img.shields.io/badge/JAVA-007396?style=for-the-badge&logo=java&logoColor=white">
Baekjoon JAVA solution :notes:

## 기본 원리

* **상태 탐색**

    문제를 해결하기 위해 여러 단계에 걸쳐 상태를 탐색

* **조건 확인**

    각 단계에서 현재 상태가 문제의 조건을 만족하는지 확인. 조건을 만족하지 않으면 해당 경로는 더 이상 탐색하지 않고 포기(백트래킹)

* **재귀적 탐색**

    유효한 상태라면 다음 단계로 넘어가고, 최종적으로 해를 찾거나 더 이상 탐색할 곳이 없을 때 탐색을 종료

## With other methods

* **동적 계획법**(Dynamic Programming)

    백트래킹과 동적 계획법은 주로 중복되는 부분 문제가 존재하는 경우 함께 사용됨.

    백트래킹은 모든 가능성을 탐색하지만, 동일한 상태를 반복적으로 계산하는 경우 매우 비효율적.

    Dynamic Programming 기법을 통해, 즉 Memoization을 사용하여 이미 계산된 결과를 저장하고 필요할 때 재사용 가능.

* **그리디 알고리즘**(Greedy Algorithm)

    백트래킹을 통해 모든 경우의 수를 탐색하는 대신, 그리디 알고리즘을 사용하여 매 단계에서 최적의 선택을 하도록 하여 탐색 범위를 줄일 수 있음.

    그리디 알고리즘은 일반적으로 문제를 빠르게 해결할 수 있지만, 항상 전역 최적해를 보장하지는 않음.

    이와 달리 백트래킹은 모든 가능한 선택을 고려하므로, 그리디 알고리즘이 적절한 해를 찾지 못한 경우 백트래킹을 통해 보완 가능

* **비트 마스킹**(Bit Masking)

    백트래킹과 비트 마스킹을 함께 사용하면, 상태 관리를 더 효율적으로 할 수 있음.

    특히 문제에서 부분 집합이나 순열과 같은 경우, 비트 마스크를 이용하여 각 상태를 비트로 표현할 수 있음. 이를 통해 중복 탐색을 줄이고 백트래킹을 최적화할 수 있음.

* **깊이 우선 탐색**(DFS)

    백트래킹은 기본적으로 DFS 방식으로 동작하며, DFS 자체도 다양한 문제를 해결할 때 백트래킹과 함께 사용될 수 있음.

## Category

:black_square_button: 15649 N과 M(1) : 작성중  

:black_square_button: 15650 N과 M(2) : 작성중

:black_square_button: 15651 N과 M(3) : 작성중

:black_square_button: 15652 N과 M(4) : 작성중

:black_square_button: 9663 N-Queen : 작성중

:black_square_button: 2580 스도쿠 : 작성중

:black_square_button: 14888 연산자 끼워넣기 : 작성중

:black_square_button: 14889 스타트와 링크 : 작성중