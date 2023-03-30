import java.util.Scanner;

public class Ex14_Quiz {
	  public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int random = (int)(3 * Math.random() + 1), user = sc.nextInt();
	        System.out.println(((random) == user)? "컴퓨터는 " + random + ", 유저는 " + user + "로 비겼습니다." : (random-user==Math.abs(1))? "컴퓨터는 " + random + ", 유저는 " + user + (random-user == 1? "로 졌습니다." : "로 이겼습니다.") : "컴퓨터는 " + random + ", 유저는 " + user + "로 이겼습니다");
	    }
}
