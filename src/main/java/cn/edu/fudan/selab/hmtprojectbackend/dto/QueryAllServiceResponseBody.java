package cn.edu.fudan.selab.hmtprojectbackend.dto;

import java.util.List;

/**
 * @Desc
 * @Author Fan Zejun E-mail:fzj0522@outlook.com
 * @Version Created at: 2018/8/16 下午4:31
 */
public class QueryAllServiceResponseBody {
    private String code;
    private String message;
    private List<ThirdPartyInformationService> list;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ThirdPartyInformationService> getList() {
        return list;
    }

    public void setList(List<ThirdPartyInformationService> list) {
        this.list = list;
    }
}
