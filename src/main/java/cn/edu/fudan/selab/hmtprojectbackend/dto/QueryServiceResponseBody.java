package cn.edu.fudan.selab.hmtprojectbackend.dto;

/**
 * @Desc
 * @Author Fan Zejun E-mail:fzj0522@outlook.com
 * @Version Created at: 2018/8/16 下午3:22
 */
public class QueryServiceResponseBody {
    private String code;
    private String message;
    private ThirdPartyInformationService service;

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

    public ThirdPartyInformationService getService() {
        return service;
    }

    public void setService(ThirdPartyInformationService service) {
        this.service = service;
    }
}
