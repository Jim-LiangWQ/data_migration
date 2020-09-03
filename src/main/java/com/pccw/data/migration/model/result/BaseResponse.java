package com.pccw.data.migration.model.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pccw.data.migration.constants.ResultCodeAndMessageEnumeration;
import lombok.Data;

import static com.pccw.data.migration.constants.ResultCodeAndMessageEnumeration.RESULT_OK;


/**
 * Created by Alpaca 2020/01/06
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse<T> {

    private String resultCode;

    private String resultMessage;

    private T payload;

    private byte[] attachment;

    private String totalPage;

    private Integer totalCount;

    public BaseResponse() {
        this(RESULT_OK.getResultCode(), RESULT_OK.getResultMessage());
    }

    public BaseResponse(String resultCode, String resultMessage) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }

    public BaseResponse(ResultCodeAndMessageEnumeration resultCodeAndMessageEnumeration) {
        this(resultCodeAndMessageEnumeration.getResultCode(), resultCodeAndMessageEnumeration.getResultMessage());
    }

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public T getPayload() {
		return payload;
	}

	public void setPayload(T payload) {
		this.payload = payload;
	}

	public byte[] getAttachment() {
		return attachment;
	}

	public void setAttachment(byte[] attachment) {
		this.attachment = attachment;
	}

	public String getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(String totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

    
    
}
