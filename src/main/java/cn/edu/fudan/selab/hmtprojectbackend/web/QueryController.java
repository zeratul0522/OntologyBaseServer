package cn.edu.fudan.selab.hmtprojectbackend.web;

import cn.edu.fudan.selab.hmtprojectbackend.dto.QueryAllServiceResponseBody;
import cn.edu.fudan.selab.hmtprojectbackend.dto.ThirdPartyInformationService;
import cn.edu.fudan.selab.hmtprojectbackend.util.BuildOntologyQueryURL;
import cn.edu.fudan.selab.hmtprojectbackend.util.HttpRequestor;
import cn.edu.fudan.selab.hmtprojectbackend.util.Parameters;
import cn.edu.fudan.selab.hmtprojectbackend.dto.QueryServiceResponseBody;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    @RequestMapping(value="/serviceURLQuery", method= RequestMethod.GET)
    public QueryServiceResponseBody getURL(@RequestParam("serviceName") String serviceName) throws Exception {
        //Deal with the empty param situation
        if(serviceName.length()==0){
            QueryServiceResponseBody queryServiceResponseBody = new QueryServiceResponseBody();
            queryServiceResponseBody.setCode("10002");
            queryServiceResponseBody.setMessage("Empty Param");

            return queryServiceResponseBody;
        }

        //Construct a request URL for ontology Restful API
        String queryStr = BuildOntologyQueryURL.queryServiceEntranceBySubjandPred(serviceName);
        //Get result from ontology base
        String ret = new HttpRequestor().doGet(queryStr);

        //No match result situation
        if(ret.length() <= 0){
            QueryServiceResponseBody queryServiceResponseBody = new QueryServiceResponseBody();
            queryServiceResponseBody.setCode("10003");
            queryServiceResponseBody.setMessage("No Match Result");

            return queryServiceResponseBody;
        }

        //Obtain the result url
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
        QueryServiceResponseBody queryServiceResponseBody = new QueryServiceResponseBody();
        queryServiceResponseBody.setCode("10000");
        queryServiceResponseBody.setMessage("Success");
        queryServiceResponseBody.setService(new ThirdPartyInformationService(serviceName,url));
        return queryServiceResponseBody;

    }

    @RequestMapping(value="/serviceURLQuery/all", method= RequestMethod.GET)
    public QueryAllServiceResponseBody getURLList() throws Exception {
        String queryStr = BuildOntologyQueryURL.queryServiceEntranceByPred();
        String ret = new HttpRequestor().doGet(queryStr);
        //No match result situation
        if(ret.length() <= 0){
            QueryAllServiceResponseBody queryAllServiceResponseBody = new QueryAllServiceResponseBody();
            queryAllServiceResponseBody.setCode("10003");
            queryAllServiceResponseBody.setMessage("No Match Result");
            queryAllServiceResponseBody.setList(null);
            return queryAllServiceResponseBody;
        }

        //Construct result list

        List<String> urls = new ArrayList<>(); //Store all urls we need
        List<String> names = new ArrayList<>(); //Store all names we need

        String[] strs = ret.split(" ");
        for(int h = 0; h < strs.length-1; h+=3){
            String temp = strs[h];
            temp = temp.split("#")[1];
            temp = temp.split("_")[0];
            names.add(temp);
        }
        for(int h = 2; h < strs.length-1; h+=3){
            String temp = strs[h];
            StringBuilder urlb = new StringBuilder();
            int sharpCnt = 0;
            for(int i = 0; i < temp.length(); i++){
                if(temp.charAt(i) == '"') sharpCnt++;
                if(sharpCnt >=2) break;
                urlb.append(temp.charAt(i));
            }
            urlb = urlb.delete(0,1);
            urls.add(urlb.toString());
        }
        List<ThirdPartyInformationService> list = new ArrayList<>();
        for(int i = 0; i < names.size();i++){
            list.add(new ThirdPartyInformationService(names.get(i),urls.get(i)));
        }


        QueryAllServiceResponseBody queryAllServiceResponseBody = new QueryAllServiceResponseBody();
        queryAllServiceResponseBody.setCode("10000");
        queryAllServiceResponseBody.setMessage("Success");
        queryAllServiceResponseBody.setList(list);
        return queryAllServiceResponseBody;
    }

}
