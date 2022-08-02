package com.day0802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class SWEA_1210_ladder {
    static int[][] board;
    static boolean[][] visited;
    static int detination;
    static int[] dx = {0,0,-1};
    static int[] dy = {1,-1,0};
    static int dfs(int x,int y){
        if (x==0) {
            return y;
        }
        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (ny <0 || ny>=100) continue;
            if (board[nx][ny] == 1 && visited[nx][ny] == false) {
                visited[nx][ny] = true;
                return dfs(nx,ny);
            }
        }
        return 0;
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 1; i <= 10; i++) {
            int n = Integer.parseInt(br.readLine());
            board = new int[100][100];
            visited = new boolean[100][100];
            for (int j = 0; j < board.length; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < board.length; k++) {
                    board[j][k] = Integer.parseInt(st.nextToken());
                }
            }
             
            for (int j = 0; j < board[0].length; j++) {
            	int[] temp = board[board.length-1];
                if (temp[j] == 2) {
                    detination = j;
                    break;
                }
            }
            visited[99][detination] = true;
            int result = dfs(99,detination);
            System.out.println("#"+i+" "+result);
        }
    }
 
}
