import java.util.*;

public class Solution {
	static int n;
	static char[][] board;
	static boolean[][] visited;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();  // 테스트 케이스 개수

        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();  // 바둑판의 크기
            scanner.nextLine();  // 개행 문자 제거

            char[][] board = new char[N][N];  // 바둑판의 상태를 저장할 이차원 배열

            for (int i = 0; i < N; i++) {
                String line = scanner.nextLine();
                for (int j = 0; j < N; j++) {
                    board[i][j] = line.charAt(j);
                }
            }

            int count = 0;  // 먹을 수 있는 알의 개수를 세는 변수

            // 각 포마다 먹을 수 있는 알의 개수를 세어 더함
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == 'X') {  // 이동이 가능한 포인 경우
                        count = countEatableStones(board, i, j);
                    }
                }
            }
            System.out.println("#" + t + " " + count);
        }
    }

	public static int countEatableStones(char[][] board, int x, int y) {
	    int count = 0;
	    int n = board.length;
	    
	    // 오른쪽으로 먹을 수 있는 알의 개수 카운트
	    for (int i = y+1; i < n; i++) {
	        if (board[x][i] == 'Y') break; // 포(Y)를 만나면 중단
	        if (board[x][i] == 'H') {
	            // 포(X)를 만나고 다음 위치에 알(H)가 있다면 먹을 수 있는 알
	            if (i+1 < n && board[x][i+1] == 'X') count++;
	            break;
	        }
	    }
	    
	    // 왼쪽으로 먹을 수 있는 알의 개수 카운트
	    for (int i = y-1; i >= 0; i--) {
	        if (board[x][i] == 'Y') break; // 포(Y)를 만나면 중단
	        if (board[x][i] == 'H') {
	            // 포(X)를 만나고 다음 위치에 알(H)가 있다면 먹을 수 있는 알
	            if (i-1 >= 0 && board[x][i-1] == 'X') count++;
	            break;
	        }
	    }
	    
	    // 아래쪽으로 먹을 수 있는 알의 개수 카운트
	    for (int i = x+1; i < n; i++) {
	        if (board[i][y] == 'Y') break; // 포(Y)를 만나면 중단
	        if (board[i][y] == 'H') {
	            // 포(X)를 만나고 다음 위치에 알(H)가 있다면 먹을 수 있는 알
	            if (i+1 < n && board[i+1][y] == 'X') count++;
	            break;
	        }
	    }
	    
	    // 위쪽으로 먹을 수 있는 알의 개수 카운트
	    for (int i = x-1; i >= 0; i--) {
	        if (board[i][y] == 'Y') break; // 포(Y)를 만나면 중단
	        if (board[i][y] == 'H') {
	            // 포(X)를 만나고 다음 위치에 알(H)가 있다면 먹을 수 있는 알
	            if (i-1 >= 0 && board[i-1][y] == 'X') count++;
	            break;
	        }
	    }
	    
	    return count;
	}
}