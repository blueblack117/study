package javabogi.patternMatch;

/**
 패킷 복원 (25분)
 패킷이 ID:데이터 형식으로 전송됨. 전송 순서는 무작위
 패킷은 최대 9개까지 전송된다.
 String[] packets = {"1I_LOVE", "3G_CNS", "4CNS!!", "2VE_L"};

 패킷은 앞에 전송된 데이터와 3개까지 중복될 수 있음
 중복을 고려하여 복원된 데이터 출력하는 문제.

 단, 패킷이 유실될 수 있으며 유실될 경우 그 다음에 도착하는 패킷은 중복된 데이터가 없다고 가정
 유실될 경우도 유실된 것을 제외하고 merge하여 출력 (부분점수)
 패킷이 형식에 안맞을 경우 IllegalArgumentException 전송 (부분점수)
 동일한 ID로 반복해서 들어왔을 경우 처음에 들어온 데이터만 인정하고 나머지는 버림 (부분점수)
 -> 1:I_LOVE
 2:    VE_L
 3:        G_CNS
 4:          CNS!!
 -------------------
 결과:I_LOVE_LG_CNS!!

 * -----------
 * Pseudocode
 * -----------
 * TODO
 *
 */
public class PacketRestore {

	public static void main(String[] args) {
		String[] packets = {"1I_LOVE", "3G_CNS", "4CNS!!", "2VE_L"};

		PacketRestore main = new PacketRestore();
		String[] sortedPackets = main.sort(packets);

		StringBuilder sb = new StringBuilder();
		sb.append(sortedPackets[0]);
		for (int inx=1; inx<sortedPackets.length; inx++) {
			sb.append(main.getNextString(sortedPackets[inx-1], sortedPackets[inx]));
		}
		System.out.println(sb.toString());
	}

	public String[] sort(String[] packets) {
		String[] result = packets.clone();
		for (int inx=0; inx<result.length-1; inx++) {
			for (int jnx=inx+1; jnx<result.length; jnx++) {
				if (result[inx].charAt(0) > result[jnx].charAt(0)) {
					String temp = result[inx];
					result[inx] = result[jnx];
					result[jnx] = temp;
				}
			}
		}
		return result;
	}

	public String getNextString(String prevString, String nextString) {
		String result = null;
		char prevIndex = prevString.charAt(0);
		char nextIndex = nextString.charAt(0);

		String prev = prevString.substring(1);
		String next = nextString.substring(1);
		if (prevIndex == nextIndex) {
			result = "";
		} else if ((prevIndex+1) == nextIndex) {
			boolean isDuplicate = false;
			for (int inx=3; inx>0; inx--) {
				if (prev.length() > inx && next.length() > inx) {
					String pPkg = prev.substring(prev.length()-inx, prev.length());
					String nPkg = next.substring(0, inx);
					if (pPkg.equals(nPkg)) {
						result = next.substring(inx, next.length());
						isDuplicate = true;
						break;
					}
				}
			}
			if (!isDuplicate) {
				result = next;
			}
		} else {
			result = next;
		}
		return result;
	}
}
