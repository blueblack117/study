package javabogi.JavabogiCache;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * JavabogiCache
 *
 * [목표] DB의 부하를 줄이고 빠른 응답을 위한 Cache를 개발
 *
 * [입력 데이터] 0 ~ 9 사이의 키 값이 Array 형태로 제공
 *
 * [가정] - Cache의 사이즈는 4 - Cache에 키 값이 없으면 DB를 조회하는 동안 3초, 서버에서 사용자에게 전달하는 동안 1초가
 * 소요됨. - Cache에 키 값이 있으면 서버에서 사용자에게 전달하는 동안 1초가 소요됨. - 기본적으로 들어오는 순서대로 Cache에
 * 쌓임. - Cache에 모든 공간이 가득 찼을 경우 호출된 빈도수가 적은 데이터가 있는 공간에 덮어씀. - 빈도수가 동일하다면 오래된
 * 데이터 공간에 덮어씀.
 *
 * [요구사항] - 최종 캐시 상태 출력 - 총 소요시간 출력 - 캐시가 갱신된 횟수 출력
 *
 JavabogiCache

 [목표]
 DB의 부하를 줄이고 빠른 응답을 위한 Cache를 개발

 [입력 데이터]
 0 ~ 9 사이의 키 값이 Array 형태로 제공

 [가정]
 - Cache의 사이즈는 4
 - Cache에 키 값이 없으면 DB를 조회하는 동안 3초, 서버에서 사용자에게 전달하는 동안 1초가 소요됨.
 - Cache에 키 값이 있으면 서버에서 사용자에게 전달하는 동안 1초가 소요됨.
 - 기본적으로 들어오는 순서대로 Cache에 쌓임.
 - Cache에 모든 공간이 가득 찼을 경우 호출된 빈도수가 적은 데이터가 있는 공간에 덮어씀.
 - 빈도수가 동일하다면 오래된 데이터 공간에 덮어씀.

 [요구사항]
 - 최종 캐시 상태 출력
 - 총 소요시간 출력
 - 캐시가 갱신된 횟수 출력

 [예시]
 ->   3 4 5 6 7 5 5 2 8 2 7 1 이 들어왔을 경우
 ----------------------------
 [0]  3       7           7
 [1]    4           2   2
 [2]      5     5 5
 [3]        6         8     1
 ----------------------------
 갱신 1 1 1 1 1     1 1     1
 시간 4 4 4 4 4 1 1 4 4 1 1 4
 ----------------------------

 [출력]
 현재 캐시 상태: [7, 2, 5, 1]
 총 소요시간: 36초
 총 갱신횟수: 8회

 [예시]
 ->   1 2 3 4 5 4 3 2 1 1 9 8 이 들어왔을 경우
 ----------------------------
 [0]  1       5       1 1
 [1]    2           2
 [2]      3       3
 [3]        4   4         9 8
 ----------------------------
 갱신 1 1 1 1 1       1   1 1
 시간 4 4 4 4 4 1 1 1 4 1 4 4
 ----------------------------

 [출력]
 현재 캐시 상태: [1, 2, 3, 8]
 총 소요시간: 36초
 총 갱신횟수: 8회

 *
 * ----------- Pseudocode ----------- TODO
 *
 */
public class JavabogiCache {

	private Map<Integer, Number> cache = new LinkedHashMap<Integer, Number>();

	private int count;
	private int duration;

	public void getData(int[] data) {
		for (int number : data) {
			if (cache.containsKey(number)) {
				Number cacheData = cache.get(number);
				cacheData.setCount(cacheData.getCount() + 1);
				cacheData.setTimestamp(System.currentTimeMillis());
				duration += 1;
			} else {
				if (cache.size() > 3) {
					deleteOldData();
				}
				count++;
				pushMap(number);
				duration += 4;
			}
		}
	}

	private void pushMap(int data) {
		Number number = new Number(data);
		number.setTimestamp(System.currentTimeMillis());
		cache.put(data, number);
	}

	private void deleteOldData() {
		Number oldData = null;
		Set<Integer> keys = cache.keySet();
		for (int key : keys) {
			if (oldData == null) {
				oldData = cache.get(key);
			} else {
				Number nextData = cache.get(key);
				if (oldData.getCount() > nextData.getCount()) {
					oldData = nextData;
				} else if (oldData.getCount() == nextData.getCount()) {
					int retCode = oldData.compareTo(nextData);
					if (retCode == 1) {
						oldData = nextData;
					}
				} else {
					//na
				}
			}
		}
		cache.remove(oldData.getData());
	}

	public void printStatus() {
		System.out.println("현재 캐시 상태: " + cache.keySet());
		System.out.println("총 소요시간: " + duration + "초");
		System.out.println("총 갱신횟수: " + count + "회");
	}

	public void clear() {
		cache.clear();
		count = 0;
		duration = 0;
		System.out.println();
	}

	public static void main(String[] args) {
		int[] data = { 3, 4, 5, 6, 7, 5, 5, 2, 8, 2, 7, 1 };
		int[] data2 = { 1, 2, 3, 4, 5, 4, 3, 2, 1, 1, 9, 8 };

		JavabogiCache cache = new JavabogiCache();
		cache.getData(data);
		cache.printStatus();

		cache.clear();
		cache.getData(data2);
		cache.printStatus();
	}
}

class Number {
	private long timestamp;
	private long nanoTime;
	private int data;
	private int count;

	public Number() {
		super();
		this.count = 1;
	}

	public Number(int data) {
		super();
		this.data = data;
		this.count = 1;
	}

	public Number(int data, long timestamp) {
		super();
		this.timestamp = timestamp;
		this.count = 1;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
		nanoTime = System.nanoTime();
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public long getNanoTime() {
		return nanoTime;
	}

	public void setNanoTime(long nanoTime) {
		this.nanoTime = nanoTime;
	}

	public int compareTo(Number other) {
		int isCheck = 0;
		if (this.timestamp > other.getTimestamp()) {
			isCheck = 1;
		} else if (this.timestamp < other.getTimestamp()) {
			isCheck = 2;
		} else {
			if (this.nanoTime > other.getNanoTime()) {
				isCheck = 1;
			} else if (this.nanoTime < other.getNanoTime()) {
				isCheck = 2;
			} else {
				isCheck = 0;
			}
		}
		return isCheck;
	}

	@Override
	public String toString() {
		return "Number [timestamp=" + timestamp + ", data=" + data + ", count=" + count + "]";
	}
}
