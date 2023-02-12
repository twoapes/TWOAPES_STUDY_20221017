import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import statics.RandomUtil;

/**
 * @author add by huyingzhao
 * 2023-02-07 22:14
 */
@Slf4j

public class NameTest {
    /**
     * virtual crate a user information
     * include age,sex,name ... something
     */
    @Test
    public void nameTest() {
        for (int i = 0; i < 5; i++) {
            String sex = User.sex();
            String str = "\n" + "name:" + (User.surName(1) + User.name(sex)) + "\n" +
                    "sex:" + sex + "\n" +
                    "age:" + User.age(1, 99) + "\n";
            log.info(str);
        }

        for (int i = 0; i < 5; i++) {
            String sex = User.sex();
            String str = "\n" + "name:" + (User.surName(2) + User.name(sex)) + "\n" +
                    "sex:" + sex + "\n" +
                    "age:" + User.age(10, 70) + "\n";
            log.info(str);
        }
    }
}

class User {

    /**
     * @return sex
     */
    protected static String sex() {
        return RandomUtil.randomBetween(1) == 1 ? "boy" : "girl";
    }


    /**
     * @return age
     */
    protected static int age(int begin, int end) {
        return RandomUtil.randomBetween(begin, end);
    }

    /**
     * @return surName
     * length=1 for one
     * length=2 for two
     */
    protected static String surName(int length) {
        String str;
        int index;
        String surName2 = "欧阳太史端木上官司马东方独孤南宫万俟闻人夏侯诸葛尉迟公羊赫连澹台皇甫宗政濮阳公冶太叔申屠公孙慕容仲孙钟离长孙宇文司徒鲜于司空闾丘子车亓官司寇巫马公西颛孙壤驷公良漆雕乐正宰父谷梁拓跋夹谷轩辕令狐段干百里呼延东郭南门羊舌微生公户公玉公仪梁丘公仲公上公门公山公坚左丘公伯西门公祖第五公乘贯丘公皙南荣东里东宫仲长子书子桑即墨达奚褚师吴铭";
        if (length == 1) {
            String surName1 = "赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻水云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳鲍史唐费岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅卞齐康伍余元卜顾孟平黄和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计成戴宋茅庞熊纪舒屈项祝董粱杜阮席季麻强贾路娄危江童颜郭梅盛林刁钟徐邱骆高夏蔡田胡凌霍万柯卢莫房缪干解应宗丁宣邓郁单杭洪包诸左石崔吉龚程邢滑裴陆荣翁荀羊甄家封芮储靳邴松井富乌焦巴弓牧隗山谷车侯伊宁仇祖武符刘景詹束龙叶幸司韶黎乔苍双闻莘劳逄姬冉宰桂牛寿通边燕冀尚农温庄晏瞿茹习鱼容向古戈终居衡步都耿满弘国文东殴沃曾关红游盖益桓公晋楚闫";
            index = RandomUtil.randomBetween(surName1.length() - 1);
            str = String.valueOf(surName1.charAt(index));
        } else if (length == 2) {
            index = RandomUtil.randomBetween(surName2.length() - 1);
            str = (index & 1) == 0 ? surName2.substring(index, index + 2) : surName2.substring(index - 1, index + 1);
        } else {
            index = RandomUtil.randomBetween(surName2.length() - 1);
            str = String.valueOf(surName2.charAt(index));
        }

        return str;
    }

    /**
     * @param sex sex
     * @return name
     */
    protected static String name(String sex) {
        String name;
        String girlName = "秀娟英华慧巧美娜静淑惠珠翠雅芝玉萍红娥玲芬芳燕彩春菊兰凤洁梅琳素云莲真环雪荣爱妹霞香月莺媛艳瑞凡佳嘉琼勤珍贞莉桂娣叶璧璐娅琦晶妍茜秋珊莎锦黛青倩婷姣婉娴瑾颖露瑶怡婵雁蓓纨仪荷丹蓉眉君琴蕊薇菁梦岚苑婕馨瑗琰韵融园艺咏卿聪澜纯毓悦昭冰爽琬茗羽希宁欣飘育滢馥筠柔竹霭凝晓欢霄枫芸菲寒伊亚宜可姬舒影荔枝思丽";
        String boyName = "伟刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清飞彬富顺信子杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先敬震振壮会思群豪心邦承乐绍功松善厚庆磊民友裕河哲江超浩亮政谦亨奇固之轮翰朗伯宏言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛雄琛钧冠策腾楠榕风航弘";
        boolean isMan = sex.equals("男");
        int index = isMan ? RandomUtil.randomBetween(boyName.length() - 2) : RandomUtil.randomBetween(girlName.length() - 2);
        int randNum = RandomUtil.randomBetween(1, 2);
        name = isMan ? boyName.substring(index, index + randNum) : girlName.substring(index, index + randNum);
        return name;
    }
}
