package com.simos.decrypt;

import com.simos.util.AESUtil;

/**
 * Created by l2h on 18-5-8.
 * Desc:
 */
public class AESDecryptProperty implements  DecryptProperty {
    @Override
    public String decrypt(String source) throws Exception {
        return AESUtil.decrypt(source);
    }
}
