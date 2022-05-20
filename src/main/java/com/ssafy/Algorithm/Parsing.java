package com.ssafy.Algorithm;

import com.ssafy.happyhouse.model.dto.HouseInfoDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class Parsing {
    static int map[][];
    static int[] minEdge;
    static boolean[] visited;

    static int size;

    public static void main(String[] args) throws Exception {
        Parsing p = new Parsing();
        p.parsingTime("경희", "동아", "37.5714018", "126.9620904");
    }

    public void getTime(ResponseEntity<List<HouseInfoDto>> RLH) throws Exception {
        size = RLH.getBody().toArray().length;
        map = new int[size + 1][size + 1];
        minEdge = new int[size + 1];
        visited = new boolean[size + 1];

        for (int i = 1; i <= size; i++) {
            HouseInfoDto apti = RLH.getBody().get(i - 1);
            for (int j = i + 1; j <= size; j++) {
                HouseInfoDto aptj = RLH.getBody().get(j - 1);
                parsingTime(apti.getLat(), apti.getLng(), aptj.getLat(), aptj.getLng());
            }
        }
        prim();
    }

    public void parsingTime(String fromLat, String fromLng, String toLat, String toLng) throws Exception {
//        String url = "https://upbit.com/exchange?code=CRIX.UPBIT.KRW-BTC";
        String url = "https://map.kakao.com/";
        Document doc = Jsoup.connect(url).maxBodySize(0).get();

        System.out.println(doc.getElementsByClass("tit"));
//        Element e2 = doc.getElementById("info.route.waypointSuggest.input0");
//        Element e = doc.getElementById("info.route.searchBox.list");
//        System.out.println(e);

    }

    public void prim() {
        int result = 0; // MST 비용
        minEdge[0] = 0;

        for (int c = 0; c < size; c++) { // N개의 정점을 모두 연결
            // 신장 트리에 연결되지 않은 장점 중 가장 유리한 비용의 정점을 선택
            int min = Integer.MAX_VALUE;
            int minVertex = 0;

            for (int i = 1; i <= size; i++) {
                if (!visited[i] && min > minEdge[i]) {
                    min = minEdge[i];
                    minVertex = i;
                }
            }

            // 선택된 정점을 신장틜에 포함시킴
            visited[minVertex] = true;
            result += min;

            // 선택된 정점 기준으로 신장트리에 포함되지 않은 다른 정점으로의 간선비용을 따져보고 최솟값 갱신
            for (int i = 1; i <= size; i++) {
                if (!visited[i] && map[minVertex][i] != 0 && minEdge[i] > map[minVertex][i]) {
                    minEdge[i] = map[minVertex][i];
                }
            }
        }
        System.out.println(result);
    }
}
