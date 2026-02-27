import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // 마라톤에 참여한 선수들, 완주한 선수들
        String answer = "";

        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i = 0; i < participant.length; i++) {
            if (i >= completion.length
                    || !participant[i].equals(completion[i])) {
                answer = participant[i];
                break;
            }
        }

        return answer;
    }
}