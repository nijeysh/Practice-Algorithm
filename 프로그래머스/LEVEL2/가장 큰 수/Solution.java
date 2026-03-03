import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";

        int n = numbers.length;
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, (a, b) -> {
            return (b+a).compareTo(a+b);
        });

        for (int i = 0; i < n; i++) {
            answer += arr[i];
        }

        return arr[0].equals("0") ? "0" : answer;
    }
}