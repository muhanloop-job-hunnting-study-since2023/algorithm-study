package week_12_230319_230325.meongj;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/138476?language=java
public class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        // map 개수 추가
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0)+1);
        }
        // 큰 -> 작은 순서로 map(value기준) 정렬
        // Map.Entry 리스트 작성
        List<Map.Entry<Integer, Integer>> list_entries = new ArrayList<>(map.entrySet());

        // 비교함수 Comparator를 사용하여 오름차순으로 정렬
        Collections.sort(list_entries, new Comparator<Map.Entry<Integer, Integer>>() {
            // compare로 값을 비교
            public int compare(Map.Entry<Integer, Integer> obj1, Map.Entry<Integer, Integer> obj2) {
                // 내림차순 정렬
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });
        // 결과 출력
//        for(Map.Entry<Integer, Integer> entry : list_entries) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }
        // 개수만큼 k개에서 차감
        int i = 0;
        while(k > 0) {
            k -= list_entries.get(i).getValue();
            i++;
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution t = new Solution();
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
        int[] tangerine2 = {1, 3, 2, 5, 4, 5, 2, 3};
        int[] tangerine3 = {1, 3, 2, 5, 4, 5, 2, 3};

        System.out.println(t.solution(6, tangerine));
        System.out.println(t.solution(4, tangerine2));
        System.out.println(t.solution(2, tangerine3));

    }
}