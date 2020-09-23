package javabogi.Marshall;

import java.lang.reflect.Field;

/**
 * MarshallUtil (30분)
 *
 * 1. marshall
 * VO를 입력받아 get으로 시작하는 메소드를 모두 호출하여
 * key1=value1,key2=value2... 로 만들기
 * 단, value에는 '='나 ','를 포함할 수 있고, 이 경우 '\=', '\,'로 치환해야 함.
 * 단, value가 String 타입인 것만 나열할 것.
 *
 * 2. unmarshall
 * key1=value1,key2=value2... 와 클래스명을 입력받아 set으로 시작하는 메소드를 모두 호출하여 VO로 만들기
 * 단, value의 '\=', '\,'는 '='나 ','로 치환해야 함.
 *
 * - 메인함수 설명
 * 임의의 VO인 User에 대하여
 * User("12345", "한예슬", "서울시 영등포구=여의도동,여의대로=24,30층 내옆자리", System.currentTimeMillis());
 * 를 marshall -> unmarshall -> marshall하여 첫번째 marshall과 두번째 marshall이 서로 같은지 비교
 *
 * -----------
 * Pseudocode
 * -----------
 * TODO
 *
 */
public class MarshallUtil {

	public String marshall(Object vo) throws Exception {
		String result = null;

		Field[] fields = vo.getClass().getDeclaredFields();
		if (fields != null && fields.length > 0) {
			StringBuilder sb = new StringBuilder();
			for (Field field : fields) {
				if (field.getType().equals(String.class)) {
					String key = field.getName();
					String methodName = "get" + key.substring(0,1).toUpperCase() + key.substring(1);
					String value = (String) vo.getClass().getMethod(methodName).invoke(vo);
					value = value.replace("=", "\\=");
					value = value.replace(",", "\\,");
					sb.append(key).append("=").append(value).append(",");
				}
			}
			result = sb.toString();
			result = result.substring(0, result.length()-1);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public <T> T unmarshall(String str, Class<?> clazz) throws Exception {
		str = str.replace("\\,", "&&");
		str = str.replace("\\=", "%%");
		String[] values = str.split(",");
		if (values != null && values.length > 0) {
			Class<T> newClass = (Class<T>) clazz;
			T newInstace = newClass.newInstance();
			for (String value : values) {
				String[] keys =  value.split("=");
				String setValue = keys[1].replace("&&", ",").replace("%%", "=");
				String methodName = "set" + keys[0].substring(0, 1).toUpperCase() + keys[0].substring(1);
				newClass.getMethod(methodName, String.class).invoke(newInstace, setValue);
			}
			return newInstace;
		}
		return (T) null;
	}

	public static void main(String[] args) throws Exception {
		MarshallUtil marshallUtil = new MarshallUtil();
		User user = new User("12345", "한예슬", "서울시 영등포구=여의도동,여의대로=24,30층 내옆자리", System.currentTimeMillis());

		String marshal = marshallUtil.marshall(user);
		User unmarshal = marshallUtil.unmarshall(marshal, User.class);
		String marshal2 = marshallUtil.marshall(unmarshal);

		System.out.println(marshal.equals(marshal2));	//true
		System.out.println(user.getAddress().equals(unmarshal.getAddress()));	//true
	}
}

class User {
	private String id;
	private String name;
	private String address;
	private long lastLoginTime;

	public User() {
	}

	public User(String id, String name, String address, long lastLoginTime) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.lastLoginTime = lastLoginTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(long lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
}
