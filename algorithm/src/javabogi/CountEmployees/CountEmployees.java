package javabogi.CountEmployees;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;

/**
 CountEmployees

 A사무실에는 특정일자의 출퇴근 시간이 기록된 "거대한" 로그파일이 있다고 한다.

 파일의 형식은 다음과 같다. (한 라인에서 앞부분은 출근시간(HH:MM:SS), 뒷부분은 퇴근시간이다)

 09:12:23 11:14:35
 10:34:01 13:23:40
 10:34:31 11:20:10

 특정시간을 입력(예:11:05:20)으로 주었을 때 그 시간에 총 몇 명이 사무실에 있었는지 알려주는 함수를 작성하시오.

 * -----------
 * Pseudocode
 * -----------
 * TODO
 *
 */
public class CountEmployees {

	private long count(String time) throws IOException {
		StringBuilder path = new StringBuilder();
		path.append("src/").append(CountEmployees.class.getPackage().getName().replaceAll("\\.", "/")).append("/log.txt");
		File file = new File(path.toString());

		int count = 0;
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "EUC-KR"));

			while(true) {
				String nextLine = reader.readLine();
				if (nextLine == null || nextLine.length() <= 0) {
					break;
				} else {
					String[] timeline = nextLine.split(" ");
					if (Integer.parseInt(timeline[0].replace(":", "")) <= Integer.parseInt(time.replace(":", ""))
							&& Integer.parseInt(time.replace(":", "")) <= Integer.parseInt(timeline[1].replace(":", ""))) {
						count++;
					}
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) reader.close();
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
//		CountEmployees.makeLog(1000);

		CountEmployees countEmployee = new CountEmployees();	//log.txt 파일 이용
		System.out.println(countEmployee.count("11:05:20"));
	}

	// Random Log File 생성
	public static void makeLog(long num) throws IOException {
		Random rand = new Random();
		StringBuilder path = new StringBuilder();
		path.append("src/").append(CountEmployees.class.getPackage().getName().replaceAll("\\.", "/")).append("/log.txt");
		File file = new File(path.toString());

		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "EUC-KR"));
			for (long i = 0; i < num; i++) {
				StringBuilder sb = new StringBuilder();
				sb.append(String.format("%02d:%02d:%02d", rand.nextInt(5) + 9, rand.nextInt(60), rand.nextInt(60)));
				sb.append(String.format(" %02d:%02d:%02d", rand.nextInt(7) + 12, rand.nextInt(60), rand.nextInt(60)));
				writer.write(sb.toString());
				if (i + 1 < num) {
					writer.newLine();
				}
			}
		} finally {
			if (writer != null) writer.close();
		}
	}

}
