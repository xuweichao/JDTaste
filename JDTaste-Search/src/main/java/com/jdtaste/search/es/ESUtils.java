package com.jdtaste.search.es;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by XUWEICHAO on 2018/8/25.
 */
public class ESUtils {
    private  static  TransportClient client;
    private static String CLUSTERNAME="xuweichao-application";
    private static String HOST="localhost";
    private static int PORT=9300;

    static {
        client=creatClient();
    }

    /**
     * 创建client
     * @return
     */
    public static TransportClient creatClient()  {
        Settings esSettings = Settings.builder()
                .put("cluster.name", CLUSTERNAME) //设置ES实例的名称
                .put("client.transport.sniff", true) //自动嗅探整个集群的状态，把集群中其他ES节点的ip添加到本地的客户端列表中
                .build();
        client = new PreBuiltTransportClient(esSettings);//初始化client较老版本发生了变化，此方法有几个重载方法，初始化插件等。
        //此步骤添加IP，至少一个，其实一个就够了，因为添加了自动嗅探配置
        try {
            client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(HOST), PORT));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return client;
    }

    /**
     * 保存数据
     * @param doc
     * @param index
     * @param type
     * @return
     */
    public IndexResponse insertData(Map<String, Object> doc,String index,String type){
        IndexResponse response = client.prepareIndex("student", "student")
                .setSource(doc)
                .get();
        return response;
    }

    /**
     *
     * @param doc
     * @param index
     * @param type
     * @param id
     * @return
     */
    public UpdateResponse updateData(Map<String, Object> doc,String index,String type,String id){
        UpdateResponse updateResponse =
                this.client
                        .prepareUpdate()
                        .setIndex(index)
                        .setType(type)
                        .setId(id)
                        .setDoc(doc)
                        .get();

        return updateResponse;
    }



    public static void main(String[] args) {
        TransportClient client=   ESUtils.creatClient();
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("name","kimchy");
        json.put("score",88);
        json.put("sex",2);

        IndexResponse response = client.prepareIndex("student", "student")
                .setSource(json)
                .get();
        System.out.println(response.getResult());


    }


}
