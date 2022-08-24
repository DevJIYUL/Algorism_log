import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class playboard {
	// 배열의 크기
	static int r, c;
	// map을 표현할 문자형 2차원 배열
	static char[][] graph;
	// 화산탕의 갯수
	static int n;
//	static ArrayList<ArrayList<int[]>> dp;
	static ArrayList<Stack<int[]>> dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		graph = new char[r][c];
		dp = new ArrayList<>();
		// graph 입력받기
		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				graph[i][j] = str.charAt(j);
			}
			// 입력 제대로 받아졋는지 test code
//			System.out.println(Arrays.toString(graph[i]));
		}
		for (int i = 0; i < c; i++) {
			dp.add(new Stack<>());
		}
		for (int i = 1; i <= c; i++) {
			rolling(0, i - 1, i - 1);
		}
//		System.out.println("시작할때 dp");
//		for (int q = 0; q < c; q++) {
//			for (int[] it : dp.get(q)) {
//				System.out.print(Arrays.toString(it));
//			}
//			System.out.println();
//		}
//		System.out.println("------------------");
		st = new StringTokenizer(br.readLine());
		// 화산탄 갯수
		n = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int index = Integer.parseInt(st.nextToken());
			while (!dp.get(index - 1).isEmpty()) {
				if (graph[dp.get(index - 1).peek()[0]][dp.get(index - 1).peek()[1]] == '.') {
//					rolling(dp.get(index-1).get(dp.get(index-1).size()-1)[0], dp.get(index-1).get(dp.get(index-1).size()-1)[1]);
					graph[dp.get(index - 1).peek()[0]][dp.get(index - 1).peek()[1]] = 'O';
//					dp.get(index-1).remove(dp.get(index-1).size()-1);
					dp.get(index - 1).pop();
//					for (int[] queue : dp.get(index - 1)) {
//						System.out.print(Arrays.toString(queue) + " ");
//					}
//					System.out.println();
					int[] temp = dp.get(index - 1).pop();
//					int x = dp.get(index-1).get(dp.get(index-1).size()-1)[0];
//					int y = dp.get(index-1).get(dp.get(index-1).size()-1)[1];
//					dp.get(index-1).remove(dp.get(index-1).size()-1);
//					System.out.println(+" "+dp.get(index-1).get(dp.get(index-1).size()-1)[1]);
					rolling(temp[0], temp[1], index - 1);
					break;
				} else if (graph[dp.get(index - 1).peek()[0]][dp.get(index - 1).peek()[1]] == 'O') {
					dp.get(index - 1).pop();
				}
//				System.out.println(index - 1 + " 번쨰 돌을 떨어트렸다.");
//
//				System.out.println("-------------------------");
//				// 결과 출력
//				for (int q = 0; q < c; q++) {
//					for (int[] it : dp.get(q)) {
//						System.out.print(Arrays.toString(it));
//					}
//					System.out.println();
//				}
//				System.out.println("-------------------------");
			}
		}
		for (int b = 0; b < r; b++) {
			for (int j = 0; j < c; j++) {
				System.out.print(graph[b][j]);
			}
			System.out.println();
		}
	}

	private static void rolling(int depth, int index, int set) {
		dp.get(set).add(new int[] { depth, index });
//		그다음 떨어질 위치가 map크기 밖이면  return
		if (depth + 1 >= r) {
			return;
		}
		// 화산탄이 가야할 위치가 비어있으면
		if (graph[depth + 1][index] == '.') {
//			graph[depth][index]='.';
//			graph[depth+1][index]='O';
			rolling(depth + 1, index, set);
			// 화산탄이 가야할 위치가 막혀있으면
		} else if (graph[depth + 1][index] == 'O') {
			// 왼쪽
			if ((index - 1 >= 0) && (graph[depth][index - 1] == '.' && graph[depth + 1][index - 1] == '.')) {
//				graph[depth+1][index-1] ='O';
//				graph[depth][index] = '.';
				rolling(depth + 1, index - 1, set);
				// 오른쪽
			} else if ((index + 1 < c) && (graph[depth][index + 1] == '.' && graph[depth + 1][index + 1] == '.')) {
//				graph[depth+1][index+1] ='O';
//				graph[depth][index] = '.';
				rolling(depth + 1, index + 1, set);
			}
			// 화산탄의 다음위치에 장애물을 만나면 더 이상 진행 x
		} else if (graph[depth + 1][index] == 'X') {
			return;
		}

	}

}
