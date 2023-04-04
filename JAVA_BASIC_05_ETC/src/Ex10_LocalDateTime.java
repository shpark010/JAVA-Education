import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ex10_LocalDateTime {

	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd a HH:mm:ss");
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH시mm분");
		 System.out.println("현재 시간: " + now.format(dtf));
		 String a = (String)now.format(dtf2);
		 System.out.println("a : " + a);
		 
		 LocalDateTime result1 = now.plusYears(1);
		 System.out.println("1년 덧셈: " + result1.format(dtf));
		 
		 LocalDateTime result2 = now.minusMonths(2);
		 System.out.println("2월 뺄셈: " + result2.format(dtf));
		 
		 LocalDateTime result3 = now.plusDays(7);
		 System.out.println("7일 덧셈: " + result3.format(dtf));

	}

}
