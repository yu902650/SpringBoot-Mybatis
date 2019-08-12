package me.springboot.mybatis.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 网络请求工具类
 *
 * @author qjouyang
 */
public class WireHttpUtils {

    /**
     * post请求
     *
     * @param url         请求地址
     * @param params      请求参数
     * @param requestBody 请求头
     * @return
     */
    public static String post(String url, Map<String, String> params, byte[] requestBody, Map<String, String> headers)
            throws Exception {
        return new String(post(url, requestBody, headers), "UTF-8");

    }

    /**
     * post请求
     *
     * @param url         请求地址
     * @param requestBody 请求头
     * @return
     */
    public static byte[] post(String url, byte[] requestBody, Map<String, String> headers)
            throws Exception {
        if (StringUtils.isEmpty(url)) {
            throw new IllegalArgumentException("url 参数不能为空");
        }
        HttpClient client = new HttpClient();
        PostMethod post = new PostMethod(url);
//        post.addParameters(createNameValuePairs(params));
        if (Detect.notEmpty(requestBody)) {
            ByteArrayRequestEntity entity = new ByteArrayRequestEntity(requestBody);
            post.setRequestEntity(entity);
        }
        if (Detect.notEmpty(headers)) {
            Iterator it = headers.entrySet().iterator();
            while (it.hasNext()) {
                Entry<String, String> entry = (Entry<String, String>) it.next();
                post.setRequestHeader(entry.getKey(), entry.getValue());
            }
        }
        client.executeMethod(post);
        byte[] results = post.getResponseBody();
        return results;

    }

    public static byte[] post(String url, Map<String, String> param) {
        try {
            if (StringUtils.isEmpty(url)) {
                throw new IllegalArgumentException("url 参数不能为空");
            }
            HttpClient client = new HttpClient();
            PostMethod post = new PostMethod(url);

            if (Detect.notEmpty(param)) {
                Iterator it = param.entrySet().iterator();
                while (it.hasNext()) {
                    Entry<String, String> entry = (Entry<String, String>) it.next();
                    post.addParameter(entry.getKey(), entry.getValue());
                }
            }
            post.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"utf-8");
            client.executeMethod(post);
            return post.getResponseBody();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * GET请求
     *
     * @param url
     * @param params
     * @return
     */
    public static String get(String url, Map<String, String> params, Map<String, String> headers) throws Exception {
        if (StringUtils.isEmpty(url)) {
            throw new IllegalArgumentException("url 参数不能为空");
        }
        HttpClient client = new HttpClient();
        GetMethod get = new GetMethod(url);
        if (params != null && !params.isEmpty()) {
            get.setQueryString(createNameValuePairs(params));
        }
        if (Detect.notEmpty(headers)) {
            Iterator it = headers.entrySet().iterator();
            while (it.hasNext()) {
                Entry<String, String> entry = (Entry<String, String>) it.next();
                get.setRequestHeader(entry.getKey(), entry.getValue());
            }
        }
        client.executeMethod(get);
        byte[] results = get.getResponseBody();
        return new String(results, "UTF-8");
    }

    public static String post(String uri, String data) {
        CloseableHttpClient httpclient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(uri);
        String result = null;
        try {
            StringEntity s = new StringEntity(data);
            s.setContentEncoding("UTF-8");
            s.setContentType("application/x-www-form-urlencoded");//发送json数据需要设置contentType
            post.setEntity(s);
            HttpResponse res = httpclient.execute(post);
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                result = EntityUtils.toString(res.getEntity());// 返回json格式：
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    /**
     * 封装请求参数
     *
     * @param params 参数列表
     * @return
     */
    private static NameValuePair[] createNameValuePairs(Map<String, String> params) {
        NameValuePair[] nvs = null;
        if (Detect.notEmpty(params)) {
            nvs = new NameValuePair[params.size()];
            List<String> keys = new ArrayList<String>(params.keySet());
            for (int i = 0; i < keys.size(); i++) {
                String key = keys.get(i);
                NameValuePair nv = new NameValuePair(key, params.get(key));
                nvs[i] = nv;
            }
        }
        return nvs;
    }

}
