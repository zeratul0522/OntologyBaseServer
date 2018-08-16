package cn.edu.fudan.selab.hmtprojectbackend.util;

/**
 * @Desc
 * @Author Fan Zejun E-mail:fzj0522@outlook.com
 * @Version Created at: 2018/8/16 下午4:23
 */
public class BuildOntologyQueryURL {
    public static String queryServiceEntranceBySubjandPred(String subj){
        StringBuilder sb = new StringBuilder();
        sb.append("http://");
        sb.append(Parameters.SERVER_IP);
        sb.append(":");
        sb.append(Parameters.PORT);
        sb.append("/repositories/");
        sb.append(Parameters.REPOSITORY_NAME);
        sb.append("/statements?subj=%3C");
        sb.append(Parameters.PREFIX);
        sb.append(subj);
        sb.append(Parameters.SUBJ_4_SERVICE_URL_SUFFIX);
        sb.append("%3E&pred=%3C");
        sb.append(Parameters.PREFIX);
        sb.append(Parameters.PRED_4_SERVICE_URL);
        sb.append("%3E");

        return sb.toString();
    }

    public static String queryServiceEntranceByPred(){
        StringBuilder sb = new StringBuilder();
        sb.append("http://");
        sb.append(Parameters.SERVER_IP);
        sb.append(":");
        sb.append(Parameters.PORT);
        sb.append("/repositories/");
        sb.append(Parameters.REPOSITORY_NAME);
        sb.append("/statements?pred=%3C");
        sb.append(Parameters.PREFIX);
        sb.append(Parameters.PRED_4_SERVICE_URL);
        sb.append("%3E");

        return sb.toString();
    }
}
