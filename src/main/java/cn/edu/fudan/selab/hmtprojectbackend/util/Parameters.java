package cn.edu.fudan.selab.hmtprojectbackend.util;

/**
 * @Desc
 * @Author Fan Zejun E-mail:fzj0522@outlook.com
 * @Version Created at: 2018/8/8 下午3:31
 */
public class Parameters {

    private Parameters(){
    }

    /*
     * Parameters for Allegro Graph database server.
     * Here is an example to help you understand:
     *
     * http://47.100.23.182:10035/repositories/OntologyTest/statements?subj=
     * <http://www.semanticweb.org/fudan/ontologies/Human_Machine_Thing#IfRoomEmptyService_Grounding>
     * &pred=<http://www.semanticweb.org/fudan/ontologies/Human_Machine_Thing#HmtServiceEntranceURL>
     *
     * This URL aims to query URL for service named "IfRoomEmptyService".
     */
    public static final String SERVER_IP = "47.100.23.182";
    public static final String PORT = "10037";

    public static final String REPOSITORY_NAME = "OntologyTest";
    public static final String PREFIX = "http://www.semanticweb.org/fudan/ontologies/Human_Machine_Thing%23";
    public static final String SUBJ_4_SERVICE_URL_SUFFIX = "_Grounding";
    public static final String PRED_4_SERVICE_URL = "HmtServiceEntranceURL";

    //Key and secret for agraph http request
    private static final String APP_KEY = "fzjsuper";
    private static final String SECRET_KEY = "1234";

}
