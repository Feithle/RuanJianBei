package StringUtil;
public class StringToInt{
/**
 * @param UserKey
 * @return
 */
public  static String TurnStringToInt (String UserKey)
	{
		
		StringBuilder sb = new StringBuilder();
		char[] ch = UserKey.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			sb.append(Integer.valueOf(ch[i]).intValue()).append("");
		}
		return sb.toString();
	}
	}