package com.itqf.lvyou;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * 项目异常类
 * @author cailei
 * 
 */
@SuppressWarnings("all")
public class WoException extends RuntimeException {

	/**
	 * Recording the log of this class.
	 */
	private final static Logger LOG = LogManager.getLogger(WoException.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = -7936051408147786087L;

	private WoResultCode code = WoResultCode.getUnknown();

	public WoResultCode getCode() {
		return code;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Throwable#getMessage()
	 */
	public String getMessage() {
		return code.getMsg();
	}

	/**
	 * 
	 */
	public WoException() {
		super();
	}

	/**
	 * @param code
	 */
	public WoException(WoResultCode code, Object... args) {
		super();
		this.code = code;
		this.code.setMsgArgs(args);
	}

	/**
	 * @param code
	 */
	public WoException(Throwable cause, WoResultCode code, Object... args) {
		super(cause);
		this.code = code;
		this.code.setMsgArgs(args);
	}
}
