package core.name.impl;

import core.entity.NamePOJO;
import core.name.NameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author add by huyingzhao
 * 2023-07-21 09:59
 */
@Slf4j
@Service
public class NameServiceImpl implements NameService {
    private final NamePOJO namePOJO;

    @Autowired
    public NameServiceImpl(NamePOJO namePOJO) {
        this.namePOJO = namePOJO;
    }

    public String fullName1(int length) {
        return getName1() + getMing(length);
    }

    public String fullName2(int length) {
        return getName2() + getMing(length);
    }

    private String getName1() {
        String str1 = namePOJO.getName1();
        return getRandom(1, str1.toCharArray());
    }

    private String getName2() {
        String str2 = namePOJO.getName2();
        return getRandom(2, str2.toCharArray());
    }

    private String getMing(int length) {
        String str3 = namePOJO.getMing();
        return getRandom(length, str3.toCharArray());
    }

    public String getRandom(int length, char[] chars) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(chars[(int) (Math.random() * chars.length)]);
        }
        return sb.toString();
    }
}
