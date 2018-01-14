package com.jiajun.dubbo;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.cluster.LoadBalance;

import java.util.List;

/**
 * Created by SUMMERS on 2018/1/14.
 */
public class CustomLoadBalance implements LoadBalance {


    @Override
    public <T> Invoker<T> select(List<Invoker<T>> invokers, URL url, Invocation invocation) throws RpcException {

        System.out.println("---- url is " + url.toFullString());
        String ip = url.getParameter("register.ip");
        String pid = url.getParameter("pid");
        System.out.println("---- register.ip is " + ip);

        //可以用Filter机制设置attachment 传递数据
        System.out.println("---" + invocation.getAttachments());

        //获取参数信息，根据参数选取指定的invoker，可以考虑用attachment传递，这里没作思考
        Integer index = (Integer) invocation.getArguments()[0];
        if (index >= invokers.size()){
            index = invokers.size()-1;
        }
        return invokers.get(index);
    }
}
