package com.focus3d.pano.wechat.utils;

import com.focus3d.pano.wechat.utils.WeChatConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @Author Chase Lv(蛰龙)
 * @Date 2017/8/13
 * @Time 下午1:46
 * @Description
 */
@Component
public class WxPayConfigImpl extends WxPayConfig {

    @Autowired
    WeChatConfig wx;

    /**
     * 退款时流数据
     */
    private byte[] certData;

    @PostConstruct
    public void  init() throws Exception{
        String certPath = wx.getKeyPath();
//        File file = new File(certPath);
//        InputStream certStream = new FileInputStream(file);
//        this.certData = new byte[(int) file.length()];
//        certStream.read(this.certData);
//        certStream.close();
    }


    /**
     * 获取 App ID
     *
     * @return App ID
     */
    @Override
    public String getAppID() {
        return wx.getAppId();
    }

    /**
     * 获取 Mch ID
     *
     * @return Mch ID
     */
    @Override
    public String getMchID() {
        return wx.getMchId();
    }

    /**
     * 获取 API 密钥
     *
     * @return API密钥
     */
    @Override
    public String getKey() {
        return wx.getMchKey();
    }

    /**
     * 获取商户证书内容
     *
     * @return 商户证书内容
     */
    @Override
    public InputStream getCertStream() {
        ByteArrayInputStream certBis;
        certBis = new ByteArrayInputStream(this.certData);
        return certBis;
    }


    /**
     * 回调地址
     *
     * @return
     */
    @Override
    public String getNotifyUrl() {
        return wx.getNotifyUrl();
    }

    /**
     * 获取WXPayDomain, 用于多域名容灾自动切换
     *
     * @return
     */
    @Override
    IWxPayDomain getWXPayDomain() {
        return WxPayDomainSimpleImpl.instance();
    }
}
