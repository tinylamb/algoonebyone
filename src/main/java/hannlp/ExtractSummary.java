package hannlp;

import java.util.List;

import com.hankcs.hanlp.HanLP;

/**
 * Created by samo on 2017/6/20.
 *
 * @author samo
 * @date 2017/06/20
 */
public class ExtractSummary {
    public static void main(String[] args) {
        String document = "你好 麻烦帮我转接知识产权方面的小二,要咨询知识产权的问题，麻烦转下专业的客服,帮忙联系人工客服，咨询被投诉知识产权,一会还是要转到知识产权客服那去,麻烦帮我转接到处理知识产权投诉平台客服 我是投诉方,麻烦帮我转知识产权的客户,麻烦帮我转给知识产权客服,麻烦您帮忙转接一下，知识产权售假申诉的处理专员，谢谢。,你帮我转接知识产权方面的小二好吗,帮我转  知识产权的小二";
        List<String> sentenceList = HanLP.extractKeyword(document, 2);
        System.out.println(sentenceList);
    }
}
