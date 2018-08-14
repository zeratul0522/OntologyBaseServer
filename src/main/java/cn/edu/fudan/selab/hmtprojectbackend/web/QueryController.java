package cn.edu.fudan.selab.hmtprojectbackend.web;

import cn.edu.fudan.selab.hmtprojectbackend.util.HttpRequestor;
import cn.edu.fudan.selab.hmtprojectbackend.util.Parameters;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Desc
 * @Author Fan Zejun E-mail:fzj0522@outlook.com
 * @Version Created at: 2018/8/8 下午2:32
 */


/*
 * This method is intended for querying url for single service.
 */
@RestController
@RequestMapping(value="/query")
public class QueryController {
    @RequestMapping(value="/serviceURLQuery/{serviceName}", method= RequestMethod.GET)
    public String getURL(@PathVariable String serviceName) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("http://");
        sb.append(Parameters.SERVER_IP);
        sb.append(":");
        sb.append(Parameters.PORT);
        sb.append("/repositories/");
        sb.append(Parameters.REPOSITORY_NAME);
        sb.append("/statements?subj=%3C");
        sb.append(Parameters.PREFIX);
        sb.append(serviceName);
        sb.append(Parameters.SUBJ_4_SERVICE_URL_SUFFIX);
        sb.append("%3E&pred=%3C");
        sb.append(Parameters.PREFIX);
        sb.append(Parameters.PRED_4_SERVICE_URL);
        sb.append("%3E");

        String queryStr = sb.toString();

        String ret = new HttpRequestor().doGet(queryStr);
        if(ret.length() <= 0)   return "EMPTY RESULT: The service you are querying does not exist.";

        String temp = ret.split(" ")[2];
        StringBuilder urlb = new StringBuilder();
        int sharpCnt = 0;
        for(int i = 0; i < temp.length(); i++){
            if(temp.charAt(i) == '"') sharpCnt++;
            if(sharpCnt >=2) break;
            urlb.append(temp.charAt(i));
        }
        urlb = urlb.delete(0,1);
        String url = urlb.toString();
        return url;
    }
}
