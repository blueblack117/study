package practice.message.vo;

public class ResponseBody {
    private String Result;
	private String MessageID;
	private String Message;

	public ResponseBody() {
		super();
	}

	public ResponseBody(String result) {
		super();
		Result = result;
	}

	public String getResult() {
		return Result;
	}
	public void setResult(String result) {
		Result = result;
	}
	public String getMessageID() {
		return MessageID;
	}
	public void setMessageID(String messageID) {
		MessageID = messageID;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}

	@Override
	public String toString() {
		return "ResponseBody [Result=" + Result + ", MessageID=" + MessageID + ", Message=" + Message + "]";
	}

}
