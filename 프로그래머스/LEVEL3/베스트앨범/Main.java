import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreTotal = new HashMap<>();
        Map<String, List<Song>> genreSongs = new HashMap<>();

        // 1. 장르별 총 재생 수, 장르별 노래 리스트 저장
        for (int i = 0; i < genres.length; i++) {
            genreTotal.put(genres[i], genreTotal.getOrDefault(genres[i], 0) + plays[i]);

            genreSongs.putIfAbsent(genres[i], new ArrayList<>());
            genreSongs.get(genres[i]).add(new Song(i, plays[i]));
        }

        // 2. 장르를 총 재생 수 기준으로 정렬 (내림차순)
        List<String> sortedGenres = new ArrayList<>(genreTotal.keySet());
        sortedGenres.sort((a, b) -> genreTotal.get(b) - genreTotal.get(a));

        List<Integer> result = new ArrayList<>();

        // 3. 각 장르 내에서 노래 재생수 기준 정렬 → 상위 2개 선택
        for (String genre : sortedGenres) {
            List<Song> list = genreSongs.get(genre);

            list.sort((a, b) -> {
                if (b.play == a.play) return a.id - b.id; // 재생수 같으면 고유번호 오름차순
                return b.play - a.play; // 재생수 내림차순
            });

            result.add(list.get(0).id);
            if (list.size() > 1) {
                result.add(list.get(1).id);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}

class Song {
    int id;
    int play;

    Song(int id, int play) {
        this.id = id;
        this.play = play;
    }
}
