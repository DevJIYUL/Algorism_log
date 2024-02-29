package backjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P16987 {
    static class Egg{
        int hp,attack;

        @Override
        public String toString() {
            return "Egg{" +
                    "hp=" + hp +
                    ", attack=" + attack +
                    '}';
        }

        public Egg(int hp, int attack) {
            this.hp = hp;
            this.attack = attack;
        }
    }
    static int n,answer,temp[];
    static boolean[] visited;
    static Egg[] egg,arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.valueOf(st.nextToken());
        arr = new Egg[n];
        temp = new int[n];
        visited = new boolean[n];
        egg = new Egg[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int hp = Integer.valueOf(st.nextToken());
            int at = Integer.valueOf(st.nextToken());
            egg[i] = new Egg(hp,at);
        }

        com(0,0);
        System.out.println(answer);
    }

    private static void com(int index  , int count) {
        if(index == n){
            answer = Math.max(answer,count);
            return;
        }

        if (egg[index].hp<=0 || count == n-1){
            com(index+1,count);
            return;
        }
        int curCount = count;
        for (int i = 0; i < n; i++) {
            if (i==index)continue;
            if(egg[i].hp<=0)continue;

            egg[index].hp -= egg[i].attack;
            egg[i].hp -= egg[index].attack;

            if(egg[index].hp<=0)count++;
            if(egg[i].hp<=0)count++;
            com(index+1,count);

            egg[index].hp += egg[i].attack;
            egg[i].hp += egg[index].attack;
            count = curCount;
        }
    }


}