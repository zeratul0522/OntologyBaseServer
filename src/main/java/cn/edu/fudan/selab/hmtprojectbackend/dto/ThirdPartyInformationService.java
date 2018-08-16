package cn.edu.fudan.selab.hmtprojectbackend.dto;

/**
 * @Desc
 * @Author Fan Zejun E-mail:fzj0522@outlook.com
 * @Version Created at: 2018/8/16 下午3:18
 */
public class ThirdPartyInformationService {
    private String serviceName;
    private String serviceURL;

    public ThirdPartyInformationService(String serviceName, String serviceURL){
        this.serviceName = serviceName;
        this.serviceURL = serviceURL;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceURL() {
        return serviceURL;
    }

    public void setServiceURL(String serviceURL) {
        this.serviceURL = serviceURL;
    }
}
